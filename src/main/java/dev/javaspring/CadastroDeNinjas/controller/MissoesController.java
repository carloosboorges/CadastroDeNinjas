package dev.javaspring.CadastroDeNinjas.controller;
import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import dev.javaspring.CadastroDeNinjas.service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisição para mostrar as missões cadastradas
    //Mostrar todas as missões (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    //POST -- Mandar uma requisição para criar uma nova missao
    //Adicionar missão (CREATE)
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    }

    //PUT -- Mandar uma requisição para alterar uma missão existente
    //Alterar missão (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso!";
    }

    //DELETE -- Mandar uma requisição para deletar uma missão existente
    //Deletar missão (DELETE)
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    }





}
