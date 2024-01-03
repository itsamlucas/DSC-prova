CREATE TABLE Paciente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    historico_medico TEXT,
    UNIQUE (cpf)
);
