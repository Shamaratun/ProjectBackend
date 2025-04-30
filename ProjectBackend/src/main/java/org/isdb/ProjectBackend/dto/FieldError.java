package org.isdb.ProjectBackend.dto;

public record FieldError(
                String field,
                String errorCode,
                String errorMessage) {
}