package clube_campo.model.reserva;

import java.time.LocalDate;
import clube_campo.model.associado.Associado;

public record DadosAtualizacaoReserva(
    Long idReserva,
    LocalDate dataSolicitacao,
    LocalDate dataReservada,
    String nomeAreaReservada,
    Associado associado,
    Double valorReserva
) {}
