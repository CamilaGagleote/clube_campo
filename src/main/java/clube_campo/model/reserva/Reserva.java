package clube_campo.model.reserva;
import java.time.LocalDate;

import clube_campo.model.associado.Associado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private LocalDate dataSolicitacao;
    private LocalDate dataReservada;
    private String nomeAreaReservada;
    @ManyToOne
    private Associado associado;
    private double valorReserva;    
    
    public Reserva(DadosCadastroReserva dados) {
        this.dataSolicitacao = dados.dataSolicitacao();
        this.dataReservada = dados.dataReservada();
        this.nomeAreaReservada = dados.nomeAreaReservada();
        this.associado = dados.associado();
        this.valorReserva = dados.valorReserva();
    }

    public void atualizarReserva(DadosAtualizacaoReserva dados) {
        if (dados.dataSolicitacao() != null) this.dataSolicitacao = dados.dataSolicitacao();
        if (dados.dataReservada() != null) this.dataReservada = dados.dataReservada();
        if (dados.nomeAreaReservada() != null) this.nomeAreaReservada = dados.nomeAreaReservada();
        if (dados.associado() != null) this.associado = dados.associado();
        if (dados.valorReserva() != null) this.valorReserva = dados.valorReserva();
    }
}
