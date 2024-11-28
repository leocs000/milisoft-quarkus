package unitins.tp1.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.model.Funcionario;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {
    public PanacheQuery<Funcionario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%");
    }

    public PanacheQuery<Funcionario> findByMatricula(String matricula) {
        return find("UPPER(matricula) LIKE UPPER(?1) ", "%" + matricula + "%");
    }
}
