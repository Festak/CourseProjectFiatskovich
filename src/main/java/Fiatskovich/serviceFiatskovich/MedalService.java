package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.Medal;

import java.util.List;

/**
 * Created by Евгений on 18.02.2017.
 */
public interface MedalService {
    public void addMedal(Medal medal);
    public void updateMedal(Medal medal);
    public void removeMedal(int id);
    public Medal getMedalById(int id);
    public List<Medal> getAllMedals();
}
