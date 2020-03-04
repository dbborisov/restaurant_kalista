package bg.kalista.web.app.rest;

import bg.kalista.web.app.model.MenuModel;
import bg.kalista.web.app.model.ProductModel;
import bg.kalista.web.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuRestController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "src/main/resources/static/img/";

    private final ProductService productService;

    public MenuRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/api/all" , produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody Object getCategory(){
        List<ProductModel> all = this.productService.getAll();
        return all;
    }

    @GetMapping(value = "/api/all/group/{name}" , produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody Object getByGroup(@PathVariable String name){
        List<ProductModel> all = this.productService.getByGroup(name);
        return all;
    }


    @PostMapping("/api/update")
    public String singleFileUpload(@ModelAttribute MenuModel menuModel) {

        System.out.println();

        return "uploadStatus";
    }



}
