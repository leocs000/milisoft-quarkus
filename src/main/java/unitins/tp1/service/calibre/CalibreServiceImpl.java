package unitins.tp1.service.calibre;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.calibre.CalibreDTO;
import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.model.Acabamento;
import unitins.tp1.model.Calibre;
import unitins.tp1.repository.AcabamentoRepository;
import unitins.tp1.repository.CalibreRepository;
import unitins.tp1.service.acabamento.AcabamentoService;

@ApplicationScoped
public class CalibreServiceImpl implements CalibreService{
    
    @Inject
    CalibreRepository repository;

    @Override
    public CalibreResponseDTO insert(CalibreDTO dto) {
        Calibre novoCalibre = new Calibre();
        novoCalibre.setCalibre(dto.calibre());
        repository.persist(novoCalibre);
        return CalibreResponseDTO.valueOf(novoCalibre);
    }

    @Override
    @Transactional
    public CalibreResponseDTO update(CalibreDTO dto, Long id) {
        Calibre calibre = repository.findById(id);
        if (calibre != null) {
            calibre.setCalibre(dto.calibre());;
           
        } else
            throw new NotFoundException();

        return CalibreResponseDTO.valueOf(calibre);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public Calibre findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CalibreResponseDTO> findByNome(String calibre, int page, int pageSize) {
        List<Calibre> list = repository.findByCalibre(calibre).page(page, pageSize).list();
        
        return list.stream()
        .map(e -> CalibreResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CalibreResponseDTO> findByAll(int page, int pageSize) {
        List<Calibre> list = repository.findAll().page(page, pageSize).list();

        return list.stream()
                .map(e -> CalibreResponseDTO.valueOf(e)).toList();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public long countByNome(String calibre) {
        return repository.findByCalibre(calibre).count();
    }

}
