package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class ProfessorPutRequestBody {
    private Long id;
    private String name;
    private String curso;
    private String data_nascimento;
    private String cpf;
    private String endereco;
}
