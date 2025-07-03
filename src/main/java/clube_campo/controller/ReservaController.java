package clube_campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import java.util.List;
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
    public Reserva cadastrarReserva(@RequestBody @Valid DadosCadastroReserva dados,
                                    @RequestParam Long idAssociado,
                                    @RequestParam Long idAreaClube,
                                    @RequestParam(required = false) Long idCobranca) {
        Reserva reserva = new Reserva(dados);
        reserva.setAssociadoReserva(associadoService.getAssociadoById(idAssociado));
        reserva.setAreaClubeReserva(areaClubeService.getAreaById(idAreaClube));
        if (idCobranca != null) {
            reserva.setCobrancaReserva(cobrancaService.getCobrancaById(idCobranca));
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
