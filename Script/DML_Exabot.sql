-- database: ../DataBase/ExaBot.sqlite
/*
CopyRight
autor:
fecha:
*/

SELECT pt.Nombre 'Cargo' ,p.Nombre 'Nombres'
FROM PersonaTipo pt
JOIN Persona p on pt.IdPersonaTipo = p.IdPersona;

INSERT INTO PersonaTipo
(Nombre) VALUES
('Soldado')
,('Mecanico')
,('Experto Ingles')
,('Experto Español');

DELETE FROM Persona;

INSERT INTO Persona
(IdPersonaTipo,Cedula, Nombre) VALUES
(1, 1235, ' Carlos Rodriguez' )
,(3, 2324, ' Martha Llinin')
,(2,8794,'Monserat Andrade ');

INSERT INTO Sexo
(Nombre) VALUES
('Masculino')
,('Femenino')
,('Otro');

INSERT INTO CatalogoTipo
(Nombre           ,Descripcion     )VALUES
('Tipo Persona'   ,'Tipo sol,mec...')
,('Sexo'          ,'mas, feme...'   )
,('Estado Civil'  ,'sol,viu,casa..' )
,('Raza'          ,'mestiz,Afro,blan..');

INSERT INTO Catalogo
(IdCatalogoTipo       ,Nombre          ,Descripcion    )VALUES
 (1                   ,'Soldado'       ,'tipo persona del ejercito')
,(1                   ,'Mecanico'      ,'tipo persona del ejercito')
,(1                   ,'Experto Ing'   ,'tipo persona del ejercito')
,(1                   ,'Experto Esp'   ,'tipo persona del ejercito')

,(2                   ,'Maculino'      ,'tipo sexualidad')
,(2                   ,'Femenino'      ,'tipo sexualidad')
,(2                   ,'Hibrido '      ,'tipo sexualidad')
,(2                   ,'Asexual'       ,'tipo sexualidad')

,(3                   ,'Soltero'       ,'tipo de Estado Civil')
,(3                   ,'Casado'        ,'tipo de Estado Civil')
,(3                   ,'Divorciado '   ,'tipo de Estado Civil')
,(3                   ,'Viudo'         ,'tipo de Estado Civil')

,(4                   ,'Negro'         ,'tipo de Etnia')
,(4                   ,'Blanco'        ,'tipo de Etnia')
,(4                   ,'Mestizo '      ,'tipo de Etnia')
,(4                   ,'Indigena'      ,'tipo de Etnia');

INSERT INTO IABot
(Nombre      ,Observacion)VALUES
('IA-Ruso'   ,'Inteligencia artificial');

INSERT INTO ExaBot
(IdIABot    ,Nombre    ,Serie      )VALUES
( 1         ,'exabot1' ,'Serie E1')
,( 1         ,'exabot2' ,'Serie E2');


INSERT INTO Persona
(IdCatalogoTipo, IdCatalogoSexo, IdCatalogoEstadocivil , Cedula, Nombre, Apellido) VALUES
(1      ,5      ,11      ,47841       ,'Carlos'     ,'Andrade')
,(2     ,6      ,10      ,23432       ,'Maria'      ,'Rodriguez')
,(3     ,6      ,11      ,32432       ,'Karla'     ,'Llinin')
,(4     ,5      ,12      ,98769       ,'Daniela'   ,'Perez');

UPDATE Persona
SET Nombre = 'Sebastian Andrade '
WHERE Cedula = '1235';

SELECT * FROM Persona;

SELECT * FROM PersonaTipo;

SELECT count (*) FROM PersonaTipo;

SELECT * FROM PersonaTipo WHERE IdPersonaTipo=2;
SELECT * FROM PersonaTipo WHERE IdPersonaTipo<3;

SELECT Nombre FROM PersonaTipo WHERE IdPersonaTipo<4;
SELECT Nombre FROM PersonaTipo WHERE Nombre like "s%";
SELECT Nombre FROM PersonaTipo WHERE Nombre like "%s";
SELECT Nombre FROM PersonaTipo WHERE Nombre like "%s%";

