package app;

import data.GestorPersonas;
import data.LectorArchivos;
import model.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase principal del sistema. Carga los datos desde archivos .txt,
 * los organiza en colecciones, y demuestra las funcionalidades
 * del sistema Llanquihue Tour.
 */
public class Main {

    public static void main(String[] args) {

        LectorArchivos lector = new LectorArchivos();
        GestorPersonas gestor = new GestorPersonas();

        System.out.println("=== CARGANDO DATOS DESDE ARCHIVOS .TXT ===\n");

        List<Cliente> clientes = lector.leerClientes("clientes.txt");
        for (Cliente c : clientes) {
            gestor.agregarCliente(c);
            c.registrar();
        }

        List<Empleado> empleados = lector.leerEmpleados("empleados.txt");
        for (Empleado e : empleados) {
            gestor.agregarEmpleado(e);
            e.registrar();
        }

        List<Proveedor> proveedores = lector.leerProveedores("proveedores.txt");
        for (Proveedor p : proveedores) {
            gestor.agregarProveedor(p);
            p.registrar();
        }

        System.out.println("\n=== TODAS LAS PERSONAS REGISTRADAS (polimorfismo + instanceof) ===\n");
        gestor.mostrarTodasLasPersonas();

        System.out.println("\n=== BUSQUEDA DE CLIENTE POR RUT (HashMap) ===\n");
        Cliente encontrado = gestor.buscarClientePorRut("16789234-5");
        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("\n=== REGISTRO DE RESERVAS (Stack) ===\n");
        PaqueteTuristico paquete1 = new PaqueteTuristico("PT-01", "Tour Volcan Osorno", 45000, 1);
        PaqueteTuristico paquete2 = new PaqueteTuristico("PT-02", "Ruta Lagos y Volcanes", 89000, 3);

        if (!clientes.isEmpty()) {
            Reserva reserva1 = new Reserva(clientes.get(0), paquete1, LocalDate.now());
            gestor.registrarReserva(reserva1);
            System.out.println("Reserva creada: " + reserva1);

            if (clientes.size() > 1) {
                Reserva reserva2 = new Reserva(clientes.get(1), paquete2, LocalDate.now());
                gestor.registrarReserva(reserva2);
                System.out.println("Reserva creada: " + reserva2);
            }
        }

        gestor.mostrarUltimaReserva();

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
