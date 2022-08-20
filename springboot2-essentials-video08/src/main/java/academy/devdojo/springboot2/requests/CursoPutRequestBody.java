package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class CursoPutRequestBody {
    private Long id;
    private String name;
}
