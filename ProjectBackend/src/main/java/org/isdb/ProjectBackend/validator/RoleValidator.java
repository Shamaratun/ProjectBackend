package org.isdb.ProjectBackend.validator;

import org.isdb.email.annotation.ValidRole;
import org.isdb.email.constants.Role;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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