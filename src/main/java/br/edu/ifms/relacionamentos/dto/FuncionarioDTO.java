package br.edu.ifms.relacionamentos.dto;

import java.util.List;

import br.edu.ifms.relacionamentos.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
 
    private int id;
    private String nome;
    private String cargo;
    private double salario;
    private List<Projeto> projetos;
}
