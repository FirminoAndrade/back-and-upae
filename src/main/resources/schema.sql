CREATE DATABASE sistema_diarias

CREATE TABLE usuarios (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,

    login VARCHAR(50) NOT NULL UNIQUE,

    senha VARCHAR(255) NOT NULL,

    perfil ENUM('ADMIN', 'RECEPCAO') NOT NULL,

    ativo BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE especialidades (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL UNIQUE,

    ativo BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE profissionais (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL UNIQUE,

    ativo BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE registro_diario (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    data DATE NOT NULL,

    especialidade_id BIGINT NOT NULL,

    profissional_id BIGINT NOT NULL,

    total_agendados INT NOT NULL,

    compareceram INT NOT NULL,

    faltaram INT NOT NULL,

    interno INT DEFAULT 0,

    externo INT DEFAULT 0,

    observacao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_especialidade
        FOREIGN KEY (especialidade_id)
        REFERENCES especialidades(id),

    CONSTRAINT fk_profissional
        FOREIGN KEY (profissional_id)
        REFERENCES profissionais(id)
);

CREATE TABLE agenda (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    data DATE NOT NULL,

    especialidade VARCHAR(100) NOT NULL,

    profissional VARCHAR(100) NOT NULL,

    agendados INT NOT NULL,

    confirmado BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE lista_espera (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(255) NOT NULL,

    prontuario VARCHAR(50),

    telefone VARCHAR(20),

    data_nascimento DATE,

    especialidade VARCHAR(150),

    confirmado BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);









INSERT INTO especialidades (nome) VALUES
('Cardiologia'),
('Ortopedia'),
('Pediatria'),
('Neurologia'),
('Dermatologia');

INSERT INTO usuarios (
    nome,
    login,
    senha,
    perfil
) VALUES (
    'Administrador',
    'admin',
    '123456',
    'ADMIN'
);

INSERT INTO agenda (

    data,

    especialidade,

    profissional,

    agendados,

    confirmado

)
VALUES (

    '2026-05-27',

    'VASCULAR',

    'JUNIOR',

    120,

    false
);

INSERT INTO profissionais (
    nome,
    especialidade_id
) VALUES
('Dr João', 1),
('Dra Maria', 1),
('Dr Carlos', 2),
('Dra Ana', 3);

SHOW CREATE TABLE registro_diario;
SHOW TABLES;
SELECT * FROM profissionais;
SELECT * FROM registro_diario;
TRUNCATE TABLE registro_diario;
DELETE FROM profissionais;
SELECT * FROM agenda;
SELECT * FROM especialidades;
UPDATE usuarios SET senha = '34077fea-52b4-483e-aa3e-28ccddf1ea10' WHERE login = 'admin';
update usuarios set ativo = true where ativo is null;
ALTER TABLE registro_diario ADD COLUMN interno INT, ADD COLUMN externo INT;
ALTER TABLE registro_diario DROP INDEX uk_data_especialidade;
ALTER TABLE registro_diario ADD COLUMN profissional_id BIGINT;
ALTER TABLE registro_diario ADD CONSTRAINT fk_profissional FOREIGN KEY (profissional_id) REFERENCES profissionais(id);
DROP TABLE profissionais;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE profissionais;
TRUNCATE TABLE especialidades;
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE registro_diario ADD COLUMN nome_profissional VARCHAR(255);
ALTER TABLE agenda ADD COLUMN turno VARCHAR(20) NOT NULL;
ALTER TABLE registro_diario
MODIFY COLUMN interconsulta INT DEFAULT 0;

UPDATE registro_diario r
JOIN profissionais p
ON r.profissional_id = p.id
SET r.nome_profissional = p.nome;
ALTER TABLE registro_diario
DROP FOREIGN KEY fk_profissional;
ALTER TABLE registro_diario
DROP COLUMN profissional_id;