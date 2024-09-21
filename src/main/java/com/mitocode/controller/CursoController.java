package com.mitocode.controller;

import com.mitocode.dto.CursoDTO;
import com.mitocode.dto.GenericResponse;
import com.mitocode.model.Curso;
import com.mitocode.service.ICursoService;

import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<CursoDTO>> readAll() throws Exception{
        List<CursoDTO> list = mapperUtil.mapList(service.findAll(), CursoDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "exito", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> readById(@PathVariable("id") Integer id) throws  Exception{
        CursoDTO obj = mapperUtil.map(service.findById(id), CursoDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "exito", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CursoDTO>> save(@Valid @RequestBody CursoDTO dto)throws Exception{
        CursoDTO obj = mapperUtil.map(service.save(mapperUtil.map(dto, Curso.class)), CursoDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200,"exito", Arrays.asList(obj)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> update(@Valid @PathVariable("id") Integer id, @RequestBody CursoDTO dto)  throws Exception{
        CursoDTO obj = mapperUtil.map(service.update(id, mapperUtil.map(dto, Curso.class)), CursoDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200, "exito", Arrays.asList(obj)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
