package com.mitocode.controller;

import com.mitocode.dto.MatriculaDTO;
import com.mitocode.model.Matricula;
import com.mitocode.service.IMatriculaService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;
    private final MapperUtil mapperUtil;
    private List<com.mitocode.model.Estudiante> Estudiante;
    private List<com.mitocode.model.Matricula> Matricula;
    private List<com.mitocode.model.Curso> Curso;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<MatriculaDTO> list = mapperUtil.mapList(service.findAll(), MatriculaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/cursosMatrculados")
    public ResponseEntity<Map<String,  List<String>>> getCursosMatricula(){
        Map<String, List<String>> listMap = service.getCursosMatriculados3();
        return  ResponseEntity.ok(listMap);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id") Integer id) throws  Exception{
        Matricula obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, MatriculaDTO.class));
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto)throws Exception{
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));
        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MatriculaDTO dto)  throws Exception{
        Matricula obj = service.update(id, mapperUtil.map(dto, Matricula.class));
        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
