package chia1104.server.validation.annotation;

import chia1104.server.validation.validator.RoleValidator;

import javax.validation.Payload;
import java.lang.annotation.*;
import javax.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { RoleValidator.class })
public @interface Role {
    String message() default "Invalid role";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
