package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface ProductDao extends JpaRepository<Product,Long> {
}
