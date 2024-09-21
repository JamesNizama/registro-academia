package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.model.DetalleMatricula;
import com.mitocode.model.Estudiante;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {

    private Integer idMatricula;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    @JsonIncludeProperties(value = {"idEstudiante"})
    private EstudianteDTO estudiante;

    @NotNull
    private boolean estado;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatricula;
}
