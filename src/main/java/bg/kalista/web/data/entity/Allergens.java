package bg.kalista.web.data.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "allergens")
@Getter
@Setter
public class Allergens extends BaseEntity implements Serializable {

    @Column(name = "allergen")
    private String allergen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
