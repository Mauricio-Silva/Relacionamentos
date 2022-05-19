package br.edu.ifms.relacionamentos.dto;

import java.util.List;

import br.edu.ifms.relacionamentos.model.Project;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionaryDTO {
 
    private int id;
    private String name;
    private String position;
    private double salary;
    private List<Project> projects;
}
