package clube_campo.controller;

import clube_campo.model.dependente.Dependente;
import clube_campo.model.dependente.DependenteService;
import clube_campo.model.dependente.DadosCadastroDependente;
import clube_campo.model.dependente.DadosAtualizacaoDependente;
import clube_campo.model.associado.Associado;
import clube_campo.model.associado.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private DependenteService service;

    @Autowired
    private AssociadoRepository associadoRepository;

    @PostMapping
    @Transactional
    public Dependente cadastrar(@RequestBody @Valid DadosCadastroDependente dados) {
        Dependente dependente = new Dependente(dados);
        if (dados.idAssociado() != null) {
            Associado associado = associadoRepository.findById(dados.idAssociado()).orElse(null);
            dependente.setAssociado(associado);
        }
        return service.cadastrar(dependente);
    }

    @GetMapping
    public List<Dependente> listar() {
        return service.getAllDependentes();
    }

    @GetMapping("/{id}")
    public Dependente buscarPorId(@PathVariable Long id) {
        return service.getDependenteById(id);
    }

    @PutMapping
    @Transactional
    public Dependente atualizar(@RequestBody @Valid DadosAtualizacaoDependente dados) {
        return service.atualizarDependente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        service.deletarDependente(id);
    }
}
