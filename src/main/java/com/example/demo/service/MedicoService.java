package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.medico.Medico;
import com.example.demo.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico obterMedicoPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Médico não encontrado com ID: " + id));
    }

    public List<Medico> obterTodosOsMedicos() {
        return medicoRepository.findAll();
    }

    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizarMedico(Long id, Medico medico) {
        Medico medicoExistente = obterMedicoPorId(id);

        medicoExistente.setNome(medico.getNome());
        medicoExistente.setEspecialidade(medico.getEspecialidade());
        medicoExistente.setCrm(medico.getCrm());
        return medicoRepository.save(medicoExistente);
    }

    public void excluirMedico(Long id) {
        Medico medico = obterMedicoPorId(id);
        medicoRepository.delete(medico);
    }
}
