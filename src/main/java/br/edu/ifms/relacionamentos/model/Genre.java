package br.edu.ifms.relacionamentos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "WEBTOON_GENRE",
        joinColumns = {@JoinColumn(name = "GENRE_ID") },
        inverseJoinColumns = {@JoinColumn(name = "WEBTOON_ID")}
    )
    List<Webtoon> webtoons;
}
