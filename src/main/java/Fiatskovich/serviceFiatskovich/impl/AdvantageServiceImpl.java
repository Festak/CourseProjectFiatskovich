package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.AdvantageDao;
import Fiatskovich.modelFiatskovich.Advantage;
import Fiatskovich.serviceFiatskovich.AdvantageService;
import Fiatskovich.viewmodelFiatskovich.AdvantageViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 26.02.2017.
 */
@Service
public class AdvantageServiceImpl extends TemplateServiceImpl implements AdvantageService {

    @Autowired
    private AdvantageDao advantageDao;

    @Override
    @Transactional
    public Set<AdvantageViewModel> getFiveAdvantages() {
        Set<Advantage> advantages = new LinkedHashSet<Advantage>(advantageDao.findAll().subList(0,5));
        return initAdvantagesViewModel(advantages);
    }

    private Advantage advantageViewModelToAdvantage(AdvantageViewModel model){
        Advantage advantage = new Advantage();
        advantage.setDescription(model.getDescription());
        return advantage;
    }


}
