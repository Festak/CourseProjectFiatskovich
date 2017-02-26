package Fiatskovich.serviceFiatskovich;

import Fiatskovich.viewmodelFiatskovich.AdvantageViewModel;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Евгений on 26.02.2017.
 */
public interface AdvantageService {
    Set<AdvantageViewModel> getFiveAdvantages();
}
