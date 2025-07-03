package clube_campo.model.cobranca;

import java.util.List;

import clube_campo.model.pagamento.Pagamento;
import clube_campo.model.reserva.Reserva;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cobranca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idCobranca")
public class Cobranca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCobranca;
    private double valorCobranca;
    private double jurosCobranca;
    private int numContacobranca;
    private int agenciaContaCobranca;
    private String cnpj;

    @OneToMany(mappedBy = "cobrancaPagamento")
    private List<Pagamento> pagamentosCobranca;

    @OneToMany(mappedBy = "cobrancaReserva")
    private List<Reserva> reservasCobranca;

    public Cobranca(DadosCadastroCobranca dados) {
        this.valorCobranca = dados.valorCobranca();
        this.jurosCobranca = dados.jurosCobranca();
        this.numContacobranca = dados.numContacobranca();
        this.agenciaContaCobranca = dados.agenciaContaCobranca();
        this.cnpj = dados.cnpj();
    }

    public void atualizarCobranca(DadosAtualizacaoCobranca dados) {
        if (dados.valorCobranca() != null) this.valorCobranca = dados.valorCobranca();
        if (dados.jurosCobranca() != null) this.jurosCobranca = dados.jurosCobranca();
        if (dados.numContacobranca() != null) this.numContacobranca = dados.numContacobranca();
        if (dados.agenciaContaCobranca() != null) this.agenciaContaCobranca = dados.agenciaContaCobranca();
        if (dados.cnpj() != null) this.cnpj = dados.cnpj();
    }
}