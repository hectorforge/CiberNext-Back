-- Deshabilitar la verificación de claves foráneas temporalmente para evitar errores de orden
SET FOREIGN_KEY_CHECKS=0;

-- ---------------------------------
-- SECCIÓN 1: USUARIOS Y ROLES
-- ---------------------------------

-- Tabla para almacenar los roles (Administrador, Profesor, Alumno)
-- Eliminar tabla Rol si existe
DROP TABLE IF EXISTS `Rol`;
CREATE TABLE `Rol` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nombre` VARCHAR(50) UNIQUE NOT NULL COMMENT 'Nombre único del rol (e.g., ROL_ADMIN, ROL_PROFESOR)'
) COMMENT='Tabla de roles para Spring Security.';

DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE `usuario_rol` (
    `usuario_id` BIGINT NOT NULL,
    `rol_id` BIGINT NOT NULL,
    PRIMARY KEY (`usuario_id`, `rol_id`),
    FOREIGN KEY (`usuario_id`) REFERENCES `Usuario`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`rol_id`) REFERENCES `Rol`(`id`) ON DELETE CASCADE
) COMMENT='Tabla intermedia para relación muchos a muchos entre Usuario y Rol.';


-- Eliminar tabla Usuario si existe
DROP TABLE IF EXISTS `Usuario`;
CREATE TABLE `Usuario` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nombre` VARCHAR(255) NOT NULL,
    `apellido` VARCHAR(255) NOT NULL,
    `dni` VARCHAR(20) UNIQUE NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL COMMENT 'Contraseña encriptada',
    `foto_perfil` VARCHAR(500),
    `rol_id` BIGINT NOT NULL,
    CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`rol_id`) REFERENCES `Rol` (`id`)
) COMMENT='Tabla base para todos los tipos de usuarios. Utiliza estrategia de herencia JOINED.';


-- Tabla para la especialización "Administrador"
DROP TABLE IF EXISTS `Administrador`;
CREATE TABLE `Administrador` (
    `usuario_id` BIGINT PRIMARY KEY,
    CONSTRAINT `fk_admin_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE
) COMMENT='Especialización de Usuario para Administradores.';

-- Tabla para la especialización "Profesor"
DROP TABLE IF EXISTS `Profesor`;
CREATE TABLE `Profesor` (
    `usuario_id` BIGINT PRIMARY KEY,
    `codigo_profesor` VARCHAR(20) UNIQUE NOT NULL,
    `correo_profesional` VARCHAR(100),
    `biografia` TEXT,
    CONSTRAINT `fk_profesor_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE
) COMMENT='Especialización de Usuario para Profesores.';

-- Tabla para la especialización "Alumno"
DROP TABLE IF EXISTS `Alumno`;
CREATE TABLE `Alumno` (
    `usuario_id` BIGINT PRIMARY KEY,
    `codigo_alumno` VARCHAR(20) UNIQUE NOT NULL,
    `correo_personal` VARCHAR(100),
    `pais` VARCHAR(100),
    CONSTRAINT `fk_alumno_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE
) COMMENT='Especialización de Usuario para Alumnos.';



-- ---------------------------------
-- SECCIÓN 2: ESTRUCTURA ACADÉMICA
-- ---------------------------------

-- Tabla para las áreas de estudio
DROP TABLE IF EXISTS `AreaEspecializacion`;
CREATE TABLE `AreaEspecializacion` (
                                       `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       `nombre` VARCHAR(255) NOT NULL,
                                       `descripcion` TEXT
) COMMENT='Define las áreas de estudio o carreras (e.g., Ingeniería de Software).';

-- Tabla para los cursos
DROP TABLE IF EXISTS `Curso`;
CREATE TABLE `Curso` (
                         `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                         `codigo` VARCHAR(50) UNIQUE NOT NULL,
                         `nombre` VARCHAR(255) NOT NULL,
                         `descripcion` TEXT
) COMMENT='Define un curso como una entidad única (e.g., CS101 Algoritmos).';

-- Tabla intermedia que modela la relación Muchos-a-Muchos entre Curso y AreaEspecializacion
DROP TABLE IF EXISTS `Curricula`;
CREATE TABLE `Curricula` (
                             `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                             `curso_id` BIGINT NOT NULL,
                             `area_especializacion_id` BIGINT NOT NULL,
                             `descripcion` TEXT COMMENT 'Descripción del curso específica para esta área.',
                             `orden` INT COMMENT 'Orden del curso dentro de la malla curricular del área.',
                             CONSTRAINT `fk_curricula_curso` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`) ON DELETE CASCADE,
                             CONSTRAINT `fk_curricula_area` FOREIGN KEY (`area_especializacion_id`) REFERENCES `AreaEspecializacion` (`id`) ON DELETE CASCADE,
                             UNIQUE (`curso_id`, `area_especializacion_id`)
) COMMENT='Tabla de unión que define a qué áreas pertenece un curso y sus atributos específicos en ese contexto.';

-- Tabla para el contenido detallado de un curso (el sílabo)
DROP TABLE IF EXISTS `UnidadAprendizaje`;
CREATE TABLE `UnidadAprendizaje` (
                                     `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     `nombre` VARCHAR(255) NOT NULL,
                                     `codigo` VARCHAR(50),
                                     `descripcion` TEXT,
                                     `estado` VARCHAR(50),
                                     `curso_id` BIGINT NOT NULL,
                                     `idPadre` BIGINT NULL COMMENT 'Para estructura jerárquica (tema/subtema).',
                                     `idAnterior` BIGINT NULL COMMENT 'Para estructura secuencial (lección anterior).',
                                     `idSiguiente` BIGINT NULL COMMENT 'Para estructura secuencial (lección siguiente).',
                                     CONSTRAINT `fk_unidad_curso` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`) ON DELETE CASCADE,
                                     CONSTRAINT `fk_unidad_padre` FOREIGN KEY (`idPadre`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE SET NULL,
                                     CONSTRAINT `fk_unidad_anterior` FOREIGN KEY (`idAnterior`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE SET NULL,
                                     CONSTRAINT `fk_unidad_siguiente` FOREIGN KEY (`idSiguiente`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE SET NULL,
                                     UNIQUE (`idAnterior`),
                                     UNIQUE (`idSiguiente`)
) COMMENT='Contenido detallado (temas, subtemas) de un curso específico.';


-- ---------------------------------
-- SECCIÓN 3: GESTIÓN DE CONTENIDO
-- ---------------------------------

DROP TABLE IF EXISTS `TipoDocumento`;
CREATE TABLE `TipoDocumento` (
                                 `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 `nombre` VARCHAR(100) NOT NULL,
                                 `extension` VARCHAR(50)
) COMMENT='Tipos de documentos (e.g., PDF, Video, Enlace).';

DROP TABLE IF EXISTS `Documento`;
CREATE TABLE `Documento` (
                             `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                             `nombre` VARCHAR(255) NOT NULL,
                             `archivo` VARCHAR(512) NOT NULL COMMENT 'URL o ruta al archivo',
                             `descripcion` TEXT,
                             `tipo_documento_id` BIGINT,
                             `unidad_aprendizaje_id` BIGINT NOT NULL,
                             CONSTRAINT `fk_documento_tipodocumento` FOREIGN KEY (`tipo_documento_id`) REFERENCES `TipoDocumento` (`id`) ON DELETE SET NULL,
                             CONSTRAINT `fk_documento_unidad` FOREIGN KEY (`unidad_aprendizaje_id`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE CASCADE
) COMMENT='Archivos y recursos asociados a una unidad de aprendizaje.';


-- ---------------------------------
-- SECCIÓN 4: ASOCIACIONES USUARIO-CURSO
-- ---------------------------------

DROP TABLE IF EXISTS `CursoProfesor`;
CREATE TABLE `CursoProfesor` (
                                 `curso_id` BIGINT NOT NULL,
                                 `profesor_usuario_id` BIGINT NOT NULL,
                                 PRIMARY KEY (curso_id, profesor_usuario_id),
                                 CONSTRAINT `fk_cursoprofesor_curso` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`) ON DELETE CASCADE,
                                 CONSTRAINT `fk_cursoprofesor_profesor` FOREIGN KEY (`profesor_usuario_id`) REFERENCES `Profesor` (`usuario_id`) ON DELETE CASCADE
) COMMENT='Asigna profesores a los cursos.';

DROP TABLE IF EXISTS `RegistroAlumno`;
CREATE TABLE `RegistroAlumno` (
                                  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  `curso_id` BIGINT NOT NULL,
                                  `alumno_usuario_id` BIGINT NOT NULL,
                                  `profesor_usuario_id` BIGINT NOT NULL,
                                  `fechaInscripcion` DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  CONSTRAINT `fk_registro_curso` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`) ON DELETE CASCADE,
                                  CONSTRAINT `fk_registro_alumno` FOREIGN KEY (`alumno_usuario_id`) REFERENCES `Alumno` (`usuario_id`) ON DELETE CASCADE,
                                  CONSTRAINT `fk_registro_profesor` FOREIGN KEY (`profesor_usuario_id`) REFERENCES `Profesor` (`usuario_id`) ON DELETE CASCADE,
                                  UNIQUE (`curso_id`, `alumno_usuario_id`)
) COMMENT='Registra la inscripción de un alumno en un curso/sección y lo asocia al profesor responsable.';


-- ---------------------------------
-- SECCIÓN 5: SISTEMA DE EVALUACIÓN
-- ---------------------------------

DROP TABLE IF EXISTS `Evaluacion`;
CREATE TABLE `Evaluacion` (
                              `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                              `descripcion` TEXT,
                              `tiempo` INT COMMENT 'Tiempo límite en minutos.',
                              `unidad_aprendizaje_id` BIGINT UNIQUE COMMENT 'Una evaluación pertenece a una única unidad (relación 1-a-1 opcional).',
                              CONSTRAINT `fk_evaluacion_unidad` FOREIGN KEY (`unidad_aprendizaje_id`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE CASCADE
) COMMENT='Define una evaluación o examen.';

DROP TABLE IF EXISTS `TipoPregunta`;
CREATE TABLE `TipoPregunta` (
                                `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                `nombre` VARCHAR(100) NOT NULL COMMENT 'e.g., Opción Múltiple, Verdadero/Falso, Respuesta Corta',
                                `descripcion` TEXT
) COMMENT='Categoriza los tipos de preguntas.';

DROP TABLE IF EXISTS `Pregunta`;
CREATE TABLE `Pregunta` (
                            `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                            `descripcion` TEXT NOT NULL,
                            `evaluacion_id` BIGINT NOT NULL,
                            `tipo_pregunta_id` BIGINT,
                            CONSTRAINT `fk_pregunta_evaluacion` FOREIGN KEY (`evaluacion_id`) REFERENCES `Evaluacion` (`id`) ON DELETE CASCADE,
                            CONSTRAINT `fk_pregunta_tipopregunta` FOREIGN KEY (`tipo_pregunta_id`) REFERENCES `TipoPregunta` (`id`) ON DELETE SET NULL
) COMMENT='Almacena las preguntas de una evaluación.';

DROP TABLE IF EXISTS `Respuesta`;
CREATE TABLE `Respuesta` (
                             `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                             `descripcion` TEXT NOT NULL,
                             `valor` DECIMAL(5, 2) DEFAULT 0.00 COMMENT 'Puntaje de la respuesta o 1.0 para la correcta, 0.0 para incorrecta.',
                             `pregunta_id` BIGINT NOT NULL,
                             CONSTRAINT `fk_respuesta_pregunta` FOREIGN KEY (`pregunta_id`) REFERENCES `Pregunta` (`id`) ON DELETE CASCADE
) COMMENT='Opciones de respuesta para una pregunta.';

DROP TABLE IF EXISTS `Intento`;
CREATE TABLE `Intento` (
                           `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                           `numero` INT NOT NULL DEFAULT 1,
                           `fecha` DATETIME DEFAULT CURRENT_TIMESTAMP,
                           `nota` DECIMAL(5, 2),
                           `evaluacion_id` BIGINT NOT NULL,
                           `registro_alumno_id` BIGINT NOT NULL,
                           CONSTRAINT `fk_intento_evaluacion` FOREIGN KEY (`evaluacion_id`) REFERENCES `Evaluacion` (`id`) ON DELETE CASCADE,
                           CONSTRAINT `fk_intento_registro` FOREIGN KEY (`registro_alumno_id`) REFERENCES `RegistroAlumno` (`id`) ON DELETE CASCADE
) COMMENT='Registra un intento de un alumno en una evaluación.';

DROP TABLE IF EXISTS `IntentoRespuesta`;
CREATE TABLE `IntentoRespuesta` (
                                    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    `intento_id` BIGINT NOT NULL,
                                    `pregunta_id` BIGINT NOT NULL,
                                    `respuesta_id` BIGINT NOT NULL,
                                    CONSTRAINT `fk_intentorespuesta_intento` FOREIGN KEY (`intento_id`) REFERENCES `Intento` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `fk_intentorespuesta_pregunta` FOREIGN KEY (`pregunta_id`) REFERENCES `Pregunta` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `fk_intentorespuesta_respuesta` FOREIGN KEY (`respuesta_id`) REFERENCES `Respuesta` (`id`) ON DELETE CASCADE,
                                    UNIQUE (`intento_id`, `pregunta_id`) COMMENT 'Asegura que solo se puede responder una vez por pregunta en cada intento.'
) COMMENT='Almacena la respuesta seleccionada por un alumno para una pregunta en un intento.';


-- ---------------------------------
-- SECCIÓN 6: COMUNICACIÓN (FORO)
-- ---------------------------------

DROP TABLE IF EXISTS `Consultas`;
CREATE TABLE `Consultas` (
                             `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                             `titulo` VARCHAR(255),
                             `mensaje` TEXT NOT NULL,
                             `fecha` DATETIME DEFAULT CURRENT_TIMESTAMP,
                             `estado` BOOL DEFAULT 0,
                             `usuario_id` BIGINT NOT NULL COMMENT 'ID del autor del mensaje (alumno o profesor). SIEMPRE presente.',
                             `registro_alumno_id` BIGINT NULL COMMENT 'ID de la matrícula del alumno que INICIA el hilo. NULL para las respuestas.',
                             `unidad_aprendizaje_id` BIGINT NOT NULL COMMENT 'ID de la unidad sobre la que se pregunta.',
                             `consulta_padre_id` BIGINT NULL COMMENT 'ID del mensaje al que se está respondiendo. NULL para el mensaje inicial.',
                             CONSTRAINT `fk_consulta_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE,
                             CONSTRAINT `fk_consulta_registro` FOREIGN KEY (`registro_alumno_id`) REFERENCES `RegistroAlumno` (`id`) ON DELETE CASCADE,
                             CONSTRAINT `fk_consulta_unidad` FOREIGN KEY (`unidad_aprendizaje_id`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE CASCADE,
                             CONSTRAINT `fk_consulta_padre` FOREIGN KEY (`consulta_padre_id`) REFERENCES `Consultas` (`id`) ON DELETE CASCADE
) COMMENT='Sistema de foro/consultas para los cursos. Auto-referenciado para hilos de respuestas.';

-- Habilitar la verificación de claves foráneas nuevamente
SET FOREIGN_KEY_CHECKS=1;




-- ---------------------------------
-- NUEVA TABLA: Registro de visualización por unidad
-- ---------------------------------

DROP TABLE IF EXISTS `UnidadVista`;
CREATE TABLE `UnidadVista` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `unidadAprendizajeId` BIGINT NOT NULL,
    `registroAlumnoId` BIGINT NOT NULL,
    `fechaVisualizacion` DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_vista_unidad` FOREIGN KEY (`unidadAprendizajeId`) REFERENCES `UnidadAprendizaje` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_vista_registro` FOREIGN KEY (`registroAlumnoId`) REFERENCES `RegistroAlumno` (`id`) ON DELETE CASCADE,
    UNIQUE (`unidadAprendizajeId`, `registroAlumnoId`)
) COMMENT='Registra que el alumno ha visualizado una unidad específica.';







