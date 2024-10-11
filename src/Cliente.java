package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        // Verificar si el cliente ya tiene una reserva activa
        for (Reserva reserva : reservas) {
            if (reserva.getFechaFin().isAfter(LocalDate.now())) {
                System.out.println("El cliente ya tiene una reserva activa.");
                return;
            }
        }

        // Crear una nueva reserva si el vehículo está disponible
        if (vehiculo.isDisponible()) {
            Reserva nuevaReserva = new Reserva("R" + reservas.size() + 1, this, vehiculo, fechaInicio, fechaFin);
            nuevaReserva.confirmarReserva(seguro, gps);
            reservas.add(nuevaReserva);
            System.out.println("Reserva confirmada.");
        } else {
            System.out.println("El vehículo no está disponible.");
        }
    }

    // Getters y setters
    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
