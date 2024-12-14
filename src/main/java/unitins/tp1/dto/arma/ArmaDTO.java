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
    @NotNull(message = "insira o 'Tipo de Arma' corretamente")
    Long idTipoArma;
    
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
            String fabricante,
            String modelo,
            Double peso,

            Long idMaterial,
            Long idCalibre,
            String descricao,
            @NotNull(message = "insira o tipo de arma corretamente") Long idTipoArma,
            Long idAcabamento,
            int capacidadeDeTiro,
            String propulsor,
            String velocidade,
            Long idtipoTiro) {
        super(nome, qtdNoEstoque, preco, descricao, fabricante, modelo, peso, idMaterial, idCalibre);
        this.idTipoArma = idTipoArma;
        this.idAcabamento = idAcabamento;
        this.capacidadeDeTiro = capacidadeDeTiro;
        this.propulsor = propulsor;
        this.velocidade = velocidade;
        this.idtipoTiro = idtipoTiro;


    }

    
}

