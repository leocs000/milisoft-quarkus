package unitins.tp1.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.Calibre;

@ApplicationScoped
public class CalibreRepository implements PanacheRepository<Calibre>{
    public PanacheQuery<Calibre> findByCalibre(String calibre) {
        return find("UPPER(calibre) LIKE UPPER(?1)", "%" + calibre + "%");
    }
}
