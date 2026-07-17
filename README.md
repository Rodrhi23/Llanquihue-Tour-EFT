# Llanquihue Tour EFT - Sistema de Gestion Turistica

## Descripcion general del sistema

Este proyecto es un prototipo de software en Java. Simula un sistema de gestion para la agencia de turismo **Llanquihue Tour**, permitiendo digitalizar el registro de clientes, empleados y proveedores, asi como la gestion de reservas de paquetes turisticos.

El sistema aplica los principios fundamentales de la Programacion Orientada a Objetos: encapsulamiento, composicion, herencia, polimorfismo, interfaces y manejo de excepciones personalizadas, ademas de trabajar con colecciones dinamicas (ArrayList, HashMap, Stack) y carga de datos desde archivos de texto externos.

## Estructura de paquetes

- **model/**: Clases de dominio del sistema.
  - `Persona`: clase abstracta base, contiene (por composicion) un `Rut` y una `Direccion`.
  - `Cliente`, `Empleado`, `Proveedor`: subclases de `Persona`, cada una implementa la interfaz `Registrable`.
  - `Registrable`: interfaz con los metodos `registrar()` y `mostrarDatos()`.
  - `Rut`: representa un RUT validado (lanza `RutInvalidoException` si el formato es incorrecto).
  - `Direccion`: representa una direccion postal simple (calle, comuna).
  - `PaqueteTuristico`: representa un tour o paquete ofrecido por la agencia.
  - `Reserva`: clase de composicion que asocia un `Cliente` con un `PaqueteTuristico` y una fecha.
- **utils/**: Clases de apoyo.
  - `RutInvalidoException`: excepcion personalizada para validar el formato del RUT.
- **data/**: Manejo de datos.
  - `LectorArchivos`: lee los archivos `.txt` (clientes, empleados, proveedores) y los convierte en objetos.
  - `GestorPersonas`: administra las colecciones del sistema (ArrayList de personas, HashMap de clientes por RUT, Stack de reservas).
- **app/**: Punto de entrada del sistema.
  - `Main`: clase principal, ejecuta la carga de datos y demuestra todas las funcionalidades del sistema.

## Resumen de clases principales

| Clase | Funcion |
|---|---|
| `Persona` | Superclase abstracta con atributos comunes (nombre, rut, direccion, telefono) |
| `Cliente` | Persona que reserva paquetes turisticos; lleva el conteo de sus reservas |
| `Empleado` | Persona que trabaja en la agencia (guia, administrativo, etc.) con cargo y sueldo |
| `Proveedor` | Persona/empresa externa que presta un servicio (transporte, alojamiento, etc.) |
| `Rut` | Valida y encapsula un RUT chileno |
| `Direccion` | Encapsula calle y comuna |
| `PaqueteTuristico` | Representa un tour disponible para reservar |
| `Reserva` | Asocia un cliente con un paquete turistico en una fecha determinada |
| `LectorArchivos` | Lee los `.txt` y construye los objetos correspondientes |
| `GestorPersonas` | Administra las colecciones (ArrayList, HashMap, Stack) y la logica de negocio |

## Colecciones utilizadas

- **ArrayList / List\<Registrable\>**: almacena todas las personas del sistema (clientes, empleados, proveedores) de forma polimorfica.
- **HashMap\<String, Cliente\>**: permite buscar un cliente de forma inmediata usando su RUT como clave.
- **Stack\<Reserva\>**: mantiene un historial de reservas, siguiendo la logica LIFO (la ultima reserva registrada es la primera en consultarse).

## Archivos de datos

El sistema carga datos de prueba desde 3 archivos de texto ubicados en la raiz del proyecto:
- `clientes.txt`
- `empleados.txt`
- `proveedores.txt`

Cada linea representa un registro, con los campos separados por `;`.

## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio:
   ```
   git clone https://github.com/Rodrhi23/LlanquihueTourEFT.git
   ```
2. Abre el proyecto en NetBeans (proyecto Maven) o en IntelliJ IDEA.
3. Verifica que los archivos `clientes.txt`, `empleados.txt` y `proveedores.txt` esten ubicados en la raiz del proyecto.
4. Ejecuta la clase `Main` (paquete `app`), o corre `mvn exec:java` desde la terminal en la carpeta del proyecto.
5. El programa mostrara por consola:
   - La carga de clientes, empleados y proveedores desde los archivos `.txt`.
   - El listado completo de personas registradas, diferenciando su tipo mediante `instanceof`.
   - Una busqueda de cliente por RUT utilizando el HashMap.
   - El registro de reservas de ejemplo utilizando el Stack.

## Principios de POO aplicados

- **Encapsulamiento**: todos los atributos son `private`, con acceso mediante getters y setters.
- **Composicion**: `Persona` contiene un `Rut` y una `Direccion`; `Reserva` contiene un `Cliente` y un `PaqueteTuristico`.
- **Herencia**: `Cliente`, `Empleado` y `Proveedor` extienden de `Persona`.
- **Polimorfismo e interfaces**: `Registrable` es implementada por las 3 subclases, y se recorre una coleccion `List<Registrable>` aplicando `instanceof` para diferenciar el comportamiento.
- **Manejo de excepciones**: `RutInvalidoException` valida el formato del RUT al construir un objeto `Rut`.
