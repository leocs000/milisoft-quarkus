package unitins.tp1.dto.arma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ArmaDTO extends ProdutoDTO {
    @NotNull(message = "insira o tipo de arma corretamente")
    int tipo;
    @NotBlank(message = "insira o 'acabamento' corretamente")
    Long idAcabamento;
    @NotNull(message = "insira o 'capacidade de tiro' corretamente")
    int capacidadeDeTiro;
    @NotNull(message = "insira o tipo de 'Propulsor' corretamente")
    String propulsor;
    @NotNull(message = "insira a 'Velocidade' corretamente")
    String velocidade;
    @NotNull(message = "insira o 'tipo de tiro' corretamente")
    Long idtipoTiro;


    public ArmaDTO(@NotBlank(message = "insira o nome corretamente") String nome,
            @NotNull(message = "insira a qtdNoEstoque corretamente") int qtdNoEstoque,
            @NotNull(message = "insira o preco corretamente") double preco,
            @NotNull(message = "insira o Fabricante corretamente") String fabricante,
            @NotNull(message = "insira o modelo corretamente") String modelo,
            @NotNull(message = "insira o modelo corretamente") Double peso,
//            @NotNull(message = "insira a categoria corretamente") Long idCategoria,
            @NotNull(message = "insira o preco corretamente") Long idMaterial,
            @NotNull(message = "insira o preco corretamente") Long idCalibre,
            @NotBlank(message = "insira a descrição corretamente") String descricao,
            @NotNull(message = "insira o tipo de arma corretamente") int tipo,
            @NotBlank(message = "insira o 'acabamento' corretamente") Long idAcabamento,
            @NotNull(message = "insira o 'capacidade de tiro' corretamente") int capacidadeDeTiro,
            @NotNull(message = "insira o tipo de 'Propulsor' corretamente") String propulsor,
            @NotNull(message = "insira a 'Velocidade' corretamente") String velocidade,
            @NotNull(message = "insira o 'tipo de tiro' corretamente") Long idtipoTiro) {
        super(nome, qtdNoEstoque, preco, descricao, fabricante, modelo, peso, /*idCategoria,*/ idMaterial, idCalibre);
        this.tipo = tipo;
        this.idAcabamento = idAcabamento;
        this.capacidadeDeTiro = capacidadeDeTiro;
        this.propulsor = propulsor;
        this.velocidade = velocidade;
        this.idtipoTiro = idtipoTiro;
    }

    
}

