package clube_campo.model.dependente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteService {
    @Autowired
    private DependenteRepository repository;

    public Dependente cadastrar(Dependente dependente) {
        return repository.save(dependente);
    }

    public List<Dependente> getAllDependentes() {
        return repository.findAll();
    }

    public Dependente getDependenteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Dependente atualizarDependente(DadosAtualizacaoDependente dados) {
        Dependente dependente = repository.findById(dados.idDependente()).orElse(null);
        if (dependente != null) {
            dependente.atualizarDependente(dados);
            return repository.save(dependente);
        }
        return null;
    }

    public void deletarDependente(Long id) {
        repository.deleteById(id);
    }
}
