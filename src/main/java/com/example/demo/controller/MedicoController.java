package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.medico.Medico;
import com.example.demo.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medico obterMedico(@PathVariable Long id) {
        return medicoRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public Medico adicionarMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    @PutMapping("/{id}")
    public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow();

        medico.setNome(medicoAtualizado.getNome());
        medico.setEspecialidade(medicoAtualizado.getEspecialidade());
        medico.setCrm(medicoAtualizado.getCrm());

        return medicoRepository.save(medico);
    }

    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }
}
