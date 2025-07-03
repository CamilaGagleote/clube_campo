package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import clube_campo.model.areaclube.AreaClube;
import clube_campo.model.areaclube.AreaClubeService;
import clube_campo.model.areaclube.DadosCadastroArea;
import clube_campo.model.areaclube.DadosAtualizacaoArea;

@RestController
@RequestMapping("/areaclube")
public class AreaClubeController {

    @Autowired
    private AreaClubeService service;


    @PostMapping
    @Transactional
    public AreaClube cadastrarArea(@RequestBody @Valid DadosCadastroArea dados) {
        AreaClube area = new AreaClube(dados);
        return service.cadastrar(area);
    }

    @GetMapping
    public List<AreaClube> listarAreas() {
        return service.getAllAreas();
    }

    @GetMapping("/{id}")
    public AreaClube buscarPorId(@PathVariable Long id) {
        return service.getAreaById(id);
    }

    @PutMapping
    @Transactional
    public AreaClube atualizarArea(@RequestBody @Valid DadosAtualizacaoArea dados) {
        return service.atualizarArea(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarArea(@PathVariable Long id) {
        service.deletarArea(id);
    }
}
