package Fiatskovich.serviceFiatskovich;

import Fiatskovich.viewmodelFiatskovich.CategoryViewModel;

import java.util.Set;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface CategoryService {
    Set<CategoryViewModel> getAllCategoriesViewModel();
    Set<CategoryViewModel> getAllCategoriesViewModelForSubscribe(String username);
    Set<CategoryViewModel> getUserCategoriesViewModel(String username);
}
