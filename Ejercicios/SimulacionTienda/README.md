# Enunciado

1. Crear una clase `Producto`:

La clase `Producto` debe tener los siguientes atributos privados:

- `codigo (tipo int)`: el código único del producto.
- `nombre (tipo String)`: el nombre del producto.
- `precio (tipo double)`: el precio del producto.

Requerimientos:

- Crear un constructor que permita inicializar todos los atributos de la clase.
- Crear métodos getters y setters para cada atributo.
- Crear un método `mostrarInformacion()` que imprima los detalles del producto.

2. Crear una clase `Cliente`:

La clase `Cliente` debe tener los siguientes atributos privados:

- `dni (tipo String)`: el documento de identidad del cliente.
- `nombre (tipo String)`: el nombre del cliente.
- `saldo (tipo double)`: el saldo disponible del cliente para realizar compras.

Requerimientos:

- Crear un constructor para inicializar los atributos.
- Crear los getters y setters correspondientes.
- Crear un método `comprarProducto(Producto producto)` que verifique si el cliente tiene saldo suficiente para comprar un producto, reduzca el saldo en caso afirmativo e imprima un mensaje que confirme la compra o indique que no es posible realizarla.

**NOTA:** El enunciado original tenía más requerimientos, pero ha sido modificado con menos requerimientos, por eso tengo clases de más.
