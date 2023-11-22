import java.util.*;

private static final double RADIO_TIERRA_KM = 6371.0;

public class MetroLyon {

  static class Estacion {
    String nombre;
    char linea;
    double latitud;
    double longitud;
    Estacion(String nombre, char linea, double latitud, double longitud) {
      this.nombre = nombre;
      this.linea = linea;
      this.latitud = latitud;
      this.longitud = longitud;
    }
  }

  static class Conexion {
    Estacion destino;
    double tiempo;
    Conexion(Estacion destino, double tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }
  }

  static class Grafo {
    Map<Estacion, List<Conexion>> adyacencias = new HashMap<>();
    // Métodos para agregar estaciones y conexiones
    void agregarEstacion(Estacion estacion) {
      adyacencias.putIfAbsent(estacion, new ArrayList<>());
    }
    
    void agregarConexion(String origen, String destino, double tiempo) {
      Estacion nodoOrigen = obtenerEstacion(origen);
      Estacion nodoDestino = obtenerEstacion(destino);
      adyacencias.get(nodoOrigen).add(new Conexion(nodoDestino, tiempo));
      // Opcional: agregar la conexión inversa para un grafo no dirigido
      adyacencias.get(nodoDestino).add(new Conexion(nodoOrigen, tiempo));
    }
    
    Estacion obtenerEstacion(String nombre) {
      return adyacencias.keySet().stream()
                        .filter(estacion -> estacion.nombre.equals(nombre))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Estación no encontrada: " + nombre));
    }
  }

  class Ruta implements Comparable<Ruta> {
    Estacion estacion;
    double costoHastaAhora;
    double estimadoHaciaObjetivo;
    Ruta previo;
    
    Ruta(Estacion est, double costo, double estimado, Ruta prev) {
        estacion = est;
        costoHastaAhora = costo;
        estimadoHaciaObjetivo = estimado;
        previo = prev;
    }
    
    double costoTotal() {
        return costoHastaAhora + estimadoHaciaObjetivo;
    }
    
    @Override
    public int compareTo(Ruta otra) {
        return Double.compare(this.costoTotal(), otra.costoTotal());
    }
  }

  public List<Estacion> algoritmoAEstrella(Estacion origen, Estacion destino) {
    PriorityQueue<Ruta> frontera = new PriorityQueue<>();
    Map<Estacion, Ruta> estacionRuta = new HashMap<>();
    frontera.add(new Ruta(origen, 0, calcularEstimado(origen, destino), null));
    
    while (!frontera.isEmpty()) {
      Ruta rutaActual = frontera.poll();
      Estacion estacionActual = rutaActual.estacion;
      
      if (estacionActual.equals(destino)) {
        return reconstruirCamino(rutaActual);
      }
      
      for (Conexion conexion : adyacencias.get(estacionActual)) {
        Estacion vecino = conexion.destino;
        double nuevoCosto = rutaActual.costoHastaAhora + conexion.tiempo;
        
        if (!estacionRuta.containsKey(vecino) || nuevoCosto < estacionRuta.get(vecino).costoHastaAhora) {
          double estimado = calcularEstimado(vecino, destino);
          Ruta nuevaRuta = new Ruta(vecino, nuevoCosto, estimado, rutaActual);
          frontera.add(nuevaRuta);
          estacionRuta.put(vecino, nuevaRuta);
        }
      }
    }
    
    throw new NoSuchElementException("No se encontró ruta entre " + origen.nombre + " y " + destino.nombre);
  }

  private List<Estacion> reconstruirCamino(Ruta rutaFinal) {
    List<Estacion> camino = new ArrayList<>();
    Ruta actual = rutaFinal;
    while (actual != null) {
        camino.add(actual.estacion);
        actual = actual.previo;
    }
    Collections.reverse(camino); // El camino se construye al revés, por lo que hay que invertirlo
    return camino;
  }
  
  //La fórmula de Haversine te dará la distancia en línea recta entre las estaciones, que puedes convertir en una estimación de tiempo de viaje multiplicando por el tiempo promedio que se tarda en viajar 1 km.
  private double calcularEstimado(Estacion desde, Estacion hasta) {
    double deltaLat = Math.toRadians(hasta.latitud - desde.latitud);
    double deltaLon = Math.toRadians(hasta.longitud - desde.longitud);
    double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
              Math.cos(Math.toRadians(desde.latitud)) * Math.cos(Math.toRadians(hasta.latitud)) *
              Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distancia = RADIO_TIERRA_KM * c;

    // Suponiendo que se tiene un tiempo de viaje promedio por kilómetro, se puede calcular una estimación
    double tiempoPromedioPorKm = 2; // El tiempo promedio que se tarda en recorrer 1 km (TODO: Averiguar cual es el tiempo real)
    return distancia * tiempoPromedioPorKm;
  }

  public static void main(String[] args) {
    // Crear y configurar el grafo
    // Implementar y ejecutar el algoritmo A*
    Grafo metro = new Grafo();
    // Añadir estaciones
    metro.agregarEstacion("Bellecour", 'A', 45.75794, 4.83368);
    metro.agregarEstacion("Bellecour", 'D', 45.75794, 4.83368);
    // ... Añadir el resto de las estaciones con su respectiva línea

    // Añadir conexiones
    metro.agregarConexion("Bellecour", 'A', "Vieux Lyon", 'D', 2); // Ejemplo de tiempo entre estaciones
    // ... Añadir el resto de las conexiones
    
    // Nota: Se asume un tiempo estándar entre estaciones. Debes ajustar según datos reales.
  }
}
