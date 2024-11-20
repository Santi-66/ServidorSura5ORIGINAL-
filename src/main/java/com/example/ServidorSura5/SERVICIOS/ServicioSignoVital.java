package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.MODELOS.SignoVital;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioSignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioSignoVital {
    @Autowired
    IRepositorioSignoVital irepositorioSignoVital;
    public SignoVital guardarSignoVital(SignoVital datossignovital)throws Exception{
        try{
            return irepositorioSignoVital.save(datossignovital);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<SignoVital> buscarsignovital() throws Exception{
        try {
            return irepositorioSignoVital.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());
        }


    }
}
