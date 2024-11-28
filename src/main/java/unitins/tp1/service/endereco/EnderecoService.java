package unitins.tp1.service.endereco;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.endereco.EnderecoDTO;
import unitins.tp1.dto.endereco.EnderecoResponseDTO;



public interface EnderecoService {
    public EnderecoResponseDTO insert(@Valid EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);
    
    public List<EnderecoResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<EnderecoResponseDTO> findByAll(int page, int pageSize);

    public long count();

    public long countByNome(String nome);
}