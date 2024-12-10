package com.fatec.compromisso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.compromisso.dtos.CompromissoRequest;
import com.fatec.compromisso.dtos.CompromissoResponse;
import com.fatec.compromisso.services.CompromissoService;
    
    @CrossOrigin
@RestController
@RequestMapping("compromisso")
public class CompromissoController {
    @Autowired
    private CompromissoService service;

    @GetMapping
    public ResponseEntity<List<CompromissoResponse>> getCompromissos() {
        return ResponseEntity.ok(service.getAllCompromisso());
    }

    @GetMapping("{id}")
    public ResponseEntity<CompromissoResponse> getCompromisso(@PathVariable long id) {
        return ResponseEntity.ok(service.getCompromissoById(id));
    }

    @PostMapping()
    public ResponseEntity<CompromissoResponse> saveCompromisso(@RequestBody CompromissoRequest Compromisso ) {
        CompromissoResponse newCompromisso = service.saveNewCompromisso(Compromisso);
        return ResponseEntity.created(null).body(newCompromisso);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCompromisso(@PathVariable long id, @RequestBody CompromissoRequest Compromisso) {
        service.uptade(Compromisso, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompromisso(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
