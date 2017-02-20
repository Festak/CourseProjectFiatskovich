package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.Product;

import java.util.Set;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface ProductService {
    Product findProductById(Long id);
    Set<Product> listProducts();
}
