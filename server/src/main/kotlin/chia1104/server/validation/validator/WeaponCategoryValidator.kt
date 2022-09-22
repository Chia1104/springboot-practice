package chia1104.server.validation.validator

import chia1104.server.validation.annotation.WeaponCategory
import chia1104.server.shared.enums.WeaponCategory as WeaponCategoryEnum

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WeaponCategoryValidator : ConstraintValidator<WeaponCategory, String> {

    private val pattern = Pattern.compile("^[A-Z_]+$");

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true;
        }
        if (!pattern.matcher(value).matches()) {
            return false;
        }
        val categories = Stream.of(*value.split(",").toTypedArray())
                .map { it.trim() }
                .collect(Collectors.toList())
        return categories.stream().allMatch { it -> WeaponCategoryEnum.values().map { it.name }.contains(it) };
    }
}