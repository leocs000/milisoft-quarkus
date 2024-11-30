package unitins.tp1.dto.tipoArma;

import unitins.tp1.model.TipoArma;

public record TipoArmaResponseDTO(
                Long id,
                String descricao 
) {
    public static  TipoArmaResponseDTO valueOf(TipoArma tipoArma){
        return new TipoArmaResponseDTO(
                    tipoArma.getId(), 
                    tipoArma.getDescricao());
    }
}
