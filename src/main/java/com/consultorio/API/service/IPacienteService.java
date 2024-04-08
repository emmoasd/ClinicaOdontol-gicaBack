package com.consultorio.API.service;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);
    List<Paciente> listarTodos();
    Paciente buscarPorId(Long id);
    void eliminarPorId(Long id);
    void actualizar(Paciente paciente);

}
