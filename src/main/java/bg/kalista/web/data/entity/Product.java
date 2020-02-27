package bg.kalista.web.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity implements Serializable {

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "specification_name")
    private String specificationName;

    @Column(name = "have_specification_name")
    private boolean haveDeference;

    @OneToMany(mappedBy = "product", targetEntity = Details.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Details> details;


    @OneToMany(mappedBy = "product", targetEntity = Allergens.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Allergens> allergens;


}
