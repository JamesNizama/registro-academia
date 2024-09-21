package com.mitocode.controller;

import com.mitocode.dto.EstudianteDTO;
import com.mitocode.model.Estudiante;
import com.mitocode.service.IEstudianteService;
import com.mitocode.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity <List<EstudianteDTO>> readAll() throws Exception{
        List<EstudianteDTO> list = mapperUtil.mapList(service.findAll(), EstudianteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesOrdenadosPorEdad() {
        List<EstudianteDTO> list = mapperUtil.mapList(service.getEstudiantesOrdenEdad(), EstudianteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws  Exception{
        Estudiante obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, EstudianteDTO.class));
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@RequestBody EstudianteDTO dto)throws Exception{
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable("id") Integer id, @RequestBody EstudianteDTO dto)  throws Exception{
        Estudiante obj = service.update(id, mapperUtil.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
