package src.metro;

public class Estacion {

    private String nombre;
    private char linea;
    private double latitud;
    private double longitud;

    Estacion(String nombre, char linea, double latitud, double longitud) {
      this.nombre = nombre;
      this.linea = linea;
      this.latitud = latitud;
      this.longitud = longitud;
    }

    double distanciaEuclidiana(Estacion otra) {
      double xDiff = otra.longitud - this.longitud;
      double yDiff = otra.latitud - this.latitud;
      return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para linea
    public char getLinea() {
        return linea;
    }

    // Setter para linea
    public void setLinea(char linea) {
        this.linea = linea;
    }

    // Getter para latitud
    public double getLatitud() {
        return latitud;
    }

    // Setter para latitud
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    // Getter para longitud
    public double getLongitud() {
        return longitud;
    }

    // Setter para longitud
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
