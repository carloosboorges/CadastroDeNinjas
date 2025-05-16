package dev.javaspring.CadastroDeNinjas.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // Transforma uma classe em uma entidade do banco de dados.
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "Idade", length = 3)
    private int idade;

    @Column(name = "Email", length = 100)
    private String email;

//@ManyToOne um ninja tem uma unica missao.
    @ManyToOne()
    @JoinColumn(name = "Missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;


    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
