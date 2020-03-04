package bg.kalista.web.service.service;

import bg.kalista.web.app.model.MenuModel;
import bg.kalista.web.app.model.ProductModel;
import bg.kalista.web.data.entity.menu.Product;

import java.util.List;

public interface ProductService {

    Product save(MenuModel menuModel);
    List<ProductModel> getAll();
    List<ProductModel> getByGroup(String group);

    Product findByNameFromDetails(Long id,String name,String fileName);

}
