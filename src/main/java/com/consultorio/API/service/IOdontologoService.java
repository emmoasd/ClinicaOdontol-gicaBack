package com.consultorio.API.service;

import com.consultorio.API.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardar (Odontologo odontologo);
    List<Odontologo> listarTodos();
    Odontologo buscarPorId(Long id);

    //buscar por matricula
    Optional<Odontologo> findByNumeroMatricula(Integer numeroMatricula);

    void eliminarPorId(Long id);
    void actualizar (Odontologo odontologo);
}
