package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.CategoryDao;
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
import java.util.LinkedHashSet;
import java.util.concurrent.CancellationException;

/**
 * Created by Евгений on 20.02.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public Product findProductById(Long id) {
        return productDao.findOne(id);
    }

    @Override
    public Set<Product> listProducts() {
        Set<Product> set = new LinkedHashSet<Product>(productDao.findAll());
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
        Set<Product> products = new LinkedHashSet<Product>(productDao.findAll());
        Set<ProductViewModel> models = new LinkedHashSet<ProductViewModel>();
        for(Product product: products){
            ProductViewModel temp = productToProductViewModel(product);
            models.add(temp);
        }
        return models;
    }

    @Override
    @Transactional
    public Set<ProductViewModel> getAllProductsByCategoryId(int id) {
    Category category = categoryDao.findOne(id);
        Set<Product> products = new LinkedHashSet<Product>(productDao.findAll());
        Set<ProductViewModel> productsViewModel = new LinkedHashSet<ProductViewModel>();
        for(Product product: products){
            if(product.getCategories().contains(category)){
              productsViewModel.add(productToProductViewModel(product));
            }

        }
        return productsViewModel;

    }
    @Transactional
    @Override
    public ProductViewModel getProductByProductName(String name) {
        Product product = new Product();
        List<Product> products = productDao.findAll();
        for(Product prod: products){
            if(prod.getName().equals(name)){
                product = prod;
            }
        }
        return productToProductViewModel(product);
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
        Set<AdvantageViewModel> model = new LinkedHashSet<AdvantageViewModel>();
        for (Advantage advantage: advantages) {
            model.add(new AdvantageViewModel(advantage.getId(),advantage.getDescription()));
        }
        return  model;
    }

    private Set<CategoryViewModel> initCategoriesViewModel(Set<Category> categories){
        Set<CategoryViewModel> model = new LinkedHashSet<CategoryViewModel>();
        for (Category category: categories) {
            model.add(new CategoryViewModel(category.getId(),category.getName()));
        }
        return  model;
    }


}
