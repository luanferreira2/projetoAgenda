package com.fatec.compromisso.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.compromisso.dtos.CompromissoRequest;
import com.fatec.compromisso.dtos.CompromissoResponse;
import com.fatec.compromisso.entities.Compromisso;
import com.fatec.compromisso.mappers.CompromissoMapper;
import com.fatec.compromisso.repositories.CompromissoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompromissoService {
    
 @Autowired
    private CompromissoRepository repository;

    public List<CompromissoResponse> getAllCompromisso() {
        return repository.findAll().stream().map(p -> CompromissoMapper.toDTO(p)).collect(Collectors.toList());
    }

    public CompromissoResponse getCompromissoById(long id) {
        Compromisso compromisso = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Compromisso não cadastrado")
        );

        return CompromissoMapper.toDTO(compromisso);
    }

    public CompromissoResponse saveNewCompromisso(CompromissoRequest compromisso) {
        Compromisso newCompromisso = repository.save(CompromissoMapper.toEntity(compromisso));
        return CompromissoMapper.toDTO(newCompromisso);
    }

    public void uptade(CompromissoRequest compromisso, long id) {
        Compromisso aux = repository.getReferenceById(id);

        aux.setDescricao(compromisso.descricao());
        aux.setLocal(compromisso.local());
        aux.setData(compromisso.data());

        repository.save(aux);
    }

    public void delete(long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }  else {
            throw new EntityNotFoundException("Produto não cadastrado");
        }
    }
}

