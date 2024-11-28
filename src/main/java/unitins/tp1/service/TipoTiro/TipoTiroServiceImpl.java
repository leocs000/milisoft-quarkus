package unitins.tp1.service.TipoTiro;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.tipoTiro.TipoTiroDTO;
import unitins.tp1.dto.tipoTiro.TipoTiroResponseDTO;
import unitins.tp1.model.Acabamento;
import unitins.tp1.model.TipoTiro;
import unitins.tp1.repository.TipoTiroRepository;

@ApplicationScoped
public class TipoTiroServiceImpl implements TipoTiroService{

    @Inject
    TipoTiroRepository repository;

    @Override
    public TipoTiroResponseDTO insert(TipoTiroDTO dto) {
        TipoTiro novoTipoTiro = new TipoTiro();
        novoTipoTiro.setDescricao(dto.descricao());
        repository.persist(novoTipoTiro);
        return TipoTiroResponseDTO.valueOf(novoTipoTiro);
    }

    @Override
    @Transactional
    public TipoTiroResponseDTO update(TipoTiroDTO dto, Long id) {
        TipoTiro tipoTiro = repository.findById(id);
        if (tipoTiro != null) {
            tipoTiro.setDescricao(dto.descricao());;
           
        } else
            throw new NotFoundException();

        return TipoTiroResponseDTO.valueOf(tipoTiro);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public TipoTiro findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TipoTiroResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> TipoTiroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TipoTiroResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> TipoTiroResponseDTO.valueOf(e)).toList();
    }

}
