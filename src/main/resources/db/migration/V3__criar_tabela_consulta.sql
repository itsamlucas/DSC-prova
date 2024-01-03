CREATE TABLE Consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_consulta TIMESTAMP NOT NULL,
    diagnostico TEXT,
    prescricao TEXT,
    paciente_id INT,
    medico_id INT,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
    FOREIGN KEY (medico_id) REFERENCES Médico(id)
);
