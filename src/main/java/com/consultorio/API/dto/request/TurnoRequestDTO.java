package com.consultorio.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TurnoRequestDTO {
    private Long id;
    private Long odontologo_id;
    private Long paciente_id;
    private String fecha;

}
