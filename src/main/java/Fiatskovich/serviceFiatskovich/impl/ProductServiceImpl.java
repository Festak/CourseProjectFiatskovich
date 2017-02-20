package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.ProductDao;
import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.serviceFiatskovich.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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
}
