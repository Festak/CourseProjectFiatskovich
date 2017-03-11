package Fiatskovich.serviceFiatskovich.impl;
import Fiatskovich.daoFiatskovich.CategoryDao;
import Fiatskovich.daoFiatskovich.ProductDao;
import Fiatskovich.modelFiatskovich.Advantage;
import Fiatskovich.modelFiatskovich.Category;
import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.modelFiatskovich.Rating;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.viewmodelFiatskovich.AdvantageViewModel;
import Fiatskovich.viewmodelFiatskovich.CategoryViewModel;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import Fiatskovich.viewmodelFiatskovich.RatingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by Евгений on 20.02.2017.
 */
@Service
public class ProductServiceImpl extends TemplateServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public void removeProductById(Long id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public ProductViewModel findProductById(Long id) {
        return productToProductViewModel(productDao.findOne(id));
    }

    @Override
    @Transactional
    public Set<Product> listProducts() {
        Set<Product> set = new LinkedHashSet<Product>(productDao.findAll());
        return set;
    }

    @Override
    @Transactional
    public ProductViewModel productToProductViewModelById(Long id) {
        Product product = productDao.findOne(id);
        return productToProductViewModel(product);
    }

    @Override
    @Transactional
    public Set<ProductViewModel> getCountOfProducts(int count) {
        Set<Product> products = new LinkedHashSet<Product>(productDao.findAll().subList(0, count));
        Set<ProductViewModel> models = new LinkedHashSet<ProductViewModel>();
        for(Product product: products){
            ProductViewModel temp = productToProductViewModel(product);
            models.add(temp);
        }
        return models;
    }

    @Override
    @Transactional
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
        sendEmail();
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
    public Set<ProductViewModel> getProductsByProductName(String name) {
        Set<ProductViewModel> model = new LinkedHashSet<ProductViewModel>();
        List<Product> products = productDao.findAll();
        for(Product prod: products){
            if(prod.getName().equals(name)){
                model.add(productToProductViewModel(prod));
            }
        }
        return model;
    }

    @Override
    @Transactional
    public void addProductViewModelToDataBase(ProductViewModel product) {
Product productToDatabase = productViewModelToProduct(product);
        productDao.save(productToDatabase);
    }


    @Override
    @Transactional
    public void editProduct(ProductViewModel product) {
        Product product1 = productDao.findOne(product.getId());
        product1.setName(product.getName());
        product1.setImageUrl(product.getImageUrl());
        product1.setMemory(product.getMemory());
        product1.setWeight(product.getWeight());
        product1.setPrice(product.getPrice());
        product1.setTemperature(product.getTemperature());
        productDao.saveAndFlush(product1);
    }

    private Product productViewModelToProduct(ProductViewModel model){
        Product product = new Product(model.getName(),model.getWeight(),
                model.getTemperature(), model.getMemory(), model.getPrice(),model.getImageUrl());
        Set<Advantage> advantages = new LinkedHashSet<Advantage>();
        advantages.add(advantageViewModelToAdvantage(model.getAdvantageViewModel()));
        product.setAdvantages(advantages);
        Set<Category> categories = new LinkedHashSet<Category>();
        categories.add(categoryViewModelToCategory(model.getCategoryViewModel()));
        product.setCategories(categories);
        product.setRatings(new ArrayList<Rating>());
        return product;
    }

    private Category categoryViewModelToCategory(CategoryViewModel model){
        Category category = new Category();
        category.setName(model.getName());
        sendEmail();
        return category;
    }

    private Advantage advantageViewModelToAdvantage(AdvantageViewModel model){
        Advantage advantage = new Advantage();
        advantage.setDescription(model.getDescription());
        return advantage;
    }

    private ProductViewModel productToProductViewModel(Product product) {
        ProductViewModel model = new ProductViewModel(product.getId(),product.getName(),
                product.getWeight(),product.getTemperature(),product.getMemory(),product.getPrice(),
                product.getImageUrl());
        model.setRatings(initRatingsViewModel(
                product.getRatings()));
        model.setRating(getAverageRating(model.getRatings()));
        model.setAdvantages(initAdvantagesViewModel(product.getAdvantages()));
        model.setCategories(initCategoriesViewModel(product.getCategories()));
        return model;
    }


    private Set<CategoryViewModel> initCategoriesViewModel(Set<Category> categories){
        Set<CategoryViewModel> model = new LinkedHashSet<CategoryViewModel>();
        for (Category category: categories) {
            model.add(new CategoryViewModel(category.getId(),category.getName()));
        }
        return  model;
    }

    private List<RatingViewModel> initRatingsViewModel(List<Rating> ratings){
        List<RatingViewModel> model = new LinkedList<RatingViewModel>();
        for (Rating rating: ratings) {
            model.add(new RatingViewModel(rating.getId(), rating.getUserId(), rating.getRating()));
        }
        return  model;
    }

    private void sendEmail(){

        final String username = "fiatskovich.w@gmail.com";
        final String password = "s1tzq8mg2";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fiatskovich.w@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("fiatskovich.w@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private double getAverageRating(List<RatingViewModel> ratings){
        double average=0;
        for(RatingViewModel rating: ratings){
            average+=rating.getRating();
        }
        if(ratings.size()!=0)
        average/=ratings.size();
        return average;
    }


}
