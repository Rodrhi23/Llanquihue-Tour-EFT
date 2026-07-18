package model;

/**
 * Contrato comun para toda entidad que pueda registrarse
 * y mostrar sus datos en el sistema.
 */
public interface Registrable {

    void registrar();

    void mostrarDatos();
}