package unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Municao extends Produto{

//    @Column(length = 20)
    private String cor;
}
