package bg.kalista.web.service.service.impl;

import bg.kalista.web.app.model.MenuModel;
import bg.kalista.web.app.model.ProductModel;
import bg.kalista.web.data.entity.Allergens;
import bg.kalista.web.data.entity.Details;
import bg.kalista.web.data.entity.Product;
import bg.kalista.web.data.repository.ProductRepository;
import bg.kalista.web.service.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product save(MenuModel parameter) {
        Product product = this.productRepository.findByCategoryNameAndSpecificationName(parameter.getCategoryName(),parameter.getGroupName());



        if(product == null){
            product = new Product();
            product.setProductName(parameter.getCategoryName());
            product.setSpecificationName(parameter.getGroupName());
            product.setAllergens(new ArrayList<>());
            product.setDetails(new ArrayList<>());
        }



        String[] split = parameter.getAllergens().split(",");

        for (int i = 0; i < split.length; i++) {
            Allergens allergens = new Allergens();
            allergens.setAllergen(split[i]);
            allergens.setProduct(product);
            product.getAllergens().add(allergens);
        }

        Details details = new Details();

        details.setDetailName(parameter.getProductName());
        details.setGrams(parameter.getGrams());
        details.setSmallGrams(parameter.getSmallGrams());
        details.setPrice(parameter.getPrice());
        details.setSmallPrice(parameter.getSmallPrice());
        details.setProduct(product);


        product.getDetails().add(details);
//        product.setHaveDeference(true);

        product.setCategoryName(parameter.getCategoryName());
//        product.setProductName(parameter.getProductName());
//        product.setSpecificationName(parameter.getGroupName());

        return this.productRepository.save(product);
    }

    @Override
    public List<ProductModel> getAll() {
        List<ProductModel> collect = this.productRepository.findAll().stream().map(e -> modelMapper.map(e, ProductModel.class)).collect(Collectors.toList());
        return collect ;
    }


    @Override
    public List<ProductModel> getByGroup(String group) {

        return  this.productRepository.findByCategoryName(group).stream().map(e -> modelMapper.map(e, ProductModel.class)).collect(Collectors.toList());
    }


}
