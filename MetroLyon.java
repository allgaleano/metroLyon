import java.util.*;

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
      for (Estacion estacion : adyacencias.keySet()) {
        if (estacion.nombre.equals(nombre)) {
          return estacion;
        }
      }
      throw new IllegalArgumentException("Estación no encontrada: " + nombre);
    }
  }

  public static void main(String[] args) {
    // Crear y configurar el grafo
    // Implementar y ejecutar el algoritmo A*
    Grafo metro = new Grafo();
    // Crear estaciones
    Estacion bellecourA = new Estacion("Bellecour", 'A', 45.75794, 4.83368);
    Estacion bellecourD = new Estacion("Bellecour", 'D', 45.75794, 4.83368);
    // ... Crear el resto de las estaciones

    // Añadir estaciones al grafo
    metro.agregarEstacion(bellecourA);
    metro.agregarEstacion(bellecourD);
    // ... Añadir el resto de las estaciones al grafo

    // Añadir conexiones
    // Debes obtener las estaciones destino y origen mediante el método obtenerEstacion
    metro.agregarConexion(bellecourA.nombre, bellecourD.nombre, 2); // Ejemplo de tiempo entre estaciones
    // ... Añadir el resto de las conexiones

    // Nota: Se asume un tiempo estándar entre estaciones. Debes ajustar según datos reales.

  }
}
