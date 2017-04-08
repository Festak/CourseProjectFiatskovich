package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;

import java.util.Set;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface ProductService {
    void removeProductById(Long id);
    ProductViewModel findProductById(Long id);
    Set<Product> listProducts();
    ProductViewModel productToProductViewModelById(Long id);
    Set<ProductViewModel> getAllProducts();
    Set<ProductViewModel> getCountOfProducts(int count);
    Set<ProductViewModel> getAllProductsByCategoryId(int id);
    Set<ProductViewModel> getProductsByProductName(String name);
    void addProductViewModelToDataBase(ProductViewModel product);
    void editProduct(ProductViewModel product);
    void setRatingToProduct(long id, int rating);

}
