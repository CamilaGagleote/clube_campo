package clube_campo.model.turma;

import clube_campo.model.associado.Associado;
import clube_campo.model.cobranca.Cobranca;
import clube_campo.model.passeioclube.PasseioClube;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Turma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idTurma")
public class Turma{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;
    private int qtdeTurma;
    private int qtdePessoa;
    private int duracao;

    @ManyToOne
    @JoinColumn(name = "passeio_id")
    private PasseioClube passeioClubeTurma;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associadoTurma;

    public Turma(DadosCadastroTurma dados) {
        this.qtdeTurma = dados.qtdeTurma();
        this.qtdePessoa = dados.qtdePessoa();
        this.duracao = dados.duracao();
    }

    public void atualizarTurma(DadosAtualizacaoTurma dados) {
        if (dados.qtdeTurma() != null) this.qtdeTurma = dados.qtdeTurma();
        if (dados.qtdePessoa() != null) this.qtdePessoa = dados.qtdePessoa();
        if (dados.duracao() != null) this.duracao = dados.duracao();
    }
}