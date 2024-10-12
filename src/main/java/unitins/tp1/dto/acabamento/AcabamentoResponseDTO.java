package unitins.tp1.dto.acabamento;

import unitins.tp1.model.Acabamento;

public record AcabamentoResponseDTO(
                Long id,
                String material
                
) {
        public static AcabamentoResponseDTO valueOf(Acabamento acabamento) {
                return new AcabamentoResponseDTO(
                                acabamento.getId(),
                                acabamento.getMaterial()
                                );
        }
}