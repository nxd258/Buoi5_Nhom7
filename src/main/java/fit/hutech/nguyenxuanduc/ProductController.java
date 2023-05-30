package fit.hutech.nguyenxuanduc;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String index (Model model)
    {
        model.addAttribute( "listproduct", productService.GetAll());
        return "products/index";
    }
    @GetMapping("/create")
    public String create (Model model)
    {
        model.addAttribute(
     "product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String create (@Valid Product newProduct,
                          @RequestParam MultipartFile imageProduct, BindingResult result,
                          Model model) {
        productService.Add(newProduct);
        return "redirect:/products";}
}