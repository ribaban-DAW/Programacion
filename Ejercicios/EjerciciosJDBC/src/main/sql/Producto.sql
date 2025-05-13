CREATE DATABASE BaseDeDatos;
USE BaseDeDatos;

CREATE TABLE Producto(
	PK_ID INT AUTO_INCREMENT,
	Nombre VARCHAR(50),
	Precio DOUBLE(10,2),
	Imagen VARCHAR(2048) DEFAULT '',

	PRIMARY KEY (PK_ID)
);

CREATE TABLE Usuario(
	PK_ID INT AUTO_INCREMENT,
	Nombre VARCHAR(50),
	Rol SET('normal', 'admin') DEFAULT 'normal',

	PRIMARY KEY (PK_ID)
);

CREATE TABLE Pedido(
	PK_ID INT AUTO_INCREMENT,
	FK_ProductoID INT,
	FK_UsuarioID INT,

	PRIMARY KEY (PK_ID),

	CONSTRAINT FK_ProductoID
	FOREIGN KEY (FK_ProductoID)
	REFERENCES Producto(PK_ID)
	ON DELETE CASCADE,
	
	CONSTRAINT FK_UsuarioID
	FOREIGN KEY (FK_UsuarioID)
	REFERENCES Usuario(PK_ID)
	ON DELETE CASCADE
);

INSERT INTO Producto(Nombre, Precio)
VALUES
('Quinoa con verdura', 6.95),
('Pizza caprese', 5.50),
('Pasta al pesto', 4.90),
('Hamburguesa vegetariana', 6.20),
('Agua', 1.00),
('Cerveza', 1.50),
('Refresco', 1.40);
