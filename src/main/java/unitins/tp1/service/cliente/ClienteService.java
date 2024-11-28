package unitins.tp1.service.cliente;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.cliente.ClienteDTO;
import unitins.tp1.dto.cliente.ClienteResponseDTO;
import unitins.tp1.dto.endereco.EnderecoDTO;
import unitins.tp1.dto.endereco.EnderecoResponseDTO;



public interface ClienteService {
    
    public ClienteResponseDTO insert(@Valid ClienteDTO dto);

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public EnderecoResponseDTO insetEndereco(EnderecoDTO dto, Long id);
    
    public String insetTelefone(String telefone, Long id);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public ClienteResponseDTO findByUsuario(String login);

    public List<ClienteResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<ClienteResponseDTO> findByAll(int page, int pageSize); 

    public long count();

    public long countByNome(String nome);

}