package chia1104.server.validation.validator;

import chia1104.server.validation.annotation.Role;
import chia1104.server.shared.enums.Role as RoleEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RoleValidator : ConstraintValidator<Role, String> {

    private val pattern = Pattern.compile("^[A-Z_]+$");

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true;
        }
        if (!pattern.matcher(value).matches()) {
            return false;
        }
        val roles = Stream.of(*value.split(",").toTypedArray())
                .map { it.trim() }
                .collect(Collectors.toSet());
        return roles.stream().allMatch { it -> RoleEnum.values().map { it.name }.contains(it) };
    }
}