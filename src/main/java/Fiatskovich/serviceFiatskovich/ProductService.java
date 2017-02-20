package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;

import java.util.Set;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface ProductService {
    Product findProductById(Long id);
    Set<Product> listProducts();
    ProductViewModel productToProductViewModelById(Long id);
    Set<ProductViewModel> getAllProducts();
}
