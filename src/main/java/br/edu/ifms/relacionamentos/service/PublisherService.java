package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Publisher;
import br.edu.ifms.relacionamentos.repository.PublisherRepository;

@Service
public class PublisherService {
    
    @Autowired
    PublisherRepository publisherRepository;


    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }


    public Publisher getPublisherById(int id) {
        return publisherRepository.getById(id);
    }


    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }


    public void deletePublisherById(int id) {
        publisherRepository.deleteById(id);
    }
}
