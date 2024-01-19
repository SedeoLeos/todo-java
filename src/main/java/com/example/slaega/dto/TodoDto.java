package com.example.slaega.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class TodoDto {
    @Valid
    @NotEmpty(message="le nom de")
    @Size(max=50,message = "max")
    String name;
    @Valid
    @NotEmpty(message="le nom de")
    @Size(max=150, message = "max")
    String description;
}
