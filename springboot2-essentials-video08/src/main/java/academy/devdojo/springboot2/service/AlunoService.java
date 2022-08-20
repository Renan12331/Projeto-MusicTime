package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Aluno;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.AlunoMapper;
import academy.devdojo.springboot2.repository.AlunoRepository;
import academy.devdojo.springboot2.requests.AlunoPostRequestBody;
import academy.devdojo.springboot2.requests.AlunoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;
    public List<Aluno> listAll() {

		return alunoRepository.findAll();
    }

	public List<Aluno> findByName(String name) {

		return alunoRepository.findByName(name);
	}

    public Aluno findByIdOrThrowBadRequestException(long id) {
        return alunoRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Aluno not Found"));
    }
	@Transactional
    public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
		return alunoRepository.save(AlunoMapper.INSTANCE.toAluno(alunoPostRequestBody));
    }

	public void delete(long id) {
		alunoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(AlunoPutRequestBody alunoPutRequestBody) {
		Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
		Aluno aluno = AlunoMapper.INSTANCE.toAluno(alunoPutRequestBody);
        aluno.setId(savedAluno.getId());
		alunoRepository.save(aluno);
		
	}
}
