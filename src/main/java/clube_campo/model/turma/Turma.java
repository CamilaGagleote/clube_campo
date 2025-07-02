package clube_campo.model.turma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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