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

3. Crear una clase `Videojuego`:

La clase `Videojuego` es una subclase de `Producto`, y debe tener los siguientes atributos adicionales:

- `genero (tipo String)`: el género del videojuego (ej. acción, aventura, deportes).
- `plataforma (tipo String)`: la plataforma del videojuego (ej. PlayStation, Xbox, PC).

Requerimientos:

- Crear un constructor que inicialice todos los atributos, tanto los de la clase padre (`Producto`) como los nuevos.
- Sobrescribir el método `mostrarInformacion()` para que también muestre el género y la plataforma del videojuego.

4. Clase principal `Tienda`:

En la clase principal, crea un `main` donde se:

- Cree al menos un objeto de la clase `Videojuego`
- Cree un objeto de la clase `Cliente` 
- Llame al método `mostrarInformacion()` para mostrar los detalles del videojuego.
- Llame al método `comprarProducto()` para simular la compra del videojuego por parte del cliente.

## Extensiones opcionales:

- Agregar más productos o más tipos de clientes.
- Implementar descuentos para algunos productos o clientes VIP.
- Añadir validación de datos (por ejemplo, que el precio no sea negativo).
