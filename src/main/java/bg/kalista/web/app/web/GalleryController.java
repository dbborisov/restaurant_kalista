package bg.kalista.web.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {


    @GetMapping("/gallery")
    String getGallery(){

        return "gallery/gallery";
    }

    @GetMapping("/gallery/edit")
    String editGallery(){

        return "gallery/gallery_edit";
    }


    @GetMapping("/gallery/add")
    String addGallery(){

        return "gallery/gallery_add";
    }
}
