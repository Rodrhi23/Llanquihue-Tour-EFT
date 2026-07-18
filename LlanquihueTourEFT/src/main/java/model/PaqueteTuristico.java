package model;

/**
 * Representa un paquete o tour turistico ofrecido por la agencia.
 */
public class PaqueteTuristico {

    private String codigo;
    private String nombre;
    private double precio;
    private int duracionDias;

    public PaqueteTuristico(String codigo, String nombre, double precio, int duracionDias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.duracionDias = duracionDias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | $" + precio + " | " + duracionDias + " dias";
    }
}