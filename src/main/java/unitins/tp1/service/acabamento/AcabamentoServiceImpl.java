package unitins.tp1.service.acabamento;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.model.Acabamento;
import unitins.tp1.repository.AcabamentoRepository;


@ApplicationScoped
public class AcabamentoServiceImpl implements AcabamentoService {

    @Inject
    AcabamentoRepository repository;

    @Override
    public AcabamentoResponseDTO insert(@Valid AcabamentoDTO dto) {
        Acabamento novoAcabamento = new Acabamento();
        novoAcabamento.setMaterial(dto.material());
        repository.persist(novoAcabamento);
        return AcabamentoResponseDTO.valueOf(novoAcabamento);
    }

    @Override
    @Transactional
    public AcabamentoResponseDTO update(AcabamentoDTO dto, Long id) {
        Acabamento acabamento = repository.findById(id);
        if (acabamento != null) {
            acabamento.setMaterial(dto.material());;
           
        } else
            throw new NotFoundException();

        return AcabamentoResponseDTO.valueOf(acabamento);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public Acabamento findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AcabamentoResponseDTO> findByNome(String nome, int page, int pageSize) {
        List<Acabamento> list = repository.findByNome(nome).page(page, pageSize).list();
        return list.stream()
                .map(e -> AcabamentoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<AcabamentoResponseDTO> findByAll(int page, int pageSize) {
        List<Acabamento> list = repository.findAll().page(page, pageSize).list();
        return list.stream().map(e -> AcabamentoResponseDTO.valueOf(e)).toList();
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