package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
