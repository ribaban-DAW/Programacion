# Enunciado

- Crea una clase Empleado que tenga los siguientes atributos privados: Nif, Nombre, Sueldo base, Horas extra realizadas en el mes, Tipo de IRPF (%), Casado o no, Número de hijos, Importe de la hora extra. Este será un atributo static o atributo de clase.
- Los objetos Empleado se podrán crear con un constructor por defecto y con un constructor con todos los parámetros menos el Importe de la hora extra.
Además de los métodos getter/setter la clase Empleado tendrá estos métodos:
- Método para el cálculo del complemento correspondiente a las horas extra realizadas.
- Método para calcular el sueldo bruto (sueldo base + complemento por horas extras)
- Método para calcular las retenciones por IRPF. El porcentaje de IRPF se aplica sobre el sueldo bruto, teniendo en cuenta que el porcentaje que hay que aplicar es el tipo menos 2 puntos si el empleado está casado y menos 1 punto adicional por cada hijo que tenga.
- Método toString() para mostrar los datos de los empleados de la siguiente forma:

```
12345678A Lucas Guerrero Arjona
Sueldo Base: 1150.0
Horas extras: 4
tipo IRPF: 15.0
Casado: S
Número de Hijos: 2
```

Una vez creada la clase Empleado, la utilizaremos en un programa que lea empleados y los guarde en un array estático. El número total de empleados se pide por teclado. El número máximo de empleados es de 20.
Después de leer los datos de los empleados se pedirá que se introduzca el importe correspondiente al pago por hora extra asignándoselo al atributo estático de la clase. A continuación, el programa mostrará el sueldo neto de cada uno de los empleados.
