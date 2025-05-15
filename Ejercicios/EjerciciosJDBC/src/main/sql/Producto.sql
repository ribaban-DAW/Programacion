CREATE TABLE IF NOT EXISTS Producto(
	PK_ID INT AUTO_INCREMENT,
	Nombre VARCHAR(50),
	Precio DOUBLE(10,2),
	Imagen VARCHAR(2048) DEFAULT '',

	PRIMARY KEY (PK_ID)
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
