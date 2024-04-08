package com.consultorio.API.repository;

import com.consultorio.API.entity.Odontologo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
 public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
    Optional<Odontologo> findByNumeroMatricula(Integer numeroMatricula);

    List<Odontologo> findAll();

}
