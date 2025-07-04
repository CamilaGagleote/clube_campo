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

import clube_campo.model.turma.TurmaService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService service;

    @Autowired
    private TurmaService serviceTurma;

    @PostMapping
    @Transactional
    public Associado cadastrar(@RequestBody @Valid DadosCadastroAssociado dados) {
        Associado associado = new Associado(dados);
        if(dados.idTurma() != null) {
            associado.setTurmaAssociado(serviceTurma.getTurmaById(dados.idTurma()));
        }

        return service.salvar(associado);
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
