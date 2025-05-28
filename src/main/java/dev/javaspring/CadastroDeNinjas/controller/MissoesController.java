package dev.javaspring.CadastroDeNinjas.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //GET -- Mandar uma requisição para mostrar as missões cadastradas
    //Mostrar todas as missões (READ)
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missões listada com sucesso.";
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
