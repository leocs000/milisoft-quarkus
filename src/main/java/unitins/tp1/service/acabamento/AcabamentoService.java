package unitins.tp1.service.acabamento;

import java.util.List;

import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.model.Acabamento;



public interface AcabamentoService {
    public AcabamentoResponseDTO insert(AcabamentoDTO dto);

    public AcabamentoResponseDTO update(AcabamentoDTO dto, Long id);

    public void delete(Long id);

    public Acabamento findById(Long id);
    
    public List<AcabamentoResponseDTO> findByNome(String nome);

    public List<AcabamentoResponseDTO> findByAll();
}