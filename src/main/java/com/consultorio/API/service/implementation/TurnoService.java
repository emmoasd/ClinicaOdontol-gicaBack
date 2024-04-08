package com.consultorio.API.service.implementation;

import com.consultorio.API.controller.TurnoController;
import com.consultorio.API.dto.request.TurnoRequestDTO;
import com.consultorio.API.dto.response.TurnoResponseDTO;
import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;
import com.consultorio.API.entity.Turno;
import com.consultorio.API.exception.ResourceNotFoundException;
import com.consultorio.API.repository.ITurnoRepository;
import com.consultorio.API.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TurnoService implements ITurnoService {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TurnoController.class));
    private ITurnoRepository turnoRepository;
    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    @Override
    public TurnoResponseDTO guardar(TurnoRequestDTO turnoRequestDTO) {
        //settear de el DTO a las entidades para persistirlo a la BD
        Turno turnoEntity = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        //convertir formato de fecha y settearlo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //creamos el LocalDate que vamos a tener que persistir en la BD
        LocalDate date = LocalDate.parse(turnoRequestDTO.getFecha(), formatter);

        paciente.setId(turnoRequestDTO.getPaciente_id());
        odontologo.setId(turnoRequestDTO.getOdontologo_id());

        //seteamos Paciente y Odontologo a la entidad Turno
        turnoEntity.setOdontologo(odontologo);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setFechaIngreso(date);

        turnoRepository.save(turnoEntity);

        //mapear la entidad persistida a el dto response
        TurnoResponseDTO turnoResponseDTO = new TurnoResponseDTO();
        turnoResponseDTO.setId(turnoEntity.getId());
        turnoResponseDTO.setOdontologo_id(turnoEntity.getOdontologo().getId());
        turnoResponseDTO.setPaciente_id(turnoEntity.getPaciente().getId());
        turnoResponseDTO.setFecha(turnoEntity.getFechaIngreso().toString());

        return turnoResponseDTO;
    }

    @Override
    public List<TurnoResponseDTO> listarTodos() {
        return null;
    }

    @Override
    public Optional<TurnoResponseDTO> buscarPorId(Long id) {
        Optional<Turno> turnoABuscar = turnoRepository.findById(id);

        Optional<TurnoResponseDTO> turnoOptional = null;

        if (turnoABuscar.isPresent()) {
            Turno turno = turnoABuscar.get();
            TurnoResponseDTO turnoResponseDTO = new TurnoResponseDTO();
            turnoResponseDTO.setId(turno.getId());
            turnoResponseDTO.setOdontologo_id(turno.getOdontologo().getId());
            turnoResponseDTO.setPaciente_id(turno.getPaciente().getId());
            turnoResponseDTO.setFecha(turno.getFechaIngreso().toString());

            //voy a convertir mi turnoDTO a Optional para devolverlo
            turnoOptional = Optional.of(turnoResponseDTO);

            return turnoOptional;
        } else {
            throw new ResourceNotFoundException("No existe la cita" + id);
        }
    }


    @Override
    public void eliminar(Long id) {
        // Verificar si el turno existe antes de eliminarlo
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if (optionalTurno.isPresent()) {
            turnoRepository.delete(optionalTurno.get());
            LOGGER.info("Turno eliminado con éxito");
        } else {
            throw new ResourceNotFoundException("No se puede eliminar el turno. No se encontró el turno con ID: " + id);
        }
    }


}
