package clases;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, double capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    // Getters
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    // Setters
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
