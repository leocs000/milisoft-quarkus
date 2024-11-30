package unitins.tp1.dto.tipoArma;

import jakarta.validation.constraints.NotBlank;
import unitins.tp1.model.TipoArma;

public record TipoArmaDTO(
        @NotBlank(message = "insira a descricao corretamente")
        String descricao
        ) {
    public static TipoArmaDTO valueOf(TipoArma tipoArma) {
        return new TipoArmaDTO(
            tipoArma.getDescricao());
    }
}
