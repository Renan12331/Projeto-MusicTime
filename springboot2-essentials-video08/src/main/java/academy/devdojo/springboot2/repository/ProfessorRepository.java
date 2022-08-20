package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByName(String name);
}
