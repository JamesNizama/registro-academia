package com.mitocode.service;

import com.mitocode.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante, Integer>{

    List<Estudiante> getEstudiantesOrdenEdad();
}
