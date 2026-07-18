package model;

/**
 * Representa a un cliente de la agencia Llanquihue Tour.
 * Extiende Persona e implementa Registrable.
 */
public class Cliente extends Persona implements Registrable {

    private String correo;
    private int totalReservas;

    public Cliente(String nombre, Rut rut, Direccion direccion, String telefono, String correo) {
        super(nombre, rut, direccion, telefono);
        this.correo = correo;
        this.totalReservas = 0;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTotalReservas() {
        return totalReservas;
    }

    public void incrementarReservas() {
        this.totalReservas++;
    }

    @Override
    public void registrar() {
        System.out.println("Cliente registrado: " + getNombre() + " (RUT: " + getRut() + ")");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("[Cliente] " + toString() + " | Correo: " + correo
                + " | Reservas realizadas: " + totalReservas);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}