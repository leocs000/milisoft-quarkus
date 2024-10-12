package unitins.tp1.dto.acabamento;

import jakarta.validation.constraints.NotBlank;
import unitins.tp1.model.Acabamento;


public record AcabamentoDTO(
        @NotBlank(message = "insira o nome corretamente")
        String material
        ) {
    public static AcabamentoDTO valueOf(Acabamento acabamento) {
        return new AcabamentoDTO(
            acabamento.getMaterial());
    }
}