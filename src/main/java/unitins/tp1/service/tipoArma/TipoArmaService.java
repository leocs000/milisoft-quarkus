package unitins.tp1.service.tipoArma;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.tipoArma.TipoArmaDTO;
import unitins.tp1.dto.tipoArma.TipoArmaResponseDTO;
import unitins.tp1.model.TipoArma;

public interface TipoArmaService {
    public TipoArmaResponseDTO insert(@Valid TipoArmaDTO dto);

    public TipoArmaResponseDTO update(TipoArmaDTO dto, Long id);

    public void delete(Long id);

    public TipoArma findById(Long id);
    
    public List<TipoArmaResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<TipoArmaResponseDTO> findByAll(int page, int pageSize);

    public long count();

    public long countByNome(String nome);
}
