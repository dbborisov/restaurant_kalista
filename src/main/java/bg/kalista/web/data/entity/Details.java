package bg.kalista.web.data.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "details")
@Getter
@Setter
public class Details extends BaseEntity implements Serializable {

    @Column(name = "detailName")
    private String detailName;

    @Column(name = "price")
    private double price;


    @Column(name = "grams")
    private double grams;

    @Column(name = "small_price")
    private double smallPrice;


    @Column(name = "small_grams")
    private double smallGrams;

    @Column(name = "picture")
    private String picture;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
