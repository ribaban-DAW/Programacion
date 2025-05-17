CREATE TABLE IF NOT EXISTS Producto(
	PK_ID INT AUTO_INCREMENT,
	Nombre VARCHAR(50),
	Precio DOUBLE(10,2),
	ImagenURL VARCHAR(2048) DEFAULT 'img/unknown.webp',

	PRIMARY KEY (PK_ID)
);

INSERT INTO Producto(Nombre, Precio, ImagenURL)
VALUES
('Quinoa con verdura', 6.95, 'img/quinoa-con-verdura.webp'),
('Pizza caprese', 5.50, 'img/pizza-caprese.webp'),
('Pasta al pesto', 4.90, 'img/pasta-al-pesto.webp'),
('Hamburguesa vegetariana', 6.20, 'img/hamburguesa-vegetariana.webp'),
('Agua', 1.00, 'img/agua.webp'),
('Cerveza', 1.50, 'img/cerveza.webp'),
('Refresco', 1.40, 'img/refresco.webp');
