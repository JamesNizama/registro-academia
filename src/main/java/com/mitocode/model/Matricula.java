package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_MATRICULA_ESTUDIANTE"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<DetalleMatricula> detalleMatricula;
}
