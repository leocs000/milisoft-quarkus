package unitins.tp1.dto.calibre;

import jakarta.validation.constraints.NotBlank;

public record CalibreDTO(
    @NotBlank(message = "insira o calibre")
    String calibre
) {

} 
    
