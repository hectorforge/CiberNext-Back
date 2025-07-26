-- ================================================================================= --
--     SCRIPT DE INSERCIÓN - PARTE 3 (CORREGIDO Y REORDENADO): USUARIOS Y MATRÍCULAS     --
-- ================================================================================= --
-- V3: Reordena las inserciones para resolver el error de clave foránea.
-- Este script asume que la estructura de la base de datos ya existe y está vacía.
-- Los datos de Cursos y Áreas (Parte 1 y 2) ya deben estar insertados.
-- ================================================================================= --

-- ---------------------------------
-- 1. POBLAR LA TABLA `Rol`
-- ---------------------------------
INSERT INTO `Rol` (`id`, `nombre`) VALUES
                                       (1, 'ROL_ADMIN'),
                                       (2, 'ROL_PROFESOR'),
                                       (3, 'ROL_ALUMNO');

-- -----------------------------------------------------------
-- 2. POBLAR LA TABLA `Usuario` (TODOS LOS TIPOS)
-- -----------------------------------------------------------
-- NOTA: La contraseña es un ejemplo. En producción, usar un hash BCrypt.
SET @hashed_password = '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqR2e5dOKJdaLACL9CFgVGXRcix.';

-- == Administradores (rol_id = 1) ==
INSERT INTO `Usuario` (`id`, `nombre`, `dni`, `correo`, `password`, `rol_id`) VALUES
                                                                                  (1, 'Admin General', '00000001', 'admin@sistema.com', @hashed_password, 1),
                                                                                  (2, 'Coordinador Academico', '00000002', 'coordinador@sistema.com', @hashed_password, 1);

-- == Profesores (rol_id = 2) ==
INSERT INTO `Usuario` (`id`, `nombre`, `dni`, `correo`, `password`, `rol_id`) VALUES
                                                                                  (3, 'Carlos Santana', '10000001', 'c.santana@profesor.com', @hashed_password, 2),
                                                                                  (4, 'Diana Prince', '10000002', 'd.prince@profesor.com', @hashed_password, 2),
                                                                                  (5, 'Ricardo Tapia', '10000003', 'r.tapia@profesor.com', @hashed_password, 2),
                                                                                  (6, 'Anthony Stark', '10000004', 'a.stark@profesor.com', @hashed_password, 2),
                                                                                  (7, 'Barbara Gordon', '10000005', 'b.gordon@profesor.com', @hashed_password, 2),
                                                                                  (8, 'Steve Rogers', '10000006', 's.rogers@profesor.com', @hashed_password, 2),
                                                                                  (19, 'Natasha Romanoff', '10000007', 'n.romanoff@profesor.com', @hashed_password, 2);

-- == Alumnos (rol_id = 3) ==
INSERT INTO `Usuario` (`id`, `nombre`, `dni`, `correo`, `password`, `rol_id`) VALUES
                                                                                  (9, 'Ana Lopez', '20000001', 'ana.lopez@alumno.com', @hashed_password, 3),
                                                                                  (10, 'Bruno Diaz', '20000002', 'bruno.diaz@alumno.com', @hashed_password, 3),
                                                                                  (11, 'Carla Kent', '20000003', 'carla.kent@alumno.com', @hashed_password, 3),
                                                                                  (12, 'David Perez', '20000004', 'david.perez@alumno.com', @hashed_password, 3),
                                                                                  (13, 'Elena Garcia', '20000005', 'elena.garcia@alumno.com', @hashed_password, 3),
                                                                                  (14, 'Fernando Torres', '20000006', 'fernando.t@alumno.com', @hashed_password, 3),
                                                                                  (15, 'Gabriela Solis', '20000007', 'gabi.solis@alumno.com', @hashed_password, 3),
                                                                                  (16, 'Hugo Sanchez', '20000008', 'hugo.sanchez@alumno.com', @hashed_password, 3),
                                                                                  (17, 'Irene Adler', '20000009', 'irene.adler@alumno.com', @hashed_password, 3),
                                                                                  (18, 'Javier Mascherano', '20000010', 'j.mascherano@alumno.com', @hashed_password, 3),
                                                                                  (20, 'Laura Jimenez', '20000011', 'laura.j@alumno.com', @hashed_password, 3),
                                                                                  (21, 'Marcos Rojo', '20000012', 'marcos.r@alumno.com', @hashed_password, 3),
                                                                                  (22, 'Nora Castillo', '20000013', 'nora.c@alumno.com', @hashed_password, 3),
                                                                                  (23, 'Oscar Velez', '20000014', 'oscar.v@alumno.com', @hashed_password, 3),
                                                                                  (24, 'Patricia Luna', '20000015', 'patricia.l@alumno.com', @hashed_password, 3),
                                                                                  (25, 'Raul Gonzalez', '20000016', 'raul.g@alumno.com', @hashed_password, 3),
                                                                                  (26, 'Sofia Vergara', '20000017', 'sofia.v@alumno.com', @hashed_password, 3),
                                                                                  (27, 'Tomas Rincon', '20000018', 'tomas.r@alumno.com', @hashed_password, 3),
                                                                                  (28, 'Ursula Corbero', '20000019', 'ursula.c@alumno.com', @hashed_password, 3),
                                                                                  (29, 'Victor Valdes', '20000020', 'victor.v@alumno.com', @hashed_password, 3);

-- -----------------------------------------------------------
-- 3. ESPECIALIZAR USUARIOS (POBLAR TABLAS HIJAS)
-- -----------------------------------------------------------
INSERT INTO `Administrador` (`usuario_id`) VALUES (1), (2);
INSERT INTO `Profesor` (`usuario_id`) VALUES (3), (4), (5), (6), (7), (8), (19);
INSERT INTO `Alumno` (`usuario_id`) VALUES (9), (10), (11), (12), (13), (14), (15), (16), (17), (18), (20), (21), (22), (23), (24), (25), (26), (27), (28), (29);


-- -----------------------------------------------------------
-- 4. ASIGNAR PROFESORES A CURSOS (`CursoProfesor`)
-- -----------------------------------------------------------
-- Area Frontend
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (1, 19), (2, 3), (3, 3);
-- Area Análisis, Diseño y Gestión
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (4, 4), (5, 4), (6, 19);
-- Area Bases de Datos
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (7, 5), (8, 5), (9, 5);
-- Area Backend
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (10, 6), (11, 6), (12, 6);
-- Area FullStack
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (13, 7), (14, 7), (15, 6);
-- Area Desarrollo Mobil
INSERT INTO `CursoProfesor` (`curso_id`, `profesor_usuario_id`) VALUES (16, 8), (17, 8), (18, 6);


-- -----------------------------------------------------------
-- 5. INSCRIBIR ALUMNOS EN CURSOS (`RegistroAlumno`)
-- -----------------------------------------------------------
-- == Alumnos enfocados en FRONTEND ==
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`) VALUES
                                                                   (1, 9), (2, 9), (1, 11), (3, 11), (1, 13), (2, 13), (3, 13), (1, 15), (2, 15), (1, 17), (3, 17), (1, 20), (2, 22), (3, 22);
-- == Alumnos enfocados en BACKEND ==
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`) VALUES
                                                                   (10, 10), (12, 10), (10, 14), (11, 14), (12, 14), (10, 16), (12, 16), (12, 18), (11, 21), (12, 21), (10, 23), (11, 23), (12, 25), (15, 25);
-- == Alumnos enfocados en DESARROLLO MÓVIL ==
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`) VALUES
                                                                   (16, 12), (17, 12), (17, 24), (18, 24), (16, 26), (17, 26), (18, 26), (17, 27), (16, 28), (18, 29);
-- == Alumnos en cursos de otras áreas (menor cantidad) ==
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`) VALUES
                                                                   (7, 9), (8, 10), (6, 14);










-- ================================================================================= --
--     SCRIPT DE INSERCIÓN - PARTE 2: ACTIVIDAD DE ESTUDIANTES               --
-- ================================================================================= --
-- Este script simula la actividad de los estudiantes: intentos de evaluación y
-- participación en foros. Asume que todos los scripts anteriores han sido ejecutados.
-- ================================================================================= --

-- ----------------------------------------------------------------------
-- 1. POBLAR INTENTOS DE EVALUACIÓN (`Intento` y `IntentoRespuesta`)
-- ----------------------------------------------------------------------
-- NOTA: La nota se calcula como (respuestas_correctas / total_preguntas) * 20.

-- == Ana Lopez (ID: 9) - Track Frontend. Lucha con el primer examen pero lo pasa. ==
-- Su RegistroAlumno en "Desarrollo Web I" (Curso 1) es el ID 1. La Evaluación es la 1.
-- Intento #1 (Desaprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (1, 1, NOW() - INTERVAL 2 DAY, 6.66, 1, 1);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (1, 1, 2), (1, 2, 5), (1, 3, 10); -- 1 correcta, 2 incorrectas
-- Intento #2 (Aprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (2, 2, NOW() - INTERVAL 1 DAY, 13.33, 1, 1);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (2, 1, 2), (2, 2, 6), (2, 3, 10); -- 2 correctas, 1 incorrecta

-- Como Ana ya aprobó la evaluación del curso 1, ahora puede intentar la del curso 2 (React).
-- Su RegistroAlumno en "React" (Curso 2) es el ID 2. La Evaluación es la 2.
-- Intento #1 en React (Aprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (3, 1, NOW(), 20.00, 2, 2);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (3, 4, 15), (3, 5, 20), (3, 6, 23); -- 3 correctas

-- == Bruno Diaz (ID: 10) - Track Backend. Buen progreso. ==
-- Su RegistroAlumno en "Algoritmia" (Curso 10) es el ID 4. La Evaluación es la 4.
-- Intento #1 en Algoritmia (Aprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (4, 1, NOW() - INTERVAL 5 DAY, 20.00, 4, 4);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (4, 10, 39), (4, 11, 42), (4, 12, 47); -- 3 correctas

-- Como aprobó Algoritmia, puede tomar el examen de Spring Boot.
-- Su RegistroAlumno en "Spring Boot" (Curso 12) es el ID 5. La Evaluación es la 6.
-- Intento #1 en Spring Boot (Aprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (5, 1, NOW() - INTERVAL 1 DAY, 13.33, 6, 5);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (5, 16, 54), (5, 17, 57), (5, 18, 60); -- 2 correctas, 1 incorrecta

-- == Sofia Vergara (ID: 26) - Track Móvil. Aún no ha dado su primer examen. ==
-- A pesar de estar inscrita en 3 cursos, no tiene registros en la tabla `Intento`.

-- == Fernando Torres (ID: 14) - Track Backend. En progreso. ==
-- Su RegistroAlumno en "POO (C#)" (Curso 11) es el ID 17. La Evaluación es la 5.
-- Intento #1 en POO (Aprobado)
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (6, 1, NOW() - INTERVAL 3 DAY, 13.33, 5, 17);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (6, 13, 49), (6, 14, 51), (6, 15, 54); -- 2 correctas, 1 incorrecta
-- Aún no ha intentado la evaluación de Spring Boot (Curso 12).

-- == Elena Garcia (ID: 13) - Track Frontend. Aún no ha dado el examen de Angular. ==
-- Su RegistroAlumno en "Desarrollo Web I" es el ID 9, y en "React" es el ID 10.
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (7, 1, NOW() - INTERVAL 4 DAY, 20.00, 1, 9);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (7, 1, 2), (7, 2, 6), (7, 3, 11); -- Todas correctas
INSERT INTO `Intento` (`id`, `numero`, `fecha`, `nota`, `evaluacion_id`, `registro_alumno_id`) VALUES (8, 1, NOW() - INTERVAL 2 DAY, 20.00, 2, 10);
INSERT INTO `IntentoRespuesta` (`intento_id`, `pregunta_id`, `respuesta_id`) VALUES (8, 4, 15), (8, 5, 20), (8, 6, 23); -- Todas correctas
-- No tiene intentos para la evaluación de Angular (Eval ID 3) porque la acaba de desbloquear.


-- ----------------------------------------------------
-- 2. POBLAR `Consultas` (FOROS)
-- ----------------------------------------------------

-- == Hilo 1: En el curso "React" (ID: 2) ==
-- Gabriela Solis (ID: 15) tiene una duda sobre useEffect.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (1, 'Duda sobre el array de dependencias en useEffect', 'Hola profesor, no entiendo bien cuándo debo poner variables en el array de dependencias de useEffect. ¿Si lo dejo vacío se ejecuta solo una vez?', 2, 15, NULL);
-- El profesor del curso, Carlos Santana (ID: 3), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (2, NULL, '¡Hola Gabriela! Exactamente. Si dejas el array de dependencias vacío `[]`, el efecto se ejecutará solo una vez, después del primer renderizado, similar a `componentDidMount`. Si incluyes una variable, el efecto se volverá a ejecutar cada vez que el valor de esa variable cambie.', 2, 3, 1);
-- Otro alumno, Ana Lopez (ID: 9), que también está en el curso, añade un comentario.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (3, NULL, '¡Gracias por la pregunta Gabriela! A mí me sirvió mucho pensar que el array le dice a React: "vigila estas variables y si alguna cambia, ejecuta el efecto de nuevo".', 2, 9, 1);

-- == Hilo 2: En el curso "Desarrollo de Servicios Rest (Spring Boot)" (ID: 12) ==
-- Fernando Torres (ID: 14) pregunta sobre la diferencia entre @Component, @Service y @Repository.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (4, 'Diferencias entre @Component, @Service y @Repository', 'Profesor, he visto que las tres anotaciones parecen hacer lo mismo (crear un bean). ¿Cuál es la diferencia real y cuándo debo usar cada una?', 12, 14, NULL);
-- El profesor del curso, Anthony Stark (ID: 6), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (5, NULL, 'Excelente pregunta, Fernando. Si bien técnicamente las tres crean un bean, su uso es semántico. `@Repository` se usa en la capa de persistencia y traduce excepciones de la BD. `@Service` se usa en la capa de negocio para la lógica principal. `@Component` es genérica. Usar la correcta ayuda a que el código sea más legible y permite que los frameworks apliquen lógicas específicas (AOP).', 12, 6, 4);

-- == Hilo 3: En el curso "Desarrollo Web I" (ID: 1) ==
-- Laura Jimenez (ID: 20) tiene problemas con Flexbox.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (6, '¿Cómo centrar un div vertical y horizontalmente con Flexbox?', 'He intentado con `align-items: center` pero no funciona como espero. ¿Qué me falta?', 1, 20, NULL);
-- La profesora del curso, Natasha Romanoff (ID: 19), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `curso_id`, `usuario_id`, `consulta_padre_id`) VALUES
    (7, NULL, 'Hola Laura, es una duda muy común. Para centrar en ambos ejes, necesitas dos propiedades en el contenedor padre: `align-items: center;` (para el eje vertical) y `justify-content: center;` (para el eje horizontal). Además, asegúrate de que el contenedor tenga una altura definida (ej. `height: 100vh;`) para que el centrado vertical tenga efecto.', 1, 19, 6);