package clube_campo.model.associado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clube_campo.model.dependente.Dependente;
import clube_campo.model.dependente.DependenteRepository;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository repository;
    @Autowired
    private DependenteRepository dependenteRepository;

    public Associado cadastrar(DadosCadastroAssociado dados) {
        Associado associado = new Associado(dados);
        Associado associadoSalvo = repository.save(associado);

        if (dados.dependentes() != null && !dados.dependentes().isEmpty()) {
            dados.dependentes().forEach(depDto -> {
                Dependente dependente = new Dependente(depDto);
                dependente.setAssociado(associadoSalvo);
                dependenteRepository.save(dependente);
            });
        }
        associadoSalvo.setDependentes(dependenteRepository.findByAssociado(associadoSalvo));
        return associadoSalvo;
    }

    public List<Associado> getAllAssociados() {
        List<Associado> associados = repository.findAll();
        associados.forEach(a -> a.setDependentes(dependenteRepository.findByAssociado(a)));
        return associados;
    }

    public Associado getAssociadoById(Long id) {
        Associado associado = repository.findById(id).orElse(null);
        if (associado != null) {
            associado.setDependentes(dependenteRepository.findByAssociado(associado));
        }
        return associado;
    }

    public Associado atualizarAssociado(DadosAtualizacaoAssociado dados) {
        Associado associado = repository.findById(dados.idAssociado()).orElse(null);
        if (associado != null) {
            associado.atualizarAssociado(dados);
            return repository.save(associado);
        }
        return null;
    }

    public void deletarAssociado(Long id) {
        repository.deleteById(id);
    }

    public Associado salvar(Associado associado) {
        return repository.save(associado);
    }
}
