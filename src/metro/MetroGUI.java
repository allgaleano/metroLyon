package src.metro;

import java.awt.*;
import javax.swing.*;

public class MetroGUI extends JFrame {

  private Grafo metro;
  private CoordenadaPlano coordenadaPlano;

  public MetroGUI(Grafo metro) {
    this.metro = metro;
    setTitle("Metro de Lyon");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Calcula los límites geográficos para todas tus estaciones.
    double[] limites = calcularLimites(metro);
    // Inicializa CoordenadaPlano con los límites y el tamaño del área de dibujo.
    double padding = 0.015;
    coordenadaPlano =
      new CoordenadaPlano(
        limites[0],
        limites[1],
        limites[2],
        limites[3],
        getWidth(),
        getHeight(),
        padding
      );

    add(new GraficoMetro());
  }

  private class GraficoMetro extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      
      for (Estacion estacion : metro.obtenerEstaciones()) {
        // Convierte las coordenadas geográficas a coordenadas del plano.
        Point punto = coordenadaPlano.convertirCoordenadas(
          estacion.getLatitud(),
          estacion.getLongitud()
        );

        // Dibuja la estación en el plano.
        g.fillOval(punto.x - 5, punto.y - 5, 10, 10); // Centra el óvalo en el punto

        // Dibuja el nombre de la estación.
        g.drawString(estacion.getNombre(), punto.x + 10, punto.y + 5);

        // Para las conexiones, dibuja líneas entre las estaciones.
        for (Conexion conexion : metro.obtenerConexiones(estacion)) {
          Estacion destino = conexion.getDestino();
          Point puntoDestino = coordenadaPlano.convertirCoordenadas(
            destino.getLatitud(),
            destino.getLongitud()
          );
          g.setColor(obtenerColorPorLinea(estacion.getLinea()));
          g.drawLine(punto.x, punto.y, puntoDestino.x, puntoDestino.y);
        }
        g.setColor(Color.BLACK);
      }
    }
  }

  // Método para calcular los límites geográficos.
  private double[] calcularLimites(Grafo metro) {
    double minX = Double.MAX_VALUE;
    double maxX = Double.MIN_VALUE;
    double minY = Double.MAX_VALUE;
    double maxY = Double.MIN_VALUE;

    for (Estacion estacion : metro.obtenerEstaciones()) {
      if (estacion.getLongitud() < minX) minX = estacion.getLongitud();
      if (estacion.getLongitud() > maxX) maxX = estacion.getLongitud();
      if (estacion.getLatitud() < minY) minY = estacion.getLatitud();
      if (estacion.getLatitud() > maxY) maxY = estacion.getLatitud();
    }

    // Devuelve los límites exactos sin aplicar el padding aquí
    return new double[] { minX, minY, maxX, maxY };
  }

  private Color obtenerColorPorLinea(char linea) {
    switch (linea) {
        case 'A':
            return Color.RED;
        case 'B':
            return Color.BLUE;
        case 'C':
            return Color.GREEN;
        case 'D':
            return Color.YELLOW;
        // Agrega más casos según sea necesario
        default:
            return Color.BLACK; // Un color predeterminado si no se reconoce la línea
    }
}

}
