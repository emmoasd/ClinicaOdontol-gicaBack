package com.consultorio.API.controller;

import com.consultorio.API.dto.request.TurnoRequestDTO;
import com.consultorio.API.dto.response.TurnoResponseDTO;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.IPacienteService;
import com.consultorio.API.service.ITurnoService;
import com.consultorio.API.service.implementation.OdontologoService;
import com.consultorio.API.service.implementation.PacienteService;
import com.consultorio.API.service.implementation.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TurnoController.class));


    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService){
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //guardar un turno
    @PostMapping
    public ResponseEntity<TurnoResponseDTO> guardar(@RequestBody TurnoRequestDTO turno){
        ResponseEntity<TurnoResponseDTO> response;
        LOGGER.info("Verificando el turno" + turno);

        //verificar que exista dentista y paciente
        if (odontologoService.buscarPorId(turno.getOdontologo_id()) != null &&
                pacienteService.buscarPorId(turno.getPaciente_id()) != null){
            response = ResponseEntity.ok(turnoService.guardar(turno));
        } else {
            //si no existe el odontologo o el paciente
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            LOGGER.info("Verificando el turno" + turno);
        }
        return response;
    }
    //buscar todos los turnos
    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> findAll(){
        LOGGER.info("Buscando todos los turnos");
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    //buscar turno por id
    @GetMapping ("/{id}")
    public ResponseEntity<TurnoResponseDTO> findById(@PathVariable Long id) {
        turnoService.buscarPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        LOGGER.info("Eliminando el turno con ID: " + id);
        try {
            turnoService.eliminar(id);
            return ResponseEntity.ok("Turno eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el turno");
        }
    }

}
