package com.consultorio.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaDeAlta;
    private String domicilio;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Turno> turnoSet = new HashSet();

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaDeAlta=" + fechaDeAlta +
                ", domicilio='" + domicilio + '\'' +
                ", turnoSet=" + turnoSet +
                '}';
    }
}
