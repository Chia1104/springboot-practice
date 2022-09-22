package chia1104.server.validation.annotation;

import chia1104.server.validation.validator.WeaponCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { WeaponCategoryValidator.class })
public @interface WeaponCategory {
    String message() default "Invalid weapon category";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
