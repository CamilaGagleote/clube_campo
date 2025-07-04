package clube_campo.model.turma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository repository;

    public Turma cadastrar(Turma turma) {
        return repository.save(turma);
    }

    public List<Turma> getAllTurmas() {
        return repository.findAll();
    }

    public Turma getTurmaById(Long id) {
        return repository.findById(id).orElse(null);
    }  

    public void deletarTurma(Long id) {
        repository.deleteById(id);
    }
}
