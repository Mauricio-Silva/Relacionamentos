package br.edu.ifms.relacionamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {
    
    private int id;
    private String nome;
    private double custoTotal;
    private int duracao;
    private List<Funcionario> funcionarios;
}
