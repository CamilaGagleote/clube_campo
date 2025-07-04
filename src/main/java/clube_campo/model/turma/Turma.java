package clube_campo.model.turma;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import clube_campo.model.associado.Associado;
import clube_campo.model.cobranca.Cobranca;
import clube_campo.model.pagamento.Pagamento;
import clube_campo.model.passeioclube.PasseioClube;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "passeio_id")
    private PasseioClube passeioClubeTurma;

    @OneToMany(mappedBy = "turmaAssociado")
    @JsonIgnore
    private List<Associado> associadosTurma;

}