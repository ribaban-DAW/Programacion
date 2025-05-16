# EjerciciosJDBC

## Enunciado

La aplicación mostrará inicialmente un formulario de inicio de sesión. Tras
introducir las credenciales, se comprobará si el usuario existe:

- Si no existe, se mostrará un mensaje de “Acceso denegado”.
- Si existe, se comprobará el tipo de usuario, que podrá ser uno de los
siguientes:

    1. Administrador (admin):

        Se mostrará una interfaz CRUD que permita:

        - Visualizar un listado de los usuarios.
        - Crear nuevos usuarios.
        - Modificar usuarios existentes.
        - Eliminar usuarios.

    2. Usuario normal:

        - Se ejecutará la aplicación del menú desarrollada en el tema anterior,
        permitiendo al usuario dar de alta un pedido en la base de datos.

Notas importantes:

- No puede haber dos usuarios con el mismo nombre de usuario.
- Se permite que diferentes usuarios tengan la misma contraseña.

## Configuración

Es necesario crear en `src/main/webapp/WEB-INF/classes` un archivo `.env`
siguiendo el `.env.example`.

```
DB_USERNAME=user
DB_PASSWORD=pass
```
