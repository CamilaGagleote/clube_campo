package clube_campo.model.reserva;
import java.time.LocalDate;
import java.util.List;

import clube_campo.model.areaclube.AreaClube;
import clube_campo.model.associado.Associado;
import clube_campo.model.cobranca.Cobranca;
import clube_campo.model.passeioclube.PasseioClube;
import clube_campo.model.turma.Turma;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @JoinColumn(name = "associado_id")
    private Associado associadoReserva;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaClube areaClubeReserva;

    @ManyToOne
    @JoinColumn(name = "cobranca_id")
    private Cobranca cobrancaReserva;

    private double valorReserva;    
    
    public Reserva(DadosCadastroReserva dados) {
        this.dataSolicitacao = dados.dataSolicitacao();
        this.dataReservada = dados.dataReservada();
        this.nomeAreaReservada = dados.nomeAreaReservada();
        this.valorReserva = dados.valorReserva();
    }

    public void atualizarReserva(DadosAtualizacaoReserva dados) {
        if (dados.dataSolicitacao() != null) this.dataSolicitacao = dados.dataSolicitacao();
        if (dados.dataReservada() != null) this.dataReservada = dados.dataReservada();
        if (dados.nomeAreaReservada() != null) this.nomeAreaReservada = dados.nomeAreaReservada();
        if (dados.associado() != null) this.associadoReserva = dados.associado();
        if (dados.valorReserva() != null) this.valorReserva = dados.valorReserva();
    }
}
