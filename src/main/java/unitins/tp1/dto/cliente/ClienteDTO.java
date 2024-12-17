package unitins.tp1.dto.cliente;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import unitins.tp1.dto.endereco.EnderecoDTO;

public record ClienteDTO(
        
        String nome,
        
        @NotBlank(message = "O campo 'CPF' não pode estar em branco")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
        String cpf,
        
        @NotBlank(message = "O campo 'e-mail' não pode estar em branco")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
        String email,
       
        String numeroRegistro_posse_porte,
       
        //List<String> listaTelefones,
        
        List<EnderecoDTO> listaEnderecos,
        
        @NotNull(message = "O campo login não pode ficar em branco")
        String login,
        
        @NotNull(message = "O campo senha não pode ficar em branco")
        String senha){       
}