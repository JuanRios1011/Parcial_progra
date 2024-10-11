package clases;


public abstract class Vehiculo {
    protected String idVehiculo;
    protected String marca;
    protected String modelo;
    protected int año;
    protected double costoDiario;
    protected boolean disponibilidad;

    // Constructor
    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double precioBase = dias * this.costoDiario;
        if (seguro) {
            precioBase += precioBase * 0.10; // 10% adicional por seguro
        }
        if (gps) {
            precioBase += 5 * dias; // $5 adicionales por cada día con GPS
        }
        return precioBase;
    }


    // Getters
    public String getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    // Setters
    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}