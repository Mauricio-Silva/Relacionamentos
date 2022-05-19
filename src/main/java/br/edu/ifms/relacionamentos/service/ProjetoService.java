package br.edu.ifms.relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Projeto;
import br.edu.ifms.relacionamentos.repository.ProjetoRepository;

@Service
public class ProjetoService {
    
    @Autowired
    ProjetoRepository projetoRepository;


    public Projeto getProjetoById(int id) {
        return projetoRepository.getById(id);
    }


    public List
}
