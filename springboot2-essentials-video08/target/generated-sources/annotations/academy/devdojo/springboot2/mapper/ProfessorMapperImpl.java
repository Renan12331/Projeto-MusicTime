package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Professor;
import academy.devdojo.springboot2.domain.Professor.ProfessorBuilder;
import academy.devdojo.springboot2.requests.ProfessorPostRequestBody;
import academy.devdojo.springboot2.requests.ProfessorPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T15:01:15-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProfessorMapperImpl extends ProfessorMapper {

    @Override
    public Professor toProfessor(ProfessorPostRequestBody professorPostRequestBody) {
        if ( professorPostRequestBody == null ) {
            return null;
        }

        ProfessorBuilder professor = Professor.builder();

        professor.name( professorPostRequestBody.getName() );
        professor.curso( professorPostRequestBody.getCurso() );
        professor.data_nascimento( professorPostRequestBody.getData_nascimento() );
        professor.cpf( professorPostRequestBody.getCpf() );
        professor.endereco( professorPostRequestBody.getEndereco() );

        return professor.build();
    }

    @Override
    public Professor toProfessor(ProfessorPutRequestBody professorPutRequestBody) {
        if ( professorPutRequestBody == null ) {
            return null;
        }

        ProfessorBuilder professor = Professor.builder();

        professor.id( professorPutRequestBody.getId() );
        professor.name( professorPutRequestBody.getName() );
        professor.curso( professorPutRequestBody.getCurso() );
        professor.data_nascimento( professorPutRequestBody.getData_nascimento() );
        professor.cpf( professorPutRequestBody.getCpf() );
        professor.endereco( professorPutRequestBody.getEndereco() );

        return professor.build();
    }
}
