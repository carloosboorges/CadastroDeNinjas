package dev.javaspring.CadastroDeNinjas.repository;
import dev.javaspring.CadastroDeNinjas.entity.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {




}
