# Llanquihue Tour EFT - Sistema de Gestion Turistica

## Descripcion general del sistema

Este proyecto es un prototipo de software en Java. Simula un sistema de gestion para la agencia de turismo **Llanquihue Tour**, permitiendo digitalizar el registro de clientes, empleados y proveedores, asi como la gestion de reservas de paquetes turisticos.

El sistema aplica los principios fundamentales de la Programacion Orientada a Objetos: encapsulamiento, composicion, herencia, polimorfismo, interfaces y manejo de excepciones personalizadas, ademas de trabajar con colecciones dinamicas (ArrayList, HashMap, Stack) y carga de datos desde archivos de texto externos.


Paquetes

model: las clases principales (Persona, Cliente, Empleado, Proveedor, Rut, Direccion, PaqueteTuristico, Reserva, y la interfaz Registrable).
utils: RutInvalidoException, para validar que el RUT venga bien formateado.
data: LectorArchivos (lee los .txt) y GestorPersonas (maneja las listas y busquedas).
app: Main, la clase que corre todo.

Como funciona por dentro

Persona es la clase base, de ahi heredan Cliente, Empleado y Proveedor.
Cada una implementa Registrable, con sus metodos registrar() y mostrarDatos().
Persona tiene un Rut y una Direccion (composicion).
Se usan 3 tipos de colecciones: ArrayList (lista general), HashMap (busqueda rapida por rut), Stack (historial de reservas).

Como correrlo

Abrir el proyecto en NetBeans.
Revisar que clientes.txt, empleados.txt y proveedores.txt esten en la raiz del proyecto (al lado del pom.xml).
Correr la clase Main (paquete app).
Deberia mostrar en consola: carga de datos, listado de todas las personas, busqueda de un cliente por rut, y las reservas guardadas.
