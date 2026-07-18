package model;

/**
 * Representa a un proveedor externo (transporte, alojamiento, etc.).
 * Extiende Persona e implementa Registrable.
 */
public class Proveedor extends Persona implements Registrable {

    private String tipoServicio;
    private String empresa;

    public Proveedor(String nombre, Rut rut, Direccion direccion, String telefono, String tipoServicio, String empresa) {
        super(nombre, rut, direccion, telefono);
        this.tipoServicio = tipoServicio;
        this.empresa = empresa;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void registrar() {
        System.out.println("Proveedor registrado: " + getNombre() + " - Empresa: " + empresa);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("[Proveedor] " + toString() + " | Tipo de servicio: " + tipoServicio
                + " | Empresa: " + empresa);
    }
}