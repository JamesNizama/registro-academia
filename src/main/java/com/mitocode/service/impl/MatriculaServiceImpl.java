package com.mitocode.service.impl;

import com.mitocode.model.DetalleMatricula;
import com.mitocode.model.Matricula;
import com.mitocode.repository.IMatriculaRepo;
import com.mitocode.repository.IGenericoRepo;
import com.mitocode.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
@Slf4j
public class MatriculaServiceImpl extends  CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericoRepo<Matricula, Integer> getRepo() {
        return repo;
    }

   @Override
    public Map<String, List<String>> getCursosMatriculados3() {
        Stream<Matricula> matriculaStream = repo.findAll().stream();
        Stream<List<DetalleMatricula>> listStream = matriculaStream.map(Matricula::getDetalleMatricula);

        Stream<DetalleMatricula> streamDetalle =  listStream.flatMap(Collection::stream);

       Map<String, List<String>> byEstudiante = streamDetalle
               .collect(Collectors.groupingBy(
                       dm -> dm.getMatricula().getEstudiante().getNombres() + " " +
                               dm.getMatricula().getEstudiante().getApellidos(),
                       Collectors.mapping(dm -> dm.getCurso().getNombre(),
                               Collectors.toList())
               ));
        return byEstudiante;
    }
}
