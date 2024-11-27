package unitins.tp1.dto.material;

import jakarta.validation.constraints.NotBlank;
import unitins.tp1.model.Material;

public record MaterialDTO(

    @NotBlank(message = "insira o nome corretamente")
    String material

) {

    public static MaterialDTO valueOf(Material material){
        return new MaterialDTO(
            material.getMaterial()
        );
    }
} 
