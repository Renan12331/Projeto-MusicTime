package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Curso;
import academy.devdojo.springboot2.domain.Curso.CursoBuilder;
import academy.devdojo.springboot2.requests.CursoPostRequestBody;
import academy.devdojo.springboot2.requests.CursoPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T15:01:15-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CursoMapperImpl extends CursoMapper {

    @Override
    public Curso toCurso(CursoPostRequestBody cursoPostRequestBody) {
        if ( cursoPostRequestBody == null ) {
            return null;
        }

        CursoBuilder curso = Curso.builder();

        curso.name( cursoPostRequestBody.getName() );

        return curso.build();
    }

    @Override
    public Curso toCurso(CursoPutRequestBody cursoPutRequestBody) {
        if ( cursoPutRequestBody == null ) {
            return null;
        }

        CursoBuilder curso = Curso.builder();

        curso.id( cursoPutRequestBody.getId() );
        curso.name( cursoPutRequestBody.getName() );

        return curso.build();
    }
}
