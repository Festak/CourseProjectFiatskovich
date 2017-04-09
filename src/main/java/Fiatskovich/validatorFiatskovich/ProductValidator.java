package Fiatskovich.validatorFiatskovich;

import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Евгений on 09.04.2017.
 */
@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductViewModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductViewModel product = (ProductViewModel) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "temperature", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memory", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imageUrl", "Required");

       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryViewModel.name", "Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "advantageViewModel.description", "Required");

    }
}
