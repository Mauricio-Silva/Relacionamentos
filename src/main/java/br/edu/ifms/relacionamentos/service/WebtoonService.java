package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Webtoon;
import br.edu.ifms.relacionamentos.repository.WebtoonRepository;

@Service
public class WebtoonService {
    
    @Autowired
    WebtoonRepository webtoonRepository;


    public List<Webtoon> getAllWebtoons() {
        return webtoonRepository.findAll();
    }


    public Webtoon getWebtoonById(int id) {
        return webtoonRepository.getById(id);
    }


    public void saveWebtoon(Webtoon webtoon) {
        webtoonRepository.save(webtoon);
    }


    public void deleteWebtoonById(int id) {
        webtoonRepository.deleteById(id);
    }    
}
