package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEstudiante;

    @Column(nullable = false, length = 25)
    private String nombres;

    @Column(nullable = false, length = 25)
    private String apellidos;

    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(nullable = false)
    private int edad;

}
