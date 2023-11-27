package src.metro;

public class Conexion {
    Estacion destino;
    double tiempo;

    Conexion(Estacion destino, double tiempo) {
      this.destino = destino;
      this.tiempo = tiempo;
    }

    // Getter para destino
    public Estacion getDestino() {
        return destino;
    }

    // Setter para destino
    public void setDestino(Estacion destino) {
        this.destino = destino;
    }

    // Getter para tiempo
    public double getTiempo() {
        return tiempo;
    }

    // Setter para tiempo
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
}
