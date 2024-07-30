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

