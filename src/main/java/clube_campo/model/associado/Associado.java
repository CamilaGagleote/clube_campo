package clube_campo.model.associado;

import java.time.LocalTime;


import java.time.LocalDate;
import java.util.List;

import clube_campo.model.dependente.Dependente;
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

@Entity(name = "Associado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAssociado")
public class Associado{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssociado;
    private String rgAssociado;
    private String nomeAssociado;
    private String cpfAssociado;
    private String ruaEnderecoAssociado;
    private String cepEnderecoAssociado;
    private String bairroEnderecoAssociado;
    private String cidadeEnderecoAssociado;
    private String telefoneResidencialAssociado;
    private String telefoneComercialAssociado;
    private String celularAssociado;
    private LocalDate dataCadastroAssociado;
    List<Dependente> filhos;
}