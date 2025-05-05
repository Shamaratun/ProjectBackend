package org.isdb.ProjectBackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.isdb.ProjectBackend.annotation.ValidRole;
import org.isdb.ProjectBackend.constants.Role;

public class RoleValidator implements ConstraintValidator<ValidRole, Role> {
    @Override
    public boolean isValid(Role role, ConstraintValidatorContext context) {
        if (role == null) {
            return false;
        }
        try {
            Role.valueOf(role.name());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}