package clube_campo.model.cobranca;

public record DadosAtualizacaoCobranca(
    Long idCobranca,
    Double valorCobranca,
    Double jurosCobranca,
    Integer numContacobranca,
    Integer agenciaContaCobranca,
    String cnpj
) {}
