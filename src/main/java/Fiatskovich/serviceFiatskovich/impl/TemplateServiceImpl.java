package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.modelFiatskovich.Advantage;
import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.viewmodelFiatskovich.AdvantageViewModel;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 11.03.2017.
 */
public abstract class TemplateServiceImpl {

    public TemplateServiceImpl(){}

    protected Set<AdvantageViewModel> initAdvantagesViewModel(Set<Advantage> advantages){
        Set<AdvantageViewModel> model = new LinkedHashSet<AdvantageViewModel>();
        for (Advantage advantage: advantages) {
            model.add(new AdvantageViewModel(advantage.getId(),advantage.getDescription()));
        }
        return  model;
    }
}
