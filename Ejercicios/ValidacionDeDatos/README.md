# Enunciado

## Objetivo:

Implementar un programa en Java que solicite al usuario que introduzca varios tipos de datos personales y valide cada uno de ellos utilizando expresiones regulares. El programa debe proporcionar un menú que permita al usuario elegir qué dato desea introducir y validar.

## Datos a validar

- Nombre: Debe comenzar con una letra y contener solo letras (tanto mayúsculas como minúsculas), espacios, y caracteres especiales como "ñ" y vocales acentuadas.

    - Expresión regular: ^[A-Za-zÁÉÍÓÚáéíóúñÑ]+( [A-Za-zÁÉÍÓÚáéíóúñÑ]+)*$
    - Ejemplo válido: Juan Pérez, María López, José García.

- Apellidos: Deben contener solo letras, espacios y caracteres especiales como "ñ" y vocales acentuadas.

    - Ejemplo válido: García Márquez, López Fernández.

- Número de teléfono: Formato: +34 600 123 456 o 600 123 456.

    - Ejemplo válido: +34 600 123 456, 600 123 456.

- Correo electrónico: Debe contener un formato válido de correo electrónico.

    - Ejemplo válido: usuario@dominio.com, nombre.apellido@ejemplo.es.

- DNI: Debe contener 8 dígitos seguidos de una letra.

    - Ejemplo válido: 12345678A.

- IBAN: Formato de cuenta bancaria IBAN español: ESXX 0000 0000 0000 0000 0000.

    - Ejemplo válido: ES12 1234 5678 9012 3456 7890.

- Fecha de nacimiento: Formato dd/mm/yyyy.

    - Ejemplo válido: 15/04/1990.

- Código postal: Debe ser un número de 5 dígitos.

    - Ejemplo válido: 28001.

- Número de tarjeta de crédito: Debe tener 16 dígitos en el formato 1234 5678 9012 3456.

    - Ejemplo válido: 1234 5678 9012 3456.

- Placa de vehículo: Formato: 1234 ABC (4 números seguidos de un espacio y 3 letras).

    - Ejemplo válido: 1234 ABC, 5678 DEF.
- Número de la Seguridad Social: Formato más largo, que puede ser algo como 123-45-6789.

    - Ejemplo válido: 123-45-6789.

- URL: Debe ser una URL válida.

    - Ejemplo válido: http://www.ejemplo.com, https://www.ejemplo.es, https://www.mis-sitios.co.uk

Deberás implementar una función para cada una de las validaciones que muestre un mensaje si los datos solicitados son o no correctos.
