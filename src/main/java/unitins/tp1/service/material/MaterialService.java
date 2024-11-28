package unitins.tp1.service.material;

import java.util.List;

import unitins.tp1.dto.material.MaterialDTO;
import unitins.tp1.dto.material.MaterialResponseDTO;
import unitins.tp1.model.Material;

public interface MaterialService {

    public MaterialResponseDTO insert(MaterialDTO dto);

    public MaterialResponseDTO update(MaterialDTO dto, Long id);

    public void delete(Long id);

    public Material findById(Long id);

    public List<MaterialResponseDTO> findByNome(String nome);
    
    public List<MaterialResponseDTO> findByAll();
}
