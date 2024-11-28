package unitins.tp1.service.TipoTiro;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.tipoTiro.TipoTiroDTO;
import unitins.tp1.dto.tipoTiro.TipoTiroResponseDTO;
import unitins.tp1.model.TipoTiro;

public interface TipoTiroService {
    public TipoTiroResponseDTO insert(@Valid TipoTiroDTO dto);

    public TipoTiroResponseDTO update(TipoTiroDTO dto, Long id);

    public void delete(Long id);

    public TipoTiro findById(Long id);
    
    public List<TipoTiroResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<TipoTiroResponseDTO> findByAll(int page, int pageSize);

    public long count();

    public long countByNome(String nome);
}
