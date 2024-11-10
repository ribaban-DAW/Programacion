# Enunciado

Desarrollar un programa en Java que permita a un usuario ingresar el nombre y las notas de los tres trimestres de un alumno. El programa debe calcular el promedio de las notas y determinar si el alumno está "Aprobado" o "Suspenso".

## Requisitos:

- El programa debe solicitar al usuario que ingrese el nombre del alumno.
- El programa debe solicitar al usuario que ingrese las notas correspondientes a los tres trimestres usando un arreglo.
- Debe calcular el promedio de las notas ingresadas.
- Si el promedio es igual o superior a 5, el programa debe mostrar "Aprobado".
- Si el promedio es inferior a 5, el programa debe mostrar "Suspenso".
- Utilizar la clase Scanner para obtener la entrada del usuario.
- Asegurarse de manejar posibles errores de entrada, como valores no numéricos.

Ejemplo de ejecución:

```
Ingrese el nombre del alumno: Juan Pérez
Ingrese la nota del trimestre 1: 6
Ingrese la nota del trimestre 2: 7
Ingrese la nota del trimestre 3: 4
El estado del alumno Juan Pérez es: Aprobado
```

**Criterios de Aprobación**:

- El programa debe compilar y ejecutarse sin errores.
- Debe solicitar el nombre y las notas correctamente y mostrar el estado del alumno basado en el promedio calculado.

Nota: tanto para solicitar las tres notas como para calcular la media deberás usar dos bucles tipo for o for each que recorran el array que has utilizado y que podrás declarar de forma muy similar a esta:

`double[] notas = new double[3]`;
