package dev.javaspring.CadastroDeNinjas.dto;
import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO  {

    private Long id;
    private String nome;
    private int idade;
    private String imgURL;
    private String email;
    private String rank;
    private MissoesModel missoes;

}
