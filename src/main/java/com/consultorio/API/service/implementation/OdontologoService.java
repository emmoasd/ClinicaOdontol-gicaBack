package com.consultorio.API.service.implementation;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.repository.IOdontologoRepository;
import com.consultorio.API.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }

    //guardar odontologo
    @Override
    public Odontologo guardar(Odontologo odontologo) {

        return odontologoRepository.save(odontologo);
    }
    //traer todos los odontologos
    @Override
    public List<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

    //buscar por id
    @Override
    public Odontologo buscarPorId(Long id) {
        Optional<Odontologo>odontologoOptional = odontologoRepository.findById(id);
        if (odontologoOptional.isPresent()){
            return odontologoOptional.get();
        }else {
            return null;
        }
    }
    //buscar por matricula
    @Override
    public Optional<Odontologo> findByNumeroMatricula(Integer numeroMatricula) {
        return odontologoRepository.findByNumeroMatricula(numeroMatricula);
    }
    //Eliminar odontologo
    @Override
    public void eliminarPorId(Long id) { odontologoRepository.deleteById(id); }

    //Actualizar informacion de odontologo
    @Override
    public void actualizar(Odontologo odontologo) {

        odontologoRepository.save(odontologo);
    }



}
