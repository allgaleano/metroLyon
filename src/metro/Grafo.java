package src.metro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {

  Map<Estacion, List<Conexion>> adyacencias = new HashMap<>();

  // Métodos para agregar estaciones y conexiones
  void agregarEstacion(Estacion estacion) {
    adyacencias.putIfAbsent(estacion, new ArrayList<>());
  }

  void agregarConexion(Estacion origen, Estacion destino, double tiempo) {
    Estacion nodoOrigen = obtenerEstacion(origen.getNombre(), origen.getLinea());
    Estacion nodoDestino = obtenerEstacion(destino.getNombre(), destino.getLinea());

    adyacencias.get(nodoOrigen).add(new Conexion(nodoDestino, tiempo));
  }

  Estacion obtenerEstacion(String nombreEstacion, char linea) {
  return adyacencias.keySet().stream()
                    .filter(e -> e.getNombre().equals(nombreEstacion) && e.getLinea() == linea)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Estación no encontrada: " + nombreEstacion + " Línea: " + linea));
    }

  // Método para obtener todas las estaciones.
  public List<Estacion> obtenerEstaciones() {
    return new ArrayList<>(adyacencias.keySet());
  }

  // Método para obtener todas las conexiones de una estación específica.
  public List<Conexion> obtenerConexiones(Estacion estacion) {
    return adyacencias.getOrDefault(estacion, new ArrayList<>());
  }

  private static double heuristic(Estacion actual, Estacion objetivo) {
    double distancia = actual.distanciaEuclidiana(objetivo);
    double TRANSBORDO_PENALIDAD = 5; // 5 minutos por transbordo
    if (actual.getNombre() != objetivo.getNombre()) {
      distancia += TRANSBORDO_PENALIDAD;
    }
    return distancia;
  }

  List<Estacion> aStar(Estacion inicio, Estacion objetivo) {
    PriorityQueue<Estacion> frontera = new PriorityQueue<>(
      Comparator.comparingDouble(n -> heuristic(n, objetivo))
    );
    Map<Estacion, Estacion> camino = new HashMap<>();
    Map<Estacion, Double> costo = new HashMap<>();
    frontera.add(inicio);
    costo.put(inicio, 0.0);

    while (!frontera.isEmpty()) {
      Estacion actual = frontera.poll();

      if (actual.equals(objetivo)) {
        return reconstruirCamino(camino, actual);
      }

      for (Conexion conexion : adyacencias.get(actual)) {
        Estacion vecino = conexion.destino;
        double nuevoCosto = costo.get(actual) + conexion.tiempo;
        if (!costo.containsKey(vecino) || nuevoCosto < costo.get(vecino)) {
          costo.put(vecino, nuevoCosto);
          frontera.add(vecino);
          camino.put(vecino, actual);
        }
      }
    }
    return null; // No se encontró ruta
  }

  private List<Estacion> reconstruirCamino(
    Map<Estacion, Estacion> camino,
    Estacion actual
  ) {
    LinkedList<Estacion> ruta = new LinkedList<>();
    while (actual != null) {
      ruta.addFirst(actual);
      actual = camino.get(actual);
    }
    return ruta;
  }

  public void mostrarEstacionesYConexionesPorLinea() {
    // Agrupar estaciones por línea
    Map<Character, List<Estacion>> estacionesPorLinea = new HashMap<>();
    for (Estacion estacion : this.obtenerEstaciones()) {
        estacionesPorLinea.computeIfAbsent(estacion.getLinea(), k -> new ArrayList<>()).add(estacion);
    }

    // Ordenar las líneas
    List<Character> lineasOrdenadas = new ArrayList<>(estacionesPorLinea.keySet());
    Collections.sort(lineasOrdenadas);

    // Imprimir las estaciones y conexiones por línea
    for (char linea : lineasOrdenadas) {
        String colorLinea = obtenerColorANSIPorLinea(linea);
        System.out.println("Línea " + colorLinea + linea + ANSI_RESET);

        List<Estacion> estaciones = estacionesPorLinea.get(linea);
        for (Estacion estacion : estaciones) {
            System.out.println("  Estación: " + colorLinea + estacion.getNombre() + ANSI_RESET);
            List<Conexion> conexiones = this.obtenerConexiones(estacion);
            for (Conexion conexion : conexiones) {
                Estacion destino = conexion.getDestino();
                String colorDestino = obtenerColorANSIPorLinea(destino.getLinea()); // Usa el color de la línea destino
                System.out.println("    - Conexión a: " + colorDestino + destino.getNombre() + " con un tiempo de: " + conexion.getTiempo() + " minutos." + ANSI_RESET);
            }
        }
    }
}

    
private String obtenerColorANSIPorLinea(char linea) {
        switch (linea) {
            case 'A':
                return ANSI_RED;
            case 'B':
                return ANSI_BLUE;
            case 'C':
                return ANSI_GREEN;
            case 'D':
                return ANSI_YELLOW;
            // Agrega más colores para otras líneas si es necesario
            default:
                return ANSI_RESET; // Color predeterminado
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
}
