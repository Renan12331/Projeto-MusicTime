package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class AlunoPostRequestBody {
    private String name;
    private String matricula;
    private String data_nascimento;
    private String cpf;
    private String endereco;
    private String curso;
}
