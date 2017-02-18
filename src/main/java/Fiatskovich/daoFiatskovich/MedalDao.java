package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.Medal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Евгений on 18.02.2017.
 */
public interface MedalDao {
    public void addMedal(Medal medal);
    public void updateMedal(Medal medal);
    public void removeMedal(int id);
    public Medal getMedal(int id);
    public List<Medal> getAllMedals();

}
