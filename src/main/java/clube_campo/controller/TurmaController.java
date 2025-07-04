package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import clube_campo.model.turma.*;
import clube_campo.model.associado.AssociadoService;
import clube_campo.model.passeioclube.PasseioClubeService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private PasseioClubeService passeioClubeService;

    @PostMapping
    @Transactional
    public Turma cadastrarTurma(@RequestBody @Valid DadosCadastroTurma dados) {
        Turma turma = new Turma();
        turma.setPasseioClubeTurma(passeioClubeService.getPasseioById(dados.idPasseioClube()));
        return turmaService.cadastrar(turma);
    }

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaService.getAllTurmas();
    }

    @GetMapping("/{id}")
    public Turma buscarPorId(@PathVariable Long id) {
        return turmaService.getTurmaById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarTurma(@PathVariable Long id) {
        turmaService.deletarTurma(id);
    }
}
