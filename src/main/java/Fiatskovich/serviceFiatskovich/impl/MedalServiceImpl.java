package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.MedalDao;
import Fiatskovich.modelFiatskovich.Medal;
import Fiatskovich.serviceFiatskovich.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Евгений on 20.02.2017.
 */
@Service
public class MedalServiceImpl implements MedalService {

    @Autowired
    private MedalDao medalDao;

    @Override
    public Medal findMedalById(int id) {
        return medalDao.findOne(1);
    }
}
