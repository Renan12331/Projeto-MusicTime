package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Aluno;
import academy.devdojo.springboot2.domain.Aluno.AlunoBuilder;
import academy.devdojo.springboot2.requests.AlunoPostRequestBody;
import academy.devdojo.springboot2.requests.AlunoPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T15:01:14-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AlunoMapperImpl extends AlunoMapper {

    @Override
    public Aluno toAluno(AlunoPostRequestBody alunoPostRequestBody) {
        if ( alunoPostRequestBody == null ) {
            return null;
        }

        AlunoBuilder aluno = Aluno.builder();

        aluno.name( alunoPostRequestBody.getName() );
        aluno.matricula( alunoPostRequestBody.getMatricula() );
        aluno.cpf( alunoPostRequestBody.getCpf() );
        aluno.endereco( alunoPostRequestBody.getEndereco() );
        aluno.curso( alunoPostRequestBody.getCurso() );

        return aluno.build();
    }

    @Override
    public Aluno toAluno(AlunoPutRequestBody alunoPutRequestBody) {
        if ( alunoPutRequestBody == null ) {
            return null;
        }

        AlunoBuilder aluno = Aluno.builder();

        aluno.id( alunoPutRequestBody.getId() );
        aluno.name( alunoPutRequestBody.getName() );
        aluno.matricula( alunoPutRequestBody.getMatricula() );
        aluno.cpf( alunoPutRequestBody.getCpf() );
        aluno.endereco( alunoPutRequestBody.getEndereco() );
        aluno.curso( alunoPutRequestBody.getCurso() );

        return aluno.build();
    }
}
