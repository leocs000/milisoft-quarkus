package unitins.tp1.dto.tipoTiro;

import unitins.tp1.model.TipoTiro;

public record TipoTiroResponseDTO(
    Long id,
    String descricao
) {
    public static TipoTiroResponseDTO valueOf(TipoTiro tipoTiro){
        return new TipoTiroResponseDTO(
            tipoTiro.getId(), 
            tipoTiro.getDescricao());
    }
} 
