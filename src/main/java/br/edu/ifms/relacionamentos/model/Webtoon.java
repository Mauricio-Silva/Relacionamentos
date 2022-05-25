package br.edu.ifms.relacionamentos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Webtoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String description;
    int chapters;

    @OneToOne
    Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;

    @ManyToMany(mappedBy = "webtoons")
    List<Genre> genres;
}



/*
[!] Relacionamentos:

# 1 - 1
se há duas classes Professor e Turma, e cada professor tem uma turma, para relacionar 1 para 1:
class Professor {
  @OneToOne
  Turma turma
}
Obs: @OneToOne deve ser anotado apenas em uma das classes/entidades
nesse caso de relacionamento 1 para 1, a classe Turma agirá como atributo de Professor




# 1 - n / n - 1
se há duas classes Professor e Turma, e cada turma tem uma vários, para relacionar 1 para n:
Professor (n) --- (1) Turma

class Professor {
  @ManyToOne
  @JoinColumn(name = "turma_id")
  Turma turma
}

class Class {
  @OneToMany(mappedBy = "turma")
  List<Professor> professores
}
*/