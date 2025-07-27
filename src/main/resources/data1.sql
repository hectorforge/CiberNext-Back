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
--     SCRIPT DE INSERCIÓN - PARTE 3 (FINAL): CONTENIDO Y EVALUACIONES DETALLADAS    --
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

INSERT INTO `TipoPregunta` (`id`, `nombre`) VALUES
                                                (1, 'Opción Múltiple - Única Respuesta'), (2, 'Verdadero / Falso');

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


-- ----------------------------------------------------
-- 2. POBLAR EVALUACIONES, PREGUNTAS Y RESPUESTAS
-- ----------------------------------------------------

-- == Evaluación 1: "Examen Final de Desarrollo Web I" para Unidad 9 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (1, 'Evaluación final sobre HTML, CSS y JS asíncrono.', 30, 9);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (1, '¿Cuál es el propósito principal de la sintaxis `async/await` en JavaScript?', 1, 1),
                                                                                      (2, '¿Qué propiedad de Flexbox se utiliza para distribuir el espacio entre los ítems a lo largo del eje principal?', 1, 1),
                                                                                      (3, 'La etiqueta HTML `<aside>` se usa para:', 1, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (1, 'Para declarar variables que no cambian.', 0.0), (1, 'Para hacer que el código síncrono se comporte de forma asíncrona.', 0.0), (1, 'Para escribir código asíncrono que se lea de forma similar al síncrono.', 1.0), (1, 'Para crear un nuevo hilo de ejecución.', 0.0),
                                                                    (2, 'align-items', 0.0), (2, 'justify-content', 1.0), (2, 'flex-direction', 0.0), (2, 'flex-wrap', 0.0),
                                                                    (3, 'El contenido principal de la página.', 0.0), (3, 'Una sección de navegación con enlaces.', 0.0), (3, 'Contenido que está tangencialmente relacionado con el contenido principal.', 1.0), (3, 'El pie de página del documento.', 0.0);

-- == Evaluación 2: "Examen Final de React" para Unidad 16 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (2, 'Evaluación sobre el ecosistema de React, incluyendo Hooks y manejo de estado.', 35, 16);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (4, '¿Qué hook de React se utiliza para realizar efectos secundarios en componentes funcionales, como el fetching de datos?', 2, 1),
                                                                                      (5, 'En JSX, ¿cómo se aplica una clase CSS a un elemento?', 2, 1),
                                                                                      (6, '¿Cuál es el propósito principal de TanStack Query (React Query)?', 2, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (4, 'useState', 0.0), (4, 'useContext', 0.0), (4, 'useEffect', 1.0), (4, 'useReducer', 0.0),
                                                                    (5, 'usando el atributo `class="mi-clase"`', 0.0), (5, 'usando el atributo `cssClass="mi-clase"`', 0.0), (5, 'usando el atributo `style="mi-clase"`', 0.0), (5, 'usando el atributo `className="mi-clase"`', 1.0),
                                                                    (6, 'Para manejar el ruteo de la aplicación.', 0.0), (6, 'Para gestionar el estado global de forma simple.', 0.0), (6, 'Para simplificar el fetching, caching y actualización del estado del servidor.', 1.0), (6, 'Para crear formularios complejos.', 0.0);

-- == Evaluación 3: "Examen Final de Angular" para Unidad 24 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (3, 'Evaluación sobre conceptos clave de Angular como DI, RxJS y el nuevo sistema de Signals.', 40, 24);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (7, 'En Angular, ¿qué decorador se utiliza para declarar una clase como un servicio que puede ser inyectado?', 3, 1),
                                                                                      (8, 'Un `Observable` de RxJS...', 3, 1),
                                                                                      (9, 'La principal ventaja de los `Signals` en Angular es que...', 3, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (7, '@Component', 0.0), (7, '@NgModule', 0.0), (7, '@Injectable()', 1.0), (7, '@Directive', 0.0),
                                                                    (8, '...es un valor único que se resuelve en el futuro.', 0.0), (8, '...representa un flujo de datos al que te puedes suscribir para recibir valores a lo largo del tiempo.', 1.0), (8, '...es una función que se ejecuta una sola vez.', 0.0), (8, '...es un tipo de dato para almacenar texto.', 0.0),
                                                                    (9, '...permiten usar JavaScript antiguo en Angular.', 0.0), (9, '...ofrecen una detección de cambios más granular y eficiente, mejorando el rendimiento.', 1.0), (9, '...reemplazan completamente a los componentes.', 0.0), (9, '...solo sirven para manejar formularios.', 0.0);

-- == Evaluación 4: "Examen Final de Algoritmia" para Unidad 101 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (4, 'Evaluación sobre complejidad, estructuras de datos y algoritmos fundamentales.', 45, 101);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (10, '¿Cuál es la complejidad temporal (Big O) en el peor de los casos para una búsqueda en un Árbol Binario de Búsqueda (BST) no balanceado?', 4, 1),
                                                                                      (11, '¿Qué estructura de datos es más adecuada para implementar un sistema de "Deshacer" (Undo)?', 4, 1),
                                                                                      (12, 'El algoritmo de recorrido de grafos que explora todos los vecinos de un nodo antes de pasar al siguiente nivel se llama:', 4, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (10, 'O(1)', 0.0), (10, 'O(log n)', 0.0), (10, 'O(n)', 1.0), (10, 'O(n^2)', 0.0),
                                                                    (11, 'Cola (Queue)', 0.0), (11, 'Pila (Stack)', 1.0), (11, 'Lista Enlazada', 0.0), (11, 'Tabla Hash', 0.0),
                                                                    (12, 'Búsqueda en Profundidad (DFS)', 0.0), (12, 'Algoritmo de Dijkstra', 0.0), (12, 'Búsqueda en Amplitud (BFS)', 1.0), (12, 'Algoritmo de Kruskal', 0.0);

-- == Evaluación 5: "Examen Final de POO con C#" para Unidad 110 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (5, 'Evaluación sobre los pilares de la POO, principios SOLID y características de C#.', 40, 110);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (13, 'El principio SOLID que establece que "las clases deben estar abiertas para la extensión, pero cerradas para la modificación" es:', 5, 1),
                                                                                      (14, 'En C#, ¿cuál es la principal diferencia entre una `interface` y una `abstract class`?', 5, 1),
                                                                                      (15, 'La palabra clave `async` en la firma de un método en C# indica que...', 5, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (13, 'Principio de Responsabilidad Única (SRP)', 0.0), (13, 'Principio de Inversión de Dependencias (DIP)', 0.0), (13, 'Principio Abierto/Cerrado (OCP)', 1.0), (13, 'Principio de Segregación de Interfaces (ISP)', 0.0),
                                                                    (14, 'Una clase puede heredar de múltiples clases abstractas, pero solo implementar una interfaz.', 0.0), (14, 'Las interfaces pueden contener campos (variables de instancia), mientras que las clases abstractas no.', 0.0), (14, 'Una clase puede implementar múltiples interfaces, pero solo heredar de una clase (abstracta o no).', 1.0), (14, 'Las clases abstractas no pueden tener constructores.', 0.0),
                                                                    (15, '...el método se ejecutará en un hilo separado automáticamente.', 0.0), (15, '...el método puede usar la palabra clave `await` para pausar su ejecución sin bloquear el hilo.', 1.0), (15, '...el método debe devolver obligatoriamente un `void`.', 0.0), (15, '...el método es obsoleto y será eliminado.', 0.0);

-- == Evaluación 6: "Examen Final de Spring Boot" para Unidad 119 ==
INSERT INTO `Evaluacion` (`id`, `descripcion`, `tiempo`, `unidad_aprendizaje_id`) VALUES (6, 'Evaluación final sobre el ecosistema de Spring Boot, incluyendo JPA, Seguridad y Testing.', 45, 119);
INSERT INTO `Pregunta` (`id`, `descripcion`, `evaluacion_id`, `tipo_pregunta_id`) VALUES
                                                                                      (16, '¿Qué anotación de Spring Boot se usa en una clase de configuración para habilitar la seguridad web?', 6, 1),
                                                                                      (17, 'En Spring Data JPA, ¿cómo se define un método en una interfaz de Repositorio para buscar un usuario por su email?', 6, 1),
                                                                                      (18, 'La anotación `@Transactional` en un método de servicio asegura que...', 6, 1);
-- Respuestas
INSERT INTO `Respuesta` (`pregunta_id`, `descripcion`, `valor`) VALUES
                                                                    (16, '@EnableSecurity', 0.0), (16, '@EnableWebSecurity', 1.0), (16, '@Secure', 0.0), (16, '@EnableJwt', 0.0),
                                                                    (17, '`User findByEmail(String email);`', 1.0), (17, '`User selectUserByEmail(String email);`', 0.0), (17, '`@Query("SELECT u FROM User u WHERE u.email = ?1")` es la única forma.', 0.0), (17, '`User getByEmailAddress(String email);`', 0.0),
                                                                    (18, '...el método se ejecute de forma asíncrona.', 0.0), (18, '...se cree un log de todas las operaciones realizadas.', 0.0), (18, '...todas las operaciones de base de datos dentro del método se ejecuten como una única transacción atómica (o todo o nada).', 1.0), (18, '...el método solo pueda ser llamado por administradores.', 0.0);