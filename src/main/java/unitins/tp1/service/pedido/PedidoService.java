package unitins.tp1.service.pedido;

import java.util.List;

import unitins.tp1.dto.pedido.PedidoDTO;
import unitins.tp1.dto.pedido.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

        public PedidoResponseDTO insert(@Valid PedidoDTO dto, Long idCliente);
        public PedidoResponseDTO findById(Long id);
        public List<PedidoResponseDTO> findAll();
        public List<PedidoResponseDTO> findByCliente(Long idCliente);
    
        public void alterarStatusPagamento(Long id);
    
        public List<PedidoResponseDTO> meusPedidos();
    
    }