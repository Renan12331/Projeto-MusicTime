package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Curso;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.CursoMapper;
import academy.devdojo.springboot2.repository.CursoRepository;
import academy.devdojo.springboot2.requests.CursoPostRequestBody;
import academy.devdojo.springboot2.requests.CursoPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    public List<Curso> listAll(){
        return cursoRepository.findAll();
    }

    public List<Curso> findByName(String name){
        return cursoRepository.findByName(name);
    }
    public Curso findByIdOrThrowBadRequestException(long id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Curso not Found"));
    }
    @Transactional
    public Curso save(CursoPostRequestBody cursoPostRequestBody) {
        return cursoRepository.save(CursoMapper.INSTANCE.toCurso(cursoPostRequestBody));
    }

    public void delete(long id) {
        cursoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CursoPutRequestBody cursoPutRequestBody) {
        Curso savedCurso = findByIdOrThrowBadRequestException(cursoPutRequestBody.getId());
        Curso curso = CursoMapper.INSTANCE.toCurso(cursoPutRequestBody);
        curso.setId(savedCurso.getId());
        cursoRepository.save(curso);
    }
}
