package dev.javaspring.CadastroDeNinjas.controller;


import dev.javaspring.CadastroDeNinjas.entity.NinjaModel;
import dev.javaspring.CadastroDeNinjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas() ;
    }

    //Procurar ninja por id (CREAT)
    @GetMapping("/listar/{id}")
    public NinjaModel procurarNinjaPorId(@PathVariable Long id) {
           Optional<NinjaModel> ninja = ninjaService.listarPorId(id);
              if (ninja.isPresent()) {
                return ninja.get();
              } else {
                throw new RuntimeException("Ninja não encontrado com o id: " + id);
              }

    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Dados do ninja alterados com sucesso!";
    }

    //Deletar ninja por id (DELETE)
    @DeleteMapping("/deletarid")
    public String deletarNinjaPorId() {
        return "Ninja deletado com sucesso!";
    }

}
