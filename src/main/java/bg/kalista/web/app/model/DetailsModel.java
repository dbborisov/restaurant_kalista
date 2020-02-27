package bg.kalista.web.app.model;

import bg.kalista.web.data.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class DetailsModel implements Serializable {

    private Long id;

    private String detailName;

    private String picture;

    private double price;
    private double grams;
    private double smallPrice;
    private double smallGrams;

//    private ProductModel product;
}
