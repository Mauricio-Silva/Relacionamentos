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
public class Functionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String position;
    private double salary;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PROJECT_FUNCTIONARY", 
        joinColumns = {@JoinColumn(name = "FUNCTIONARY_ID")},
        inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID")}
    )
    private List<Project> projects;
}
