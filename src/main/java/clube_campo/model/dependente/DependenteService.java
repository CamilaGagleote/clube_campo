package clube_campo.model.dependente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clube_campo.model.associado.Associado;
import clube_campo.model.associado.AssociadoRepository;

@Service
public class DependenteService {
    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    public Dependente cadastrar(Dependente dependente) {
        return dependenteRepository.save(dependente);
    }

    public List<Dependente> getAllDependentes() {
        return dependenteRepository.findAll();
    }

    public Dependente getDependenteById(Long id) {
        return dependenteRepository.findById(id).orElse(null);
    }

    public Dependente atualizarDependente(DadosAtualizacaoDependente dados) {
        Dependente dependente = dependenteRepository.findById(dados.idDependente()).orElse(null);
        if (dependente != null) {
            dependente.atualizarDependente(dados);
            return dependenteRepository.save(dependente);
        }
        return null;
    }

    public void deletarDependente(Long id) {
        dependenteRepository.deleteById(id);
    }
}
