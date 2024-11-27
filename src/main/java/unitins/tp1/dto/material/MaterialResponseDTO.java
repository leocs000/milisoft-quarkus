package unitins.tp1.dto.material;

import unitins.tp1.model.Material;

public record MaterialResponseDTO(
    Long id,
    String material
) {
    public static MaterialResponseDTO valueOf(Material material){
        return new MaterialResponseDTO(
            material.getId(),
            material.getMaterial());

    }
} 
