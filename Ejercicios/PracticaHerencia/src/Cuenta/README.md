# Enunciado

Desarrollar un programa que modele una cuenta bancaria que tiene los siguientes atributos, que deben ser de acceso protegido:

- Saldo, de tipo float.
- Número de consignaciones con valor inicial cero, de tipo int.
- Número de retiros con valor inicial cero, de tipo int.
- Tasa anual (porcentaje), de tipo float.
- Comisión mensual con valor inicial cero, de tipo float.

La clase Cuenta tiene un constructor que inicializa los atributos saldo y tasa anual con valores pasados como parámetros. La clase Cuenta tiene los siguientes métodos:

- Consignar una cantidad de dinero en la cuenta actualizando su saldo.
- Retirar una cantidad de dinero en la cuenta actualizando su saldo. El valor a retirar no debe superar el saldo.
- Calcular el interés mensual de la cuenta y actualiza el saldo correspondiente.
- Extracto mensual: actualiza el saldo restándole la comisión mensual y calculando el interés mensual correspondiente (invoca el método anterior).
- Imprimir: muestra en pantalla los valores de los atributos.

La clase Cuenta tiene dos clases hijas:

- Cuenta de ahorros: posee un atributo para determinar si la cuenta de ahorros está
activa (tipo boolean). Si el saldo es menor a $10000, la cuenta está inactiva, en
caso contrario se considera activa. Los siguientes métodos se redefinen:

  - Consignar: se puede consignar dinero si la cuenta está activa. Debe invocar al método heredado.
  - Retirar: es posible retirar dinero si la cuenta está activa. Debe invocar al método heredado.
  - Extracto mensual: si el número de retiros es mayor que 4, por cada retiro adicional, se cobra $1000 como comisión mensual. Al generar el extracto, se determina si la cuenta está activa o no con el saldo.
  - Un nuevo método imprimir que muestra en pantalla el saldo de la cuenta, la comisión mensual y el número de transacciones realizadas (suma de cantidad de consignaciones y retiros).

- Cuenta corriente: posee un atributo de sobregiro, el cual se inicializa en cero. Se
redefinen los siguientes métodos:

	- Retirar: se retira dinero de la cuenta actualizando su saldo. Se puede retirar dinero superior al saldo. El dinero que se debe queda como sobregiro.
	- Consignar: invoca al método heredado. Si hay sobregiro, la cantidad consignada reduce el sobregiro.
  - Extracto mensual: invoca al método heredado.
  - Un nuevo método imprimir que muestra en pantalla el saldo de la cuenta, la comisión mensual, el número de transacciones realizadas (suma de cantidad de consignaciones y retiros) y el valor de sobregiro.

Realizar un método main que implemente un objeto Cuenta de ahorros y llame a los
métodos correspondientes.