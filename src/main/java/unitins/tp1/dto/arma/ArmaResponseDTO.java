package unitins.tp1.dto.arma;

import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.dto.material.MaterialResponseDTO;
import unitins.tp1.dto.tipoTiro.TipoTiroResponseDTO;
import unitins.tp1.model.Arma;
import unitins.tp1.model.TipoArma;

public record ArmaResponseDTO(
    Long id,
    String nome,
    String descricao,
    Double preco,
    int qtdNoEstoque,
    String fabricante,
    String modelo,
//    CategoriaResponseDTO categoria,
    MaterialResponseDTO material,
    CalibreResponseDTO calibre,
    TipoArma tipo,
    AcabamentoResponseDTO acabamento,
    Double peso,
    String propulsor,
    TipoTiroResponseDTO tipoTiro,
    String velocidade,
    int capacidadeDeTiro,
    String nomeImagem
    ){
        public static ArmaResponseDTO valueOf(Arma arma){
            return new ArmaResponseDTO(
                arma.getId(),
                arma.getNome(),
                arma.getDescricao(),
                arma.getPreco(),
                arma.getQtdNoEstoque(),
                arma.getFabricante(),
                arma.getModelo(),
                MaterialResponseDTO.valueOf(arma.getMaterial()),
                CalibreResponseDTO.valueOf(arma.getCalibre()),
                arma.getTipo(),
                AcabamentoResponseDTO.valueOf(arma.getAcabamento()),
                arma.getPeso(),
                arma.getPropulsor(),
                TipoTiroResponseDTO.valueOf(arma.getTipoTiro()),
                arma.getVelocidade(),
                arma.getCapacidadeDeTiro(),
                arma.getNomeImagem());                  
    }
}
