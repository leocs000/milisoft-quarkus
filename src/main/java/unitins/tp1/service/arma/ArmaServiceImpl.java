package unitins.tp1.service.arma;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.arma.ArmaDTO;
import unitins.tp1.dto.arma.ArmaResponseDTO;
import unitins.tp1.model.Arma;
import unitins.tp1.model.TipoArma;
import unitins.tp1.repository.ArmaRepository;
import unitins.tp1.service.acabamento.AcabamentoService;
import unitins.tp1.service.calibre.CalibreService;

@ApplicationScoped
public class ArmaServiceImpl implements ArmaService {
    @Inject
    ArmaRepository repository;

    @Inject
    AcabamentoService acabamentoService;

    @Inject
    CalibreService calibreService;

    @Override
    @Transactional
    public ArmaResponseDTO insert(ArmaDTO dto) {
        Arma novaArma = new Arma();
            novaArma.setNome(dto.getNome());
            novaArma.setQtdNoEstoque(dto.getQtdNoEstoque());
            novaArma.setPreco(dto.getPreco());
            novaArma.setDescricao(dto.getDescricao());
            novaArma.setFabricante(dto.getFabricante());
            novaArma.setModelo(dto.getModelo());
            novaArma.setPeso(dto.getPeso());
            novaArma.setTipo(TipoArma.valueOf(dto.getTipo()));
            novaArma.setAcabamento(acabamentoService.findById(dto.getIdAcabamento()));
            novaArma.setCalibre(calibreService.findById(dto.getIdCalibre()));
            novaArma.setCapacidadeDeTiro(dto.getCapacidadeDeTiro());

        repository.persist(novaArma);

        return ArmaResponseDTO.valueOf(novaArma);
    }

    @Override
    @Transactional
    public ArmaResponseDTO update(ArmaDTO dto, Long id) {

        Arma arma = (Arma) repository.findById(id);
        if (arma != null) {
            arma.setNome(dto.getNome());
            arma.setDescricao(dto.getDescricao());
            arma.setPreco(dto.getPreco());
            arma.setQtdNoEstoque(dto.getQtdNoEstoque());
            arma.setTipo(TipoArma.valueOf(dto.getTipo()));
            arma.setAcabamento(acabamentoService.findById(dto.getIdAcabamento()));
            arma.setCalibre(calibreService.findById(dto.getIdCalibre()));
            arma.setCapacidadeDeTiro(dto.getCapacidadeDeTiro());
            arma.setFabricante(dto.getFabricante());
            arma.setModelo(dto.getModelo());
        } else
            throw new NotFoundException();
        return ArmaResponseDTO.valueOf(arma);
    }


    //TRATAR ERRO DE ID INVALIDO
    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
        throw new NotFoundException("Arma não encontrada para o ID: " + id);
    }

    @Override
    public ArmaResponseDTO findById(Long id) {
        if(repository.findById(id) != null)
            return ArmaResponseDTO.valueOf(repository.findById(id));
        else{
            throw new NotFoundException("Arma não encontrada para o ID: " + id);
        }
    }

    @Override
    public List<ArmaResponseDTO> findByNome(String nome) {
        if(nome != null || nome == ""){
        return repository.findByNome(nome).stream()
            .map(p -> ArmaResponseDTO.valueOf(p)).toList();
        }
        throw new NotFoundException("Nome não encontrado!");
    }

    @Override
    public List<ArmaResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(p -> ArmaResponseDTO.valueOf(p)).toList();
    }

    @Override
    public ArmaResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Arma arma = repository.findById(id);
        arma.setNomeImagem(nomeImagem);
        return ArmaResponseDTO.valueOf(arma);
    }
    
}
