package clube_campo.controller;

import clube_campo.model.cobranca.Cobranca;
import clube_campo.model.cobranca.CobrancaService;
import clube_campo.model.cobranca.DadosCadastroCobranca;
import clube_campo.model.cobranca.DadosAtualizacaoCobranca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cobranca")
public class CobrancaController {

    @Autowired
    private CobrancaService service;

    @PostMapping
    @Transactional
    public Cobranca cadastrar(@RequestBody @Valid DadosCadastroCobranca dados) {
        Cobranca cobranca = new Cobranca(dados);
        return service.cadastrar(cobranca);
    }

    @GetMapping
    public List<Cobranca> listar() {
        return service.getAllCobrancas();
    }

    @GetMapping("/{id}")
    public Cobranca buscarPorId(@PathVariable Long id) {
        return service.getCobrancaById(id);
    }

    @PutMapping
    @Transactional
    public Cobranca atualizar(@RequestBody @Valid DadosAtualizacaoCobranca dados) {
        return service.atualizarCobranca(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        service.deletarCobranca(id);
    }
}
