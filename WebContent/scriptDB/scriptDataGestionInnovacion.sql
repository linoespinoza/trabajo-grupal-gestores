-- PLAN TARIFARIO
INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Basico', 100.00, 5.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Premium', 200.00, 10.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Platinum', 300.00, 20.00);

-- CENTRO DE FORMACION
INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10406048417', 'Universidad Peruana de Ciencias Aplicadas', 'UNI', 'http://www.upc.edu.pe', '/images/upload/logo/logoUpc.png', 1);

INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10334522659', 'Instituto Superior Tecnologico Cibertec', 'INS', 'http://www.cibertec.edu.pe', '/images/upload/logo/logoCibertec.png', 2);

INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10804050208','Instituto Superior Tecnologico IDAT','INS','http://www.idat.edu.pe','/images/logo/logoIdat.png',1);

-- USUARIO
INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Harry', 'Bravo', 'Coronel', 'M', 'DNI', '40604841', 'hbravocoronel@gmail.com', '962329330', 'admin', 'ADM', NULL);

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pedro', 'Huanco', 'Rivas', 'M', 'DNI', '42654751', 'u201320957@upc.edu.pe', '995553330', 'phuanco', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Roberto', 'Lopez', 'Lingan', 'M', 'DNI', '58933771', 'u201312558@upc.edu.pe', '914554321', 'rlopez', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Fiorella', 'Rojas', 'Mesa', 'F', 'DNI', '22258051', 'u201462989@upc.edu.pe', '922984532', 'frojas', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Luisa', 'Barrera', 'Nunez', 'F', 'DNI', '33344066', 'luisa.barrera@upc.edu.pe', '985583722', 'lbarrera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Oscar', 'Elera', 'Munoz', 'M', 'DNI', '56357809', 'oscar.elera@upc.edu.pe', '953278012', 'oelera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Marco', 'Aurelio', 'Yanez', 'M', 'DNI', '35488065', 'marco.aurelio@upc.edu.pe', '922537712', 'maurelio', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pablo', 'Narvaez', 'Pena', 'M', 'DNI', '33212222', 'pablo.narvaez@upc.edu.pe', '956128913', 'pnarvaez', 'EVA', '10406048417');
INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Luis','Salazar','Lopez','M','DNI','40582715','luis.salazar@cibertec.edu.pe','911892356','lsalazar','EVA','10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Hector','Enciso','Robles','M','DNI','15590921','hector.enciso@cibertec.edu.pe','978152621','henciso','DOC','10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Sandra','Jimenez','Llatas','F','DNI','48102051','sandra.jimenez@upc.edu.pe','915757412','sjimenez','DOC','10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Juan','Pinto','Vivar','M','DNI','45753101','u200109081@idat.edu.pe','945103201','jvivar','EST','10804050208');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Andrea','Miranda','Ruiz','F','DNI','48970271','u201202558@idat.edu.pe','940380021','amiranda','EST','10804050208');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Julia','Rivera','Sarria','F','DNI','42070125','julia.rivera@idat.edu.pe','928119260','jrivera','EVA','10804050208');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Marcel','Saravia','Pinto','M','DNI','15482123','marcel.saravia@idat.edu.pe','985102512','msaravia','DOC','10804050208');

-- IDEA
INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Aula Virtual', 'Tener clases no presenciales', 'online,cursos,foro,evaluacion', '/archivo/upload/aulaVirtual.docx', 2, 'CRE', NOW(), NULL, NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Matricula Online', 'Matricularse en la comodidad de su casa', 'online,horario,matricula,cursos', '/archivo/upload/matriculaOnline.docx', 3, 'PUB', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Encuesta de Alumnos Online', 'Encuesta online de los alumnos con respecto a la calidad educativa', 'online,evaluacion,educacion,calidad', '/archivo/upload/encuestaAlumnoOnline.docx', 4, 'APR', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Ingles Online', 'Ingles en la comodidad de su casa', 'online,horario,ingles,examenes', '/archivo/upload/inglesOnline.docx', 2, 'REC', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Conferencia Online', 'Conferencia online para estudiantes', 'online,conferencia,educacion,temas', '/archivo/upload/conferenciaOnline.docx', 4, 'APR', NOW(), NOW(), 5);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Proquest','Como aprovechar el uso de la biblioteca virtual','biblioteca,libros,online,busqueda','/archivo/upload/BibliotecaVirtual.docx',3,'CRE','2014-03-19 03:57:07',NULL,NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('EBSCO','Optimizar la busqueda de recursos academicos onlines','revistas,recursos,online,busqueda','/archivo/upload/BusquedaRecusrosOnline.docx',4,'CRE','2014-03-19 03:57:07',NULL,NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Organiza tu tiempo','Taller Online para organizar mejor el tiempo','tiempo,organizacion,planeamiento,online','/archivo/upload/TallerTiempoOnline.docx',2,'APR','2014-03-19 03:57:07','2014-03-19 03:57:07',6);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Aprueba tus Examenes Online','Tutorial con tecnicas de estudio para rendir adecuadamente los examenes online','examenes,online,aprobar,tecnicas','/archivo/upload/ApruebaExamenesOnline.docx',3,'REC','2014-03-19 03:57:07','2014-03-19 03:57:07',7);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Grupos de Trabajo Interdiciplinas', 'Formación de grupos de trabajo entre alumnos de diferentes especialidades', 'grupo,especialidades,trabajo,estructura', '/archivo/upload/workgroup.pdf', 2, 'CRE', '2014-02-20 13:00:07', NULL, NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Lectura Academica', 'Metodo para generar conciencia de lectura informativa y profesional', 'lectura,conciencia,academica,metodo', '/archivo/upload/lecturaca.pdf', 3, 'PUB', '2014-02-15 18:10:07', NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Conciencia Solidaria', 'Metodologia para crear conciencia solidaria', 'solidaridad,conciencia,metodo,social', '/archivo/upload/concienciasolidaria.docx', 4, 'APR', '2014-02-05 11:01:27', NOW(), 6);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Trabaja y estudia sin contratiempos', 'Recomendaciones para trabajar y estudiar a la vez', 'tabajar,estudiar,recomendacion,simultaneo', '/archivo/upload/trabestud.pdf', 2, 'REC', '2014-02-10 08:00:17', NOW(), NULL);
-- USUARIO PERMITIDO
INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (3, 2, 4);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (4, 2, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (5, 2, 1);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (6, 2, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (4, 3, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (6, 3, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (4, 4, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (6, 4, 2);

--REPORTE DE PAGO

INSERT INTO reporte_pago (`Fe_Anio_Pago`, `Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Enero','10334522659','2',2,150.00);

INSERT INTO reporte_pago (`Fe_Anio_Pago`,`Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Febrero','10334522659','2',5,350.00);

INSERT INTO reporte_pago (`Fe_Anio_Pago`,`Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Marzo','10334522659','2',3,200.00);

INSERT INTO reporte_pago (`Fe_Anio_Pago`,`Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Enero','10406048417','1',2,220.00);

INSERT INTO reporte_pago(`Fe_Anio_Pago`,`Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Febrero','10406048417','2',15,500.00);

INSERT INTO reporte_pago(`Fe_Anio_Pago`,`Fe_Mes_Pago`,`Co_Centro_Formacion`,`Co_Plan_Tarifario`,`Qt_Ideas`,`Ss_Monto_Mensual`)
VALUES( 2014,'Marzo','10406048417','1',6,600.00);