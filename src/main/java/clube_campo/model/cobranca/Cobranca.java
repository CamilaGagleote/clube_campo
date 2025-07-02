package clube_campo.model.cobranca;

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
    private String cpnj;

}