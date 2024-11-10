# Enunciado

Un conocido comercio para el que estás desarrollando su nuevo sitio web te ha encargado que realices una validación inicial de las referencias que aparecen en las etiquetas de sus productos y que, además, gestiones un inventario pequeño de estos productos. La etiqueta sigue el formato `2022—xrFdS/25_9`, donde:

- Los primeros 4 caracteres deben ser numéricos.
- A continuación, debe haber un guion (-).
- Los siguientes cinco caracteres son combinaciones de letras minúsculas y mayúsculas.
- Luego debe aparecer una barra inclinada (/).
- Después, dos dígitos numéricos.
- Seguidos de un guion bajo (_) y, por último, un dígito.

Crea una clase llamada Etiqueta, que de momento tenga las siguientes propiedades y métodos:

Propiedades:

- `nombreArticulo`: el nombre del producto.
- `referenciaArticulo`: la referencia o código del artículo.
- `inventario`: un número que indique la cantidad disponible del artículo en el inventario.
- `precio`: el precio del artículo.

Métodos:
- `mostrarArticulo()`: muestra el nombre del artículo, su referencia, la cantidad disponible en el inventario y su precio.
- `validarEtiqueta()`: verifica que la referencia del artículo cumpla con el formato especificado.
- `agregarInventario(cantidad)`: incrementa el inventario en la cantidad especificada.
- `reducirInventario(cantidad)`: reduce el inventario en la cantidad especificada, siempre que haya suficientes unidades.
- `actualizarPrecio(nuevoPrecio)`: permite actualizar el precio del artículo.

Luego, crea un objeto de esta clase y prueba los métodos para comprobar que la referencia se valida correctamente, que se puede consultar el inventario, actualizar el precio, y que los métodos para añadir y reducir inventario funcionan de manera adecuada.

**Duración de la prueba**: 1 hora
