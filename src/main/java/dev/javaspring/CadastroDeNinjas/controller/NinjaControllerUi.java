package dev.javaspring.CadastroDeNinjas.controller;

import dev.javaspring.CadastroDeNinjas.dto.NinjaDTO;
import dev.javaspring.CadastroDeNinjas.service.NinjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }
}
