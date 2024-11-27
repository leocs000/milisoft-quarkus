package unitins.tp1.dto.arma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ProdutoDTO {
    @NotBlank(message = "insira o nome corretamente")
    String nome;

    @NotNull(message = "insira a qtdNoEstoque corretamente")
    int qtdNoEstoque;

    @NotNull(message = "insira o preco corretamente")
    double preco;

    @NotBlank(message = "insira a descrição corretamente")
    String descricao;
    String fabricante;
    String modelo;
    Double peso;
//    Long idCategoria;
    Long idMaterial;
    Long idCalibre;

    public ProdutoDTO(@NotBlank(message = "insira o nome corretamente") String nome,
                      @NotNull(message = "insira a qtdNoEstoque corretamente") int qtdNoEstoque,
                      @NotNull(message = "insira o preco corretamente") double preco,
                      @NotBlank(message = "insira a descrição corretamente") String descricao,
                      String fabricante,
                      String modelo,
                      Double peso,
  //                    Long idCategoria,
                      Long idMaterial,
                      Long idCalibre) {
        this.nome = nome;
        this.qtdNoEstoque = qtdNoEstoque;
        this.preco = preco;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.peso = peso;
//        this.idCategoria = idCategoria;
        this.idMaterial = idMaterial;
        this.idCalibre = idCalibre;
    }
}

