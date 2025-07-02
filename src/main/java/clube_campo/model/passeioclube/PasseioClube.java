package clube_campo.model.passeioclube;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PasseioClube")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPasseio")
public class PasseioClube{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPasseio;
    private String nomePasseio;
    private int qtdeTurma; 
    private int duracao;

    public PasseioClube(DadosCadastroPasseioClube dados) {
        this.nomePasseio = dados.nomePasseio();
        this.qtdeTurma = dados.qtdeTurma();
        this.duracao = dados.duracao();
    }

    public void atualizarPasseio(DadosAtualizacaoPasseioClube dados) {
        if (dados.nomePasseio() != null) this.nomePasseio = dados.nomePasseio();
        if (dados.qtdeTurma() != null) this.qtdeTurma = dados.qtdeTurma();
        if (dados.duracao() != null) this.duracao = dados.duracao();
    }
}