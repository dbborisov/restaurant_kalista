package bg.kalista.web.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuModel {

    public String categoryName;
    public String groupName;
    public String productName;
    public String typesName;

    private double grams;
    private double price;
    private double smallGrams;
    private double smallPrice;
    private String allergens;

}
