CREATE DATABASE gestion_proyectos;
USE gestion_proyectos;

CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proyecto VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    estado VARCHAR(50) -- 'en curso' o 'completado'
);

CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_proyecto INT,
    descripcion_tarea TEXT,
    responsable VARCHAR(255),
    fecha_inicio DATE,
    fecha_fin DATE,
    estado VARCHAR(50), -- 'pendiente', 'en progreso' o 'completada'
    FOREIGN KEY (id_proyecto) REFERENCES proyectos(id)
);
