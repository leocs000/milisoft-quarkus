package unitins.tp1.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.Acabamento;

@ApplicationScoped
public class AcabamentoRepository implements PanacheRepository<Acabamento> {
    public PanacheQuery<Acabamento> findByNome(String nome) {
        return find("UPPER(material) LIKE UPPER(?1)", "%" + nome + "%");
    }
}