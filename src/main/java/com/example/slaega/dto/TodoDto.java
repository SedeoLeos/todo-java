package com.example.slaega.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {

    @NotEmpty(message="le nom de")
    @NotBlank(message = "Product name cannot be blank")
    @Length(min = 5, max = 50, message = "Product name must be between 5-512 characters")
    private String name;

    @NotEmpty(message="le nom de")
    @Length(min = 5, max = 150, message = "Product name must be between 5-512 characters")
    private String description;
}
