package clube_campo.model.associado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository repository;

    public Associado cadastrar(Associado associado) {
        return repository.save(associado);
    }

    public List<Associado> getAllAssociados() {
        return repository.findAll();
    }

    public Associado getAssociadoById(Long id) {
        return repository.findById(id).orElse(null);
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
}
