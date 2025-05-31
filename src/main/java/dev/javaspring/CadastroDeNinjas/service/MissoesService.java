package dev.javaspring.CadastroDeNinjas.service;

import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import dev.javaspring.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        return missoesRepository.findById(id).orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public void deleteMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }

//    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizada) {
//       Optional<MissoesModel> missoes = missoesRepository.findById(id);
//
//
//    }









}
