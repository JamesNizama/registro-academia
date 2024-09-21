package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_matricula", foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA"))
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_curso", foreignKey = @ForeignKey(name = "FK_DETALLE_CURSO"))
    private Curso curso;

    @Column(nullable = false)
    private String aula;

}
