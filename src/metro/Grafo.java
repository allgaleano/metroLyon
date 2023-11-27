package src.metro;

import java.util.ArrayList;
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
    Estacion nodoOrigen = obtenerEstacion(origen);
    Estacion nodoDestino = obtenerEstacion(destino);

    adyacencias.get(nodoOrigen).add(new Conexion(nodoDestino, tiempo));
  }

  Estacion obtenerEstacion(Estacion nombre) {
    for (Estacion e : adyacencias.keySet()) {
      if (e.getNombre().equals(nombre.getNombre())) {
        return e;
      }
    }
    throw new IllegalArgumentException("Estación no encontrada: " + nombre);
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
}
