package clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(String idReserva, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = 0.0; // Calculado después
    }

    public void confirmarReserva(boolean seguro, boolean gps) {
        // Calcula el número de días de la reserva
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);

        // Calcula el costo total con seguro y GPS
        this.costoTotal = vehiculo.calcularPrecio((int) dias, seguro, gps);

        // Marca el vehículo como no disponible (reservado)
        vehiculo.setDisponibilidad(false);
    }


    // Getters y setters
    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
