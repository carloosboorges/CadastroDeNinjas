package dev.javaspring.CadastroDeNinjas.controller;

import dev.javaspring.CadastroDeNinjas.dto.NinjaDTO;
import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import dev.javaspring.CadastroDeNinjas.service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList; // Este import pode não ser necessário se você não o usa diretamente
import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    // Injeção de dependência via construtor (boa prática)
    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    /**
     * Exibe a lista de todos os ninjas.
     * Mapeado para a URL /ninjas/ui/listar.
     * @param model O objeto Model para passar dados para a view.
     * @return O nome do template Thymeleaf (listarNinjas.html).
     */
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Retorna o nome da página que renderiza a lista de ninjas
    }

    /**
     * Exclui um ninja pelo ID e redireciona para a lista.
     * Mapeado para a URL /ninjas/ui/deletar/{id}.
     * @param id O ID do ninja a ser deletado.
     * @return Um redirecionamento para a página de listagem de ninjas.
     */
    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar"; // Redireciona para a lista após a exclusão
    }

    /**
     * Exibe os detalhes de um ninja específico pelo ID.
     * Mapeado para a URL /ninjas/ui/detalhes/{id}.
     * (Anteriormente era /listar/{id}, alterado para melhor semântica)
     * @param id O ID do ninja a ser exibido.
     * @param model O objeto Model para passar o ninja para a view.
     * @return O nome do template Thymeleaf (detalhesNinja.html) ou listarNinjas.html se não encontrado.
     */
    @GetMapping("/detalhes/{id}") // Rota alterada para ser mais semântica
    public String mostrarDetalhesNinja(@PathVariable Long id, Model model) { // Nome do método alterado
        NinjaDTO ninja =  ninjaService.listarPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "/ninjas/ui/adicionar"; // Retorna o template de detalhes do ninja
        } else {
            // Se o ninja não for encontrado, adiciona uma mensagem e redireciona para a lista
            model.addAttribute("mensagem", "Ninja não encontrado.");
            return "redirect:/ninjas/ui/listar"; // Redireciona para a lista com uma mensagem
        }
    }

    /**
     * Exibe o formulário para adicionar um novo ninja.
     * Mapeado para a URL /ninjas/ui/adicionar.
     * @param model O objeto Model para passar um NinjaDTO vazio para o formulário.
     * @return O nome do template Thymeleaf (adicionarNinja.html).
     */
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        // Garante que o objeto MissoesModel não é nulo para o formulário,
        // evitando NullPointerException ao tentar acessar campos da missão no HTML.
        if (ninjaDTO.getMissoes() == null) {
            ninjaDTO.setMissoes(new MissoesModel());
        }
        model.addAttribute("ninja", ninjaDTO);
        return "adicionarNinja"; // Retorna o template do formulário de adição
    }

    /**
     * Processa o envio do formulário de adição de ninja.
     * Mapeado para a URL /ninjas/ui/salvar via POST.
     * @param ninja O objeto NinjaDTO preenchido com os dados do formulário.
     * @param redirectAttributes Usado para adicionar atributos flash (mensagens que persistem após o redirecionamento).
     * @return Um redirecionamento para a página de listagem de ninjas.
     */
    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute("ninja") NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        // Chama o serviço para criar (salvar) o novo ninja
        ninjaService.criarNinja(ninja);
        // Adiciona uma mensagem de sucesso que será exibida após o redirecionamento
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar"; // Redireciona para a lista de ninjas
    }

    // Você pode adicionar aqui métodos para editar, etc.
}
