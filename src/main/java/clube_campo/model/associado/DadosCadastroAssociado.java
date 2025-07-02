package clube_campo.model.associado;

import java.time.LocalDate;

public record DadosCadastroAssociado(
    String rgAssociado,
    String nomeAssociado,
    String cpfAssociado,
    String ruaEnderecoAssociado,
    String cepEnderecoAssociado,
    String bairroEnderecoAssociado,
    String cidadeEnderecoAssociado,
    String telefoneResidencialAssociado,
    String telefoneComercialAssociado,
    String celularAssociado,
    LocalDate dataCadastroAssociado
) {}
