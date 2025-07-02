package clube_campo.model.passeioclube;

import jakarta.persistence.Entity;
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
    private Long idPasseio;
    private String nomePasseio;
    private int qtdeTurma; 
    private int duracao;
}