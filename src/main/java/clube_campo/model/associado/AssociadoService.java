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

        // Salva os dependentes, se houver
        if (dados.dependentes() != null && !dados.dependentes().isEmpty()) {
            dados.dependentes().forEach(depDto -> {
                Dependente dependente = new Dependente(depDto);
                dependente.setAssociado(associadoSalvo);
                dependenteRepository.save(dependente);
            });
        }
        // Atualiza a lista de dependentes do associado salvo
        associadoSalvo.setDependentes(dependenteRepository.findByAssociado(associadoSalvo));
        return associadoSalvo;
    }

    public List<Associado> getAllAssociados() {
        List<Associado> associados = repository.findAll();
        // Garante que cada associado venha com a lista de dependentes preenchida
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
            // Não mexe nos dependentes aqui, apenas atualiza os dados do associado
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
