package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.consulta.Consulta;
import com.example.demo.service.ConsultaService;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> obterConsultaPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.obterConsultaPorId(id);
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> obterTodasConsultas() {
        List<Consulta> consultas = consultaService.obterTodasAsConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        Consulta consultaAtualizada = consultaService.atualizarConsulta(id, consulta);
        return new ResponseEntity<>(consultaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsulta(@PathVariable Long id) {
        consultaService.excluirConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

