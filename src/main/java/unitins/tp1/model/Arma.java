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
    @Column(length = 60)
    private String marca;
    @ManyToOne
    @JoinColumn(name = "id_acabamento")
    private Acabamento acabamento;
    @ManyToOne
    @JoinColumn(name = "id_calibre")
    private Calibre calibre;
    @Column(length = 60)
    private String comprimentoDoCano;
    @Column
    private int capacidadeDeTiro;
    @Column(length = 60)
    private String numeroSigma;
    @Column
    private String numeroDaArma;
    @Column(length = 60)
    private String modelo;
    
    @Column(name="registro_nacional_armas")
    private String rna;

    private String nomeImagem;

}
