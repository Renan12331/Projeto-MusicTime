package academy.devdojo.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import academy.devdojo.springboot2.domain.Professor;
import academy.devdojo.springboot2.requests.ProfessorPostRequestBody;
import academy.devdojo.springboot2.requests.ProfessorPutRequestBody;
import academy.devdojo.springboot2.service.ProfessorService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("professores")
@Log4j2
@RequiredArgsConstructor
public class ProfessorControler {
    private final DateUtil dateUtil;
    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(professorService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable long id){
        return ResponseEntity.ok(professorService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Professor>> findByName(@RequestParam String name){
        return ResponseEntity.ok(professorService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody ProfessorPostRequestBody professorPostRequestBody){
        return new ResponseEntity<>(professorService.save(professorPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        professorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProfessorPutRequestBody professorPutRequestBody){
        professorService.replace(professorPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
