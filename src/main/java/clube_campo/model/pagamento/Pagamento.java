package clube_campo.model.pagamento;
import java.time.LocalDate;

import clube_campo.model.cobranca.Cobranca;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPagamento")
public class Pagamento{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;
    private double valorPagamento;
    private String formaPagamento;
    private LocalDate dataPagamento;
    
    @ManyToOne
    @JoinColumn(name = "cobranca_id")
    private Cobranca cobrancaPagamento;

    public Pagamento(DadosCadastroPagamento dados) {
        this.valorPagamento = dados.valorPagamento();
        this.formaPagamento = dados.formaPagamento();
        this.dataPagamento = LocalDate.now();
    }

    public void atualizarPagamento(DadosAtualizacaoPagamento dados) {
        if (dados.valorPagamento() != null) this.valorPagamento = dados.valorPagamento();
        if (dados.formaPagamento() != null) this.formaPagamento = dados.formaPagamento();
        this.dataPagamento = LocalDate.now();
    }
}