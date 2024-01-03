package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.consulta.Consulta;
import com.example.demo.domain.medico.Medico;
import com.example.demo.domain.paciente.Paciente;
import com.example.demo.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    public Consulta obterConsultaPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Consulta não encontrada com ID: " + id));
    }

    public List<Consulta> obterTodasAsConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta cadastrarConsulta(Consulta consulta) {
        Paciente paciente = pacienteService.obterPacientePorId(consulta.getPaciente().getId());
        Medico medico = medicoService.obterMedicoPorId(consulta.getMédico().getId());

        validarDadosConsulta(consulta);

        consulta.setPaciente(paciente);
        consulta.setMédico(medico);

        return consultaRepository.save(consulta);
    }

    public Consulta atualizarConsulta(Long id, Consulta consulta) {
        Consulta consultaExistente = obterConsultaPorId(id);
    
        consultaExistente.setDataConsulta(consulta.getDataConsulta());
        consultaExistente.setDiagnóstico(consulta.getDiagnóstico());
        consultaExistente.setPrescrição(consulta.getPrescrição());
    
        validarDadosConsulta(consultaExistente); 
    
        return consultaRepository.save(consultaExistente);
    }
    
    private void validarDadosConsulta(Consulta consulta) {
        if (consulta.getDataConsulta() == null || consulta.getDataConsulta().isBefore(LocalDate.now())) {
            throw new CustomException("A data da consulta é inválida.");
        }
    }
    public void excluirConsulta(Long id) {
        Consulta consulta = obterConsultaPorId(id);
        consultaRepository.delete(consulta);
    }

    public ConsultaRepository getConsultaRepository() {
        return consultaRepository;
    }

    public void setConsultaRepository(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public MedicoService getMedicoService() {
        return medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
}