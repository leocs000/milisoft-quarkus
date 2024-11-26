package unitins.tp1.service.calibre;

import java.util.List;

import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.calibre.CalibreDTO;
import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.model.Acabamento;
import unitins.tp1.model.Calibre;

public interface CalibreService {
    public CalibreResponseDTO insert(CalibreDTO dto);

    public CalibreResponseDTO update(CalibreDTO dto, Long id);

    public void delete(Long id);

    public Calibre findById(Long id);
    
    public List<CalibreResponseDTO> findByNome(String nome);

    public List<CalibreResponseDTO> findByAll();
}
