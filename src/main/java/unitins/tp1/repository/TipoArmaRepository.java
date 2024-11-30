package unitins.tp1.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.TipoArma;


@ApplicationScoped
public class TipoArmaRepository implements PanacheRepository<TipoArma>{
    public PanacheQuery<TipoArma> findByNome(String nome) {
        return find("UPPER(label) LIKE UPPER(?1)", "%" + nome + "%");
    }

}
