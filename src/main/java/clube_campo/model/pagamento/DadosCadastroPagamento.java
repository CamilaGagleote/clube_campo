package clube_campo.model.pagamento;

import java.time.LocalDate;

public record DadosCadastroPagamento(
    Double valorPagamento,
    String formaPagamento,
    LocalDate dataPagamento
) {}
