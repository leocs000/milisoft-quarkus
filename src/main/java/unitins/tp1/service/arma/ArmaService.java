package unitins.tp1.service.arma;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.arma.ArmaDTO;
import unitins.tp1.dto.arma.ArmaResponseDTO;



public interface ArmaService {
    public ArmaResponseDTO insert(@Valid ArmaDTO dto);

    public ArmaResponseDTO update(ArmaDTO dto, Long id);

    public void delete(Long id);

    public ArmaResponseDTO updateNomeImagem(Long id, String nomeImagem) ;

    public ArmaResponseDTO findById(Long id);

    public List<ArmaResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<ArmaResponseDTO> findByAll(int page, int pageSize);
    
    public long count();

    public long countByNome(String nome);
}
