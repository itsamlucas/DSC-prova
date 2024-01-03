package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.paciente.Paciente;
import com.example.demo.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrarPaciente(Paciente paciente) {
        if (pacienteRepository.findByCpf(paciente.getCpf()).isPresent()) {
            throw new CustomException("CPF já cadastrado. Não é possível adicionar o paciente.");
        }
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> obterTodosOsPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obterPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new CustomException("Paciente não encontrado com ID: " + id));
    }

    public Paciente atualizarPaciente(Long id, Paciente paciente) {
        Paciente pacienteExistente = obterPacientePorId(id);
        pacienteExistente.setNome(paciente.getNome());
        pacienteExistente.setHistoricoMedico(paciente.getHistoricoMedico());
        return pacienteRepository.save(pacienteExistente);
    }

    public void excluirPaciente(Long id) {
        Paciente paciente = obterPacientePorId(id);
        pacienteRepository.delete(paciente);
        pacienteRepository.deleteById(id);
    }
}
