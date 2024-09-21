package com.mitocode.service.impl;

import com.mitocode.model.Estudiante;
import com.mitocode.repository.IEstudianteRepo;
import com.mitocode.repository.IGenericoRepo;
import com.mitocode.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericoRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> getEstudiantesOrdenEdad() {
        return repo.findAll().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getEdad(), e1.getEdad()))
                .collect(Collectors.toList());
    }
}
