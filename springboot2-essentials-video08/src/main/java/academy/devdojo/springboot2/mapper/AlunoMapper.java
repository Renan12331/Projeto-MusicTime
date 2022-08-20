package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Aluno;
import academy.devdojo.springboot2.requests.AlunoPostRequestBody;
import academy.devdojo.springboot2.requests.AlunoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {
    public static final AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    public abstract Aluno toAluno(AlunoPostRequestBody alunoPostRequestBody);

    public abstract Aluno toAluno(AlunoPutRequestBody alunoPutRequestBody);
}
