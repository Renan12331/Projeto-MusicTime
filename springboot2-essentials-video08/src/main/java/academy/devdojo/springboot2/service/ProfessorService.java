package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Professor;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.ProfessorMapper;
import academy.devdojo.springboot2.repository.ProfessorRepository;
import academy.devdojo.springboot2.requests.ProfessorPostRequestBody;
import academy.devdojo.springboot2.requests.ProfessorPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor

public class ProfessorService {
    private final ProfessorRepository professorRepository;
    public List<Professor> listAll(){
        return professorRepository.findAll();
    }

    public List<Professor> findByName(String name){
        return professorRepository.findByName(name);
    }
    public Professor findByIdOrThrowBadRequestException(long id){
        return professorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Curso not Found"));
    }
    @Transactional
    public Professor save(ProfessorPostRequestBody professorPostRequestBody) {
        return professorRepository.save(ProfessorMapper.INSTANCE.toProfessor(professorPostRequestBody));
    }

    public void delete(long id) {
        professorRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ProfessorPutRequestBody professorPutRequestBody) {
        Professor savedProfessor = findByIdOrThrowBadRequestException(professorPutRequestBody.getId());
        Professor professor = ProfessorMapper.INSTANCE.toProfessor(professorPutRequestBody);
        professor.setId(savedProfessor.getId());
        professorRepository.save(professor);
    }
}
