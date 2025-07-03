package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import clube_campo.model.passeioclube.*;

@RestController
@RequestMapping("/passeioclube")
public class PasseioClubeController {

    @Autowired
    private PasseioClubeService service;

    @PostMapping
    @Transactional
    public PasseioClube cadastrarPasseio(@RequestBody @Valid DadosCadastroPasseioClube dados) {
        PasseioClube passeio = new PasseioClube(dados);
        return service.cadastrar(passeio);
    }

    @GetMapping
    public List<PasseioClube> listarPasseios() {
        return service.getAllPasseios();
    }

    @GetMapping("/{id}")
    public PasseioClube buscarPorId(@PathVariable Long id) {
        return service.getPasseioById(id);
    }

    @PutMapping
    @Transactional
    public PasseioClube atualizarPasseio(@RequestBody @Valid DadosAtualizacaoPasseioClube dados) {
        return service.atualizarPasseio(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPasseio(@PathVariable Long id) {
        service.deletarPasseio(id);
    }

    public void deletarArea(@PathVariable Long id) {
        service.deletarPasseio(id);
    }
}
