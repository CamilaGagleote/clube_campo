package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

import java.util.List;

import clube_campo.model.cobranca.Cobranca;
import clube_campo.model.cobranca.CobrancaService;
import clube_campo.model.pagamento.DadosAtualizacaoPagamento;
import clube_campo.model.pagamento.DadosCadastroPagamento;
import clube_campo.model.pagamento.Pagamento;
import clube_campo.model.pagamento.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CobrancaService serviceCobranca;

    @Autowired
    private PagamentoService service;

    @PostMapping
    @Transactional
    public Pagamento cadastrarPagamento(
        @RequestBody @Valid DadosCadastroPagamento dados
    ) {
        Pagamento pagamento = new Pagamento(dados);
        
        Cobranca cobranca = serviceCobranca.getCobrancaById(dados.idCobranca());
        pagamento.setCobrancaPagamento(cobranca);

        return service.cadastrar(pagamento);
    }

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return service.getAllPagamentos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable Long id) {
        return service.getPagamentoById(id);
    }

    @PutMapping
    @Transactional
    public Pagamento atualizarPagamento(@RequestBody @Valid DadosAtualizacaoPagamento dados) {
        return service.atualizarPagamento(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPagamento(@PathVariable Long id) {
        service.deletarPagamento(id);
    }
}
