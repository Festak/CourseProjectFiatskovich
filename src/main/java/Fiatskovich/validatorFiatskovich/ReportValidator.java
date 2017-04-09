package Fiatskovich.validatorFiatskovich;

import Fiatskovich.modelFiatskovich.Report;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Евгений on 09.04.2017.
 */
@Component
public class ReportValidator implements Validator {

    private final static String EMAIL_REGEXP = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    @Override
    public boolean supports(Class<?> aClass) {
        return Report.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Report report = (Report) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPhone", "Required");

        if(!report.getUserEmail().matches(EMAIL_REGEXP)){
            errors.rejectValue("userEmail", "Email.notCorrect");
        }

    }
}
