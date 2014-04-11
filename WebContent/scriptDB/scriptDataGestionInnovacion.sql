-- PLAN TARIFARIO
INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Básico', 100.00, 5.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Premium', 200.00, 10.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Platinum', 300.00, 20.00);

-- CENTRO DE FORMACION
INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10406048417', 'Universidad Peruana de Ciencias Aplicadas', 'UNI', 'http://www.upc.edu.pe', 'logoUpc.jpg', 1);

INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10334522659', 'Instituto Superior Tecnológico Cibertec', 'INS', 'http://www.cibertec.edu.pe', 'logoCibertec.jpg', 2);

-- REPORTE DE PAGO
INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2012,'Marzo','10406048417','1',1,105.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2012,'Setiembre','10334522659','3',1,320.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2013,'Mayo','10334522659','1',1,105.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2013,'Agosto','10334522659','3',1,320.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Febrero','10334522659','1',1,105.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Febrero','10406048417','3',1,320.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Marzo','10334522659','1',1,105.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Marzo','10406048417','3',1,320.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Abril','10334522659','1',1,105.00);

INSERT INTO REPORTE_PAGO (Fe_Anio_Pago,Fe_Mes_Pago,Co_Centro_Formacion,Co_Plan_Tarifario,Qt_Ideas,Ss_Monto_Mensual)
VALUES(2014,'Abril','10406048417','3',3,960.00);

-- USUARIO
INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Harry', 'Bravo', 'Coronel', 'M', 'DNI', '40604841', 'hbravocoronel@gmail.com', '962329330', 'admin', 'ADM', NULL);

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pedro', 'Huanco', 'Rivas', 'M', 'DNI', '42654751', 'u201320957@upc.edu.pe', '995553330', 'phuanco', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Roberto', 'López', 'Lingan', 'M', 'DNI', '58933771', 'u201312558@upc.edu.pe', '914554321', 'rlopez', 'EST', '10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Fiorella', 'Rojas', 'Mesa', 'F', 'DNI', '22258051', 'u201462989@upc.edu.pe', '922984532', 'frojas', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Luisa', 'Barrera', 'Nuñez', 'F', 'DNI', '33344066', 'luisa.barrera@upc.edu.pe', '985583722', 'lbarrera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Oscar', 'Elera', 'Muñoz', 'M', 'DNI', '56357809', 'oscar.elera@upc.edu.pe', '953278012', 'oelera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Marco', 'Aurelio', 'Yañez', 'M', 'DNI', '35488065', 'marco.aurelio@upc.edu.pe', '922537712', 'maurelio', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pablo', 'Narvaez', 'Peña', 'M', 'DNI', '33212222', 'pablo.narvaez@upc.edu.pe', '956128913', 'pnarvaez', 'EVA', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Claudia', 'Sanchez', 'Herrera', 'F', 'DNI', '46321609', 'claudia.sanchez@cibertec.edu.pe', '983741252', 'csanchez', 'EVA', '10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Dora', 'Llerena', 'Montes', 'F', 'DNI', '43518329', 'rosa.llerena@cibertec.edu.pe', '981290212', 'dllerena', 'DOC', '10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Jose', 'Luna', 'Rodriguez', 'M', 'DNI', '46486513', 'u201214132@cibertec.edu.pe', '951337011', 'jluna', 'EST', '10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Henry', 'Perez', 'Romero', 'M', 'DNI', '44615323', 'u201321932@cibertec.edu.pe', '90425103', 'hperez', 'EST', '10334522659');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Erick', 'Tello', 'Meza', 'M', 'DNI', '46236293', 'erick.tello@cibertec.edu.pe', '93031569', 'etello', 'DOC', '10334522659');


-- IDEA
INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Aula Virtual','Tener clases no presenciales','online,cursos,foro,evaluación','aulaVirtual.docx',2,'CRE','2014-04-05 05:06:42',NULL,NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Matricula Online','Matricularse en la comodidad de su casa','online,horario,matricula,cursos','matriculaOnline.docx',4,'PUB','2014-02-20 10:15:03',NULL,NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Encuesta de Alumnos Online','Encuesta online de los alumnos con respecto a la calidad educativa','online,evaluación,educación,calidad','encuestaAlumnoOnline.docx',3,'PUB','2014-04-05 05:06:42','2014-04-05 05:06:42',NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Inglés Online','Inglés en la comodidad de su casa','online,horario,inglés,exámenes','inglesOnline.docx',2,'PUB','2014-04-05 05:06:42','2014-04-05 05:06:42',NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Conferencia Online','Conferencia online para estudiantes','online,conferencia,educación,temas','conferenciaOnline.docx',2,'PUB','2014-04-05 05:06:42','2014-04-05 05:06:42',NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Exito en trabajo grupal','Referencias para lograr la sinergia en los grupos de trabajo','grupos,sinergia,exito,trabajos','grupoexitoso.pdf',12,'CRE','2014-03-03 00:00:01',NULL,NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Programación Fácil','Metodo de programación java agil y simple','programacion,java,metodo,agil','programacionfacil.pdf',3,'PUB','2014-03-10 00:00:00','2014-04-05 17:50:54',NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Lectura Dinamica','Pautas para leer, comprender y resumir grandes volumnenes de texto','texto,leer,pauta,dinamismo','lecturadinamica.docx',11,'APR','2014-02-13 00:00:00','2014-04-05 17:50:55',10);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Proquest','Como aprovechar el uso de la biblioteca virtual','biblioteca,libros,online,busqueda','bibliotecavirtual.docx',4,'PUB','2012-03-19 03:57:07','2012-04-09 11:07:17',null);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('EBSCO','Optimizar la busqueda de recursos academicos onlines','revistas,recursos,online,busqueda','busquedarecursoonline.docx',11,'APR','2013-05-29 20:07:10','2013-06-09 13:57:52',13);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Organiza tu tiempo','Taller Online para organizar mejor el tiempo','tiempo,organizacion,planeamiento,online','tallertiempoonline.docx',12,'REC','2013-08-11 15:20:41','2013-08-31 18:15:47',null);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Aprueba tus Examenes Online','Tutorial con tecnicas de estudio para rendir adecuadamente los examenes online','examenes,online,aprobar,tecnicas','apruebaexamenesonline.docx',3,'REC','2012-09-11 18:02:01','2012-09-25 09:01:11',null);

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
VALUES (10, 3, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (11, 3, 1);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (13, 3, 4);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (12, 3, 1);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (4, 4, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (6, 4, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (10, 7, 1);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (11, 7, 3);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (12, 7, 2);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (2, 9, 3);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (3, 9, 3);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (4, 9, 5);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (5, 9, 5);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (6, 9, 4);

INSERT INTO USUARIO_PERMITIDO (Co_Usuario, Co_Idea, Qt_Puntaje)
VALUES (7, 9, 1);

COMMIT;