package bg.kalista.web.app.model;

import bg.kalista.web.data.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class AllergensModel implements Serializable {
    private String allergen;

//    private ProductModel product;
}
