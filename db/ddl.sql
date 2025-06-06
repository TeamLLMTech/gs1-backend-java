CREATE TABLE Alertas
(
    id_alerta       INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nivel_alerta    SMALLINT  NOT NULL,
    mensagem_alerta CLOB  NOT NULL,
    data_emissao    DATE  NOT NULL,
    id_evento       INTEGER  NOT NULL
);

CREATE TABLE Estados
(
    id_estado INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome      VARCHAR2 (100 CHAR) NOT NULL,
    sigla     CHAR (2 CHAR) NOT NULL,
    id_pais   INTEGER NOT NULL
);

CREATE TABLE Eventos
(
    id_evento       INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    data_prevista   DATE NOT NULL,
    probabilidade   NUMBER (5,2) NOT NULL,
    gerado_em       DATE NOT NULL,
    descricao       CLOB,
    id_modelo       INTEGER NOT NULL,
    id_tipo_evento  INTEGER NOT NULL,
    id_regiao       INTEGER NOT NULL,
    data_ocorrencia DATE
);

CREATE TABLE ModelosIA
(
    id_modelo        INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome_modelo      VARCHAR2 (100 CHAR) NOT NULL,
    tipo_modelo      VARCHAR2 (50 CHAR) NOT NULL,
    algoritmo_base   VARCHAR2 (100 CHAR),
    data_treinamento DATE NOT NULL,
    acuracia         NUMBER (5,2),
    descricao_modelo CLOB
);

CREATE TABLE Municipios
(
    id_municipio INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome         VARCHAR2 (100 CHAR) NOT NULL,
    id_estado    INTEGER NOT NULL
);

CREATE TABLE Paises
(
    id_pais INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome    VARCHAR2 (100 CHAR) NOT NULL,
    sigla   CHAR (3 CHAR) NOT NULL
);

CREATE TABLE RegioesMonitoradas
(
    id_regiao          INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome_regiao        VARCHAR2 (100 BYTE) NOT NULL,
    tipo_zona          VARCHAR2 (20) NOT NULL,
    populacao_estimada INTEGER,
    descriacao_area    CLOB,
    id_municipio       INTEGER NOT NULL
);

CREATE TABLE TiposEventosNaturais
(
    id_tipo_evento     INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo_evento        VARCHAR2 (50 CHAR) NOT NULL,
    descricao          CLOB,
    intensidade_evento SMALLINT
);

CREATE TABLE Usuarios
(
    id_usuario    INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome          VARCHAR2 (100 CHAR) NOT NULL,
    email         VARCHAR2 (150 CHAR) NOT NULL,
    senha         VARCHAR2 (255 CHAR) NOT NULL,
    perfil        VARCHAR2 (50 CHAR) NOT NULL,
    ativo         NUMBER NOT NULL,
    data_cadastro DATE NOT NULL
);

CREATE TABLE UsuariosRegioes
(
    id_usuario INTEGER NOT NULL,
    id_regiao  INTEGER NOT NULL,
    CONSTRAINT Relation_18_PK PRIMARY KEY (id_usuario, id_regiao)
);


ALTER TABLE Alertas
    ADD CONSTRAINT Alertas_Eventos_FK FOREIGN KEY
    (
     id_evento
    )
    REFERENCES Eventos
    (
     id_evento
    )
;

ALTER TABLE Estados
    ADD CONSTRAINT Estados_Paises_FK FOREIGN KEY
    (
     id_pais
    )
    REFERENCES Paises
    (
     id_pais
    )
;

ALTER TABLE Eventos
    ADD CONSTRAINT Eventos_ModelosIA_FK FOREIGN KEY
    (
     id_modelo
    )
    REFERENCES ModelosIA
    (
     id_modelo
    )
;

ALTER TABLE Eventos
    ADD CONSTRAINT Eventos_RegioesMonitoradas_FK FOREIGN KEY
    (
     id_regiao
    )
    REFERENCES RegioesMonitoradas
    (
     id_regiao
    )
;

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE Eventos
    ADD CONSTRAINT Eventos_TiposEventosNaturais_FK FOREIGN KEY
    (
     id_tipo_evento
    )
    REFERENCES TiposEventosNaturais
    (
     id_tipo_evento
    )
;

ALTER TABLE Municipios
    ADD CONSTRAINT Municipios_Estados_FK FOREIGN KEY
    (
     id_estado
    )
    REFERENCES Estados
    (
     id_estado
    )
;

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE RegioesMonitoradas
    ADD CONSTRAINT RegioesMonitoradas_Municipios_FK FOREIGN KEY
    (
     id_municipio
    )
    REFERENCES Municipios
    (
     id_municipio
    )
;

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE UsuariosRegioes
    ADD CONSTRAINT Relation_18_RegioesMonitoradas_FK FOREIGN KEY
    (
     id_regiao
    )
    REFERENCES RegioesMonitoradas
    (
     id_regiao
    )
;

ALTER TABLE UsuariosRegioes
    ADD CONSTRAINT Relation_18_Usuarios_FK FOREIGN KEY
    (
     id_usuario
    )
    REFERENCES Usuarios
    (
     id_usuario
    )
;

ALTER TABLE Estados
 ADD CONSTRAINT chk_sigla CHECK (LENGTH(sigla) = 2);

ALTER TABLE Usuarios
 ADD CONSTRAINT chk_ativo CHECK (ativo IN (0, 1));

ALTER TABLE Alertas
 ADD CONSTRAINT chk_nivel CHECK (nivel_alerta BETWEEN 1 AND 5);