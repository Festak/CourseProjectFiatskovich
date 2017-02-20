package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.Medal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 20.02.2017.
 */
public interface MedalDao extends JpaRepository<Medal, Integer> {
}
