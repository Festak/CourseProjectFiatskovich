package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.ProductDao;
import Fiatskovich.modelFiatskovich.Advantage;
import Fiatskovich.modelFiatskovich.Category;
import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.viewmodelFiatskovich.AdvantageViewModel;
import Fiatskovich.viewmodelFiatskovich.CategoryViewModel;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;

/**
 * Created by Евгений on 20.02.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public Product findProductById(Long id) {
        return productDao.findOne(id);
    }

    @Override
    public Set<Product> listProducts() {
        Set<Product> set = new HashSet<Product>(productDao.findAll());
        return set;
    }

    @Override
    @Transactional
    public ProductViewModel productToProductViewModelById(Long id) {
        Product product = productDao.findOne(id);
        ProductViewModel model = new ProductViewModel(product.getId(),product.getName(),
                product.getWeight(),product.getTemperature(),product.getMemory(),product.getPrice(),
                product.getImageUrl());
        model.setAdvantages(initAdvantagesViewModel(product.getAdvantages()));
        model.setCategories(initCategoriesViewModel(product.getCategories()));
        return model;
    }

    @Override
    public Set<ProductViewModel> getAllProducts() {
        Set<Product> products = new HashSet<Product>(productDao.findAll());
        Set<ProductViewModel> models = new HashSet<ProductViewModel>();
        for(Product product: products){
            ProductViewModel temp = productToProductViewModel(product);
            models.add(temp);
        }
        return models;
    }

    private ProductViewModel productToProductViewModel(Product product) {
        ProductViewModel model = new ProductViewModel(product.getId(),product.getName(),
                product.getWeight(),product.getTemperature(),product.getMemory(),product.getPrice(),
                product.getImageUrl());
        model.setAdvantages(initAdvantagesViewModel(product.getAdvantages()));
        model.setCategories(initCategoriesViewModel(product.getCategories()));
        return model;
    }

    private Set<AdvantageViewModel> initAdvantagesViewModel(Set<Advantage> advantages){
        Set<AdvantageViewModel> model = new HashSet<AdvantageViewModel>();
        for (Advantage advantage: advantages) {
            model.add(new AdvantageViewModel(advantage.getId(),advantage.getDescription()));
        }
        return  model;
    }

    private Set<CategoryViewModel> initCategoriesViewModel(Set<Category> categories){
        Set<CategoryViewModel> model = new HashSet<CategoryViewModel>();
        for (Category category: categories) {
            model.add(new CategoryViewModel(category.getId(),category.getName()));
        }
        return  model;
    }


}
