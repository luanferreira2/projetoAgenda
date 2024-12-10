package com.fatec.compromisso.mappers;

import com.fatec.compromisso.dtos.CompromissoRequest;
import com.fatec.compromisso.dtos.CompromissoResponse;
import com.fatec.compromisso.entities.Compromisso;

public class CompromissoMapper {
    
  
    public static CompromissoResponse toDTO(Compromisso compromisso) {

        return new CompromissoResponse(
            compromisso.getId(), 
            compromisso.getDescricao(), 
            compromisso.getLocal(), 
            compromisso.getData()
        );
    }

    public static Compromisso toEntity(CompromissoRequest CompromissoRequest) {
        
        Compromisso Compromisso = new Compromisso();
        Compromisso.setDescricao(CompromissoRequest.descricao());
        Compromisso.setLocal(CompromissoRequest.local());
        Compromisso.setData(CompromissoRequest.data());

        return Compromisso;
    }
    
}
