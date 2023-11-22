import java.util.*;

public class MetroLyon {

  static class Estacion {
    String nombre;
    char linea;
    Estacion(String nombre, char linea) {
      this.nombre = nombre;
      this.linea = linea;
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

  private double calcularEstimado(Estacion desde, Estacion hasta) {
    // Supongamos que el tiempo promedio entre cada estación es de 2 minutos
    double tiempoPromedioPorEstacion = 2.0;

    // La estimación puede ser el número de letras de diferencia en los nombres,
    // lo que es un placeholder para un cálculo basado en la posición o índice de las estaciones
    int estimacionDeNumeroDeEstaciones = Math.abs(desde.nombre.length() - hasta.nombre.length());

    // Devolvemos una estimación del tiempo total basada en la cantidad de estaciones intermedias
    return estimacionDeNumeroDeEstaciones * tiempoPromedioPorEstacion;
  }

  public static void main(String[] args) {
    // Crear y configurar el grafo
    // Implementar y ejecutar el algoritmo A*
    Grafo metro = new Grafo();
    // Añadir estaciones
    metro.agregarEstacion("Bellecour", 'A');
    // ... Añadir el resto de las estaciones con su respectiva línea

    // Añadir conexiones
    metro.agregarConexion("Bellecour", 'A', "Vieux Lyon", 'D', 2); // Ejemplo de tiempo entre estaciones
    // ... Añadir el resto de las conexiones
    
    // Nota: Se asume un tiempo estándar entre estaciones. Debes ajustar según datos reales.
  }
}
