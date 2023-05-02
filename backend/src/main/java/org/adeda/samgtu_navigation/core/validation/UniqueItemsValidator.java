package org.adeda.samgtu_navigation.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Set;

public class UniqueItemsValidator implements ConstraintValidator<UniqueItems, List<?>> {
    @Override
    public boolean isValid(List<?> objects, ConstraintValidatorContext constraintValidatorContext) {
        return Set.copyOf(objects).size() == objects.size();
    }
}
