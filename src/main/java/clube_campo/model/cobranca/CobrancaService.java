package clube_campo.model.cobranca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CobrancaService {
    @Autowired
    private CobrancaRepository repository;

    public Cobranca cadastrar(Cobranca cobranca) {
        return repository.save(cobranca);
    }

    public List<Cobranca> getAllCobrancas() {
        return repository.findAll();
    }

    public Cobranca getCobrancaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cobranca atualizarCobranca(DadosAtualizacaoCobranca dados) {
        Cobranca cobranca = repository.findById(dados.idCobranca()).orElse(null);
        if (cobranca != null) {
            cobranca.atualizarCobranca(dados);
            return repository.save(cobranca);
        }
        return null;
    }

    public void deletarCobranca(Long id) {
        repository.deleteById(id);
    }
}
