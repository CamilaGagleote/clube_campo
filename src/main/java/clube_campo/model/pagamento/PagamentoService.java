package clube_campo.model.pagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    public Pagamento cadastrar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public List<Pagamento> getAllPagamentos() {
        return repository.findAll();
    }

    public Pagamento getPagamentoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pagamento atualizarPagamento(DadosAtualizacaoPagamento dados) {
        Pagamento pagamento = repository.findById(dados.idPagamento()).orElse(null);
        if (pagamento != null) {
            pagamento.atualizarPagamento(dados);
            return repository.save(pagamento);
        }
        return null;
    }

    public void deletarPagamento(Long id) {
        repository.deleteById(id);
    }

}
