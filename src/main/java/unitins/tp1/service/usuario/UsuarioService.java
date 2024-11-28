package unitins.tp1.service.usuario;

import java.util.List;

import jakarta.validation.Valid;
import unitins.tp1.dto.usuario.UsuarioDTO;
import unitins.tp1.dto.usuario.UsuarioResponseDTO;
import unitins.tp1.dto.usuario.alterarLoginUsuarioDTO;
import unitins.tp1.dto.usuario.alterarSenhaUsuarioDTO;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public UsuarioResponseDTO alterarSenha(alterarSenhaUsuarioDTO alterarSenhaUsuarioDTO, String senha);
    
    public UsuarioResponseDTO alterarLogin(alterarLoginUsuarioDTO alterarLoginUsuarioDTO, String login);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome, int page, int pageSize);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll(int page, int pageSize);
    
    public UsuarioResponseDTO findMyUser();

    public long count();

    public long countByNome(String nome);

}