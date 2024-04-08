package com.consultorio.API.controller;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.implementation.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService){

        this.odontologoService = odontologoService;
    }
    //buscar odontologo por id
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    //buscar odontologo por matricula
    @GetMapping("/matricula/{numeroMatricula}")

    public ResponseEntity<Odontologo> buscarMatricula(@PathVariable Integer numeroMatricula) throws Exception {
        Optional<Odontologo> odontologoOptional = odontologoService.findByNumeroMatricula(numeroMatricula);

        if (odontologoOptional.isPresent()){
            return ResponseEntity.ok(odontologoOptional.get());
        }else {
            throw new Exception("No se encontró el odontólogo con la matricula " + numeroMatricula);
        }
    }
    //lista todos los odontologos
    @GetMapping("/todos")
    public ResponseEntity<List<Odontologo>> listarTodos() {

        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    //actualizar un odontologo
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@RequestBody Odontologo odontologo){
        ResponseEntity<String> response = null;
        Odontologo odontologoBuscado = odontologoService.buscarPorId(odontologo.getId());

        if (odontologoBuscado != null ){
            odontologoService.actualizar(odontologo);
            response = ResponseEntity.ok("Se ha actualizado el odontólogo " + odontologo.getNombre());
        } else{
            response = ResponseEntity.ok().body("No se puede actualizar el odontólogo");
        }
        return response;
    }
    //eliminar un odontologo
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminarPorId(id);
        return ResponseEntity.ok("Odontólogo eliminado con éxito");
    }
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarOdontologo(@RequestBody Odontologo odontologo) {
        Odontologo odontologoGuardado = odontologoService.guardar(odontologo);
        if (odontologoGuardado != null) {
            return ResponseEntity.ok("Odontólogo agregado correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al agregar odontólogo");
        }
    }


}


