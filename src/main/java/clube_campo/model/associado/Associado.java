package clube_campo.model.associado;

import java.time.LocalTime;


import java.time.LocalDate;
import java.util.List;

import clube_campo.model.dependente.Dependente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "associado")
    private List<Dependente> dependentes;

    public void atualizarAssociado(DadosAtualizacaoAssociado dados) {
        if (dados.nomeAssociado() != null) this.nomeAssociado = dados.nomeAssociado();
        if (dados.rgAssociado() != null) this.rgAssociado = dados.rgAssociado();
        if (dados.cpfAssociado() != null) this.cpfAssociado = dados.cpfAssociado();
        if (dados.ruaEnderecoAssociado() != null) this.ruaEnderecoAssociado = dados.ruaEnderecoAssociado();
        if (dados.cepEnderecoAssociado() != null) this.cepEnderecoAssociado = dados.cepEnderecoAssociado();
        if (dados.bairroEnderecoAssociado() != null) this.bairroEnderecoAssociado = dados.bairroEnderecoAssociado();
        if (dados.cidadeEnderecoAssociado() != null) this.cidadeEnderecoAssociado = dados.cidadeEnderecoAssociado();
        if (dados.telefoneResidencialAssociado() != null) this.telefoneResidencialAssociado = dados.telefoneResidencialAssociado();
        if (dados.telefoneComercialAssociado() != null) this.telefoneComercialAssociado = dados.telefoneComercialAssociado();
        if (dados.celularAssociado() != null) this.celularAssociado = dados.celularAssociado();
        if (dados.dataCadastroAssociado() != null) this.dataCadastroAssociado = dados.dataCadastroAssociado();
    }

    public Associado(DadosCadastroAssociado dados) {
        this.rgAssociado = dados.rgAssociado();
        this.nomeAssociado = dados.nomeAssociado();
        this.cpfAssociado = dados.cpfAssociado();
        this.ruaEnderecoAssociado = dados.ruaEnderecoAssociado();
        this.cepEnderecoAssociado = dados.cepEnderecoAssociado();
        this.bairroEnderecoAssociado = dados.bairroEnderecoAssociado();
        this.cidadeEnderecoAssociado = dados.cidadeEnderecoAssociado();
        this.telefoneResidencialAssociado = dados.telefoneResidencialAssociado();
        this.telefoneComercialAssociado = dados.telefoneComercialAssociado();
        this.celularAssociado = dados.celularAssociado();
        this.dataCadastroAssociado = dados.dataCadastroAssociado();
    }
}