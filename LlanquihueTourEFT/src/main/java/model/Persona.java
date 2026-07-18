package model;

/**
 * Clase base que representa a una persona dentro del sistema.
 * Contiene atributos comunes a Cliente, Empleado y Proveedor,
 * y utiliza composicion con Rut y Direccion.
 */
public abstract class Persona {

    private String nombre;
    private Rut rut;
    private Direccion direccion;
    private String telefono;

    public Persona(String nombre, Rut rut, Direccion direccion, String telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Sin Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | RUT: " + rut + " | Direccion: " + direccion
                + " | Telefono: " + telefono;
    }
}
