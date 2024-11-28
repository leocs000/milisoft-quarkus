package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_tiro")
public class TipoTiro extends DefaultEntity{
    @Column(length = 60)
    private String descricao;
}
