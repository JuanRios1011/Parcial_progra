package clases;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int año, double costoDiario, int cilindrada) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.cilindrada = cilindrada;
    }

    // Getters
    public int getCilindrada() {
        return cilindrada;
    }

    // Setters
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
