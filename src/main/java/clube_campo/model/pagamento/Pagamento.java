package clube_campo.model.pagamento;
import java.time.LocalDate;

import jakarta.persistence.Entity;
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
    private Long idPagamento;
    private double valorPagamento;
    private String formaPagamento;
    private LocalDate dataPagamento;
}