package com.consultorio.API.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoResponseDTO  {
    private Long id;
    private Long odontologo_id;
    private Long paciente_id;
    private String fecha;
}
