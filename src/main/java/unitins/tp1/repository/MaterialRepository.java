package unitins.tp1.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.Material;

@ApplicationScoped
public class MaterialRepository implements PanacheRepository<Material>{
    public List<Material> findByNome(String nome){
        return find("UPPER(material) LIKE UPPER(?1)", "%" + nome + "%").list();
    }
}
