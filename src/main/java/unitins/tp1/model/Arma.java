package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "arma")
public class Arma extends Produto{
    @Column(name="tipo_arma")
    private TipoArma tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_acabamento")
    private Acabamento acabamento;
    
    @Column
    private int capacidadeDeTiro;
    
    @Column
    private String tipoPropulsor;

    @Column
    private String velocidade;

    @ManyToOne
    @JoinColumn(name = "id_tipoTriro")
    private TipoTiro tipoTiro;

    @ManyToOne
    @JoinColumn(name = "id_municao")
    private Municao tipoMunicao;

    @Column(length = 60)
    private String nomeImagem;

}
