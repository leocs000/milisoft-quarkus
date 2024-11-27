package unitins.tp1.dto.tipoTiro;

import jakarta.validation.constraints.NotBlank;
import unitins.tp1.model.TipoTiro;

public record TipoTiroDTO(
    @NotBlank(message = "insira o nome corretamente")
    String descricao
) {
    public static TipoTiroDTO valueOf(TipoTiro tipoTiro){

        return new TipoTiroDTO(
            tipoTiro.getDescricao()
        );
    }
} 
