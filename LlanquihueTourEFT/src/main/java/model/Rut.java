package model;

import utils.RutInvalidoException;

/**
 * Representa un RUT chileno validado.
 * Se usa por composicion dentro de la clase Persona.
 */
public class Rut {

    private String numero;

    public Rut(String numero) throws RutInvalidoException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws RutInvalidoException {
        if (numero == null || !numero.matches("\\d{7,8}-[\\dkK]")) {
            throw new RutInvalidoException("RUT invalido: " + numero + ". Formato esperado: 12345678-9");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}
