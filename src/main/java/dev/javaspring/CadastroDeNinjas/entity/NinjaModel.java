package dev.javaspring.CadastroDeNinjas.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // Transforma uma classe em uma entidade do banco de dados.
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", length = 100)
    private String nome;

    @Column(name = "Idade", length = 3)
    private int idade;

    @Column(name = "Rank", length = 100)
    private String rank;

    @Column(name = "IMG_URL", length = 200)
    private String imgURL;

    @Column(unique = true, name = "Email", length = 100) //unique = true = apenas usuario com o mesmo email.
    private String email;

//@ManyToOne um ninja tem uma unica missao.
    @ManyToOne()
    @JoinColumn(name = "Missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;


}
