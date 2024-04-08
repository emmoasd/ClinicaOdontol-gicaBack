package com.consultorio.API.repository;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    List<Paciente> findAll();
}
