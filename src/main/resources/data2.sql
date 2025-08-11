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
-- 1. Insertar roles
INSERT INTO `Rol` (`id`, `nombre`) VALUES
(1, 'ADMIN'),
(2, 'DOCENTE'),
(3, 'ALUMNO');

-- 2. Variable de contraseña hasheada
-- NOTA: En producción, esta debe generarse dinámicamente con BCrypt (contra1234)
SET @hashed_password = '$2b$12$AyI5rl14aAMfmRsqL/GhrexfLuHPsz51OHMn4NAJd4rZFTIDpfFO.';


-- == Administradores ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`, `rol_id`) VALUES
(1, 'Admin', 'General', '00000001', 'admin@sistema.com', @hashed_password, NULL, 1),
(2, 'Coordinador', 'Academico', '00000002', 'coordinador@sistema.com', @hashed_password, NULL, 1);

-- == Profesores ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`, `rol_id`) VALUES
(3, 'Carlos', 'Santana', '10000001', 'c.santana@profesor.com', @hashed_password, 'https://img.com/csantana.jpg', 2),
(4, 'Diana', 'Prince', '10000002', 'd.prince@profesor.com', @hashed_password, 'https://img.com/dprince.jpg', 2),
(5, 'Ricardo', 'Tapia', '10000003', 'r.tapia@profesor.com', @hashed_password, 'https://img.com/rtapia.jpg', 2),
(6, 'Anthony', 'Stark', '10000004', 'a.stark@profesor.com', @hashed_password, 'https://img.com/astark.jpg', 2),
(7, 'Barbara', 'Gordon', '10000005', 'b.gordon@profesor.com', @hashed_password, 'https://img.com/bgordon.jpg', 2),
(8, 'Steve', 'Rogers', '10000006', 's.rogers@profesor.com', @hashed_password, 'https://img.com/srogers.jpg', 2),
(19, 'Natasha', 'Romanoff', '10000007', 'n.romanoff@profesor.com', @hashed_password, 'https://img.com/nromanoff.jpg', 2);

-- == Alumnos ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`, `rol_id`) VALUES
(9, 'Ana', 'Lopez', '20000001', 'ana.lopez@alumno.com', @hashed_password, 'https://img.com/ana.jpg', 3),
(10, 'Bruno', 'Diaz', '20000002', 'bruno.diaz@alumno.com', @hashed_password, 'https://img.com/bruno.jpg', 3),
(11, 'Carla', 'Kent', '20000003', 'carla.kent@alumno.com', @hashed_password, 'https://img.com/carla.jpg', 3),
(12, 'David', 'Perez', '20000004', 'david.perez@alumno.com', @hashed_password, 'https://img.com/david.jpg', 3),
(13, 'Elena', 'Garcia', '20000005', 'elena.garcia@alumno.com', @hashed_password, 'https://img.com/elena.jpg', 3),
(14, 'Fernando', 'Torres', '20000006', 'fernando.t@alumno.com', @hashed_password, 'https://img.com/fernando.jpg', 3),
(15, 'Gabriela', 'Solis', '20000007', 'gabi.solis@alumno.com', @hashed_password, 'https://img.com/gabriela.jpg', 3),
(16, 'Hugo', 'Sanchez', '20000008', 'hugo.sanchez@alumno.com', @hashed_password, 'https://img.com/hugo.jpg', 3),
(17, 'Irene', 'Adler', '20000009', 'irene.adler@alumno.com', @hashed_password, 'https://img.com/irene.jpg', 3),
(18, 'Javier', 'Mascherano', '20000010', 'j.mascherano@alumno.com', @hashed_password, 'https://img.com/javier.jpg', 3),
(20, 'Laura', 'Jimenez', '20000011', 'laura.j@alumno.com', @hashed_password, 'https://img.com/laura.jpg', 3),
(21, 'Marcos', 'Rojo', '20000012', 'marcos.r@alumno.com', @hashed_password, 'https://img.com/marcos.jpg', 3),
(22, 'Nora', 'Castillo', '20000013', 'nora.c@alumno.com', @hashed_password, 'https://img.com/nora.jpg', 3),
(23, 'Oscar', 'Velez', '20000014', 'oscar.v@alumno.com', @hashed_password, 'https://img.com/oscar.jpg', 3),
(24, 'Patricia', 'Luna', '20000015', 'patricia.l@alumno.com', @hashed_password, 'https://img.com/patricia.jpg', 3),
(25, 'Raul', 'Gonzalez', '20000016', 'raul.g@alumno.com', @hashed_password, 'https://img.com/raul.jpg', 3),
(26, 'Sofia', 'Vergara', '20000017', 'sofia.v@alumno.com', @hashed_password, 'https://img.com/sofia.jpg', 3),
(27, 'Tomas', 'Rincon', '20000018', 'tomas.r@alumno.com', @hashed_password, 'https://img.com/tomas.jpg', 3),
(28, 'Ursula', 'Corbero', '20000019', 'ursula.c@alumno.com', @hashed_password, 'https://img.com/ursula.jpg', 3),
(29, 'Victor', 'Valdes', '20000020', 'victor.v@alumno.com', @hashed_password, 'https://img.com/victor.jpg', 3);


-- Asignar ROL_ADMIN a los usuarios administradores
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES
(1, 1),
(2, 1);

-- Asignar ROL_PROFESOR a los usuarios profesores
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(19, 2);

-- Asignar ROL_ALUMNO a los usuarios alumnos
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES
(9, 3),
(10, 3),
(11, 3),
(12, 3),
(13, 3),
(14, 3),
(15, 3),
(16, 3),
(17, 3),
(18, 3),
(20, 3),
(21, 3),
(22, 3),
(23, 3),
(24, 3),
(25, 3),
(26, 3),
(27, 3),
(28, 3),
(29, 3);


-- -----------------------------------------------------------
-- 3. ESPECIALIZAR USUARIOS (POBLAR TABLAS HIJAS)
-- -----------------------------------------------------------
INSERT INTO `Administrador` (`usuario_id`) VALUES (1), (2);

INSERT INTO `Profesor` (`usuario_id`, `codigo_profesor`, `correo_profesional`, `biografia`) VALUES
(3, 'PROF-0001', 'csantana@academia.com', 'Especialista en Java y frameworks modernos.'),
(4, 'PROF-0002', 'dprince@academia.com', 'Ingeniera de software con experiencia en gestión ágil.'),
(5, 'PROF-0003', 'rtapia@academia.com', 'Amante de las bases de datos relacionales y NoSQL.'),
(6, 'PROF-0004', 'astark@academia.com', 'Arquitecto de software y evangelista de Spring Boot.'),
(7, 'PROF-0005', 'bgordon@academia.com', 'Profesora enfocada en desarrollo web full stack.'),
(8, 'PROF-0006', 'srogers@academia.com', 'Desarrollador mobile y docente motivacional.'),
(19, 'PROF-0007', 'nromanoff@academia.com', 'Docente de tecnologías frontend y accesibilidad.');

INSERT INTO `Alumno` (`usuario_id`, `codigo_alumno`, `correo_personal`, `pais`) VALUES
(9, 'ALU-0001', 'ana.lopez@gmail.com', 'Perú'),
(10, 'ALU-0002', 'bruno.diaz@gmail.com', 'Argentina'),
(11, 'ALU-0003', 'carla.kent@gmail.com', 'México'),
(12, 'ALU-0004', 'david.perez@gmail.com', 'Colombia'),
(13, 'ALU-0005', 'elena.garcia@gmail.com', 'Perú'),
(14, 'ALU-0006', 'fernando.torres@gmail.com', 'Chile'),
(15, 'ALU-0007', 'gabriela.solis@gmail.com', 'Perú'),
(16, 'ALU-0008', 'hugo.sanchez@gmail.com', 'México'),
(17, 'ALU-0009', 'irene.adler@gmail.com', 'Ecuador'),
(18, 'ALU-0010', 'javier.mascherano@gmail.com', 'Argentina'),
(20, 'ALU-0011', 'laura.jimenez@gmail.com', 'Perú'),
(21, 'ALU-0012', 'marcos.rojo@gmail.com', 'Argentina'),
(22, 'ALU-0013', 'nora.castillo@gmail.com', 'Colombia'),
(23, 'ALU-0014', 'oscar.velez@gmail.com', 'Perú'),
(24, 'ALU-0015', 'patricia.luna@gmail.com', 'Chile'),
(25, 'ALU-0016', 'raul.gonzalez@gmail.com', 'México'),
(26, 'ALU-0017', 'sofia.vergara@gmail.com', 'Colombia'),
(27, 'ALU-0018', 'tomas.rincon@gmail.com', 'Venezuela'),
(28, 'ALU-0019', 'ursula.corbero@gmail.com', 'España'),
(29, 'ALU-0020', 'victor.valdes@gmail.com', 'España');


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
-- Curso 1 (Dev Web I) -> Profesor 19 (Natasha R.)
-- Curso 2 (React) -> Profesor 3 (Carlos S.)
-- Curso 3 (Angular) -> Profesor 3 (Carlos S.)
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`, `profesor_usuario_id`) VALUES
                                                                                          (1, 9, 19), (2, 9, 3),    -- Ana Lopez
                                                                                          (1, 11, 19), (3, 11, 3),   -- Carla Kent
                                                                                          (1, 13, 19), (2, 13, 3), (3, 13, 3), -- Elena Garcia
                                                                                          (1, 15, 19), (2, 15, 3),   -- Gabriela Solis
                                                                                          (1, 17, 19), (3, 17, 3),   -- Irene Adler
                                                                                          (1, 20, 19),              -- Laura Jimenez
                                                                                          (2, 22, 3), (3, 22, 3);    -- Nora Castillo

-- Curso 10 (Algoritmia) -> Profesor 6 (Anthony S.)
-- Curso 11 (POO C#) -> Profesor 6 (Anthony S.)
-- Curso 12 (Spring Boot) -> Profesor 6 (Anthony S.)
-- Curso 15 (Python) -> Profesor 6 (Anthony S.)
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`, `profesor_usuario_id`) VALUES
                                                                                          (10, 10, 6), (12, 10, 6),  -- Bruno Diaz
                                                                                          (10, 14, 6), (11, 14, 6), (12, 14, 6), -- Fernando Torres
                                                                                          (10, 16, 6), (12, 16, 6),  -- Hugo Sanchez
                                                                                          (12, 18, 6),              -- Javier Mascherano
                                                                                          (11, 21, 6), (12, 21, 6),  -- Marcos Rojo
                                                                                          (10, 23, 6), (11, 23, 6),  -- Oscar Velez
                                                                                          (12, 25, 6), (15, 25, 6);  -- Raul Gonzalez

-- Curso 16 (Android) -> Profesor 8 (Steve R.)
-- Curso 17 (Flutter) -> Profesor 8 (Steve R.)
-- Curso 18 (iOS) -> Profesor 6 (Anthony S.)
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`, `profesor_usuario_id`) VALUES
                                                                                          (16, 12, 8), (17, 12, 8),   -- David Perez
                                                                                          (17, 24, 8), (18, 24, 6),   -- Patricia Luna
                                                                                          (16, 26, 8), (17, 26, 8), (18, 26, 6), -- Sofia Vergara
                                                                                          (17, 27, 8),              -- Tomas Rincon
                                                                                          (16, 28, 8),              -- Ursula Corbero
                                                                                          (18, 29, 6);              -- Victor Valdes

-- == Alumnos en cursos de otras áreas (menor cantidad) ==
-- Curso 7 (Modelado BD) -> Profesor 5 (Ricardo T.)
-- Curso 8 (BD I SQL) -> Profesor 5 (Ricardo T.)
-- Curso 6 (SCRUM) -> Profesor 19 (Natasha R.)
INSERT INTO `RegistroAlumno` (`curso_id`, `alumno_usuario_id`, `profesor_usuario_id`) VALUES
                                                                                          (7, 9, 5),   -- Ana Lopez
                                                                                          (8, 10, 5),  -- Bruno Diaz
                                                                                          (6, 14, 19); -- Fernando Torres









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
-- == Hilo 1: En el curso "React" (ID: 2) sobre la Unidad de Aprendizaje "useEffect" (ID: 12) ==
-- Gabriela Solis (Usuario ID: 15) en su matrícula de React (Registro ID: 12) tiene una duda.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (1, 'Duda sobre el array de dependencias en useEffect', 'Hola profesor, no entiendo bien cuándo debo poner variables en el array de dependencias de useEffect. ¿Si lo dejo vacío se ejecuta solo una vez?', 15, 12, 12, NULL);

-- El profesor del curso, Carlos Santana (Usuario ID: 3), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (2, NULL, '¡Hola Gabriela! Exactamente. Si dejas el array de dependencias vacío `[]`, el efecto se ejecutará solo una vez, después del primer renderizado, similar a `componentDidMount`. Si incluyes una variable, el efecto se volverá a ejecutar cada vez que el valor de esa variable cambie.', 3, NULL, 12, 1);

-- Otro alumno, Ana Lopez (Usuario ID: 9), añade un comentario.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (3, NULL, '¡Gracias por la pregunta Gabriela! A mí me sirvió mucho pensar que el array le dice a React: "vigila estas variables y si alguna cambia, ejecuta el efecto de nuevo".', 9, NULL, 12, 1);

-- == Hilo 2: En "Spring Boot" (ID: 12) sobre la Unidad "Fundamentos de Spring Boot 3" (ID: 112) ==
-- Fernando Torres (Usuario ID: 14) en su matrícula de Spring Boot (Registro ID: 18) pregunta.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (4, 'Diferencias entre @Component, @Service y @Repository', 'Profesor, he visto que las tres anotaciones parecen hacer lo mismo (crear un bean). ¿Cuál es la diferencia real y cuándo debo usar cada una?', 14, 18, 112, NULL);

-- El profesor del curso, Anthony Stark (Usuario ID: 6), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (5, NULL, 'Excelente pregunta, Fernando. Si bien técnicamente las tres crean un bean, su uso es semántico. `@Repository` se usa en la capa de persistencia y traduce excepciones de la BD. `@Service` se usa en la capa de negocio para la lógica principal. `@Component` es genérica. Usar la correcta ayuda a que el código sea más legible y permite que los frameworks apliquen lógicas específicas (AOP).', 6, NULL, 112, 4);

-- == Hilo 3: En "Desarrollo Web I" (ID: 1) sobre la Unidad "Flexbox" (ID: 4) ==
-- Laura Jimenez (Usuario ID: 20) en su matrícula de Dev Web I (Registro ID: 15) tiene problemas.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (6, '¿Cómo centrar un div vertical y horizontalmente con Flexbox?', 'He intentado con `align-items: center` pero no funciona como espero. ¿Qué me falta?', 20, 15, 4, NULL);

-- La profesora del curso, Natasha Romanoff (Usuario ID: 19), responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (7, NULL, 'Hola Laura, es una duda muy común. Para centrar en ambos ejes, necesitas dos propiedades en el contenedor padre: `align-items: center;` (para el eje vertical) y `justify-content: center;` (para el eje horizontal). Además, asegúrate de que el contenedor tenga una altura definida (ej. `height: 100vh;`) para que el centrado vertical tenga efecto.', 19, NULL, 4, 6);


-- == Hilo 4: En el curso "Angular" (ID: 3) sobre la Unidad "Componentes y Plantillas" (ID: 19) ==
-- Elena Garcia (Usuario ID: 13), en su matrícula de Angular (Registro ID: 11), tiene una duda fundamental.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (8, '¿Cuándo usar ngOnInit vs el constructor?', 'Profesor, he visto ejemplos que inicializan propiedades en el constructor y otros en ngOnInit. ¿Cuál es la buena práctica y por qué?', 13, 11, 19, NULL);

-- El profesor del curso, Carlos Santana (Usuario ID: 3), responde con la mejor práctica.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (9, NULL, '¡Gran pregunta, Elena! La regla general es: usa el `constructor` para la inyección de dependencias (DI) y para inicializaciones muy simples que no dependan de inputs. Usa `ngOnInit` para toda la lógica de inicialización compleja, especialmente si necesitas acceder a las propiedades `@Input()` del componente, ya que en `ngOnInit` tienes la garantía de que ya están disponibles.', 3, NULL, 19, 8);

-- Carla Kent (Usuario ID: 11), otra alumna, comparte su experiencia.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (10, NULL, 'A mí me ayudó pensar que el constructor es para "preparar las herramientas" y ngOnInit es para "empezar a usarlas".', 11, NULL, 19, 8);


-- == Hilo 5: En "Spring Boot" (ID: 12) sobre la Unidad "Capa de Persistencia" (ID: 114) ==
-- Bruno Diaz (Usuario ID: 10), en su matrícula de Spring Boot (Registro ID: 5), pregunta sobre DTOs.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (11, '¿Por qué usar DTOs si ya tengo la Entidad JPA?', 'Hola, me parece que crear una clase DTO para cada entidad es duplicar código. ¿No sería más fácil exponer la entidad `@Entity` directamente en el controlador? ¿Cuáles son los riesgos?', 10, 5, 114, NULL);

-- El profesor, Anthony Stark (Usuario ID: 6), da una respuesta de arquitecto.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (12, NULL, 'Bruno, es una de las preguntas más importantes en la arquitectura de APIs. Exponer la entidad directamente tiene varios riesgos graves: 1) Expones la estructura de tu BD al exterior. 2) Cualquier cambio en tu tabla (añadir una columna) se refleja inmediatamente en tu API, rompiendo contratos. 3) Puedes caer en bucles de serialización infinitos con relaciones bidireccionales. Los DTOs (Data Transfer Objects) actúan como una capa de protección y un contrato explícito con tus clientes. Te dan control total sobre qué datos mostrar y recibir.', 6, NULL, 114, 11);


-- == Hilo 6: En "Introducción a la Algoritmia" (ID: 10) sobre la Unidad de Ordenamiento (ID: 97) ==
-- Hugo Sanchez (Usuario ID: 16), en su matrícula de Algoritmia (Registro ID: 19), tiene una duda teórica.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (13, '¿Por qué QuickSort es O(n^2) en el peor caso?', 'Entiendo que en promedio es O(n log n), pero no veo cómo puede llegar a ser tan lento como un Bubble Sort. ¿Podría dar un ejemplo del peor caso?', 16, 19, 97, NULL);

-- El profesor Anthony Stark (Usuario ID: 6) responde.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (14, NULL, 'Hugo, el peor caso para QuickSort ocurre cuando el pivote elegido es consistentemente el elemento más pequeño o más grande del sub-arreglo. Imagina un arreglo que ya está ordenado ([1, 2, 3, 4, 5]) y siempre eliges el primer elemento como pivote. En la primera partición, moverás n-1 elementos. En la siguiente, n-2, y así sucesivamente. Esto resulta en una suma de `n + (n-1) + (n-2) ... + 1`, que es O(n^2). Por eso, la elección de un buen pivote (como uno aleatorio o la mediana de tres) es crucial.', 6, NULL, 97, 13);


-- == Hilo 7: En "POO con C#" (ID: 11) sobre la Unidad de SOLID (ID: 108) ==
-- Marcos Rojo (Usuario ID: 21), en su matrícula (Registro ID: 22), pide un ejemplo práctico.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (15, 'Ejemplo práctico del Principio de Inversión de Dependencias (DIP)', 'Entiendo la teoría de "depender de abstracciones, no de concreciones", pero me cuesta verlo en código real. ¿Cómo se vería un "antes" y un "después" de aplicar DIP?', 21, 22, 108, NULL);

-- El profesor Anthony Stark (Usuario ID: 6) responde con código.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (16, NULL, 'Claro, Marcos. **ANTES (Mal):** `class Notificador { private MySqlDatabase _db = new MySqlDatabase(); public void Notificar() { _db.GuardarNotificacion(); } }`. Aquí `Notificador` depende directamente de `MySqlDatabase`. **DESPUÉS (Bien):** `interface IDatabase { void Guardar(); } class Notificador { private IDatabase _db; public Notificador(IDatabase db) { _db = db; } public void Notificar() { _db.Guardar(); } }`. Ahora `Notificador` depende de una abstracción (`IDatabase`) y podemos pasarle cualquier base de datos (MySql, SqlServer) que la implemente. Eso es DIP.', 6, NULL, 108, 15);

-- Fernando Torres (Usuario ID: 14), que también lleva el curso, añade un punto.
INSERT INTO `Consultas` (`id`, `titulo`, `mensaje`, `usuario_id`, `registro_alumno_id`, `unidad_aprendizaje_id`, `consulta_padre_id`) VALUES
    (17, NULL, '¡Buenísimo! Y eso también facilita mucho las pruebas unitarias. En el "después", podemos pasarle un `MockDatabase` al `Notificador` para probarlo sin necesidad de una base de datos real.', 14, NULL, 108, 15);


INSERT INTO `UnidadVista` (`unidadAprendizajeId`, `registroAlumnoId`) VALUES
(1, 1),  -- HTML Semántico
(2, 1),  -- Formularios y Accesibilidad
(3, 1),  -- CSS Moderno
(4, 1),  -- Flexbox
(6, 1);  -- Responsive Design