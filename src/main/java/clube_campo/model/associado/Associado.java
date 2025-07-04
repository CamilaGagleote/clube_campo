package clube_campo.model.associado;

import java.time.LocalTime;


import java.time.LocalDate;
import java.util.List;

import clube_campo.model.dependente.DadosCadastroDependente;
import clube_campo.model.dependente.Dependente;
import clube_campo.model.reserva.Reserva;
import clube_campo.model.turma.Turma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


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
    private String estadoEnderecoAssociado;
    private String telefoneResidencialAssociado;
    private String telefoneComercialAssociado;
    private String celularAssociado;
    private LocalDate dataCadastroAssociado;
    private String tipoAssociado;
    private Boolean carteirinhaBloqueada = false;
    @OneToMany(mappedBy = "associado")
    @JsonIgnore
    private List<Dependente> dependentes;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turmaAssociado;

    @OneToMany(mappedBy = "associadoReserva")
    @JsonIgnore
    private List<Reserva> reservasReserva;

    public void atualizarAssociado(DadosAtualizacaoAssociado dados) {
        if (dados.nomeAssociado() != null) this.nomeAssociado = dados.nomeAssociado();
        if (dados.rgAssociado() != null) this.rgAssociado = dados.rgAssociado();
        if (dados.cpfAssociado() != null) this.cpfAssociado = dados.cpfAssociado();
        if (dados.ruaEnderecoAssociado() != null) this.ruaEnderecoAssociado = dados.ruaEnderecoAssociado();
        if (dados.cepEnderecoAssociado() != null) this.cepEnderecoAssociado = dados.cepEnderecoAssociado();
        if (dados.bairroEnderecoAssociado() != null) this.bairroEnderecoAssociado = dados.bairroEnderecoAssociado();
        if (dados.cidadeEnderecoAssociado() != null) this.cidadeEnderecoAssociado = dados.cidadeEnderecoAssociado();
        if (dados.estadoEnderecoAssociado() != null) this.estadoEnderecoAssociado = dados.estadoEnderecoAssociado();
        if (dados.telefoneResidencialAssociado() != null) this.telefoneResidencialAssociado = dados.telefoneResidencialAssociado();
        if (dados.telefoneComercialAssociado() != null) this.telefoneComercialAssociado = dados.telefoneComercialAssociado();
        if (dados.celularAssociado() != null) this.celularAssociado = dados.celularAssociado();
        if (dados.dataCadastroAssociado() != null) this.dataCadastroAssociado = dados.dataCadastroAssociado();
        if(dados.tipoAssociado() != null) this.tipoAssociado = dados.tipoAssociado();
        
    }

    public Associado(DadosCadastroAssociado dados) {
        this.rgAssociado = dados.rgAssociado();
        this.nomeAssociado = dados.nomeAssociado();
        this.cpfAssociado = dados.cpfAssociado();
        this.ruaEnderecoAssociado = dados.ruaEnderecoAssociado();
        this.cepEnderecoAssociado = dados.cepEnderecoAssociado();
        this.bairroEnderecoAssociado = dados.bairroEnderecoAssociado();
        this.cidadeEnderecoAssociado = dados.cidadeEnderecoAssociado();
        this.estadoEnderecoAssociado = dados.estadoEnderecoAssociado();
        this.telefoneResidencialAssociado = dados.telefoneResidencialAssociado();
        this.telefoneComercialAssociado = dados.telefoneComercialAssociado();
        this.celularAssociado = dados.celularAssociado();
        this.dataCadastroAssociado = dados.dataCadastroAssociado();
        this.tipoAssociado = dados.tipoAssociado(); }
}