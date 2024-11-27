package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubCategoria extends Categoria{

    @Column(length = 60)
    private Categoria Categoria;
}
