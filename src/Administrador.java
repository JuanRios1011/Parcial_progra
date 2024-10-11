package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        this.flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
        System.out.println("Vehículo añadido a la flota.");
    }

    public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        return vehiculo.isDisponible(); // Aquí podrías añadir lógica más compleja para verificar reservas existentes
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    // Getters y setters
    public List<Vehiculo> getFlota() {
        return flota;
    }

    public void setFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }
}
