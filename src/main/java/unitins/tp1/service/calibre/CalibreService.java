package unitins.tp1.service.calibre;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.calibre.CalibreDTO;
import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.model.Calibre;

public interface CalibreService {
    public CalibreResponseDTO insert(@Valid CalibreDTO dto);

    public CalibreResponseDTO update(CalibreDTO dto, Long id);

    public void delete(Long id);

    public Calibre findById(Long id);
    
    public List<CalibreResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<CalibreResponseDTO> findByAll(int page, int pageSize);

    public long count();

    public long countByNome(String nome);
}
