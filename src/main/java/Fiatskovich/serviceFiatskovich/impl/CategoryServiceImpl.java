package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.CategoryDao;
import Fiatskovich.modelFiatskovich.Category;
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

    @Override
    @Transactional
    public Set<CategoryViewModel> getAllCategoriesViewModel() {
        Set<Category> set = new LinkedHashSet<Category>(categoryDao.findAll());
        return categoryToCategoryViewModelCollection(set);
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
