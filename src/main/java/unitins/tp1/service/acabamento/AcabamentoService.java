package unitins.tp1.service.acabamento;

import java.util.List;

import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;



public interface AcabamentoService {
    public AcabamentoResponseDTO insert(AcabamentoDTO dto);

    public AcabamentoResponseDTO update(AcabamentoDTO dto, Long id);

    public void delete(Long id);

    public AcabamentoResponseDTO findById(Long id);
    
    public List<AcabamentoResponseDTO> findByNome(String nome);

    public List<AcabamentoResponseDTO> findByAll();
}