package academy.devdojo.springboot2.mapper;


import academy.devdojo.springboot2.domain.Professor;
import academy.devdojo.springboot2.requests.ProfessorPostRequestBody;
import academy.devdojo.springboot2.requests.ProfessorPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProfessorMapper {
    public static final ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);
    public abstract Professor toProfessor(ProfessorPostRequestBody professorPostRequestBody);
    public abstract Professor toProfessor(ProfessorPutRequestBody professorPutRequestBody);
}
