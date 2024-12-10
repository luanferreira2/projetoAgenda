package com.fatec.compromisso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.compromisso.entities.Compromisso;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{
    
}
