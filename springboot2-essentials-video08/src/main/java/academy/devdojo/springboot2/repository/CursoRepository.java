package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByName(String name);
}
