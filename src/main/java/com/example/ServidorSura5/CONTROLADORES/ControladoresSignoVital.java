package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.SignoVital;
import com.example.ServidorSura5.SERVICIOS.ServicioSignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signovital")
public class ControladoresSignoVital {
    @Autowired
    ServicioSignoVital servivioSignoVital;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody SignoVital datos) {
        try {
            return ResponseEntity
                    .status((HttpStatus.OK))
                    .body(servivioSignoVital.guardarSignoVital(datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> obtener() {
        try {
            return ResponseEntity
                    .status((HttpStatus.OK))
                    .body(servivioSignoVital.buscarsignovital());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
