package unitins.tp1.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import unitins.tp1.dto.itemPedido.ItemPedidoDTO;
import unitins.tp1.dto.pedido.PedidoDTO;
import unitins.tp1.dto.pedido.PedidoResponseDTO;
import unitins.tp1.model.Arma;
import unitins.tp1.model.Cliente;
import unitins.tp1.model.FormaDePagamento;
import unitins.tp1.model.ItemPedido;
import unitins.tp1.model.Pedido;
import unitins.tp1.model.Status;
import unitins.tp1.repository.ArmaRepository;
import unitins.tp1.repository.ClienteRepository;
import unitins.tp1.repository.PedidoRepository;
import unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private ArmaRepository armaRepository;

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @Override
    @Transactional
    public PedidoResponseDTO insert(@Valid PedidoDTO dto, Long idCliente) {

        Pedido pedido = new Pedido();
        Cliente cliente = clienteRepository.findById(idCliente);

        pedido.setDataHora(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setFormaDePagamento(FormaDePagamento.valueOf(dto.idFormaDePagamento()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        double total = 0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();

            item.setArma(armaRepository.findById(itemDTO.idArma()));
            item.setQuantidade((itemDTO.quantidade()));

            if (item.getQuantidade() <= item.getArma().getQtdNoEstoque()) {
                item.getArma().setQtdNoEstoque(item.getArma().getQtdNoEstoque() - item.getQuantidade());
            } else {
                throw new ValidationException("QuantidadeDisponivel", "Quantidade Indisponivel");
            }

            total += calcularValorTotal(item.getArma(), item);
            
            itens.add(item);
        }

        pedido.setItens(itens);
        pedido.setTotalPedido(total);

        pedido.setStatus(Status.PENDENTE);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);

    }

    private double calcularValorTotal(Arma arma, ItemPedido item) {
        double precoarma = arma.getPreco();
        return (precoarma * item.getQuantidade());
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll(int page, int pageSize) {
        List<Pedido> list = pedidoRepository.findAll().page(page, pageSize).list();
        
        return list.stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente, int page, int pageSize) {
        return pedidoRepository.findByCliente(idCliente).page(page, pageSize).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void alterarStatusPagamento(Long id) {
        Pedido pedido = pedidoRepository.findById(id);

        String login = jwt.getSubject();
        String nomeCliente = clienteRepository.findByLogin(login).getNome();

        if (pedido == null) {
            throw new ValidationException("Buscando Pedido", "O Pedido não foi encontrado");
        }

        if (!pedido.getCliente().getNome().equals(nomeCliente)) {
            throw new ValidationException("Verificando...",
                    "Você não tem permissão para alterar o status de pagamento desse");
        }

        if (pedido.getStatus() == Status.PENDENTE) {
            pedido.setStatus(Status.PAGO);
        } else if (pedido.getStatus() == Status.PAGO) {
            throw new ValidationException("Situação:", "Pedido ja esta pago");
        }
    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> meusPedidos(int page, int pageSize) {
        String login = jwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.usuario.login", login).page(page, pageSize).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();

        if (pedidos.isEmpty()) {
            throw new ValidationException("Verificando...", "Você ainda não fez nenhum pedido :(");
        }
        return pedidos;

    }

}