package clube_campo.model.pagamento;

import java.time.LocalDate;

public record DadosAtualizacaoPagamento(
    Long idPagamento,
    Double valorPagamento,
    String formaPagamento,
    LocalDate dataPagamento
) {}
