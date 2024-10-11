package clases;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear administrador y añadir vehículos
        Administrador admin = new Administrador();
        Auto auto1 = new Auto("A001", "Toyota", "Corolla", 2020, 20000, "Gasolina");
        Camioneta camioneta1 = new Camioneta("C001", "Ford", "Ranger", 2021, 80000, 1000);
        admin.añadirVehiculo(auto1);
        admin.añadirVehiculo(camioneta1);

        // Listar vehículos disponibles
        System.out.println("Vehículos disponibles antes de la reserva:");
        for (Vehiculo veh : admin.listarVehiculosDisponibles()) {
            System.out.println(veh.getIdVehiculo() + " - " + veh.getMarca() + " " + veh.getModelo() + " (Tipo: " + veh.getClass().getSimpleName() + ")");
        }

        // Pedir al usuario que ingrese los detalles de la reserva
        System.out.println("Ingrese su nombre:");
        String nombreCliente = scanner.nextLine();
        Cliente cliente1 = new Cliente("C001", nombreCliente);

        System.out.println("¿Qué vehículo desea reservar? Ingrese el ID del vehículo (e.j., A001 para Auto o C001 para Camioneta):");
        String idVehiculo = scanner.nextLine();
        Vehiculo vehiculoSeleccionado = null;

        // Buscar el vehículo basado en el ID
        for (Vehiculo veh : admin.listarVehiculosDisponibles()) {
            if (veh.getIdVehiculo().equals(idVehiculo)) {
                vehiculoSeleccionado = veh;
                break;
            }
        }

        // Si no se encuentra el vehículo, muestra un error
        if (vehiculoSeleccionado == null) {
            System.out.println("Vehículo no encontrado. Por favor, intente de nuevo.");
            return;
        }

        System.out.println("Has seleccionado: " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo() + " (Tipo: " + vehiculoSeleccionado.getClass().getSimpleName() + ")");

        System.out.println("Ingrese el número de días de la reserva:");
        int diasReserva = scanner.nextInt();
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(diasReserva);

        System.out.println("¿Desea seguro? (True/False):");
        boolean seguro = scanner.nextBoolean();

        System.out.println("¿Desea GPS? (True/False):");
        boolean gps = scanner.nextBoolean();

        // Reservar el vehículo
        cliente1.reservarVehiculo(vehiculoSeleccionado, fechaInicio, fechaFin, seguro, gps);

        // Mostrar el costo total de la reserva
        double costoTotal = vehiculoSeleccionado.calcularPrecio(diasReserva, seguro, gps);
        System.out.println("Reserva confirmada. El costo total es: $" + costoTotal);

        // Lista vehículos disponibles después de la reserva
        System.out.println("Vehículos disponibles después de la reserva:");
        for (Vehiculo veh : admin.listarVehiculosDisponibles()) {
            System.out.println(veh.getMarca() + " " + veh.getModelo());
        }

        // Añadir un nuevo vehículo como administrador
        Auto auto2 = new Auto("A002", "Honda", "Civic", 2019, 100.000, "Gasolina");
        admin.añadirVehiculo(auto2);

        // Verificar disponibilidad del nuevo vehículo
        boolean disponibilidad = admin.verificarDisponibilidad(auto2, LocalDate.now(), LocalDate.now().plusDays(1));
        System.out.println("Disponibilidad del nuevo auto (Honda Civic): " + (disponibilidad ? "Disponible" : "No disponible"));

        scanner.close();
    }
}
