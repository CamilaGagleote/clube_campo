package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

import java.util.List;

import clube_campo.model.areaclube.AreaClube;
import clube_campo.model.reserva.*;
import clube_campo.model.associado.AssociadoService;
import clube_campo.model.areaclube.AreaClubeService;
import clube_campo.model.cobranca.CobrancaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private AreaClubeService areaClubeService;

    @Autowired
    private CobrancaService cobrancaService;

    @PostMapping
    @Transactional
    public Reserva cadastrarReserva(@RequestBody @Valid DadosCadastroReserva dados) {
        Reserva reserva = new Reserva(dados);
        reserva.setAssociadoReserva(associadoService.getAssociadoById(dados.idAssociado()));
        AreaClube area = areaClubeService.getAreaById(dados.idAreaClube());
        reserva.setAreaClubeReserva(area);
        if (area.getIndicadorReservavelArea() == null || !area.getIndicadorReservavelArea()) {
            throw new RuntimeException("Área não reservável.");
        }       
        if (dados.idCobranca() != null) {
            reserva.setCobrancaReserva(cobrancaService.getCobrancaById(dados.idCobranca()));
        }
        return reservaService.cadastrar(reserva);
    }

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public Reserva buscarPorId(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }

    @PutMapping
    @Transactional
    public Reserva atualizarReserva(@RequestBody @Valid DadosAtualizacaoReserva dados) {
        return reservaService.atualizarReserva(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
    }
}
