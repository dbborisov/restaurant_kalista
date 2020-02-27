package bg.kalista.web.app.rest;

import bg.kalista.web.app.model.ProductModel;
import bg.kalista.web.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadStatus";
    }
}
