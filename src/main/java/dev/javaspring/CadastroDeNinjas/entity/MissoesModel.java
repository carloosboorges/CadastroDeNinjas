package dev.javaspring.CadastroDeNinjas.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String nomeDaMissao;

    @Column(length = 100)
    private String dificuldade;

    //Uma missao pode ter varios ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
