package academy.devdojo.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import academy.devdojo.springboot2.domain.Curso;
import academy.devdojo.springboot2.requests.CursoPostRequestBody;
import academy.devdojo.springboot2.requests.CursoPutRequestBody;
import academy.devdojo.springboot2.service.CursoService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("cursos")
@Log4j2
@RequiredArgsConstructor
public class CursoControler {
    private final DateUtil dateUtil;
    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(cursoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Curso> findById(@PathVariable long id){
        return ResponseEntity.ok(cursoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Curso>> findByName(@RequestParam String name){
        return ResponseEntity.ok(cursoService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody CursoPostRequestBody cursoPostRequestBody){
        return new ResponseEntity<>(cursoService.save(cursoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CursoPutRequestBody cursoPutRequestBody){
        cursoService.replace(cursoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
