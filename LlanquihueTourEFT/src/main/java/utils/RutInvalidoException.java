package utils;

/**
 * Excepcion personalizada que se lanza cuando un RUT no cumple
 * con el formato esperado (ej: 12345678-9).
 */
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}