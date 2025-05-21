package dto;

import jakarta.validation.constraints.NotNull;

public record HelloRequest(@NotNull String name) { }
