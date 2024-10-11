package clases;

public class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Getters
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    // Setters
    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
}
