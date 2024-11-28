package unitins.tp1.service.funcionario;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.funcionario.FuncionarioDTO;
import unitins.tp1.dto.funcionario.FuncionarioResponseDTO;


public interface FuncionarioService {
        public FuncionarioResponseDTO insert(@Valid FuncionarioDTO dto);

    public FuncionarioResponseDTO update(FuncionarioDTO dto, Long id);

    public void delete(Long id);

    public FuncionarioResponseDTO findById(Long id);

    public List<FuncionarioResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<FuncionarioResponseDTO> findByAll(int page, int pageSize); 

    public List<FuncionarioResponseDTO> findByMatricula(String matricula, int page, int pageSize);

    public long count();

    public long countByNome(String nome);
}
