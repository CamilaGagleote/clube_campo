package clube_campo.model.cobranca;

public record DadosCadastroCobranca(
    Double valorCobranca,
    Double jurosCobranca,
    Integer numContacobranca,
    Integer agenciaContaCobranca,
    String cpnj
) {}
