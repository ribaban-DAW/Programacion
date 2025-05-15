CREATE TABLE IF NOT EXISTS Usuario(
	PK_ID INT AUTO_INCREMENT,
	Nombre VARCHAR(50) UNIQUE,
	Contraseña VARCHAR(255) NOT NULL,
	Rol SET('normal', 'admin') DEFAULT 'normal',

	PRIMARY KEY (PK_ID)
);

INSERT INTO Usuario(Nombre, Contraseña, Rol)
VALUES
('usuario', 'si', 'normal'),
('admin', 'no', 'admin'),
('lamron', 'puede', 'normal');
