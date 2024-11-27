package unitins.tp1.dto.arma;

import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.dto.material.MaterialResponseDTO;
import unitins.tp1.model.Calibre;
import unitins.tp1.model.Categoria;
import unitins.tp1.model.Material;
import unitins.tp1.model.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco,
        int qtdNoEstoque,
        String fabricante,
        String modelo,
 //       CategoriaResponseDTO categoria,
        MaterialResponseDTO material,
        CalibreResponseDTO calibre) {
    public static ProdutoResponseDTO valueOf(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQtdNoEstoque(),
                produto.getFabricante(),
                produto.getModelo(),
 //               CategoriaResponseDTO.valueOf(produto.getCategoria()),
                MaterialResponseDTO.valueOf(produto.getMaterial()),
                CalibreResponseDTO.valueOf(produto.getCalibre()));
    }
}
