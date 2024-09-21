package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {

    //@NotNull
    @JsonBackReference
    private MatriculaDTO  matricula;

    @NotNull
    @JsonIncludeProperties(value = {"idCurso"})
    private CursoDTO curso;

    @NotNull
    private String aula;
}
