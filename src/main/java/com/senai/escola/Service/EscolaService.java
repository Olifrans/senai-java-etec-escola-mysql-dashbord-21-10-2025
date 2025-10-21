package com.senai.escola.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.escola.Interface.EscolaRepository;
import com.senai.escola.Models.Escola;

@Service
public class EscolaService {
    private final EscolaRepository repository;

    public EscolaService(EscolaRepository repository) {
        this.repository = repository;
    }

    public List<Escola> buscarEscolas() {
        return repository.findAll();
    }

    public Escola salvarNovoEscola(Escola escola) {
        return repository.save(escola);
    }

    public Escola buscarEscolaId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarEscola(Long id) {
        repository.deleteById(id);
    }

}
