package com.CONVERTICSHOP.demo.controller;

import com.CONVERTICSHOP.demo.modelo.Carrito;
import com.CONVERTICSHOP.demo.modelo.Factura;
import com.CONVERTICSHOP.demo.services.CarritoService.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/carrito")

public class CarritoController  {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/{idCarrito}")
    private  ResponseEntity<Carrito> obtenerTodos(@PathVariable Integer idCarrito) throws Exception {
        return ResponseEntity.ok((Carrito) carritoService.obtenerCarrito(idCarrito));
    }

    @PostMapping("/guardar")
    private ResponseEntity<?> saveFactura(@RequestBody Carrito carrito){

        LocalDate fechaCreacion =LocalDate.now();

        carrito.setFecha(fechaCreacion);

        try{

            Carrito carrito1= carritoService.registrarCarrito(carrito);

            return ResponseEntity.created(new URI("/carrito/"+carrito1.getIdCarrito())).body(carrito1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
