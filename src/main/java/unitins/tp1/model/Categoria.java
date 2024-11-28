package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Categoria extends DefaultEntity{

//    @Column(length = 60)
    private String descricao;
}
