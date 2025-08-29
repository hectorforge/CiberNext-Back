-- ================================================================================= --
--         SCRIPT DE INSERCIÓN DE DATOS DE PRUEBA - PARTE 1: ESTRUCTURA DE CURSOS      --
-- ================================================================================= --
-- Este script asume que las tablas están vacías y que los IDs autoincrementales
-- comenzarán en 1 para cada tabla.
-- ================================================================================= --

-- ---------------------------------
-- 1. POBLAR LA TABLA `AreaEspecializacion`
-- ---------------------------------
INSERT INTO `AreaEspecializacion` (`id`, `nombre`, `descripcion`) VALUES
                                                                      (1, 'Frontend', 'Cursos enfocados en el desarrollo de la interfaz de usuario y la experiencia del lado del cliente.'),
                                                                      (2, 'Análisis, Diseño y Gestión', 'Cursos relacionados con la ingeniería de software, modelado de sistemas y metodologías ágiles.'),
                                                                      (3, 'Bases de datos', 'Cursos centrados en el diseño, modelado y gestión de bases de datos relacionales y no relacionales.'),
                                                                      (4, 'Backend', 'Cursos enfocados en la lógica del lado del servidor, APIs y la algoritmia fundamental.'),
                                                                      (5, 'FullStack', 'Cursos que combinan tecnologías de frontend y backend para un desarrollo completo.'),
                                                                      (6, 'Desarrollo Mobil', 'Cursos para la creación de aplicaciones en dispositivos móviles como Android e iOS.');

-- ---------------------------------
-- 2. POBLAR LA TABLA `Curso`
-- ---------------------------------
INSERT INTO `Curso` (`id`, `codigo`, `nombre`, `descripcion`) VALUES
-- Frontend
(1, 'FE-01', 'Desarrollo Web I', 'Fundamentos de HTML, CSS y JavaScript para la construcción de sitios web estáticos.'),
(2, 'FE-02', 'React', 'Desarrollo de interfaces de usuario modernas y reactivas con la librería React.'),
(3, 'FE-03', 'Angular', 'Construcción de aplicaciones web a gran escala con el framework Angular.'),
-- Análisis, Diseño y Gestión
(4, 'ADG-01', 'Modelado de procesos de negocio', 'Técnicas y herramientas para modelar flujos de trabajo y procesos de negocio usando BPMN.'),
(5, 'ADG-02', 'Análisis y Diseño de Sistemas', 'Metodologías para el análisis de requerimientos y diseño de sistemas de software usando UML.'),
(6, 'ADG-03', 'SCRUM', 'Marco de trabajo ágil para la gestión y desarrollo de proyectos complejos.'),
-- Bases de datos
(7, 'DB-01', 'Modelación de bases de datos', 'Diseño de modelos entidad-relación y diagramas de bases de datos.'),
(8, 'DB-02', 'Bases de Datos I (Relacionales)', 'Fundamentos del lenguaje SQL y gestión de bases de datos relacionales como MySQL y PostgreSQL.'),
(9, 'DB-03', 'Bases de Datos II (No Relacionales)', 'Introducción a las bases de datos NoSQL, con ejemplos en MongoDB y Redis.'),
-- Backend
(10, 'BE-01', 'Introducción a la Algoritmia', 'Conceptos fundamentales de algoritmos, estructuras de datos y complejidad computacional.'),
(11, 'BE-02', 'Programación Orientada a Objetos (C#)', 'Principios de la POO aplicados con el lenguaje C# y el ecosistema .NET.'),
(12, 'BE-03', 'Desarrollo de Servicios Rest (Spring Boot)', 'Creación de APIs RESTful robustas y seguras utilizando el framework Spring Boot.'),
-- FullStack
(13, 'FS-01', 'PHP', 'Desarrollo web completo utilizando PHP, incluyendo conexión a bases de datos y gestión de sesiones.'),
(14, 'FS-02', 'NODE JS', 'Construcción de aplicaciones backend y APIs de alto rendimiento con Node.js y Express.'),
(15, 'FS-03', 'PYTHON', 'Desarrollo de aplicaciones web fullstack con Python, utilizando frameworks como Django o Flask.'),
-- Desarrollo Mobil
(16, 'DM-01', 'Android Studio', 'Desarrollo de aplicaciones nativas para Android utilizando Kotlin o Java.'),
(17, 'DM-02', 'Flutter', 'Creación de aplicaciones multiplataforma para iOS y Android desde una única base de código con Flutter.'),
(18, 'DM-03', 'IOS', 'Desarrollo de aplicaciones nativas para el ecosistema de Apple utilizando Swift y Xcode.');

-- --------------------------------------------------------------------------
-- 3. POBLAR LA TABLA `Curricula` (Unión de Curso y AreaEspecializacion)
-- --------------------------------------------------------------------------
-- Cada fila representa que un curso pertenece a un área, con una descripción
-- y un orden específico dentro de esa área.
INSERT INTO `Curricula` (`curso_id`, `area_especializacion_id`, `descripcion`, `orden`) VALUES
-- Cursos de Frontend (Area ID: 1)
(1, 1, 'Curso fundamental para iniciar en el desarrollo frontend.', 1),
(2, 1, 'Curso intermedio para construir UIs dinámicas.', 2),
(3, 1, 'Curso avanzado para aplicaciones de nivel empresarial.', 3),
-- Cursos de Análisis, Diseño y Gestión (Area ID: 2)
(4, 2, 'Clave para entender el "qué" y el "cómo" de los requerimientos de negocio.', 1),
(5, 2, 'Esencial para traducir requerimientos en una arquitectura de software sólida.', 2),
(6, 2, 'Fundamental para la gestión de proyectos de desarrollo modernos.', 3),
-- Cursos de Bases de datos (Area ID: 3)
(7, 3, 'El primer paso para cualquier desarrollo: el diseño de los datos.', 1),
(8, 3, 'Dominio del estándar de la industria para bases de datos estructuradas.', 2),
(9, 3, 'Exploración de las alternativas modernas para datos no estructurados y a gran escala.', 3),
-- Cursos de Backend (Area ID: 4)
(10, 4, 'La base teórica de todo buen programador.', 1),
(11, 4, 'Paradigmas de programación para construir software mantenible y escalable.', 2),
(12, 4, 'El estándar de facto para la creación de microservicios en el ecosistema Java.', 3),
-- Cursos de FullStack (Area ID: 5)
(13, 5, 'Un lenguaje robusto y ampliamente utilizado para el desarrollo web tradicional.', 1),
(14, 5, 'Enfoque moderno y de alto rendimiento basado en JavaScript.', 2),
(15, 5, 'Flexibilidad y un ecosistema potente para ciencia de datos y desarrollo web.', 3),
-- Cursos de Desarrollo Mobil (Area ID: 6)
(16, 6, 'Desarrollo nativo para la plataforma móvil más extendida del mundo.', 1),
(17, 6, 'La solución moderna para un desarrollo móvil rápido y multiplataforma.', 2),
(18, 6, 'Desarrollo nativo para el ecosistema de alto valor de Apple.', 3);








-- ================================================================================= --
--     SCRIPT DE INSERCIÓN DE DATOS - PARTE 2 : UNIDADES DE APRENDIZAJE (UA) PARA CADA CURSO     --
-- ================================================================================= --
-- Este script reemplaza la versión anterior de Unidades de Aprendizaje.
-- El contenido ha sido expandido para ser más específico, técnico y actualizado
-- a las últimas versiones y mejores prácticas de las tecnologías.
-- ================================================================================= --

-- ---------------------------------
-- INSERCIÓN EN LA TABLA `UnidadAprendizaje`
-- ---------------------------------

INSERT INTO `UnidadAprendizaje` (`id`, `nombre`, `descripcion`, `curso_id`, `idPadre`) VALUES
-- Curso 1: Desarrollo Web I (IDs: 1-9)
(1, 'Módulo 1: HTML5 Semántico', 'Estructura moderna de documentos web. Uso correcto de etiquetas como <main>, <section>, <article>, <nav>, y <header> para mejorar SEO y accesibilidad.', 1, NULL),
(2, '1.1: Formularios y Accesibilidad', 'Creación de formularios robustos con validaciones nativas y atributos ARIA para accesibilidad.', 1, 1),
(3, 'Módulo 2: CSS3 Moderno', 'Fundamentos de CSS, selectores avanzados, pseudo-clases y el modelo de caja.', 1, NULL),
(4, '2.1: Maquetación con Flexbox', 'Creación de layouts unidimensionales flexibles y alineación de elementos.', 1, 3),
(5, '2.2: Maquetación con CSS Grid', 'Diseño de layouts complejos bidimensionales para la estructura principal de la página.', 1, 3),
(6, 'Módulo 3: Responsive Design', 'Uso de Media Queries para adaptar el diseño a diferentes tamaños de pantalla (móvil, tablet, escritorio).', 1, NULL),
(7, 'Módulo 4: JavaScript ES6+', 'Fundamentos de JavaScript moderno: let/const, arrow functions, template literals, y desestructuración.', 1, NULL),
(8, '4.1: Manipulación del DOM y Eventos', 'Cómo seleccionar, modificar y crear elementos HTML dinámicamente. Gestión de eventos de usuario.', 1, 7),
(9, 'Módulo 5: Asincronía y APIs', 'Introducción a la asincronía con Promesas y Async/Await. Consumo de APIs REST con la función fetch().', 1, NULL),

-- Curso 2: React (IDs: 10-17)
(10, 'Módulo 1: Ecosistema Moderno y JSX', 'Configuración de un proyecto con Vite. Entendiendo JSX y cómo React renderiza elementos en el DOM.', 2, NULL),
(11, 'Módulo 2: Componentes Funcionales y Props', 'Creación de componentes reutilizables y comunicación padre-hijo mediante el paso de propiedades (props).', 2, NULL),
(12, 'Módulo 3: Estado y Hooks Fundamentales', 'Introducción al manejo del estado con el hook useState. El ciclo de vida de un componente con useEffect.', 2, NULL),
(13, '3.1: Hooks Avanzados', 'Uso de useContext para estado global, useReducer para lógica de estado compleja y useRef para referencias directas al DOM.', 2, 12),
(14, 'Módulo 4: Ruteo con React Router', 'Implementación de navegación en una Single Page Application (SPA) con la librería React Router v6.', 2, NULL),
(15, 'Módulo 5: Manejo de Formularios', 'Técnicas para la gestión de formularios controlados y no controlados. Introducción a librerías como React Hook Form.', 2, NULL),
(16, 'Módulo 6: Consumo de APIs y Estado Asíncrono', 'Estrategias para fetching de datos y manejo de estados de carga, éxito y error. Uso de librerías como TanStack Query.', 2, NULL),

-- Curso 3: Angular (IDs: 18-25)
(18, 'Módulo 1: Fundamentos de TypeScript y Angular 16+', 'Introducción a TypeScript. Arquitectura de Angular: Módulos vs. Standalone Components.', 3, NULL),
(19, 'Módulo 2: Componentes y Plantillas', 'Creación de componentes, interpolación, property binding, event binding y two-way binding con ngModel.', 3, NULL),
(20, 'Módulo 3: Directivas y Pipes', 'Uso de directivas estructurales (*ngIf, *ngFor) y de atributos. Transformación de datos en plantillas con Pipes.', 3, NULL),
(21, 'Módulo 4: Servicios e Inyección de Dependencias (DI)', 'Centralización de la lógica y datos en servicios. El sistema de inyección de dependencias de Angular.', 3, NULL),
(22, 'Módulo 5: Ruteo y Navegación', 'Configuración del AppRoutingModule para la navegación entre vistas y paso de parámetros en rutas.', 3, NULL),
(23, 'Módulo 6: Programación Reactiva con RxJS', 'Introducción a Observables, Operadores y Subjects para manejar flujos de datos asíncronos.', 3, NULL),
(24, 'Módulo 7: Manejo de Estado con Signals', 'Introducción al nuevo sistema de reactividad de Angular: Signals, para un manejo de estado más simple y performante.', 3, NULL),

-- Curso 4: Modelado de procesos de negocio (IDs: 26-31)
(26, 'Módulo 1: Introducción a la Gestión por Procesos (BPM)', 'El ciclo de vida de BPM (diseño, modelado, ejecución, monitoreo, optimización) y su impacto en la eficiencia organizacional.', 4, NULL),
(27, 'Módulo 2: Notación BPMN 2.0 - Elementos Fundamentales', 'Estudio detallado de Eventos (inicio, intermedio, fin), Actividades (tareas, subprocesos) y Compuertas (exclusivas, paralelas, inclusivas).', 4, NULL),
(28, '2.1: Taller de Compuertas Lógicas', 'Ejercicios prácticos para modelar decisiones y flujos paralelos en un proceso.', 4, 27),
(29, 'Módulo 3: Pools, Lanes y Flujos de Mensaje', 'Modelado de la interacción entre diferentes participantes (departamentos, sistemas) y la comunicación entre procesos (colaboraciones).', 4, NULL),
(30, 'Módulo 4: Artefactos y Objetos de Datos', 'Uso de anotaciones, grupos y objetos de datos para enriquecer el modelo y representar la información que fluye en el proceso.', 4, NULL),
(31, 'Módulo 5: Taller Práctico Integral', 'Modelado de un proceso de negocio de extremo a extremo (ej. "proceso de compra online") utilizando una herramienta como Bizagi Modeler.', 4, NULL),

-- Curso 5: Análisis y Diseño de Sistemas (IDs: 32-39) - Re-insertado
(32, 'Módulo 1: Ingeniería de Requerimientos', 'Diferencia entre requerimientos funcionales y no funcionales. Técnicas de elicitación (entrevistas, workshops) y especificación (SRS).', 5, NULL),
(33, 'Módulo 2: Modelado de Casos de Uso', 'Identificación de actores y casos de uso. Descripción detallada y relaciones (include, extend, generalization).', 5, NULL),
(34, 'Módulo 3: Diseño Estructural con Diagramas de Clases', 'Representación de la estructura estática del sistema. Clases, atributos, métodos, y relaciones (asociación, agregación, composición, herencia).', 5, NULL),
(35, '3.1: Aplicando Principios GRASP', 'Asignación de responsabilidades a las clases utilizando patrones como Experto de la Información, Creador, y Bajo Acoplamiento.', 5, 34),
(36, 'Módulo 4: Diseño Dinámico con Diagramas de Secuencia', 'Modelado del comportamiento y la interacción entre objetos a lo largo del tiempo para un caso de uso específico.', 5, NULL),
(37, 'Módulo 5: Patrones de Diseño Creacionales y Estructurales', 'Estudio práctico de patrones como Singleton, Factory, Adapter y Façade para resolver problemas comunes de diseño.', 5, NULL),
(38, 'Módulo 6: Arquitectura de Software', 'Introducción a estilos arquitectónicos como N-Capas, MVC, Microservicios y Arquitectura Hexagonal.', 5, NULL),

-- Curso 6: SCRUM (IDs: 120-127) - CONTENIDO NUEVO
(120, 'Módulo 1: Fundamentos Ágiles', 'El Manifiesto Ágil: valores y principios. Diferencias entre metodologías predictivas y adaptativas.', 6, NULL),
(121, 'Módulo 2: El Framework Scrum', 'La teoría de Scrum basada en el empirismo. Pilares: transparencia, inspección y adaptación.', 6, NULL),
(122, '2.1: Los Roles de Scrum', 'Responsabilidades del Product Owner (el "qué"), el Scrum Master (el "cómo") y los Developers (la "creación").', 6, 121),
(123, 'Módulo 3: Los Eventos de Scrum', 'El propósito y la dinámica de los 5 eventos: El Sprint, Sprint Planning, Daily Scrum, Sprint Review y Sprint Retrospective.', 6, NULL),
(124, 'Módulo 4: Los Artefactos de Scrum', 'Gestión del Product Backlog (el plan), el Sprint Backlog (el trabajo del Sprint) y el Incremento (el resultado).', 6, NULL),
(125, '4.1: Historias de Usuario y Refinamiento', 'Técnicas para escribir buenas Historias de Usuario (INVEST) y el proceso de refinamiento del backlog.', 6, 124),
(126, 'Módulo 5: Planificación y Estimación Ágil', 'Introducción a la estimación relativa con Story Points y la técnica de Planning Poker. El concepto de Velocidad.', 6, NULL),

-- Curso 7: Modelación de bases de datos (IDs: 67-75)
(67, 'Módulo 1: El Modelo Relacional', 'Introducción al modelo relacional de Codd. Conceptos de tablas, tuplas, atributos, dominios y claves (primarias, foráneas, candidatas).', 7, NULL),
(68, 'Módulo 2: Modelo Entidad-Relación (ER)', 'Cómo abstraer los requerimientos del negocio a un modelo conceptual. Entidades, atributos (simples, compuestos, multivaluados) y relaciones.', 7, NULL),
(69, '2.1: Cardinalidad y Tipos de Relaciones', 'Análisis profundo de relaciones uno a uno (1:1), uno a muchos (1:N) y muchos a muchos (N:M).', 7, 68),
(70, 'Módulo 3: Modelo Entidad-Relación Extendido (EER)', 'Conceptos avanzados como supertipos, subtipos (herencia), especialización y generalización.', 7, NULL),
(71, 'Módulo 4: Normalización de Datos', 'El proceso para eliminar la redundancia y mejorar la integridad de los datos. De la 1FN a la 3FN y FNBC.', 7, NULL),
(72, '4.1: Taller Práctico de Normalización', 'Aplicación de las formas normales a un modelo de datos complejo para optimizar su estructura.', 7, 71),
(73, 'Módulo 5: Del Modelo Lógico al Físico', 'Cómo transformar un diagrama ER normalizado en un script SQL (DDL) para crear la estructura en un SGBD como MySQL.', 7, NULL),
(74, 'Módulo 6: Desnormalización Estratégica', 'Cuándo y por qué romper las reglas de normalización para optimizar el rendimiento de las consultas (OLAP vs OLTP).', 7, NULL),

-- Curso 8: Bases de Datos I (Relacionales) SQL (IDs: 76-85)
(76, 'Módulo 1: Lenguaje de Definición de Datos (DDL)', 'Creación y gestión de la estructura de la base de datos: CREATE TABLE, ALTER TABLE, DROP TABLE, TRUNCATE TABLE.', 8, NULL),
(77, '1.1: Tipos de Datos y Restricciones (Constraints)', 'Uso de tipos de datos (INT, VARCHAR, DATE, etc.) y constraints (PRIMARY KEY, FOREIGN KEY, UNIQUE, NOT NULL, CHECK).', 8, 76),
(78, 'Módulo 2: Lenguaje de Manipulación de Datos (DML)', 'Operaciones con los registros: INSERT, UPDATE y DELETE.', 8, NULL),
(79, 'Módulo 3: Consultas con SELECT', 'La base de la extracción de datos. Cláusulas SELECT, FROM, WHERE, ORDER BY y LIMIT.', 8, NULL),
(80, 'Módulo 4: Consultas Multi-Tabla (JOINs)', 'Combinación de datos de múltiples tablas: INNER JOIN, LEFT JOIN, RIGHT JOIN y FULL OUTER JOIN.', 8, NULL),
(81, 'Módulo 5: Agregación de Datos', 'Uso de funciones de agregación (COUNT, SUM, AVG, MAX, MIN) con la cláusula GROUP BY y filtrado de grupos con HAVING.', 8, NULL),
(82, 'Módulo 6: Consultas Avanzadas', 'Introducción a subconsultas, Common Table Expressions (CTEs con WITH) y funciones de ventana.', 8, NULL),
(83, 'Módulo 7: Transacciones e Índices', 'Garantizar la atomicidad con transacciones (COMMIT, ROLLBACK) y optimizar el rendimiento de las búsquedas con CREATE INDEX.', 8, NULL),

-- Curso 9: Bases de Datos II (No Relacionales) NoSQL (IDs: 86-94)
(86, 'Módulo 1: El Mundo NoSQL y el Teorema CAP', 'Por qué surgen las bases de datos NoSQL. Entendiendo el balance entre Consistencia, Disponibilidad y Tolerancia a Particiones.', 9, NULL),
(87, 'Módulo 2: Bases de Datos Documentales - MongoDB', 'Almacenamiento de documentos BSON en colecciones. Modelado flexible y consultas con MQL (Mongo Query Language).', 9, NULL),
(88, '2.1: Operaciones CRUD y Agregaciones en MongoDB', 'Realización de operaciones de inserción, lectura, actualización y borrado. Uso del Aggregation Framework.', 9, 87),
(89, 'Módulo 3: Bases de Datos Clave-Valor - Redis', 'Estructuras de datos en memoria de alta velocidad. Casos de uso: caché, contadores, colas de mensajes y sesiones de usuario.', 9, NULL),
(90, 'Módulo 4: Bases de Datos de Familia de Columnas - Cassandra', 'Arquitectura distribuida para alta disponibilidad y escalabilidad masiva. Ideal para cargas de trabajo con muchas escrituras.', 9, NULL),
(91, 'Módulo 5: Bases de Datos de Grafos - Neo4j', 'Modelado de datos altamente conectados. Nodos, relaciones y propiedades. Consultas con el lenguaje Cypher.', 9, NULL),
(92, 'Módulo 6: ¿Cuándo usar SQL vs NoSQL?', 'Análisis comparativo de casos de uso para decidir la tecnología de base de datos adecuada para un proyecto.', 9, NULL),

-- Curso 10: Introducción a la Algoritmia (IDs: 95-103)
(95, 'Módulo 1: Análisis de Complejidad', 'Medición de la eficiencia de un algoritmo. Notación Asintótica: Big O (peor caso), Big Ω (mejor caso), Big Θ (caso promedio).', 10, NULL),
(96, 'Módulo 2: Estructuras de Datos Lineales', 'Implementación y análisis de Arrays, Listas Enlazadas (simples, dobles), Pilas (Stacks) y Colas (Queues).', 10, NULL),
(97, 'Módulo 3: Algoritmos de Ordenamiento', 'Análisis comparativo de algoritmos simples (Burbuja, Inserción) y eficientes (MergeSort, QuickSort, HeapSort).', 10, NULL),
(98, 'Módulo 4: Algoritmos de Búsqueda', 'Búsqueda lineal vs. Búsqueda Binaria en arreglos ordenados.', 10, NULL),
(99, 'Módulo 5: Estructuras de Datos No Lineales I - Hash Tables', 'Funcionamiento de las tablas hash, manejo de colisiones y su importancia para búsquedas en O(1).', 10, NULL),
(100, 'Módulo 6: Estructuras de Datos No Lineales II - Árboles', 'Árboles binarios de búsqueda (BST), balanceo (AVL) y recorridos (in-order, pre-order, post-order).', 10, NULL),
(101, 'Módulo 7: Estructuras de Datos No Lineales III - Grafos', 'Representación de grafos (matrices y listas de adyacencia). Algoritmos de recorrido: Búsqueda en Amplitud (BFS) y Búsqueda en Profundidad (DFS).', 10, NULL),

-- Curso 11: Programación Orientada a Objetos (C#) (IDs: 104-111)
(104, 'Módulo 1: Pilares de la POO', 'Análisis profundo de Encapsulamiento, Herencia, Polimorfismo y Abstracción con ejemplos en C#.', 11, NULL),
(105, 'Módulo 2: Clases, Structs y Records en .NET', 'Diferencias y casos de uso para tipos por referencia y por valor. Introducción a los `records` inmutables.', 11, NULL),
(106, 'Módulo 3: Herencia y Polimorfismo en C#', 'Uso de clases base, `override`, `virtual`. Implementación de polimorfismo en tiempo de ejecución.', 11, NULL),
(107, 'Módulo 4: Interfaces y Clases Abstractas', 'Diseño de contratos y abstracción. Diferencias clave y cuándo usar cada una.', 11, NULL),
(108, 'Módulo 5: Principios de Diseño SOLID', 'Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion. Aplicados en C#.', 11, NULL),
(109, 'Módulo 6: Patrones de Diseño Creacionales y Estructurales', 'Implementación de patrones como Singleton, Factory Method, Adapter y Decorator en C#.', 11, NULL),
(110, 'Módulo 7: Programación Asíncrona en POO', 'Uso de `async` y `await` en métodos de clase para operaciones no bloqueantes.', 11, NULL),

-- Curso 12: Desarrollo de Servicios Rest (Spring Boot) (IDs: 112-120)
(112, 'Módulo 1: Fundamentos de Spring Boot 3', 'Inversión de Control (IoC), Inyección de Dependencias (DI). Anotaciones: @Component, @Service, @Autowired.', 12, NULL),
(113, 'Módulo 2: Capa Web - Controladores REST', 'Creación de Endpoints con @RestController. Anotaciones de mapeo (@GetMapping, @PostMapping, etc.). Manejo de DTOs y validaciones (Validation API).', 12, NULL),
(114, 'Módulo 3: Capa de Persistencia - Spring Data JPA', 'Mapeo Objeto-Relacional (ORM) con @Entity. Creación de @Repository para operaciones CRUD.', 12, NULL),
(115, '3.1: Consultas Personalizadas y Paginación', 'Creación de métodos de consulta derivados y uso de @Query. Implementación de paginación y ordenamiento.', 12, 114),
(116, 'Módulo 4: Capa de Servicio y Lógica de Negocio', 'Implementación de la lógica de negocio en clases anotadas con @Service. Manejo de transacciones con @Transactional.', 12, NULL),
(117, 'Módulo 5: Seguridad con Spring Security 6', 'Configuración de la cadena de filtros de seguridad. Asegurar endpoints basados en roles. Implementación de autenticación con JWT.', 12, NULL),
(118, 'Módulo 6: Manejo de Errores y Excepciones', 'Creación de un manejador de excepciones global con @ControllerAdvice y @ExceptionHandler.', 12, NULL),
(119, 'Módulo 7: Testing', 'Pruebas unitarias para servicios (con Mockito) y pruebas de integración para controladores (con MockMvc).', 12, NULL),

-- Curso 13: PHP (IDs: 128-135)
(128, 'Módulo 1: PHP Moderno (8+)', 'Configuración del entorno con Docker. Sintaxis moderna: tipado estricto, arrow functions, named arguments. Gestión de dependencias con Composer.', 13, NULL),
(129, 'Módulo 2: Programación Orientada a Objetos en PHP', 'Clases, objetos, herencia, interfaces y traits. Aplicación de principios SOLID en PHP.', 13, NULL),
(130, 'Módulo 3: Interacción con Bases de Datos con PDO', 'Realización de consultas preparadas para prevenir inyección SQL. Mapeo de resultados a objetos.', 13, NULL),
(131, 'Módulo 4: Arquitectura y Ruteo', 'Creación de un enrutador simple para manejar peticiones web y estructurar la aplicación siguiendo un patrón similar a MVC.', 13, NULL),
(132, 'Módulo 5: Introducción a un Framework Moderno (Laravel/Symfony)', 'Conceptos básicos de un framework de PHP para acelerar el desarrollo: ORM (Eloquent), plantillas (Blade) y controladores.', 13, NULL),
(133, '5.1: Creación de una API REST con Laravel', 'Desarrollo de endpoints, manejo de peticiones y respuestas JSON.', 13, 132),

-- Curso 14: NODE JS (IDs: 136-143)
(136, 'Módulo 1: Fundamentos Asíncronos de JavaScript y Node.js', 'El Event Loop, Callbacks, Promesas y la sintaxis Async/Await. Módulos CommonJS vs. ES Modules.', 14, NULL),
(137, 'Módulo 2: El Ecosistema de Node.js', 'Gestión de paquetes con NPM/Yarn. Scripts de NPM. Variables de entorno con `dotenv`.', 14, NULL),
(138, 'Módulo 3: Creación de un Servidor con Express.js', 'Framework Express: Ruteo, Middlewares, manejo de errores y servicio de archivos estáticos.', 14, NULL),
(139, 'Módulo 4: API RESTful con Express y MongoDB', 'Diseño de una API REST. Integración con MongoDB usando Mongoose para el modelado de datos.', 14, NULL),
(140, '4.1: Autenticación con JWT', 'Implementación de un sistema de autenticación basado en JSON Web Tokens para proteger rutas.', 14, 139),
(141, 'Módulo 5: Pruebas (Testing)', 'Introducción al testing de APIs con herramientas como Jest y Supertest.', 14, NULL),

-- Curso 15: PYTHON (IDs: 144-151)
(144, 'Módulo 1: Python para el Backend', 'Entornos virtuales (venv), gestión de paquetes con Pip. Fundamentos de la programación orientada a objetos en Python.', 15, NULL),
(145, 'Módulo 2: Frameworks Web - Flask vs. Django', 'Comparativa de arquitecturas: el minimalismo de Flask contra el enfoque "baterías incluidas" de Django.', 15, NULL),
(146, 'Módulo 3: Desarrollo de APIs con Flask', 'Creación de una API REST simple con Flask. Ruteo, manejo de peticiones y respuestas JSON.', 15, NULL),
(147, 'Módulo 4: Desarrollo FullStack con Django', 'Arquitectura MVT (Modelo-Vista-Template). El ORM de Django, sistema de administración y plantillas.', 15, NULL),
(148, '4.1: El ORM de Django', 'Definición de modelos, migraciones y realización de consultas complejas a la base de datos.', 15, 147),
(149, 'Módulo 5: Django REST Framework (DRF)', 'Construcción de APIs potentes sobre Django. Serializadores, Vistas basadas en clases y sistema de ruteo.', 15, NULL),

-- Curso 16: Android Studio (IDs: 152-159)
(152, 'Módulo 1: Fundamentos de Kotlin y Coroutines', 'Sintaxis moderna de Kotlin (null safety, data classes). Introducción a la asincronía con coroutines para operaciones de red y base de datos.', 16, NULL),
(153, 'Módulo 2: Android Jetpack - UI Declarativa con Jetpack Compose', 'Construcción de interfaces de usuario modernas de forma declarativa. @Composable functions, State, y Layouts (Column, Row, Box).', 16, NULL),
(154, 'Módulo 3: Arquitectura de la Aplicación (MVVM)', 'Implementación del patrón Model-View-ViewModel con componentes de Jetpack: ViewModel, LiveData/StateFlow.', 16, NULL),
(155, 'Módulo 4: Navegación con Navigation Component', 'Definición de un grafo de navegación para gestionar el flujo entre las diferentes pantallas (composables) de la aplicación.', 16, NULL),
(156, 'Módulo 5: Persistencia de Datos con Room', 'Uso de la librería Room para crear y gestionar una base de datos SQLite local de forma sencilla y segura.', 16, NULL),
(157, 'Módulo 6: Red y APIs con Retrofit', 'Consumo de servicios RESTful de forma eficiente utilizando la librería Retrofit y serialización con Gson/Moshi.', 16, NULL),

-- Curso 17: Flutter (IDs: 160-167)
(160, 'Módulo 1: Fundamentos de Dart y Programación Asíncrona', 'Sintaxis de Dart, null safety, y manejo de la asincronía con Futures y Streams.', 17, NULL),
(161, 'Módulo 2: El Framework de Widgets', 'Todo es un Widget. Diferencia entre StatelessWidget y StatefulWidget. El árbol de widgets.', 17, NULL),
(162, '2.1: Widgets Esenciales de Layout', 'Construcción de interfaces complejas con Column, Row, Stack, ListView y Container.', 17, 161),
(163, 'Módulo 3: Navegación con Navigator 2.0', 'Gestión de rutas y pantallas en la aplicación utilizando el sistema de navegación declarativo de Flutter.', 17, NULL),
(164, 'Módulo 4: Manejo de Estado con Provider/Riverpod', 'Estrategias para gestionar el estado de la aplicación de forma eficiente y escalable, separando la UI de la lógica de negocio.', 17, NULL),
(165, 'Módulo 5: Consumo de APIs HTTP', 'Realización de peticiones a servicios REST utilizando el paquete `http` o `dio`.', 17, NULL),
(166, 'Módulo 6: Persistencia Local', 'Almacenamiento de datos simples con `shared_preferences` y datos complejos con una base de datos local como `sqflite`.', 17, NULL),

-- Curso 18: IOS (IDs: 168-175)
(168, 'Módulo 1: Fundamentos de Swift', 'Sintaxis, tipos de datos, opcionales, control de flujo y programación orientada a protocolos (POP).', 18, NULL),
(169, 'Módulo 2: UI Declarativa con SwiftUI', 'Construcción de interfaces para el ecosistema Apple (iOS, macOS, watchOS) con un enfoque declarativo. Views, Modifiers y State.', 18, NULL),
(170, '2.1: Vistas y Controles de SwiftUI', 'Uso de Text, Image, Button, List, Form y otros controles para crear interfaces ricas.', 18, 169),
(171, 'Módulo 3: Manejo de Datos y Estado', 'El flujo de datos en SwiftUI: @State, @Binding, @StateObject y @ObservedObject para crear UIs reactivas.', 18, NULL),
(172, 'Módulo 4: Navegación en SwiftUI', 'Implementación de la navegación jerárquica (NavigationStack) y modal (Sheets).', 18, NULL),
(173, 'Módulo 5: Networking con Async/Await', 'Consumo de APIs REST de forma moderna y legible utilizando la sintaxis async/await de Swift.', 18, NULL),
(174, 'Módulo 6: Persistencia de Datos con SwiftData', 'Modelado y persistencia de datos locales de forma sencilla utilizando el nuevo framework SwiftData.', 18, NULL);


-- ----------------------------------------------------
-- ACTUALIZACIÓN DE SECUENCIA (idAnterior, idSiguiente)
-- ----------------------------------------------------
-- Este bloque enlaza las unidades principales de cada curso en una secuencia lógica.

-- Curso 1: Desarrollo Web I
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 3 WHERE `id` = 1;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 1, `idSiguiente` = 6 WHERE `id` = 3;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 3, `idSiguiente` = 7 WHERE `id` = 6;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 6, `idSiguiente` = 9 WHERE `id` = 7;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 7 WHERE `id` = 9;

-- Curso 2: React
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 11 WHERE `id` = 10;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 10, `idSiguiente` = 12 WHERE `id` = 11;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 11, `idSiguiente` = 14 WHERE `id` = 12;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 12, `idSiguiente` = 15 WHERE `id` = 14;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 14, `idSiguiente` = 16 WHERE `id` = 15;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 15 WHERE `id` = 16;

-- Curso 3: Angular
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 19 WHERE `id` = 18;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 18, `idSiguiente` = 20 WHERE `id` = 19;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 19, `idSiguiente` = 21 WHERE `id` = 20;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 20, `idSiguiente` = 22 WHERE `id` = 21;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 21, `idSiguiente` = 23 WHERE `id` = 22;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 22, `idSiguiente` = 24 WHERE `id` = 23;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 23 WHERE `id` = 24;

-- Curso 4: Modelado de procesos de negocio
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 27 WHERE `id` = 26;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 26, `idSiguiente` = 29 WHERE `id` = 27;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 27, `idSiguiente` = 30 WHERE `id` = 29;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 29, `idSiguiente` = 31 WHERE `id` = 30;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 30 WHERE `id` = 31;

-- Curso 5: Análisis y Diseño de Sistemas
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 33 WHERE `id` = 32;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 32, `idSiguiente` = 34 WHERE `id` = 33;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 33, `idSiguiente` = 36 WHERE `id` = 34;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 34, `idSiguiente` = 37 WHERE `id` = 36;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 36, `idSiguiente` = 38 WHERE `id` = 37;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 37 WHERE `id` = 38;

-- Curso 6: SCRUM
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 121 WHERE `id` = 120;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 120, `idSiguiente` = 123 WHERE `id` = 121;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 121, `idSiguiente` = 124 WHERE `id` = 123;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 123, `idSiguiente` = 126 WHERE `id` = 124;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 124 WHERE `id` = 126;

-- Curso 7: Modelación de bases de datos
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 68 WHERE `id` = 67;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 67, `idSiguiente` = 70 WHERE `id` = 68;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 68, `idSiguiente` = 71 WHERE `id` = 70;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 70, `idSiguiente` = 73 WHERE `id` = 71;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 71, `idSiguiente` = 74 WHERE `id` = 73;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 73 WHERE `id` = 74;

-- Curso 8: Bases de Datos I (Relacionales)
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 78 WHERE `id` = 76;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 76, `idSiguiente` = 79 WHERE `id` = 78;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 78, `idSiguiente` = 80 WHERE `id` = 79;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 79, `idSiguiente` = 81 WHERE `id` = 80;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 80, `idSiguiente` = 82 WHERE `id` = 81;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 81, `idSiguiente` = 83 WHERE `id` = 82;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 82 WHERE `id` = 83;

-- Curso 9: Bases de Datos II (No Relacionales)
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 87 WHERE `id` = 86;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 86, `idSiguiente` = 89 WHERE `id` = 87;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 87, `idSiguiente` = 90 WHERE `id` = 89;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 89, `idSiguiente` = 91 WHERE `id` = 90;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 90, `idSiguiente` = 92 WHERE `id` = 91;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 91 WHERE `id` = 92;

-- Curso 10: Introducción a la Algoritmia
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 96 WHERE `id` = 95;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 95, `idSiguiente` = 97 WHERE `id` = 96;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 96, `idSiguiente` = 98 WHERE `id` = 97;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 97, `idSiguiente` = 99 WHERE `id` = 98;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 98, `idSiguiente` = 100 WHERE `id` = 99;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 99, `idSiguiente` = 101 WHERE `id` = 100;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 100 WHERE `id` = 101;

-- Curso 11: Programación Orientada a Objetos (C#)
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 105 WHERE `id` = 104;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 104, `idSiguiente` = 106 WHERE `id` = 105;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 105, `idSiguiente` = 107 WHERE `id` = 106;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 106, `idSiguiente` = 108 WHERE `id` = 107;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 107, `idSiguiente` = 109 WHERE `id` = 108;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 108, `idSiguiente` = 110 WHERE `id` = 109;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 109 WHERE `id` = 110;

-- Curso 12: Desarrollo de Servicios Rest (Spring Boot)
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 113 WHERE `id` = 112;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 112, `idSiguiente` = 114 WHERE `id` = 113;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 113, `idSiguiente` = 116 WHERE `id` = 114;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 114, `idSiguiente` = 117 WHERE `id` = 116;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 116, `idSiguiente` = 118 WHERE `id` = 117;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 117, `idSiguiente` = 119 WHERE `id` = 118;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 118 WHERE `id` = 119;

-- Curso 13: PHP
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 129 WHERE `id` = 128;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 128, `idSiguiente` = 130 WHERE `id` = 129;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 129, `idSiguiente` = 131 WHERE `id` = 130;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 130, `idSiguiente` = 132 WHERE `id` = 131;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 131 WHERE `id` = 132;

-- Curso 14: NODE JS
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 137 WHERE `id` = 136;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 136, `idSiguiente` = 138 WHERE `id` = 137;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 137, `idSiguiente` = 139 WHERE `id` = 138;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 138, `idSiguiente` = 141 WHERE `id` = 139;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 139 WHERE `id` = 141;

-- Curso 15: PYTHON
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 145 WHERE `id` = 144;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 144, `idSiguiente` = 146 WHERE `id` = 145;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 145, `idSiguiente` = 147 WHERE `id` = 146;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 146, `idSiguiente` = 149 WHERE `id` = 147;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 147 WHERE `id` = 149;

-- Curso 16: Android Studio
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 153 WHERE `id` = 152;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 152, `idSiguiente` = 154 WHERE `id` = 153;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 153, `idSiguiente` = 155 WHERE `id` = 154;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 154, `idSiguiente` = 156 WHERE `id` = 155;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 155, `idSiguiente` = 157 WHERE `id` = 156;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 156 WHERE `id` = 157;

-- Curso 17: Flutter
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 161 WHERE `id` = 160;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 160, `idSiguiente` = 163 WHERE `id` = 161;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 161, `idSiguiente` = 164 WHERE `id` = 163;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 163, `idSiguiente` = 165 WHERE `id` = 164;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 164, `idSiguiente` = 166 WHERE `id` = 165;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 165 WHERE `id` = 166;

-- Curso 18: IOS
UPDATE `UnidadAprendizaje` SET `idSiguiente` = 169 WHERE `id` = 168;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 168, `idSiguiente` = 171 WHERE `id` = 169;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 169, `idSiguiente` = 172 WHERE `id` = 171;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 171, `idSiguiente` = 173 WHERE `id` = 172;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 172, `idSiguiente` = 174 WHERE `id` = 173;
UPDATE `UnidadAprendizaje` SET `idAnterior` = 173 WHERE `id` = 174;







-- ================================================================================= --
--     SCRIPT DE INSERCIÓN - PARTE 3: CONTENIDO Y EVALUACIONES DETALLADAS            --
-- ================================================================================= --
-- V2: Expande masivamente el contenido y las evaluaciones para los cursos de
-- Frontend y Backend, siguiendo reglas específicas.
-- Este script reemplaza cualquier ejecución anterior de la Parte 4.
-- ================================================================================= --

-- ---------------------------------
-- 1. POBLAR TABLAS DE TIPOS
-- ---------------------------------
INSERT INTO `TipoDocumento` (`id`, `nombre`, `extension`) VALUES
                                                              (1, 'Video-lección', 'mp4'),
                                                              (2, 'PDF-Lectura', 'pdf'),
                                                              (3, 'Código Fuente', 'zip'),
                                                              (4, 'Enlace Externo', 'url'),
                                                              (5, 'Presentación', 'pptx');

-- -----------------------------------------------------------
-- 2. POBLAR `Documento` PARA CURSOS DE FRONTEND Y BACKEND
-- -----------------------------------------------------------

-- Contenido para Curso 1: Desarrollo Web I
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Video: Introducción a HTML Semántico', 'https://videos.sistema.com/html-semantico.mp4', 1, 1),
                                                                                                ('Lectura: Guía de etiquetas HTML5', 'https://docs.sistema.com/guia-html5.pdf', 2, 1),
                                                                                                ('Código: Ejemplo de formulario accesible', 'https://repos.sistema.com/form-accesible.zip', 3, 2),
                                                                                                ('Video: Dominando el Modelo de Caja en CSS', 'https://videos.sistema.com/css-box-model.mp4', 1, 3),
                                                                                                ('Recurso: Guía completa de Flexbox', 'https://css-tricks.com/snippets/css/a-guide-to-flexbox/', 4, 4),
                                                                                                ('Recurso: Guía completa de CSS Grid', 'https://css-tricks.com/snippets/css/complete-guide-grid/', 4, 5),
                                                                                                ('Presentación: Estrategias de Responsive Design', 'https://slides.sistema.com/responsive.pptx', 5, 6),
                                                                                                ('Video: JavaScript Moderno - ES6+', 'https://videos.sistema.com/es6-features.mp4', 1, 7),
                                                                                                ('Código: Taller de Manipulación del DOM', 'https://repos.sistema.com/dom-workshop.zip', 3, 8),
                                                                                                ('Lectura: Entendiendo Promesas y Async/Await', 'https://docs.sistema.com/async-js.pdf', 2, 9);

-- Contenido para Curso 2: React
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Video: Configurando un proyecto con Vite', 'https://videos.sistema.com/react-vite.mp4', 1, 10),
                                                                                                ('Lectura: ¿Qué es JSX?', 'https://docs.sistema.com/jsx-explained.pdf', 2, 10),
                                                                                                ('Código: Creación de componentes funcionales', 'https://repos.sistema.com/react-components.zip', 3, 11),
                                                                                                ('Video: El Hook useState', 'https://videos.sistema.com/use-state.mp4', 1, 12),
                                                                                                ('Video: El Hook useEffect', 'https://videos.sistema.com/use-effect.mp4', 1, 12),
                                                                                                ('Lectura: Guía de Hooks Avanzados', 'https://docs.sistema.com/advanced-hooks.pdf', 2, 13),
                                                                                                ('Código: Ejemplo con React Router v6', 'https://repos.sistema.com/react-router-example.zip', 3, 14),
                                                                                                ('Video: Formularios con React Hook Form', 'https://videos.sistema.com/react-hook-form.mp4', 1, 15),
                                                                                                ('Lectura: Fetching de datos con TanStack Query', 'https://docs.sistema.com/tanstack-query.pdf', 2, 16);

-- Contenido para Curso 3: Angular
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Lectura: Standalone Components en Angular 16+', 'https://docs.sistema.com/angular-standalone.pdf', 2, 18),
                                                                                                ('Video: Data Binding en Angular', 'https://videos.sistema.com/angular-binding.mp4', 1, 19),
                                                                                                ('Código: Ejemplos de Directivas Estructurales', 'https://repos.sistema.com/angular-directives.zip', 3, 20),
                                                                                                ('Video: Inyección de Dependencias Explicada', 'https://videos.sistema.com/angular-di.mp4', 1, 21),
                                                                                                ('Código: Configuración de Rutas Hijas', 'https://repos.sistema.com/angular-routing.zip', 3, 22),
                                                                                                ('Lectura: Introducción a la Programación Reactiva', 'https://docs.sistema.com/rxjs-intro.pdf', 2, 23),
                                                                                                ('Video: El Futuro del Estado: Angular Signals', 'https://videos.sistema.com/angular-signals.mp4', 1, 24);

-- Contenido para Curso 10: Introducción a la Algoritmia
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Lectura: Guía de Notación Big O', 'https://docs.sistema.com/big-o.pdf', 2, 95),
                                                                                                ('Código: Implementación de Pilas y Colas', 'https://repos.sistema.com/stacks-queues.zip', 3, 96),
                                                                                                ('Video: Comparativa Visual de Algoritmos de Ordenamiento', 'https://videos.sistema.com/sorting-visual.mp4', 1, 97),
                                                                                                ('Presentación: Búsqueda Binaria vs. Lineal', 'https://slides.sistema.com/searches.pptx', 5, 98),
                                                                                                ('Lectura: Cómo funcionan las Tablas Hash', 'https://docs.sistema.com/hash-tables.pdf', 2, 99),
                                                                                                ('Video: Recorridos de Árboles (In-Order, Pre-Order, Post-Order)', 'https://videos.sistema.com/tree-traversal.mp4', 1, 100),
                                                                                                ('Código: Implementación de BFS y DFS en un Grafo', 'https://repos.sistema.com/graph-traversal.zip', 3, 101);

-- Contenido para Curso 11: Programación Orientada a Objetos (C#)
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Lectura: Los 4 Pilares de la POO', 'https://docs.sistema.com/oop-pillars.pdf', 2, 104),
                                                                                                ('Video: Records en C# - Inmutabilidad Fácil', 'https://videos.sistema.com/csharp-records.mp4', 1, 105),
                                                                                                ('Código: Ejemplo de Polimorfismo', 'https://repos.sistema.com/csharp-polymorphism.zip', 3, 106),
                                                                                                ('Lectura: Interfaces vs. Clases Abstractas', 'https://docs.sistema.com/interface-vs-abstract.pdf', 2, 107),
                                                                                                ('Recurso: Guía de Principios SOLID', 'https://digital.ai/resources/solid-principles', 4, 108),
                                                                                                ('Video: Patrón Factory en C#', 'https://videos.sistema.com/factory-pattern.mp4', 1, 109),
                                                                                                ('Código: Uso de async/await para E/S de archivos', 'https://repos.sistema.com/csharp-async-io.zip', 3, 110);

-- Contenido para Curso 12: Desarrollo de Servicios Rest (Spring Boot)
INSERT INTO `Documento` (`nombre`, `archivo`, `tipo_documento_id`, `unidad_aprendizaje_id`) VALUES
                                                                                                ('Lectura: El Contenedor de Spring y la Inyección de Dependencias', 'https://docs.sistema.com/spring-ioc.pdf', 2, 112),
                                                                                                ('Video: Creando tu Primer Endpoint', 'https://videos.sistema.com/spring-first-endpoint.mp4', 1, 113),
                                                                                                ('Código: Ejemplo de Entidad y Repositorio JPA', 'https://repos.sistema.com/spring-jpa-example.zip', 3, 114),
                                                                                                ('Lectura: Paginación y Ordenamiento con Spring Data', 'https://docs.sistema.com/spring-pagination.pdf', 2, 115),
                                                                                                ('Presentación: Flujo de una Petición en Spring MVC', 'https://slides.sistema.com/spring-mvc-flow.pptx', 5, 116),
                                                                                                ('Video: Asegurando una API con JWT y Spring Security 6', 'https://videos.sistema.com/spring-security-jwt.mp4', 1, 117),
                                                                                                ('Código: Manejador de Excepciones Global', 'https://repos.sistema.com/spring-exception-handler.zip', 3, 118),
                                                                                                ('Lectura: Testing con Mockito y MockMvc', 'https://docs.sistema.com/spring-testing.pdf', 2, 119);






-- ================================================================================= --
--     SCRIPT DE INSERCIÓN - PARTE 4: USUARIOS Y MATRÍCULAS                          --
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
                                       (2, 'PROFESOR'),
                                       (3, 'ALUMNO');

-- 2. Variable de contraseña hasheada
-- NOTA: En producción, esta debe generarse dinámicamente con BCrypt (contra1234)
SET @hashed_password = '$2b$12$AyI5rl14aAMfmRsqL/GhrexfLuHPsz51OHMn4NAJd4rZFTIDpfFO.';


-- == Administradores ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`) VALUES
                                                                                                            (1, 'Admin', 'General', '00000001', 'admin@sistema.com', @hashed_password, NULL),
                                                                                                            (2, 'Coordinador', 'Academico', '00000002', 'coordinador@sistema.com', @hashed_password, NULL);

-- == Profesores ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`, `telefono`) VALUES
                                                                                                            (3, 'Carlos', 'Santana', '10000001', 'c.santana@profesor.com', @hashed_password, 'https://img.com/csantana.jpg', '987654321'),
                                                                                                            (4, 'Diana', 'Prince', '10000002', 'd.prince@profesor.com', @hashed_password, 'https://img.com/dprince.jpg', '990001133'),
                                                                                                            (5, 'Ricardo', 'Tapia', '10000003', 'r.tapia@profesor.com', @hashed_password, 'https://img.com/rtapia.jpg', '985551134'),
                                                                                                            (6, 'Anthony', 'Stark', '10000004', 'a.stark@profesor.com', @hashed_password, 'https://img.com/astark.jpg', '972221135'),
                                                                                                            (7, 'Barbara', 'Gordon', '10000005', 'b.gordon@profesor.com', @hashed_password, 'https://img.com/bgordon.jpg', '968881136'),
                                                                                                            (8, 'Steve', 'Rogers', '10000006', 's.rogers@profesor.com', @hashed_password, 'https://img.com/srogers.jpg', '954441137'),
                                                                                                            (19, 'Natasha', 'Romanoff', '10000007', 'n.romanoff@profesor.com', @hashed_password, 'https://img.com/nromanoff.jpg', '937771137');

-- == Alumnos ==
INSERT INTO `Usuario` (`id`, `nombre`, `apellido`, `dni`, `email`, `password`, `foto_perfil`) VALUES
                                                                                                            (9, 'Ana', 'Lopez', '20000001', 'ana.lopez@alumno.com', @hashed_password, 'https://img.com/ana.jpg'),
                                                                                                            (10, 'Bruno', 'Diaz', '20000002', 'bruno.diaz@alumno.com', @hashed_password, 'https://img.com/bruno.jpg'),
                                                                                                            (11, 'Carla', 'Kent', '20000003', 'carla.kent@alumno.com', @hashed_password, 'https://img.com/carla.jpg'),
                                                                                                            (12, 'David', 'Perez', '20000004', 'david.perez@alumno.com', @hashed_password, 'https://img.com/david.jpg'),
                                                                                                            (13, 'Elena', 'Garcia', '20000005', 'elena.garcia@alumno.com', @hashed_password, 'https://img.com/elena.jpg'),
                                                                                                            (14, 'Fernando', 'Torres', '20000006', 'fernando.t@alumno.com', @hashed_password, 'https://img.com/fernando.jpg'),
                                                                                                            (15, 'Gabriela', 'Solis', '20000007', 'gabi.solis@alumno.com', @hashed_password, 'https://img.com/gabriela.jpg'),
                                                                                                            (16, 'Hugo', 'Sanchez', '20000008', 'hugo.sanchez@alumno.com', @hashed_password, 'https://img.com/hugo.jpg'),
                                                                                                            (17, 'Irene', 'Adler', '20000009', 'irene.adler@alumno.com', @hashed_password, 'https://img.com/irene.jpg'),
                                                                                                            (18, 'Javier', 'Mascherano', '20000010', 'j.mascherano@alumno.com', @hashed_password, 'https://img.com/javier.jpg'),
                                                                                                            (20, 'Laura', 'Jimenez', '20000011', 'laura.j@alumno.com', @hashed_password, 'https://img.com/laura.jpg'),
                                                                                                            (21, 'Marcos', 'Rojo', '20000012', 'marcos.r@alumno.com', @hashed_password, 'https://img.com/marcos.jpg'),
                                                                                                            (22, 'Nora', 'Castillo', '20000013', 'nora.c@alumno.com', @hashed_password, 'https://img.com/nora.jpg'),
                                                                                                            (23, 'Oscar', 'Velez', '20000014', 'oscar.v@alumno.com', @hashed_password, 'https://img.com/oscar.jpg'),
                                                                                                            (24, 'Patricia', 'Luna', '20000015', 'patricia.l@alumno.com', @hashed_password, 'https://img.com/patricia.jpg'),
                                                                                                            (25, 'Raul', 'Gonzalez', '20000016', 'raul.g@alumno.com', @hashed_password, 'https://img.com/raul.jpg'),
                                                                                                            (26, 'Sofia', 'Vergara', '20000017', 'sofia.v@alumno.com', @hashed_password, 'https://img.com/sofia.jpg'),
                                                                                                            (27, 'Tomas', 'Rincon', '20000018', 'tomas.r@alumno.com', @hashed_password, 'https://img.com/tomas.jpg'),
                                                                                                            (28, 'Ursula', 'Corbero', '20000019', 'ursula.c@alumno.com', @hashed_password, 'https://img.com/ursula.jpg'),
                                                                                                            (29, 'Victor', 'Valdes', '20000020', 'victor.v@alumno.com', @hashed_password, 'https://img.com/victor.jpg');


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
--     SCRIPT DE INSERCIÓN - PARTE 5: ACTIVIDAD DE ESTUDIANTES                       --
-- ================================================================================= --
-- Este script simula la actividad de los estudiantes: intentos de evaluación y
-- participación en foros. Asume que todos los scripts anteriores han sido ejecutados.
-- ================================================================================= --

-- Datos de prueba consistentes para Consultas (100 registros)
-- Pregunta 1: Ana Lopez en Desarrollo Web I (curso 1, unidad 1, matrícula 1)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es HTML semántico?', 'No entiendo la diferencia entre <section> y <article>.', 9, 1, 1, NULL);

-- Respuesta 1: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'La diferencia es el propósito del contenido. <section> agrupa temas, <article> es contenido independiente.', 19, NULL, 1, 1);

-- Pregunta 2: Bruno Diaz en Algoritmia (curso 10, unidad 95, matrícula 4)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Cómo se mide la eficiencia de un algoritmo?', '¿Qué significa O(n)?', 10, 4, 95, NULL);

-- Respuesta 2: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'O(n) indica que el tiempo de ejecución crece linealmente con la entrada.', 6, NULL, 95, 3);

-- Pregunta 3: Carla Kent en Angular (curso 3, unidad 18, matrícula 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un componente standalone?', '¿Por qué Angular 16 los recomienda?', 11, 6, 18, NULL);

-- Respuesta 3: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Permiten crear componentes independientes sin módulos, simplificando la arquitectura.', 3, NULL, 18, 5);

-- Pregunta 4: Elena Garcia en React (curso 2, unidad 10, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es JSX?', '¿Por qué se usa en React?', 13, 8, 10, NULL);

-- Respuesta 4: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'JSX es una sintaxis que permite escribir HTML dentro de JavaScript, facilitando la creación de componentes.', 3, NULL, 10, 7);

-- Pregunta 5: Fernando Torres en Spring Boot (curso 12, unidad 112, matrícula 12)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es IoC en Spring?', '¿Por qué es importante la inyección de dependencias?', 14, 12, 112, NULL);

-- Respuesta 5: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'IoC permite que el framework gestione las dependencias, facilitando el mantenimiento.', 6, NULL, 112, 9);

-- Pregunta 6: David Perez en Android Studio (curso 16, unidad 152, matrícula 16)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una coroutine en Kotlin?', '¿Cómo ayuda en Android?', 12, 16, 152, NULL);

-- Respuesta 6: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Las coroutines permiten manejar operaciones asíncronas de forma sencilla y eficiente.', 8, NULL, 152, 11);

-- Pregunta 7: Patricia Luna en Flutter (curso 17, unidad 160, matrícula 20)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un widget en Flutter?', '¿Cuál es la diferencia entre Stateless y Stateful?', 24, 20, 160, NULL);

-- Respuesta 7: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'StatelessWidget no cambia su estado, StatefulWidget sí puede cambiarlo durante la ejecución.', 8, NULL, 160, 13);

-- Pregunta 8: Ana Lopez en Modelado BD (curso 7, unidad 67, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una clave primaria?', '¿Por qué es importante en una tabla?', 9, 22, 67, NULL);

-- Respuesta 8: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'La clave primaria identifica de forma única cada fila en una tabla.', 5, NULL, 67, 15);

-- Pregunta 9: Bruno Diaz en BD I SQL (curso 8, unidad 76, matrícula 23)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un constraint en SQL?', '¿Para qué sirve?', 10, 23, 76, NULL);

-- Respuesta 9: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un constraint impone reglas sobre los datos, como claves primarias o foráneas.', 5, NULL, 76, 17);

-- Pregunta 10: Fernando Torres en SCRUM (curso 6, unidad 120, matrícula 25)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es el manifiesto ágil?', '¿Por qué es relevante en SCRUM?', 14, 25, 120, NULL);

-- Respuesta 10: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'El manifiesto ágil define los valores y principios que guían el desarrollo ágil.', 19, NULL, 120, 19);


-- Pregunta 11: Carla Kent en Angular (unidad 19, matrícula 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un servicio en Angular?', '¿Cómo se inyecta en un componente?', 11, 6, 19, NULL);
-- Respuesta 11: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Se inyecta usando el constructor y el decorador @Injectable.', 3, NULL, 19, 21);

-- Pregunta 12: Elena Garcia en React (unidad 11, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un hook personalizado?', '¿Cuándo conviene crearlo?', 13, 8, 11, NULL);
-- Respuesta 12: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Cuando necesitas reutilizar lógica de estado o efectos entre componentes.', 3, NULL, 11, 23);

-- Pregunta 13: Bruno Diaz en Algoritmia (unidad 96, matrícula 4)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es la recursividad?', '¿Cuándo es útil?', 10, 4, 96, NULL);
-- Respuesta 13: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'La recursividad es útil para problemas que pueden dividirse en subproblemas similares.', 6, NULL, 96, 25);

-- Pregunta 14: Ana Lopez en Dev Web I (unidad 3, matrícula 1)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Para qué sirve <nav>?', '¿Debe estar en todas las páginas?', 9, 1, 3, NULL);
-- Respuesta 14: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, '<nav> define la navegación principal o secundaria de un sitio.', 19, NULL, 3, 27);

-- Pregunta 15: Patricia Luna en Flutter (unidad 161, matrícula 20)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un FutureBuilder?', '¿Cómo se usa?', 24, 20, 161, NULL);
-- Respuesta 15: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'FutureBuilder permite construir widgets basados en el resultado de un Future.', 8, NULL, 161, 29);

-- Pregunta 16: David Perez en Android Studio (unidad 153, matrícula 16)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un ViewModel?', '¿Por qué es útil en MVVM?', 12, 16, 153, NULL);
-- Respuesta 16: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'ViewModel separa la lógica de UI de los datos, facilitando el mantenimiento.', 8, NULL, 153, 31);

-- Pregunta 17: Ana Lopez en Modelado BD (unidad 68, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una relación 1 a muchos?', '¿Cómo se representa en un diagrama?', 9, 22, 68, NULL);
-- Respuesta 17: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Se representa con una línea que conecta dos entidades, una con multiplicidad 1 y la otra con N.', 5, NULL, 68, 33);

-- Pregunta 18: Bruno Diaz en BD I SQL (unidad 78, matrícula 23)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un índice en SQL?', '¿Mejora el rendimiento?', 10, 23, 78, NULL);
-- Respuesta 18: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un índice mejora la velocidad de las consultas sobre columnas específicas.', 5, NULL, 78, 35);

-- Pregunta 19: Carla Kent en Angular (unidad 20, matrícula 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un pipe en Angular?', '¿Cómo se crea uno personalizado?', 11, 6, 20, NULL);
-- Respuesta 19: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un pipe transforma datos en plantillas. Se crea con el decorador @Pipe.', 3, NULL, 20, 37);

-- Pregunta 20: Elena Garcia en React (unidad 12, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es el estado global?', '¿Cuándo usar Redux?', 13, 8, 12, NULL);
-- Respuesta 20: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Redux se usa cuando necesitas compartir estado entre muchos componentes.', 3, NULL, 12, 39);

-- Pregunta 21: Patricia Luna en iOS (unidad 168, matrícula 30)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es SwiftUI?', '¿Ventajas sobre UIKit?', 24, 30, 168, NULL);
-- Respuesta 21: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'SwiftUI es declarativo y más moderno que UIKit.', 6, NULL, 168, 41);

-- Pregunta 22: David Perez en Flutter (unidad 163, matrícula 20)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un Stream en Dart?', '¿Cómo se usa en Flutter?', 12, 20, 163, NULL);
-- Respuesta 22: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un Stream permite manejar flujos de datos asíncronos.', 8, NULL, 163, 43);

-- Pregunta 23: Ana Lopez en Dev Web I (unidad 6, matrícula 1)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es CSS Grid?', '¿Cuándo usarlo en vez de Flexbox?', 9, 1, 6, NULL);
-- Respuesta 23: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'CSS Grid es ideal para layouts bidimensionales, Flexbox para unidimensionales.', 19, NULL, 6, 45);

-- Pregunta 24: Bruno Diaz en Algoritmia (unidad 97, matrícula 4)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un algoritmo voraz?', '¿Cuándo se usa?', 10, 4, 97, NULL);
-- Respuesta 24: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un algoritmo voraz toma la mejor decisión local en cada paso.', 6, NULL, 97, 47);

-- Pregunta 25: Carla Kent en Angular (unidad 21, matrícula 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un guard en Angular?', '¿Para qué sirve?', 11, 6, 21, NULL);
-- Respuesta 25: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un guard protege rutas y controla el acceso a ellas.', 3, NULL, 21, 49);

-- Pregunta 26: Patricia Luna en Flutter (unidad 164, matrícula 20)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un Provider?', '¿Cómo gestiona el estado?', 24, 20, 164, NULL);
-- Respuesta 26: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Provider es una solución para gestión de estado en Flutter.', 8, NULL, 164, 51);

-- Pregunta 27: Ana Lopez en Modelado BD (unidad 70, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una clave compuesta?', '¿Cuándo se usa?', 9, 22, 70, NULL);
-- Respuesta 27: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Una clave compuesta usa más de una columna para identificar filas.', 5, NULL, 70, 53);

-- Pregunta 28: David Perez en Android Studio (unidad 154, matrícula 16)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es LiveData?', '¿Por qué es útil?', 12, 16, 154, NULL);
-- Respuesta 28: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'LiveData permite observar cambios en los datos y actualizar la UI automáticamente.', 8, NULL, 154, 55);

-- Pregunta 29: Bruno Diaz en BD I SQL (unidad 79, matrícula 23)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una vista en SQL?', '¿Para qué sirve?', 10, 23, 79, NULL);
-- Respuesta 29: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Una vista es una consulta almacenada que se puede tratar como una tabla.', 5, NULL, 79, 57);

-- Pregunta 30: Elena Garcia en React (unidad 14, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es el Virtual DOM?', '¿Cómo mejora el rendimiento?', 13, 8, 14, NULL);
-- Respuesta 30: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'El Virtual DOM minimiza los cambios reales en el DOM, mejorando la eficiencia.', 3, NULL, 14, 59);

-- Pregunta 31: Hugo Sanchez en Spring Boot (unidad 113, matrícula 15)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un endpoint REST?', '¿Cómo se define en Spring Boot?', 16, 15, 113, NULL);
-- Respuesta 31: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un endpoint REST es un método anotado con @GetMapping, @PostMapping, etc.', 6, NULL, 113, 61);

-- Pregunta 32: Laura Jimenez en Dev Web I (unidad 7, matrícula 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es el DOM?', '¿Cómo lo manipula JavaScript?', 20, 19, 7, NULL);
-- Respuesta 32: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'El DOM es la estructura de objetos de la página. JS lo manipula con métodos como getElementById.', 19, NULL, 7, 63);

-- Pregunta 33: Marcos Rojo en POO C# (unidad 104, matrícula 27)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es la herencia?', '¿Cómo se implementa en C#?', 21, 27, 104, NULL);
-- Respuesta 33: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'La herencia permite que una clase derive de otra usando el operador ":".', 6, NULL, 104, 65);

-- Pregunta 34: Nora Castillo en React (unidad 16, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es TanStack Query?', '¿Por qué usarlo en vez de fetch?', 22, 22, 16, NULL);
-- Respuesta 34: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'TanStack Query gestiona caché, sincronización y estados de carga automáticamente.', 3, NULL, 16, 67);

-- Pregunta 35: Oscar Velez en Algoritmia (unidad 98, matrícula 32)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es la búsqueda binaria?', '¿Cuándo es eficiente?', 23, 32, 98, NULL);
-- Respuesta 35: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Es eficiente en listas ordenadas, reduce el tiempo de búsqueda a O(log n).', 6, NULL, 98, 69);

-- Pregunta 36: Patricia Luna en iOS (unidad 169, matrícula 30)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un View en SwiftUI?', '¿Cómo se compone la UI?', 24, 30, 169, NULL);
-- Respuesta 36: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Un View es una estructura que representa una parte de la UI. Se compone de otros Views.', 6, NULL, 169, 71);

-- Pregunta 37: Tomas Rincon en Flutter (unidad 165, matrícula 34)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Cómo consumir una API en Flutter?', '¿Qué paquete se recomienda?', 27, 34, 165, NULL);
-- Respuesta 37: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Se recomienda usar el paquete http o dio para consumir APIs.', 8, NULL, 165, 73);

-- Pregunta 38: Ursula Corbero en Android Studio (unidad 157, matrícula 36)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es Retrofit?', '¿Cómo se configura?', 28, 36, 157, NULL);
-- Respuesta 38: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Retrofit es una librería para consumir APIs REST. Se configura con interfaces y anotaciones.', 8, NULL, 157, 75);

-- Pregunta 39: Victor Valdes en iOS (unidad 173, matrícula 38)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es async/await en Swift?', '¿Cómo mejora el código?', 29, 38, 173, NULL);
-- Respuesta 39: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Permite escribir código asíncrono de forma más legible y estructurada.', 6, NULL, 173, 77);

-- Pregunta 40: Ana Lopez en Dev Web I (unidad 9, matrícula 1)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es async/await en JS?', '¿Por qué es mejor que promesas?', 9, 1, 9, NULL);
-- Respuesta 40: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'async/await simplifica el manejo de código asíncrono y lo hace más legible.', 19, NULL, 9, 79);

-- Pregunta 41: Bruno Diaz en BD I SQL (unidad 80, matrícula 23)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una transacción?', '¿Por qué es importante?', 10, 23, 80, NULL);
-- Respuesta 41: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Una transacción agrupa operaciones para asegurar consistencia y atomicidad.', 5, NULL, 80, 81);

-- Pregunta 42: Carla Kent en Angular (unidad 22, matrícula 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es RxJS?', '¿Por qué se usa en Angular?', 11, 6, 22, NULL);
-- Respuesta 42: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'RxJS permite manejar flujos de datos asíncronos y reactivos.', 3, NULL, 22, 83);

-- Pregunta 43: Gabriela Solis en React (unidad 15, matrícula 13)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es React Hook Form?', '¿Ventajas sobre formularios controlados?', 15, 13, 15, NULL);
-- Respuesta 43: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'React Hook Form simplifica la gestión de formularios y mejora el rendimiento.', 3, NULL, 15, 85);

-- Pregunta 44: David Perez en Android Studio (unidad 156, matrícula 16)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es Room?', '¿Cómo se usa para persistencia?', 12, 16, 156, NULL);
-- Respuesta 44: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Room es una librería para manejar bases de datos SQLite de forma sencilla.', 8, NULL, 156, 87);

-- Pregunta 45: Elena Garcia en React (unidad 13, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es un hook avanzado?', '¿Ejemplo de useMemo?', 13, 8, 13, NULL);
-- Respuesta 45: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'useMemo memoriza valores calculados para evitar cálculos innecesarios.', 3, NULL, 13, 89);

-- Pregunta 46: Hugo Sanchez en Spring Boot (unidad 117, matrícula 31)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es JWT?', '¿Cómo protege una API?', 16, 31, 117, NULL);
-- Respuesta 46: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'JWT es un token seguro que autentica usuarios en APIs.', 6, NULL, 117, 91);

-- Pregunta 47: Ana Lopez en Modelado BD (unidad 71, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es una relación muchos a muchos?', '¿Cómo se implementa?', 9, 22, 71, NULL);
-- Respuesta 47: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Se implementa con una tabla intermedia que contiene las claves de ambas tablas.', 5, NULL, 71, 93);

-- Pregunta 48: Patricia Luna en Flutter (unidad 166, matrícula 20)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es sqflite?', '¿Para qué sirve?', 24, 20, 166, NULL);
-- Respuesta 48: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'sqflite es un paquete para manejar bases de datos SQLite en Flutter.', 8, NULL, 166, 95);

-- Pregunta 49: Raul Gonzalez en Python (unidad 144, matrícula 40)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es venv?', '¿Por qué usar entornos virtuales?', 25, 40, 144, NULL);
-- Respuesta 49: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'venv permite aislar dependencias de proyectos Python.', 6, NULL, 144, 97);

-- Pregunta 50: Sofia Vergara en Android Studio (unidad 155, matrícula 42)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es Navigation Component?', '¿Ventajas sobre Intents?', 26, 33, 155, NULL);
-- Respuesta 50: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Navigation Component facilita la gestión de rutas y el paso de datos entre pantallas.', 8, NULL, 155, 99);

-- Pregunta 51: Tomas Rincon en Flutter (unidad 164, matrícula 34)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es Riverpod?', '¿Diferencias con Provider?', 27, 34, 164, NULL);
-- Respuesta 51: Steve R. (profesor 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Riverpod es una alternativa más robusta y escalable que Provider.', 8, NULL, 164, 101);

-- Pregunta 52: Victor Valdes en iOS (unidad 174, matrícula 38)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es SwiftData?', '¿Cómo se usa para persistencia?', 29, 38, 174, NULL);
-- Respuesta 52: Anthony S. (profesor 6)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'SwiftData es el nuevo framework de persistencia local en iOS.', 6, NULL, 174, 103);

-- Pregunta 53: Laura Jimenez en Dev Web I (unidad 4, matrícula 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es Flexbox?', '¿Cuándo usarlo?', 20, 19, 4, NULL);
-- Respuesta 53: Natasha R. (profesor 19)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'Flexbox es ideal para layouts unidimensionales y alineación flexible.', 19, NULL, 4, 105);

-- Pregunta 54: Elena Garcia en React (unidad 11, matrícula 8)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es useEffect?', '¿Para qué sirve?', 13, 8, 11, NULL);
-- Respuesta 54: Carlos Santana (profesor 3)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'useEffect ejecuta efectos secundarios en componentes funcionales.', 3, NULL, 11, 107);

-- Pregunta 55: Ana Lopez en Modelado BD (unidad 73, matrícula 22)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES ('¿Qué es normalización?', '¿Por qué es importante?', 9, 22, 73, NULL);
-- Respuesta 55: Ricardo Tapia (profesor 5)
INSERT INTO Consultas (titulo, mensaje, usuario_id, registro_alumno_id, unidad_aprendizaje_id, consulta_padre_id)
VALUES (NULL, 'La normalización organiza los datos para reducir redundancia y mejorar integridad.', 5, NULL, 73, 109);


-- Corrección automática de usuario_id en Consultas
UPDATE Consultas c
JOIN RegistroAlumno ra ON c.registro_alumno_id = ra.id
SET c.usuario_id = ra.alumno_usuario_id
WHERE c.usuario_id NOT IN (ra.alumno_usuario_id, ra.profesor_usuario_id);

-- Corrección automática de registro_alumno_id en Consultas (respuestas)
UPDATE Consultas c
join Consultas padre ON c.consulta_padre_id = padre.id
SET c.registro_alumno_id = padre.registro_alumno_id
WHERE c.registro_alumno_id is null;

-- Eliminación de entradas para tener consultas sin respuestas (respuestas sin pregunta)
DELETE FROM Consultas
WHERE id IN (2, 4);

-- Segunda corrección automática de usuario_id en Consultas
UPDATE Consultas c
JOIN RegistroAlumno ra ON c.registro_alumno_id = ra.id
SET c.usuario_id = ra.profesor_usuario_id
WHERE c.usuario_id NOT IN (ra.alumno_usuario_id, ra.profesor_usuario_id)
and EXISTS (SELECT 1 FROM Profesor a WHERE a.usuario_id = C.usuario_id);


-- ================================================================================= --
--     SCRIPT DE INSERCIÓN - PARTE 5: DOCUMENTOS                       --
-- ================================================================================= --

-- ================================================================================= --


-- Curso 4: (26-32)
INSERT INTO `Documento` (`unidad_aprendizaje_id`, `tipo_documento_id`, `nombre`, `archivo`) VALUES
(26, 1, 'Video: Introducción a BPM', 'https://www.youtube.com/watch?v=abc_bpm'),
(26, 2, 'PDF: Fundamentos de BPM', 'https://bpmn.org/fundamentos.pdf'),
(26, 5, 'Presentación: Ciclo de vida BPM', 'https://slideshare.net/bpm_ciclo'),
(27, 1, 'Video: Elementos básicos de BPMN 2.0', 'https://www.youtube.com/watch?v=xyz_bpmn'),
(27, 2, 'Guía BPMN 2.0', 'https://omg.org/spec/BPMN/2.0/pdf'),
(27, 3, 'Ejemplo en Bizagi', 'https://bizagi.com/bpmn-demo'),
(28, 1, 'Video: Compuertas en BPMN', 'https://www.youtube.com/watch?v=compuertas'),
(28, 2, 'PDF: Taller de compuertas', 'https://bpmn.org/compuertas.pdf'),
(29, 1, 'Video: Pools y Lanes', 'https://www.youtube.com/watch?v=poolslanes'),
(29, 2, 'Guía: Flujos de mensaje en BPMN', 'https://bpmn.org/flows.pdf'),
(30, 1, 'Video: Artefactos BPMN', 'https://www.youtube.com/watch?v=artefactos'),
(30, 2, 'PDF: Objetos de datos', 'https://bpmn.org/data_objects.pdf'),
(31, 1, 'Video: Caso práctico BPM', 'https://www.youtube.com/watch?v=caso_bpm'),
(31, 5, 'Presentación: Modelado en Bizagi', 'https://slideshare.net/bpm_bizagi'),

-- Curso 5: (32-38)
(32, 1, 'Video: Ingeniería de Requerimientos', 'https://www.youtube.com/watch?v=req'),
(32, 2, 'PDF: Técnicas de elicitación', 'https://uml.org/req.pdf'),
(33, 1, 'Video: Diagramas de casos de uso', 'https://www.youtube.com/watch?v=casouso'),
(33, 2, 'PDF: Ejemplo casos de uso', 'https://uml.org/casouso.pdf'),
(34, 1, 'Video: Diagramas de clases', 'https://www.youtube.com/watch?v=clases'),
(34, 2, 'PDF: Diseño estructural UML', 'https://uml.org/clases.pdf'),
(35, 1, 'Video: Principios GRASP', 'https://www.youtube.com/watch?v=grasp'),
(35, 2, 'PDF: Ejemplo aplicado', 'https://uml.org/grasp.pdf'),
(36, 1, 'Video: Secuencia UML', 'https://www.youtube.com/watch?v=secuencia'),
(36, 2, 'PDF: Interacción entre objetos', 'https://uml.org/secuencia.pdf'),
(37, 1, 'Video: Patrones creacionales', 'https://www.youtube.com/watch?v=singleton'),
(37, 2, 'PDF: Adapter y Facade', 'https://uml.org/patrones.pdf'),
(38, 1, 'Video: Estilos arquitectónicos', 'https://www.youtube.com/watch?v=arquitectura'),
(38, 2, 'PDF: Microservicios vs Monolito', 'https://uml.org/arquitectura.pdf');

INSERT INTO Documento (unidad_aprendizaje_id, nombre, tipo_documento_id, archivo) VALUES
-- Curso 6: SCRUM (120-126)
(120, 'Video: Introducción al Manifiesto Ágil', 1, 'https://videos.edu/scrum/fundamentos-agiles.mp4'),
(120, 'Lectura: Principios del Manifiesto Ágil', 2, 'https://docs.edu/scrum/principios-agiles.pdf'),
(121, 'Video: Teoría de Scrum y Pilares', 1, 'https://videos.edu/scrum/framework.mp4'),
(122, 'Presentación: Roles de Scrum', 5, 'https://slides.edu/scrum/roles-scrum.pptx'),
(123, 'Video: Eventos de Scrum', 1, 'https://videos.edu/scrum/eventos.mp4'),
(124, 'Lectura: Artefactos de Scrum', 2, 'https://docs.edu/scrum/artefactos.pdf'),
(125, 'Guía: Historias de Usuario INVEST', 2, 'https://docs.edu/scrum/historias-invest.pdf'),
(126, 'Video: Planning Poker y Velocidad', 1, 'https://videos.edu/scrum/estimacion.mp4'),

-- Curso 7: Modelación de bases de datos (67-74)
(67, 'Video: El Modelo Relacional explicado', 1, 'https://videos.edu/db/modelo-relacional.mp4'),
(68, 'Lectura: Introducción a ER', 2, 'https://docs.edu/db/modelo-er.pdf'),
(69, 'Ejercicios: Relaciones 1:1, 1:N, N:M', 3, 'https://code.edu/db/ejercicios-cardinalidad.zip'),
(70, 'Lectura: Modelo EER', 2, 'https://docs.edu/db/modelo-eer.pdf'),
(71, 'Video: Normalización de Bases de Datos', 1, 'https://videos.edu/db/normalizacion.mp4'),
(72, 'Taller: Normalización práctica', 3, 'https://code.edu/db/normalizacion-ejemplos.zip'),
(73, 'Lectura: Del Modelo Lógico al Físico', 2, 'https://docs.edu/db/logico-fisico.pdf'),
(74, 'Enlace externo: Desnormalización en OLAP', 4, 'https://blog.edu/db/desnormalizacion'),

-- Curso 8: Bases de Datos I SQL (76-83)
(76, 'Video: Fundamentos de DDL en SQL', 1, 'https://videos.edu/sql/ddl.mp4'),
(77, 'Guía: Tipos de Datos y Constraints', 2, 'https://docs.edu/sql/tipos-datos.pdf'),
(78, 'Ejemplos: INSERT, UPDATE, DELETE', 3, 'https://code.edu/sql/dml-ejemplos.sql'),
(79, 'Video: Consultas SELECT', 1, 'https://videos.edu/sql/select.mp4'),
(80, 'Guía: Uso de JOINS', 2, 'https://docs.edu/sql/joins.pdf'),
(81, 'Video: Funciones de Agregación', 1, 'https://videos.edu/sql/agregacion.mp4'),
(82, 'Lectura: Subconsultas y CTEs', 2, 'https://docs.edu/sql/consultas-avanzadas.pdf'),
(83, 'Ejemplo: Uso de Transacciones', 3, 'https://code.edu/sql/transacciones.sql'),

-- Curso 9: Bases de Datos II NoSQL (86-92)
(86, 'Video: El mundo NoSQL y CAP', 1, 'https://videos.edu/nosql/teorema-cap.mp4'),
(87, 'Video: Introducción a MongoDB', 1, 'https://videos.edu/nosql/mongodb.mp4'),
(88, 'Ejemplos: CRUD en MongoDB', 3, 'https://code.edu/nosql/crud-mongo.js'),
(89, 'Video: Redis y estructuras clave-valor', 1, 'https://videos.edu/nosql/redis.mp4'),
(90, 'Guía: Introducción a Cassandra', 2, 'https://docs.edu/nosql/cassandra.pdf'),
(91, 'Video: Neo4j y grafos', 1, 'https://videos.edu/nosql/neo4j.mp4'),
(92, 'Lectura: SQL vs NoSQL comparativo', 2, 'https://docs.edu/nosql/sql-vs-nosql.pdf'),

-- Curso 10: Algoritmia (95-101)
(95, 'Video: Notación Big O', 1, 'https://videos.edu/algoritmos/big-o.mp4'),
(96, 'Guía: Listas, Pilas y Colas', 2, 'https://docs.edu/algoritmos/estructuras-lineales.pdf'),
(97, 'Ejemplos: Algoritmos de Ordenamiento', 3, 'https://code.edu/algoritmos/ordenamiento.zip'),
(98, 'Video: Búsqueda Lineal vs Binaria', 1, 'https://videos.edu/algoritmos/busqueda.mp4'),
(99, 'Lectura: Tablas Hash', 2, 'https://docs.edu/algoritmos/hash-tables.pdf'),
(100, 'Video: Árboles Binarios', 1, 'https://videos.edu/algoritmos/arboles.mp4'),
(101, 'Guía: Grafos y BFS/DFS', 2, 'https://docs.edu/algoritmos/grafos.pdf'),

-- Curso 11: POO C# (104-110)
(104, 'Video: Pilares de la POO en C#', 1, 'https://videos.edu/csharp/poo-pilares.mp4'),
(105, 'Lectura: Clases, Structs y Records', 2, 'https://docs.edu/csharp/clases-structs.pdf'),
(106, 'Ejemplo: Herencia en C#', 3, 'https://code.edu/csharp/herencia.zip'),
(107, 'Video: Interfaces y Abstractas', 1, 'https://videos.edu/csharp/interfaces.mp4'),
(108, 'Lectura: Principios SOLID', 2, 'https://docs.edu/csharp/solid.pdf'),
(109, 'Ejemplo: Singleton y Factory', 3, 'https://code.edu/csharp/patrones-creacionales.zip'),
(110, 'Video: Programación Asíncrona', 1, 'https://videos.edu/csharp/asincronia.mp4'),

-- Curso 12: Spring Boot (112-119)
(112, 'Video: Introducción a Spring Boot 3', 1, 'https://videos.edu/spring/intro-springboot.mp4'),
(113, 'Lectura: Controladores REST', 2, 'https://docs.edu/spring/rest-controllers.pdf'),
(114, 'Ejemplo: Entidades y Repositorios JPA', 3, 'https://code.edu/spring/jpa-repositorios.zip'),
(115, 'Lectura: Consultas con @Query', 2, 'https://docs.edu/spring/query.pdf'),
(116, 'Video: Servicios y Transacciones', 1, 'https://videos.edu/spring/servicios.mp4'),
(117, 'Lectura: Seguridad con JWT', 2, 'https://docs.edu/spring/security-jwt.pdf'),
(118, 'Video: Manejo Global de Excepciones', 1, 'https://videos.edu/spring/excepciones.mp4'),
(119, 'Ejemplo: Testing con Mockito', 3, 'https://code.edu/spring/testing.zip'),

-- Curso 13: PHP (128-133)
(128, 'Video: Novedades PHP 8+', 1, 'https://videos.edu/php/php8.mp4'),
(129, 'Lectura: POO en PHP', 2, 'https://docs.edu/php/poo.pdf'),
(130, 'Ejemplo: Consultas PDO', 3, 'https://code.edu/php/pdo.zip'),
(131, 'Video: Enrutamiento en PHP', 1, 'https://videos.edu/php/ruteo.mp4'),
(132, 'Lectura: Introducción a Laravel', 2, 'https://docs.edu/php/laravel.pdf'),
(133, 'Ejemplo: API REST con Laravel', 3, 'https://code.edu/php/api-rest-laravel.zip'),

-- Curso 14: Node.js (136-141)
(136, 'Video: Event Loop y Asincronía', 1, 'https://videos.edu/node/event-loop.mp4'),
(137, 'Lectura: Ecosistema Node.js', 2, 'https://docs.edu/node/ecosistema.pdf'),
(138, 'Ejemplo: Servidor Express', 3, 'https://code.edu/node/express-server.zip'),
(139, 'Video: API REST con MongoDB', 1, 'https://videos.edu/node/rest-mongo.mp4'),
(140, 'Ejemplo: Autenticación con JWT', 3, 'https://code.edu/node/jwt.zip'),
(141, 'Video: Testing con Jest', 1, 'https://videos.edu/node/testing.mp4'),

-- Curso 15: Python (144-149)
(144, 'Video: POO en Python', 1, 'https://videos.edu/python/poo.mp4'),
(145, 'Lectura: Flask vs Django', 2, 'https://docs.edu/python/flask-django.pdf'),
(146, 'Ejemplo: API REST con Flask', 3, 'https://code.edu/python/api-flask.zip'),
(147, 'Video: Django MVT', 1, 'https://videos.edu/python/django-mvt.mp4'),
(148, 'Lectura: ORM de Django', 2, 'https://docs.edu/python/django-orm.pdf'),
(149, 'Ejemplo: DRF con Serializadores', 3, 'https://code.edu/python/drf.zip'),

-- Curso 16: Android Studio (152-157)
(152, 'Video: Kotlin y Coroutines', 1, 'https://videos.edu/android/kotlin-coroutines.mp4'),
(153, 'Lectura: Jetpack Compose UI', 2, 'https://docs.edu/android/jetpack-compose.pdf'),
(154, 'Ejemplo: MVVM con ViewModel', 3, 'https://code.edu/android/mvvm.zip'),
(155, 'Video: Navigation Component', 1, 'https://videos.edu/android/navigation.mp4'),
(156, 'Lectura: Persistencia con Room', 2, 'https://docs.edu/android/room.pdf'),
(157, 'Ejemplo: Consumo API con Retrofit', 3, 'https://code.edu/android/retrofit.zip'),

-- Curso 17: Flutter (160-166)
(160, 'Video: Fundamentos de Dart', 1, 'https://videos.edu/flutter/dart.mp4'),
(161, 'Lectura: Widgets en Flutter', 2, 'https://docs.edu/flutter/widgets.pdf'),
(162, 'Ejemplo: Widgets de Layout', 3, 'https://code.edu/flutter/widgets-layout.zip'),
(163, 'Video: Navigator 2.0', 1, 'https://videos.edu/flutter/navigator2.mp4'),
(164, 'Lectura: Manejo de Estado con Riverpod', 2, 'https://docs.edu/flutter/riverpod.pdf'),
(165, 'Ejemplo: Consumo de APIs con dio', 3, 'https://code.edu/flutter/api-dio.zip'),
(166, 'Video: Persistencia con sqflite', 1, 'https://videos.edu/flutter/sqflite.mp4'),

-- Curso 18: iOS (168-174)
(168, 'Video: Fundamentos de Swift', 1, 'https://videos.edu/ios/swift.mp4'),
(169, 'Lectura: Introducción a SwiftUI', 2, 'https://docs.edu/ios/swiftui.pdf'),
(170, 'Ejemplo: Controles de SwiftUI', 3, 'https://code.edu/ios/swiftui-controles.zip'),
(171, 'Video: Manejo de Estado en SwiftUI', 1, 'https://videos.edu/ios/estado.mp4'),
(172, 'Lectura: Navegación en SwiftUI', 2, 'https://docs.edu/ios/navegacion.pdf'),
(173, 'Ejemplo: Networking con Async/Await', 3, 'https://code.edu/ios/networking.zip'),
(174, 'Video: Persistencia con SwiftData', 1, 'https://videos.edu/ios/swiftdata.mp4');


-- ================================================
-- Actualización de documentos tipo 'video'
-- para cursos 1 (Desarrollo Web I), 2 (React), 3 (Angular)
-- ================================================

-- 1. Introducción a HTML Semántico
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=wx92etmlHtc'
WHERE id = 1;

-- 2. Dominando el Modelo de Caja en CSS
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=WItW2SKZaIo'
WHERE id = 4;

-- 3. JavaScript Moderno - ES6+
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=NCwa_xi0Uuc'
WHERE id = 8;

-- 4. Configurando un proyecto con Vite
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=fC5xG3ra9eA'
WHERE id = 11;

-- 5. El Hook useState
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=O6P86uwfdR0'
WHERE id = 14;

-- 6. El Hook useEffect
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=0ZJgIjIuY7U'
WHERE id = 15;

-- 7. Formularios con React Hook Form
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=-mFXqOaqgZk'
WHERE id = 18;

-- 8. Data Binding en Angular
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=pY0J0GJwJkQ'
WHERE id = 21;

-- 9. Inyección de Dependencias Explicada
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Vxjo1l2x0Rk'
WHERE id = 23;

-- 10. El Futuro del Estado: Angular Signals
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=RhscTK3XUxA'
WHERE id = 26;

-- 11. Comparativa Visual de Algoritmos de Ordenamiento
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=ZZuD6iUe3Pc'
WHERE id = 29;

-- 12. Recorridos de Árboles (In-Order, Pre-Order, Post-Order)
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=9RHO6jU--GU'
WHERE id = 32;

-- 13. Records en C# - Inmutabilidad Fácil
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=7iHckrpa4sg'
WHERE id = 35;

-- 14. Patrón Factory en C#
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=EcFVTgRHJLM'
WHERE id = 39;

-- 15. Creando tu Primer Endpoint (Spring Boot)
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=9SGDpanrc8U'
WHERE id = 42;

-- 16. Asegurando una API con JWT y Spring Security 6
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=soGRyl9ztjI'
WHERE id = 46;

-- 17. Introducción a BPM
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=vhU3ZxJQhFI'
WHERE id = 49;

-- 18. Elementos básicos de BPMN 2.0
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=a_T7c0z6Wc0'
WHERE id = 52;

-- 19. Compuertas en BPMN
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=2I9BM1GwrBk'
WHERE id = 55;

-- 20. Pools y Lanes
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=U7Dsvw4Zx5I'
WHERE id = 57;

-- 21. Artefactos BPMN
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=fBM2fZuwB58'
WHERE id = 59;

-- 22. Caso práctico BPM
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=LDj5dEJShKo'
WHERE id = 61;

-- 23. Ingeniería de Requerimientos
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=gpn2aXfCjFI'
WHERE id = 63;

-- 24. Diagramas de casos de uso
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=UzOTp6K0FhM'
WHERE id = 65;

-- 25. Diagramas de clases
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=UI6lqHOVHic'
WHERE id = 67;

-- 26. Principios GRASP
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=jDNxV1J0dDQ'
WHERE id = 69;

-- 27. Secuencia UML
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=9Q1EFfF8M7g'
WHERE id = 71;

-- 28. Patrones creacionales
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=tAuRQs_d9F8'
WHERE id = 73;

-- 29. Estilos arquitectónicos
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=NMIZlkgKwWA'
WHERE id = 75;

-- 30. Introducción al Manifiesto Ágil
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=502ILHjX9EE'
WHERE id = 77;

-- 31. Teoría de Scrum y Pilares
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=2Vt7Ik8Ublw'
WHERE id = 79;

-- 32. Eventos de Scrum
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=JtQ4MEABuks'
WHERE id = 81;

-- 33. Planning Poker y Velocidad
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=YGg9jD8z2RM'
WHERE id = 84;

-- 34. El Modelo Relacional explicado
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=4cWkVbC2bNE'
WHERE id = 85;

-- 35. Normalización de Bases de Datos
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=UrYLYV7WSHM'
WHERE id = 89;

-- 36. Fundamentos de DDL en SQL
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=4fFz5bt8WmQ'
WHERE id = 93;

-- 37. Consultas SELECT
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=9Pzj7Aj25lw'
WHERE id = 96;

-- 38. Funciones de Agregación
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=6Iu45VZGQDk'
WHERE id = 98;

-- 39. El mundo NoSQL y CAP
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=ue8A-b3t0zc'
WHERE id = 101;

-- 40. Introducción a MongoDB
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=-bt_y4Loofg'
WHERE id = 102;

-- 41. Redis y estructuras clave-valor
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Hbt56gFj998'
WHERE id = 104;

-- 42. Neo4j y grafos
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=8jNPelugC2s'
WHERE id = 106;

-- 43. Notación Big O
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Mo4vesaut8g'
WHERE id = 108;

-- 44. Búsqueda Lineal vs Binaria
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=frxF7Vs8c1s'
WHERE id = 111;

-- 45. Árboles Binarios
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=H5JubkIy_p8'
WHERE id = 113;

-- 46. Pilares de la POO en C#
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=pTB0EiLXUC8'
WHERE id = 115;

-- 47. Interfaces y Abstractas en C#
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=UDmJGvM-OUw'
WHERE id = 118;

-- 48. Programación Asíncrona en C#
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=2moh18sh5p4'
WHERE id = 121;

-- 49. Introducción a Spring Boot 3
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=35EQXmHKZYs'
WHERE id = 122;

-- 50. Creando tu Primer Servicio y Transacción (Spring)
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=sp7EhjLkFY4'
WHERE id = 126;

-- 51. Manejo Global de Excepciones en Spring
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=2G7V3G6jIio'
WHERE id = 128;

-- 52. Novedades PHP 8+
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Wy2f6xT0KCw'
WHERE id = 130;

-- 53. Enrutamiento en PHP
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=kdt-HAtAO0E'
WHERE id = 133;

-- 54. Event Loop y Asincronía en Node.js
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=8aGhZQkoFbQ'
WHERE id = 136;

-- 55. API REST con MongoDB (Node.js)
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=BXv85yBoVFs'
WHERE id = 139;

-- 56. Testing con Jest
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=7r4xVDI2vho'
WHERE id = 141;

-- 57. POO en Python
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Ej_02ICOIgs'
WHERE id = 142;

-- 58. Django MVT
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=F5mRW0jo-U4'
WHERE id = 145;

-- 59. Kotlin y Coroutines
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=BOHK_w09pVA'
WHERE id = 148;

-- 60. Navigation Component en Android
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=5gFrXGbQ8QI'
WHERE id = 151;

-- 61. Fundamentos de Dart
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=Ej_Pcr4uC2Q'
WHERE id = 154;

-- 62. Navigator 2.0 en Flutter
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=kn0EOS-ZiIc'
WHERE id = 157;

-- 63. Persistencia con sqflite en Flutter
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=UpKrhZ0Hppk'
WHERE id = 160;

-- 64. Fundamentos de Swift
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=F2ojC6TNwws'
WHERE id = 161;

-- 65. Manejo de Estado en SwiftUI
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=WW3S3HB9nFI'
WHERE id = 164;

-- 66. Persistencia con SwiftData
UPDATE Documento
SET archivo = 'https://www.youtube.com/watch?v=0N-3R0jD6Cw'
WHERE id = 167;


-- Correcciones a los documentos
update Documento
set archivo =  '/documentos/ManualDelCurso.pdf'
where tipo_documento_id = 2;

update Documento
set archivo =  '/documentos/PROYECTO_APLICATIVO.zip'
where tipo_documento_id = 3;

update Documento
set archivo =  '/documentos/CIBERNEXT.pptx'
where tipo_documento_id = 5;


update Usuario
set foto_perfil = 'http://localhost:8080/imagenes/admin.png'
where email like '%sistema.com';

update Usuario
set foto_perfil = 'http://localhost:8080/imagenes/profesor.png'
where email like '%profesor.com';

update Usuario
set foto_perfil = 'http://localhost:8080/imagenes/alumno.png'
where email like '%alumno.com';