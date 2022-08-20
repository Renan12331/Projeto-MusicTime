package academy.devdojo.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import academy.devdojo.springboot2.requests.AlunoPostRequestBody;
import academy.devdojo.springboot2.requests.AlunoPutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import academy.devdojo.springboot2.domain.Aluno;
import academy.devdojo.springboot2.service.AlunoService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;

@RestController
@RequestMapping("alunos") // http://localhost:8080/Aluno/{id}, http://localhost:8080/Aluno/find?name=Marcelo&id=10
@Log4j2
@RequiredArgsConstructor

public class AlunoControler {
	private final DateUtil dateUtil;
    private final AlunoService AlunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(AlunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(AlunoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Aluno>> findByName(@RequestParam String name){
        return ResponseEntity.ok(AlunoService.findByName(name));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoPostRequestBody alunoPostRequestBody) {
    	return new ResponseEntity<>(AlunoService.save(alunoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	AlunoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AlunoPutRequestBody alunoPutRequestBody){
    	AlunoService.replace(alunoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
