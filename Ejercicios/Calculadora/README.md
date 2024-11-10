# Enunciado

## Objetivo:

Desarrollar un programa en Java que simule el funcionamiento de una calculadora básica, utilizando estructuras de control para gestionar las operaciones solicitadas por el usuario.

## Requisitos:

El programa debe mostrar un menú al usuario con las siguientes opciones:

- Sumar
- Restar
- Multiplicar
- Dividir
- Salir

El programa debe:

- Utilizar una estructura alternativa switch para gestionar las opciones del menú.
- Incluir una estructura condicional que evite la división entre cero (cuando el usuario seleccione la opción de división y el divisor sea 0, el programa debe mostrar un mensaje de error).
- Implementar una estructura repetitiva (como do-while) que permita solicitar al usuario una operación hasta que se seleccione la opción "0" para salir.

## Detalles:

- Al elegir una operación, el programa debe solicitar dos números al usuario.
- Si el usuario elige la opción de división y el divisor es 0, se debe mostrar un mensaje de error indicando que no es posible dividir entre cero.
- El programa debe continuar mostrando el menú hasta que el usuario pulse "0" para salir.

Ejemplo de ejecución: 

```
---- Menú Calculadora ----
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
0. Salir
Elija una opción: 1
Ingrese el primer número: 10
Ingrese el segundo número: 5
El resultado de la suma es: 15.0
```
