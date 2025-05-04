package org.isdb.ProjectBackend.dto.login;

public record FieldError(
                String field,
                String errorCode,
                String errorMessage) {
}