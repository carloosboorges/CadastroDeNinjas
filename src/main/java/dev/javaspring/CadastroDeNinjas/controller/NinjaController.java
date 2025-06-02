package dev.javaspring.CadastroDeNinjas.controller;


import dev.javaspring.CadastroDeNinjas.dto.NinjaDTO;
import dev.javaspring.CadastroDeNinjas.entity.NinjaModel;
import dev.javaspring.CadastroDeNinjas.repository.NinjaRepository;
import dev.javaspring.CadastroDeNinjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }


    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota.";
    }

    //Adicionar ninja(CREAT)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);

    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas() ;
    }

    //Procurar ninja por id (CREAT)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar ninja por id (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }

}
