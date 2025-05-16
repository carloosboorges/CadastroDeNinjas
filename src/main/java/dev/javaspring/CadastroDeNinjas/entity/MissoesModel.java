package dev.javaspring.CadastroDeNinjas.entity;


import jakarta.persistence.*;

import java.util.List;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public MissoesModel() {
    }

    public MissoesModel(String nomeDaMissao, String dificuldade) {
        this.nomeDaMissao = nomeDaMissao;
        this.dificuldade = dificuldade;
    }
}
