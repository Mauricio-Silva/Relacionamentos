package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Genre;
import br.edu.ifms.relacionamentos.repository.GenreRepository;

@Service
public class GenreService {
    
    @Autowired
    GenreRepository genreRepository;


    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    public Genre getGenreById(int id) {
        return genreRepository.getById(id);
    }


    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }


    public void deleteGenreById(int id) {
        genreRepository.deleteById(id);
    }
}
