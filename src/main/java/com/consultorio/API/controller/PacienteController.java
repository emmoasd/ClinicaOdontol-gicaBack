package com.consultorio.API.controller;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;
import com.consultorio.API.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {

        this.pacienteService = pacienteService;
    }

    //buscar por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Paciente> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    //listar todos
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Paciente>> listarTodos() {

        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    //actualizar paciente
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<String> response;
        // Verificar que existe
        Paciente pacienteBuscado = pacienteService.buscarPorId(paciente.getId());
        if (pacienteBuscado != null) {
            pacienteService.actualizar(paciente);
            response = ResponseEntity.ok("Se actualizó el paciente " + paciente.getNombre());
        } else {
            response = ResponseEntity.badRequest().body("No se pudo actualizar el paciente");
        }
        return response;
    }

    //eliminar paciente
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPorId(id);
        return ResponseEntity.ok("Paciente eliminado con éxito");
    }

    //agregar un nuevo paciente
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteService.guardar(paciente);
        if (pacienteGuardado != null) {
            return ResponseEntity.ok("Paciente agregado correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al agregar paciente");
        }
    }
}