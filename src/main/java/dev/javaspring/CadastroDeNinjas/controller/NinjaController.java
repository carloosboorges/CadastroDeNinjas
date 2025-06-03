package dev.javaspring.CadastroDeNinjas.controller;
import dev.javaspring.CadastroDeNinjas.dto.NinjaDTO;
import dev.javaspring.CadastroDeNinjas.repository.NinjaRepository;
import dev.javaspring.CadastroDeNinjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/boasvindas")
    //Swagger anotaçao @Oparation / @ApiResponses / @ApiResponse / @Parameter / @PathVariable
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas á quem acessa a ela.")//Swagger
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota.";
    }
    //Criar ninja(CREAT)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
    })

    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        try{
            NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());

        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Procurar ninja por id (CREAT)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por Id", description = "Rota lista um ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        NinjaDTO ninjaPorId = ninjaService.listarPorId(id);
        if (ninjaPorId != null) {
            return ResponseEntity.ok(ninjaPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não existe.");
        }

    }
    //Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um ninja por Id", description = "Rota altera um ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possivel alterar.")
    })
    public ResponseEntity<?> alterarNinja(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id, @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninjaAtualizadoDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if(ninjaAtualizadoDTO != null){
            return ResponseEntity.ok(ninjaAtualizadoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com ID: " + id + " não existe em nossos registros.");
        }
    }
    //Deletar ninja por id (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por Id", description = "Rota deleta um ninja pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possivel deletar.")
    })

    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja com o ID " + id + " foi deletado com sucesso. ");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("O ninja com ID: " + id + " não foi encontrado.");
        }

    }

}
