package dev.javaspring.CadastroDeNinjas.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NijaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota.";
    }

    //Adicionar ninja(CREAT)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso!";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Aqui estão todos os ninjas cadastrados.";
    }

    //Procurar ninja por id (CREAT)
    @GetMapping("/todosID")
    public String procurarNinjaPorId() {
        return "Aqui está o ninja com o id solicitado.";
    }

    //Alterar dados do ninja (UPDATE)
    @PostMapping("/alterar")
    public String alterarNinja() {
        return "Dados do ninja alterados com sucesso!";
    }

    //Deletar ninja por id (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado com sucesso!";
    }

}
