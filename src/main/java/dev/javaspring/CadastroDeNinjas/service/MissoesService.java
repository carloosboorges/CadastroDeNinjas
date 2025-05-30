package dev.javaspring.CadastroDeNinjas.service;

import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import dev.javaspring.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }





}
