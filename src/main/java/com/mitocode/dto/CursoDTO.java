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
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombreCurso;

    @NotNull
    @Size(min = 2, max = 3)
    private String siglasCurso;

    @NotNull
    private boolean estadoCurso;
}
