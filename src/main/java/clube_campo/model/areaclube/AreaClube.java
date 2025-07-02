package clube_campo.model.areaclube;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "AreaClube")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idArea")
public class AreaClube {

    @Column (name="area_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idArea;
    private String nomeArea;
    private int qtdeItensArea;
    private String monitorArea;
    private String classificacaoArea;
    private boolean indicadorReservavelArea;

    public AreaClube(DadosCadastroArea dados) {
        this.nomeArea = dados.nomeArea();
        this.qtdeItensArea = dados.qtdeItensArea();
        this.monitorArea = dados.monitorArea();
        this.classificacaoArea = dados.classificacaoArea();
        this.indicadorReservavelArea = dados.indicadorReservavelArea();
    }
    public void atualizarArea(@Valid DadosAtualizacaoArea dados) {
        if (dados.nomeArea() != null) {
            this.nomeArea = dados.nomeArea();
        }
        if (dados.qtdeItensArea() != 0) {
            this.qtdeItensArea = dados.qtdeItensArea();
        }
        if (dados.monitorArea() != null) {
            this.monitorArea = dados.monitorArea();
        }
        if (dados.classificacaoArea() != null) {
            this.classificacaoArea = dados.classificacaoArea();
        }
        if (dados.indicadorReservavelArea() != null) {
            this.indicadorReservavelArea = dados.indicadorReservavelArea();
        }
    }


}
