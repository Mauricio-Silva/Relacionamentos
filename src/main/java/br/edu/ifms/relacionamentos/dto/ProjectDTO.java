package br.edu.ifms.relacionamentos.dto;

import java.util.List;

import br.edu.ifms.relacionamentos.model.Functionary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    
    private int id;
    private String name;
    private double totalCost;
    private int duration;
    private List<Functionary> functionaries;
}
