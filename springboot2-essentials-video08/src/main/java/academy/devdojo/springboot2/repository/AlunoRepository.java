package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByName(String name);
}
