package clube_campo.model.reserva;
import java.time.LocalDate;

import clube_campo.model.associado.Associado;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idReserva")
public class Reserva{
    private Long idReserva;
    private LocalDate dataSolicitacao;
    private LocalDate dataReservada;
    private String nomeAreaReservada;
    private Associado associado;
    private double valorReserva;    
}
    