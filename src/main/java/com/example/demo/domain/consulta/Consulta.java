package com.example.demo.domain.consulta;

import java.time.LocalDate;

import com.example.demo.domain.medico.Medico;
import com.example.demo.domain.paciente.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataConsulta;
    private String diagnóstico;
    private String prescrição;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "médico_id")
    private Medico médico;

    public Consulta() {
    }

    public Consulta(LocalDate dataConsulta, String diagnóstico, String prescrição) {
        this.dataConsulta = dataConsulta;
        this.diagnóstico = diagnóstico;
        this.prescrição = prescrição;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDiagnóstico() {
        return diagnóstico;
    }

    public void setDiagnóstico(String diagnóstico) {
        this.diagnóstico = diagnóstico;
    }

    public String getPrescrição() {
        return prescrição;
    }

    public void setPrescrição(String prescrição) {
        this.prescrição = prescrição;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMédico() {
        return médico;
    }

    public void setMédico(Medico médico) {
        this.médico = médico;
    }
}
