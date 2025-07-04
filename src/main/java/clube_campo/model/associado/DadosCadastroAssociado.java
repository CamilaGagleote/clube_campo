package clube_campo.model.associado;

import java.time.LocalDate;
import java.util.List;

import clube_campo.model.dependente.DadosCadastroDependente;

public record DadosCadastroAssociado(
    String rgAssociado,
    String nomeAssociado,
    String cpfAssociado,
    String ruaEnderecoAssociado,
    String cepEnderecoAssociado,
    String bairroEnderecoAssociado,
    String cidadeEnderecoAssociado,
    String estadoEnderecoAssociado,
    String telefoneResidencialAssociado,
    String telefoneComercialAssociado,
    String celularAssociado,
    LocalDate dataCadastroAssociado,
    String tipoAssociado,
    Long idTurma
) {}
