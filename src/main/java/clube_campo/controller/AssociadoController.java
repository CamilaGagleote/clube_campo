package clube_campo.controller;

import clube_campo.model.associado.Associado;
import clube_campo.model.associado.AssociadoService;
import clube_campo.model.associado.DadosCadastroAssociado;
import clube_campo.model.associado.DadosAtualizacaoAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService service;

    @PostMapping
    @Transactional
    public Associado cadastrar(@RequestBody @Valid DadosCadastroAssociado dados) {
        Associado associado = new Associado(dados);
        if(dados.idTurma() != null) {
            associado.setAssociadoTurma(service.getAssociadoById(dados.idTurma()));
        }

        return service.cadastrar(associado);
    }

    @GetMapping
    public List<Associado> listar() {
        return service.getAllAssociados();
    }

    @GetMapping("/{id}")
    public Associado buscarPorId(@PathVariable Long id) {
        return service.getAssociadoById(id);
    }

    @PutMapping
    @Transactional
    public Associado atualizar(@RequestBody @Valid DadosAtualizacaoAssociado dados) {
        return service.atualizarAssociado(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        service.deletarAssociado(id);
    }
}
