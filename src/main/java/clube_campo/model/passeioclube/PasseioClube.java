package clube_campo.model.passeioclube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import clube_campo.model.pagamento.Pagamento;
import clube_campo.model.turma.Turma;
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
    private int duracao;

    @OneToMany(mappedBy = "passeioClubeTurma")
    @JsonIgnore
    private List<Turma> turmasPasseio;

    public PasseioClube(DadosCadastroPasseioClube dados) {
        this.nomePasseio = dados.nomePasseio();
        this.duracao = dados.duracao();
    }

    public void atualizarPasseio(DadosAtualizacaoPasseioClube dados) {
        if (dados.nomePasseio() != null) this.nomePasseio = dados.nomePasseio();
        if (dados.duracao() != null) this.duracao = dados.duracao();
    }
}