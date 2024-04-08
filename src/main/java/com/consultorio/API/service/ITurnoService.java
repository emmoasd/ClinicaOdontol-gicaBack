package com.consultorio.API.service;

import com.consultorio.API.dto.request.TurnoRequestDTO;
import com.consultorio.API.dto.response.TurnoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    TurnoResponseDTO guardar(TurnoRequestDTO turnoRequestDTO);
    List<TurnoResponseDTO> listarTodos();
    Optional<TurnoResponseDTO> buscarPorId(Long id);
    void eliminar(Long id);


}
