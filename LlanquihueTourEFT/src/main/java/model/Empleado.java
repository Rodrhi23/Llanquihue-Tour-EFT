package model;

/**
 * Representa a un empleado de la agencia (ej: guia turistico, administrativo).
 * Extiende Persona e implementa Registrable.
 */
public class Empleado extends Persona implements Registrable {

    private String cargo;
    private double sueldo;

    public Empleado(String nombre, Rut rut, Direccion direccion, String telefono, String cargo, double sueldo) {
        super(nombre, rut, direccion, telefono);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo < 0) {
            this.sueldo = 0;
        } else {
            this.sueldo = sueldo;
        }
    }

    @Override
    public void registrar() {
        System.out.println("Empleado registrado: " + getNombre() + " - Cargo: " + cargo);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("[Empleado] " + toString() + " | Cargo: " + cargo + " | Sueldo: $" + sueldo);
    }
}
