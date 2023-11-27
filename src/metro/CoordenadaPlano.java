package src.metro;

public class CoordenadaPlano {
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double width;  // Ancho del área de dibujo
    private double height; // Altura del área de dibujo
    private double padding;
    // Constructor que toma los límites geográficos y el tamaño del área de dibujo
    public CoordenadaPlano(double minX, double minY, double maxX, double maxY, double width, double height, double padding) {
        
        // Ajusta los límites para incluir el padding
        this.minX = minX - padding;
        this.maxX = maxX + padding;
        this.minY = minY - padding;
        this.maxY = maxY + padding;

        // Ajusta el área de dibujo para incluir el padding
        this.width = width - 2 * padding;
        this.height = height - 2 * padding;
    }

     // Método para transformar las coordenadas geográficas en coordenadas del plano
    public Point convertirCoordenadas(double latitud, double longitud) {
        // Escalar las coordenadas dentro del rango del área de dibujo
        double x = (longitud - minX) / (maxX - minX) * width;
        double y = (maxY - latitud) / (maxY - minY) * height;

        // Añade el padding inicial al resultado final
        x += padding;
        y += padding;

        return new Point((int) x, (int) y);
    }
}

// Clase auxiliar para representar un punto en el plano
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
