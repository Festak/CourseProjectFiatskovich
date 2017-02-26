package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.CategoryDao;
import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.Category;
import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.serviceFiatskovich.CategoryService;
import Fiatskovich.viewmodelFiatskovich.CategoryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Евгений on 20.02.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Set<CategoryViewModel> getAllCategoriesViewModel() {
        Set<Category> set = new LinkedHashSet<Category>(categoryDao.findAll());
        return categoryToCategoryViewModelCollection(set);
    }

    @Transactional
    @Override
    public Set<CategoryViewModel> getAllCategoriesViewModelForSubscribe(String username)
    {
User user = userDao.findByUsername(username);
        Set<Category> nosubscribes = new LinkedHashSet<Category>();
        Set<Category> userCategories = user.getCategories();
        Set<Category> allCategories = new LinkedHashSet<Category>(categoryDao.findAll());
        for(Category userC: userCategories){
            for(Category allC: allCategories){
                if(!userC.equals(allC.getName())){
                    nosubscribes.add(allC);
                }
            }
        }
        return categoryToCategoryViewModelCollection(nosubscribes);
    }

    @Transactional
    @Override
    public Set<CategoryViewModel> getUserCategoriesViewModel(String username){
        User user = userDao.findByUsername(username);
        Set<Category> userCategories = user.getCategories();
        return categoryToCategoryViewModelCollection(userCategories);
    }



    private CategoryViewModel categoryToCategoryViewModel(Category category){
        CategoryViewModel model = new CategoryViewModel();
        model.setId(category.getId());
        model.setName(category.getName());
        return model;
    }

    private Set<CategoryViewModel> categoryToCategoryViewModelCollection(Set<Category> categoriesTemp){
        Set<CategoryViewModel> viewModels = new LinkedHashSet<CategoryViewModel>();
        for(Category category: categoriesTemp){
            viewModels.add(categoryToCategoryViewModel(category));
        }
        return viewModels;
    }



}
