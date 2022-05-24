package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Functionary;
import br.edu.ifms.relacionamentos.repository.FunctionaryRepository;

@Service
public class FunctionaryService {
    
    @Autowired
    FunctionaryRepository functionaryRepository;


    public List<Functionary> getAllFunctionaries() {
        return functionaryRepository.findAll();
    }


    public Functionary getFunctionaryById(int id) {
        return functionaryRepository.getById(id);
    }


    public void saveFunctionary(Functionary functionary) {
        functionaryRepository.save(functionary);
    }


    public void deleteFunctionaryById(int id) {
        functionaryRepository.deleteById(id);
    }
}
