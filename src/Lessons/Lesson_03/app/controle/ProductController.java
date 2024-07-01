package Lessons.Lesson_03.app.controle;
import Lessons.Lesson_03.app.model.Product;
import Lessons.Lesson_03.app.service.ProductService;
import org.springframework.stereotype.Component;
import java.util.List;




@Component
public class ProductController {
    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }


    public Product getProductByID(Long id) {
        return service.findById(id);
    }

}
