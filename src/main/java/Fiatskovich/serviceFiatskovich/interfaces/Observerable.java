package Fiatskovich.serviceFiatskovich.interfaces;

import Fiatskovich.modelFiatskovich.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Евгений on 08.04.2017.
 */
public interface Observerable {
    @Transactional
   void notifyObservers(Set<Category> categories);
}
