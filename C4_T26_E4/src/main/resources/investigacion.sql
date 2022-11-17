DROP DATABASE IF EXISTS investigacion;
CREATE DATABASE investigacion;

USE investigacion;

DROP TABLE IF EXISTS facultad;

CREATE TABLE facultad (
  codigo int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) DEFAULT NULL,
  PRIMARY KEY (codigo)
);

DROP TABLE IF EXISTS investigadores;

CREATE TABLE investigadores (
  codigo int NOT NULL AUTO_INCREMENT,
  DNI varchar(8),
  nom_apels varchar(255) DEFAULT NULL,
  facultad int DEFAULT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (facultad) REFERENCES facultad(codigo) 
  ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS equipos;

CREATE TABLE equipos (
  id int AUTO_INCREMENT NOT NULL,
  nombre varchar(100) DEFAULT NULL,
  facultad int DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (facultad) REFERENCES facultad(codigo) 
  ON DELETE CASCADE ON UPDATE CASCADE
);


DROP TABLE IF EXISTS reservas;

CREATE TABLE reservas (
id int AUTO_INCREMENT NOT NULL,
  investigador INT NOT NULL,
  equipo int NOT NULL,
  inicio datetime DEFAULT NULL,
  fin datetime DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (investigador) REFERENCES investigadores(codigo) 
  ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (equipo) REFERENCES equipos(id) 
  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO facultad (nombre) VALUES 
('Facultad 1'),
('Facultad 2'),
('Facultad 3');

INSERT INTO investigadores (DNI, nom_apels, facultad) VALUES 
('11112222', 'Investigador 1', 1),
('33334444', 'Investigador 2', 2),
('55556666', 'Investigador 3', 3);

INSERT INTO equipos (nombre, facultad) VALUES 
('Equipo 1', 1),
('Equipo 2', 2),
('Equipo 3', 3);

INSERT INTO reservas (investigador, equipo, inicio, fin) VALUES 
(1, 1, '2022-01-01', '2022-02-01'),
(2, 2, '2022-03-01', '2022-04-01'),
(3, 3, '2022-05-01', '2022-06-01');