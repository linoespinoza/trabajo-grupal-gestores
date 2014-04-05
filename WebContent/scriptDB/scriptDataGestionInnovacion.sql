-- PLAN TARIFARIO
INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan B�sico', 100.00, 5.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Premium', 200.00, 10.00);

INSERT INTO PLAN_TARIFARIO (No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa)
VALUES ('Plan Platinum', 300.00, 20.00);

-- CENTRO DE FORMACION
INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10406048417', 'Universidad Peruana de Ciencias Aplicadas', 'UNI', 'http://www.upc.edu.pe', 'logoUpc.png', 1);

INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario)
VALUES ('10334522659', 'Instituto Superior Tecnol�gico Cibertec', 'INS', 'http://www.cibertec.edu.pe', 'logoCibertec.png', 2);

-- USUARIO
INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Harry', 'Bravo', 'Coronel', 'M', 'DNI', '40604841', 'hbravocoronel@gmail.com', '962329330', 'admin', 'ADM', NULL);

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pedro', 'Huanco', 'Rivas', 'M', 'DNI', '42654751', 'u201320957@upc.edu.pe', '995553330', 'phuanco', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Roberto', 'L�pez', 'Lingan', 'M', 'DNI', '58933771', 'u201312558@upc.edu.pe', '914554321', 'rlopez', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Fiorella', 'Rojas', 'Mesa', 'F', 'DNI', '22258051', 'u201462989@upc.edu.pe', '922984532', 'frojas', 'EST', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Luisa', 'Barrera', 'Nu�ez', 'F', 'DNI', '33344066', 'luisa.barrera@upc.edu.pe', '985583722', 'lbarrera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Oscar', 'Elera', 'Mu�oz', 'M', 'DNI', '56357809', 'oscar.elera@upc.edu.pe', '953278012', 'oelera', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Marco', 'Aurelio', 'Ya�ez', 'M', 'DNI', '35488065', 'marco.aurelio@upc.edu.pe', '922537712', 'maurelio', 'DOC', '10406048417');

INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion)
VALUES ('Pablo', 'Narvaez', 'Pe�a', 'M', 'DNI', '33212222', 'pablo.narvaez@upc.edu.pe', '956128913', 'pnarvaez', 'EVA', '10406048417');

-- IDEA
INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Aula Virtual', 'Tener clases no presenciales', 'online,cursos,foro,evaluaci�n', 'aulaVirtual.docx', 2, 'CRE', NOW(), NULL, NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Matricula Online', 'Matricularse en la comodidad de su casa', 'online,horario,matricula,cursos', 'matriculaOnline.docx', 2, 'PUB', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Encuesta de Alumnos Online', 'Encuesta online de los alumnos con respecto a la calidad educativa', 'online,evaluaci�n,educaci�n,calidad', 'encuestaAlumnoOnline.docx', 2, 'APR', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Ingl�s Online', 'Ingl�s en la comodidad de su casa', 'online,horario,ingl�s,ex�menes', 'inglesOnline.docx', 2, 'REC', NOW(), NOW(), NULL);

INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Co_Estudiante, Co_Estado, Fe_Creacion, Fe_Publicacion, Co_Asesor)
VALUES ('Conferencia Online', 'Conferencia online para estudiantes', 'online,conferencia,educaci�n,temas', 'conferenciaOnline.docx', 2, 'APR', NOW(), NOW(), 5);

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

COMMIT;