package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombresEstudiante;

    @NotNull
    @Size(min = 3, max = 50)
    private String apellidosEstudiante;

    @NotNull
    @Size(min = 8, max = 8)
    private String dniEstudiante;

    @NotNull
    private int edadEstudiante;

}
