CREATE TABLE Consulta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_consulta TIMESTAMP NOT NULL,
    diagnostico TEXT,
    prescricao TEXT,
    paciente_id BIGINT,
    medico_id BIGINT,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
    FOREIGN KEY (medico_id) REFERENCES Médico(id)
);