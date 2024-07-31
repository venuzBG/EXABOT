-- database: ../DataBase/ExaBot.sqlite
/*
CopyRight
autor:
fecha:
*/

DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;
DROP TABLE IF EXISTS Sexo;

CREATE TABLE CatalogoTipo(
  IdCatalogoTipo    INTEGER NOT NULL PRIMARY KEY autoincrement 
  ,Nombre            VARCHAR(18) NOT NULL UNIQUE
  ,Descripcion      VARCHAR(98) NOT NULL UNIQUE

  ,Estado           VARCHAR(1) NOT NULL DEFAULT('A')
  ,FechaCreacion    DATETIME DEFAULT(datetime('now','localtime'))
  ,FechaModifica    DATETIME
);

CREATE TABLE Catalogo(
  IdCatalogo         INTEGER NOT NULL PRIMARY KEY autoincrement 
  ,IdCatalogoTipo    INTEGER NOT NULL REFERENCES CatalogoTipo(IdCatalogoTipo)
  ,Nombre            VARCHAR(18) NOT NULL UNIQUE
  ,Descripcion       VARCHAR(98) NOT NULL 

  ,Estado           VARCHAR(1) NOT NULL DEFAULT('A')
  ,FechaCreacion    DATETIME DEFAULT(datetime('now','localtime'))
  ,FechaModifica    DATETIME
);

CREATE TABLE IABot (
  IdIABot           INTEGER PRIMARY KEY autoincrement
  ,Nombre           TEXT NOT NULL UNIQUE
  ,Observacion      TEXT
  ,Estado           VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X'))
  ,FechaCrea        DATETIME DEFAULT current_timestamp
);
CREATE TABLE ExaBot (
  IdExaBot          INTEGER PRIMARY KEY autoincrement
  ,IdIABot          INTEGER NOT NULL
  ,Nombre           TEXT NOT NULL
  ,Serie            TEXT NOT NULL

  ,Estado           VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X'))
  ,FechaCrea        DATETIME DEFAULT current_timestamp
  ,CONSTRAINT       fk_IABot FOREIGN KEY (IdIABot) REFERENCES IABot(IdIABot)
);

-- CREATE TABLE PersonaTipo (
--   IdPersonaTipo     INTEGER PRIMARY KEY autoincrement
--   ,Nombre           TEXT NOT NULL UNIQUE
--   ,Estado           VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X'))
--   ,FechaCrea        DATETIME DEFAULT current_timestamp
-- );

CREATE TABLE Persona (
  IdPersona                 INTEGER PRIMARY KEY autoincrement
  ,IdCatalogoTipo           INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
  ,IdCatalogoSexo           INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
  ,IdCatalogoEstadocivil    INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
  ,Cedula                   VARCHAR(10) NOT NULL UNIQUE
  ,Nombre                   VARCHAR(50) NOT NULL
  ,Apellido                 VARCHAR(50) NOT NULL

  ,Estado                   VARCHAR(1) NOT NULL DEFAULT('A')
  ,FechaCreacion            DATETIME DEFAULT(datetime('now','localtime'))
  ,FechaModifica            DATETIME
);

CREATE TABLE Sexo (
  IdSexo              INTEGER NOT NULL PRIMARY KEY autoincrement
  ,Nombre             VARCHAR(18) NOT NULL UNIQUE
  ,Estado             VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X'))
  ,FechaCrea          DATETIME DEFAULT CURRENT_TIME
  ,FechaModifica      DATETIME DEFAULT current_timestamp
)





