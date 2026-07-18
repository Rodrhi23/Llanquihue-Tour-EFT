package data;

import model.*;
import utils.RutInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria encargada de leer los archivos .txt
 * y convertir cada linea en el objeto correspondiente.
 */
public class LectorArchivos {

    public List<Cliente> leerClientes(String rutaArchivo) {
        List<Cliente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(";");
                try {
                    Rut rut = new Rut(datos[1]);
                    Direccion direccion = new Direccion(datos[2], datos[3]);
                    Cliente cliente = new Cliente(datos[0], rut, direccion, datos[4], datos[5]);
                    lista.add(cliente);
                } catch (RutInvalidoException e) {
                    System.out.println("Linea omitida por RUT invalido: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de clientes: " + e.getMessage());
        }

        return lista;
    }

    public List<Empleado> leerEmpleados(String rutaArchivo) {
        List<Empleado> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(";");
                try {
                    Rut rut = new Rut(datos[1]);
                    Direccion direccion = new Direccion(datos[2], datos[3]);
                    double sueldo = Double.parseDouble(datos[6]);
                    Empleado empleado = new Empleado(datos[0], rut, direccion, datos[4], datos[5], sueldo);
                    lista.add(empleado);
                } catch (RutInvalidoException e) {
                    System.out.println("Linea omitida por RUT invalido: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de empleados: " + e.getMessage());
        }

        return lista;
    }

    public List<Proveedor> leerProveedores(String rutaArchivo) {
        List<Proveedor> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(";");
                try {
                    Rut rut = new Rut(datos[1]);
                    Direccion direccion = new Direccion(datos[2], datos[3]);
                    Proveedor proveedor = new Proveedor(datos[0], rut, direccion, datos[4], datos[5], datos[6]);
                    lista.add(proveedor);
                } catch (RutInvalidoException e) {
                    System.out.println("Linea omitida por RUT invalido: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de proveedores: " + e.getMessage());
        }

        return lista;
    }
}
