package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Produto extends DefaultEntity{
    
    @Column(length = 60)
    private String nome;

    @Column(length = 60)
    private int qtdNoEstoque;

    @Column(length = 60)
    private Double preco;

    @Column(length = 400)
    private String descricao;

    @Column(length = 60)
    private String fabricante;

    @Column(length = 60)
    private String modelo;

    @Column(length = 60)
    private Double peso;

    // @ManyToOne
    // @JoinColumn(name = "id_categoria")
    // private Categoria categoria;

    
    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    
    @ManyToOne
    @JoinColumn(name = "id_calibre")
    private Calibre calibre;
}