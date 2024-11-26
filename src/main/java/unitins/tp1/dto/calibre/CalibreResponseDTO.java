package unitins.tp1.dto.calibre;

import unitins.tp1.model.Calibre;

public record CalibreResponseDTO(
    String calibre
) {
    public static CalibreResponseDTO valueOf(Calibre calibre){
        return new CalibreResponseDTO(
            calibre.getCalibre());
    }
} 


