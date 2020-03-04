package bg.kalista.web.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {


    private Long id;

    private String categoryName;


    private String productName;

    private String specificationName;


    private boolean haveDeference;


    List<DetailsModel> details;

    List<AllergensModel> allergens;

}
