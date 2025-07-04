package clube_campo.model.dependente;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Entity(name = "Dependente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idDependente")
public class Dependente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDependente;
    private String rgDependente;
    private String nomeDependente;

    @ManyToOne
    
    private Associado associado;

    public Dependente(DadosCadastroDependente dados) {
        this.rgDependente = dados.rgDependente();
        this.nomeDependente = dados.nomeDependente();
    }

    public void atualizarDependente(DadosAtualizacaoDependente dados) {
        if (dados.nomeDependente() != null) this.nomeDependente = dados.nomeDependente();
        if (dados.rgDependente() != null) this.rgDependente = dados.rgDependente();
    }
}