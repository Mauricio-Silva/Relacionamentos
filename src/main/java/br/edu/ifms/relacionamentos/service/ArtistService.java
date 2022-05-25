package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Artist;
import br.edu.ifms.relacionamentos.repository.ArtistRepository;

@Service
public class ArtistService {
    
    @Autowired
    ArtistRepository artistRepository;

    
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }


    public Artist getArtistById(int id) {
        return artistRepository.getById(id);
    }


    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }


    public void deleteArtistById(int id) {
        artistRepository.deleteById(id);
    }
}
