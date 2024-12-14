package unitins.tp1.service.arma;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import unitins.tp1.dto.arma.ArmaDTO;
import unitins.tp1.dto.arma.ArmaResponseDTO;
import unitins.tp1.model.Arma;
import unitins.tp1.repository.ArmaRepository;
import unitins.tp1.service.TipoTiro.TipoTiroService;
import unitins.tp1.service.acabamento.AcabamentoService;
import unitins.tp1.service.calibre.CalibreService;
import unitins.tp1.service.material.MaterialService;
import unitins.tp1.service.tipoArma.TipoArmaService;


@ApplicationScoped
public class ArmaServiceImpl implements ArmaService {
    @Inject
    ArmaRepository repository;

    @Inject
    AcabamentoService acabamentoService;

    @Inject
    CalibreService calibreService;

    @Inject
    MaterialService materialService;

    @Inject
    TipoTiroService tipoTiroService;

    @Inject
    TipoArmaService tipoArmaService;

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
            novaArma.setMaterial(materialService.findById(dto.getIdMaterial()));
            novaArma.setCalibre(calibreService.findById(dto.getIdCalibre()));
            novaArma.setTipoArma(tipoArmaService.findById(dto.getIdTipoArma()));
            novaArma.setAcabamento(acabamentoService.findById(dto.getIdAcabamento()));
            novaArma.setCapacidadeDeTiro(dto.getCapacidadeDeTiro());
            novaArma.setPropulsor(dto.getPropulsor());
            novaArma.setVelocidade(dto.getVelocidade());
            novaArma.setTipoTiro(tipoTiroService.findById(dto.getIdtipoTiro()));

        repository.persist(novaArma);

        return ArmaResponseDTO.valueOf(novaArma);
    }

    @Override
    @Transactional
    public ArmaResponseDTO update(ArmaDTO dto, Long id) {
        Arma arma = (Arma) repository.findById(id);
        if (arma != null) {
            arma.setNome(dto.getNome());
            arma.setQtdNoEstoque(dto.getQtdNoEstoque());
            arma.setPreco(dto.getPreco());
            arma.setDescricao(dto.getDescricao());
            arma.setFabricante(dto.getFabricante());
            arma.setModelo(dto.getModelo());
            arma.setPeso(dto.getPeso());
            arma.setMaterial(materialService.findById(dto.getIdMaterial()));
            arma.setCalibre(calibreService.findById(dto.getIdCalibre()));
            arma.setTipoArma(tipoArmaService.findById(dto.getIdTipoArma()));
            arma.setAcabamento(acabamentoService.findById(dto.getIdAcabamento()));
            arma.setCapacidadeDeTiro(dto.getCapacidadeDeTiro());
            arma.setPropulsor(dto.getPropulsor());
            arma.setVelocidade(dto.getVelocidade());
            arma.setTipoTiro(tipoTiroService.findById(dto.getIdtipoTiro()));
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
    public List<ArmaResponseDTO> findByNome(String nome, int page, int pageSize) {
        if(nome != null || nome == ""){
            List<Arma> list = repository.findByNome(nome).page(page, pageSize).list();

            return list.stream().map(p -> ArmaResponseDTO.valueOf(p)).toList();
        }
        throw new NotFoundException("Nome não encontrado!");
    }

    @Override
    public List<ArmaResponseDTO> findByAll(int page, int pageSize) {
        List<Arma> list = repository.findAll().page(page, pageSize).list();
        return list.stream().map(p -> ArmaResponseDTO.valueOf(p)).toList();
    }

    @Override
    @Transactional
    public ArmaResponseDTO updateNomeImagem(Long id, String nomeImagem) {

        System.out.println(nomeImagem + id);
        
        Arma arma = repository.findById(id);
        arma.setNomeImagem(nomeImagem);

        ArmaResponseDTO armas = ArmaResponseDTO.valueOf(arma);
        System.out.println(arma.getNomeImagem());
        return ArmaResponseDTO.valueOf(arma);
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
