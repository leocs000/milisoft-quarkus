package unitins.tp1.service.tipoArma;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.tipoArma.TipoArmaDTO;
import unitins.tp1.dto.tipoArma.TipoArmaResponseDTO;
import unitins.tp1.model.TipoArma;
import unitins.tp1.repository.TipoArmaRepository;

@ApplicationScoped
public class TipoArmaServiceImpl implements TipoArmaService{
    @Inject
    TipoArmaRepository repository;

    @Override
    public TipoArmaResponseDTO insert(@Valid TipoArmaDTO dto) {
        TipoArma novoTipoArma = new TipoArma();
        novoTipoArma.setDescricao(dto.descricao());
        repository.persist(novoTipoArma);
        return TipoArmaResponseDTO.valueOf(novoTipoArma);
    }

    @Override
    @Transactional
    public TipoArmaResponseDTO update(TipoArmaDTO dto, Long id) {
        TipoArma tipoarma = repository.findById(id);
        if (tipoarma != null) {
            tipoarma.setDescricao(dto.descricao());;
           
        } else
            throw new NotFoundException();

        return TipoArmaResponseDTO.valueOf(tipoarma);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public TipoArma findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TipoArmaResponseDTO> findByNome(String nome, int page, int pageSize) {
        List<TipoArma> list = repository.findByNome(nome).page(page, pageSize).list();
        return list.stream()
                .map(e -> TipoArmaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TipoArmaResponseDTO> findByAll(int page, int pageSize) {
        List<TipoArma> list = repository.findAll().page(page, pageSize).list();
        return list.stream().map(e -> TipoArmaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public long countByNome(String nome) {
        return repository.findByNome(nome).count();
    }
}
