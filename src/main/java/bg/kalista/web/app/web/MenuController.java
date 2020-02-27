package bg.kalista.web.app.web;

import bg.kalista.web.app.model.MenuModel;
import bg.kalista.web.service.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    private final ProductService productService;

    public MenuController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/menu")
    public ModelAndView getMenu(){
        ModelAndView modelAndView = new ModelAndView("menu");
        return modelAndView;
    }

    @GetMapping("/menu/add")
    public ModelAndView getMenuAdd(){
        ModelAndView modelAndView = new ModelAndView("menu_add");
        return modelAndView;
    }

    @PostMapping("/menu/add")
    public ModelAndView getMenu(@ModelAttribute MenuModel menuModel){
        this.productService.save(menuModel);
        ModelAndView modelAndView = new ModelAndView("menu_add");
        return modelAndView;
    }


    @GetMapping("/menu/view")
    public ModelAndView getMenuView(){
        ModelAndView modelAndView = new ModelAndView("menu_view");
        return modelAndView;
    }

    @GetMapping("/menu/edit")
    public ModelAndView getEditMenuView(){
        ModelAndView modelAndView = new ModelAndView("menu_edit");
        return modelAndView;
    }

}
