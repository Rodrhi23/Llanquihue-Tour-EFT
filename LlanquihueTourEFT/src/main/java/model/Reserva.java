package model;

import java.time.LocalDate;

/**
 * Representa la reserva de un paquete turistico por parte de un cliente.
 * Es una clase de composicion: contiene un Cliente y un PaqueteTuristico.
 */
public class Reserva {

    private Cliente cliente;
    private PaqueteTuristico paquete;
    private LocalDate fechaReserva;

    public Reserva(Cliente cliente, PaqueteTuristico paquete, LocalDate fechaReserva) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.fechaReserva = fechaReserva;
        cliente.incrementarReservas();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    @Override
    public String toString() {
        return "Reserva [" + fechaReserva + "] " + cliente.getNombre() + " -> " + paquete.getNombre();
    }
}