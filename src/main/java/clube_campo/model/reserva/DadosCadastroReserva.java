package clube_campo.model.reserva;

import java.time.LocalDate;
import clube_campo.model.associado.Associado;

public record DadosCadastroReserva(    
    String nomeAreaReservada,
    Long idAssociado,
    Long idAreaClube,
    Long idCobranca,
    Double valorReserva
) {}
