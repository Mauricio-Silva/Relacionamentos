package br.edu.ifms.relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Funcionario;
import br.edu.ifms.relacionamentos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario getFuncionarioById(int id) {
        return funcionarioRepository.getById(id);
    }
}
