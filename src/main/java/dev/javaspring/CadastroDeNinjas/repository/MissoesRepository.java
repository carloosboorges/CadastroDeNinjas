package dev.javaspring.CadastroDeNinjas.repository;
import dev.javaspring.CadastroDeNinjas.entity.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {


}
