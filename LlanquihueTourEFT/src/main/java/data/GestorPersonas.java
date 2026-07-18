package data;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Clase central que gestiona las colecciones de personas y reservas
 * del sistema: lista general, mapa de busqueda por rut, y pila de reservas.
 */
public class GestorPersonas {

    private List<Registrable> personas;
    private HashMap<String, Cliente> clientesPorRut;
    private Stack<Reserva> historialReservas;

    public GestorPersonas() {
        this.personas = new ArrayList<>();
        this.clientesPorRut = new HashMap<>();
        this.historialReservas = new Stack<>();
    }

    public void agregarCliente(Cliente cliente) {
        personas.add(cliente);
        clientesPorRut.put(cliente.getRut().getNumero(), cliente);
    }

    public void agregarEmpleado(Empleado empleado) {
        personas.add(empleado);
    }

    public void agregarProveedor(Proveedor proveedor) {
        personas.add(proveedor);
    }

    public Cliente buscarClientePorRut(String rut) {
        return clientesPorRut.get(rut);
    }

    public void registrarReserva(Reserva reserva) {
        historialReservas.push(reserva);
    }

    public void mostrarUltimaReserva() {
        if (historialReservas.isEmpty()) {
            System.out.println("No hay reservas registradas todavia.");
        } else {
            System.out.println("Ultima reserva: " + historialReservas.peek());
        }
    }

    public void mostrarTodasLasPersonas() {
        for (Registrable r : personas) {
            r.mostrarDatos();

            if (r instanceof Cliente) {
                System.out.println("   -> Es un Cliente, con " + ((Cliente) r).getTotalReservas() + " reservas");
            } else if (r instanceof Empleado) {
                System.out.println("   -> Es un Empleado, cargo: " + ((Empleado) r).getCargo());
            } else if (r instanceof Proveedor) {
                System.out.println("   -> Es un Proveedor, servicio: " + ((Proveedor) r).getTipoServicio());
            }
        }
    }

    public List<Registrable> getPersonas() {
        return personas;
    }
}