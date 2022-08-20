package academy.devdojo.springboot2.mapper;


import academy.devdojo.springboot2.domain.Curso;
import academy.devdojo.springboot2.requests.CursoPostRequestBody;
import academy.devdojo.springboot2.requests.CursoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CursoMapper {
    public static final CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);
    public abstract Curso toCurso(CursoPostRequestBody cursoPostRequestBody);
    public abstract Curso toCurso(CursoPutRequestBody cursoPutRequestBody);
}
