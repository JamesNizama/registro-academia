package com.mitocode.service.impl;

import com.mitocode.model.Curso;
import com.mitocode.repository.ICursoRepo;
import com.mitocode.repository.IGenericoRepo;
import com.mitocode.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends  CRUDImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericoRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
