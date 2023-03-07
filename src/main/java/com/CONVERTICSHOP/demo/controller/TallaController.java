package com.CONVERTICSHOP.demo.controller;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.modelo.Talla;
import com.CONVERTICSHOP.demo.services.TallaService.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/talla")
public class TallaController {

    @Autowired private TallaService tallaService;

    @GetMapping("/all")
    public ResponseEntity<List<Talla>> getTalla() throws Exception {
        return ResponseEntity.ok(tallaService.obtenerTodos());
    }

}
