package unitins.tp1.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.TipoTiro;

@ApplicationScoped
public class TipoTiroRepository implements PanacheRepository<TipoTiro>{
    public List<TipoTiro> findByNome(String nome){
        return find("UPPER(material) LIKE UPPER(?1)", "%" + nome + "%").list();
    }
}
