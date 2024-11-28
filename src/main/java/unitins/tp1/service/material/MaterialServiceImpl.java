package unitins.tp1.service.material;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.material.MaterialDTO;
import unitins.tp1.dto.material.MaterialResponseDTO;
import unitins.tp1.model.Acabamento;
import unitins.tp1.model.Material;
import unitins.tp1.repository.MaterialRepository;

@ApplicationScoped
public class MaterialServiceImpl implements MaterialService{

    @Inject
    MaterialRepository repository;

    @Override
    public MaterialResponseDTO insert(MaterialDTO dto) {
        Material novoMaterial = new Material();
        novoMaterial.setMaterial(dto.material());
        repository.persist(novoMaterial);
        return MaterialResponseDTO.valueOf(novoMaterial);
    }

    @Override
    public MaterialResponseDTO update(MaterialDTO dto, Long id) {
        Material material = repository.findById(id);
        if (material != null) {
            material.setMaterial(dto.material());;
           
        } else
            throw new NotFoundException();

        return MaterialResponseDTO.valueOf(material);

    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public Material findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MaterialResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> MaterialResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<MaterialResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> MaterialResponseDTO.valueOf(e)).toList();
    }

}
