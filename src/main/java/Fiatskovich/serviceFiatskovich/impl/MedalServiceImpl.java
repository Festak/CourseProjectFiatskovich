package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.MedalDao;
import Fiatskovich.modelFiatskovich.Medal;
import Fiatskovich.serviceFiatskovich.MedalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Евгений on 18.02.2017.
 */
@Service
public class MedalServiceImpl implements MedalService {
    private MedalDao medalDao;

    public MedalDao getMedalDao() {
        return medalDao;
    }

    public void setMedalDao(MedalDao medalDao) {
        this.medalDao = medalDao;
    }

    @Override
    @Transactional
    public void addMedal(Medal medal) {
this.medalDao.addMedal(medal);
    }

    @Override
    @Transactional
    public void updateMedal(Medal medal) {
this.medalDao.updateMedal(medal);
    }

    @Override
    @Transactional
    public void removeMedal(int id) {
this.medalDao.removeMedal(id);
    }

    @Override
    @Transactional
    public Medal getMedalById(int id) {
        return this.medalDao.getMedal(id);
    }

    @Override
    @Transactional
    public List<Medal> getAllMedals() {
        return this.medalDao.getAllMedals();
    }
}
