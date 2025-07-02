package clube_campo.model.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public Reserva cadastrar(Reserva reserva) {
        return repository.save(reserva);
    }

    public List<Reserva> getAllReservas() {
        return repository.findAll();
    }

    public Reserva getReservaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Reserva atualizarReserva(DadosAtualizacaoReserva dados) {
        Reserva reserva = repository.findById(dados.idReserva()).orElse(null);
        if (reserva != null) {
            reserva.atualizarReserva(dados);
            return repository.save(reserva);
        }
        return null;
    }

    public void deletarReserva(Long id) {
        repository.deleteById(id);
    }
}
