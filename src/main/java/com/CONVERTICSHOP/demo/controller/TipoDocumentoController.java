package com.CONVERTICSHOP.demo.controller;

import com.CONVERTICSHOP.demo.modelo.TipoDocumento;
import com.CONVERTICSHOP.demo.services.TipoDocumentoService.TypeDocumentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping ("/tipodocumento")
public class TipoDocumentoController {
    @Autowired
    private TypeDocumentServicesImpl tipoDocumentoServices;

    @GetMapping("/all")
    public ResponseEntity<List<TipoDocumento>> getAlltipoDocumento() throws Exception {
        return ResponseEntity.ok( tipoDocumentoServices.obtenerTodos());
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) throws Exception {
        return new ResponseEntity<>(tipoDocumentoServices.crearTipoDocumento(tipoDocumento), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idTipoDocumento}")
    public ResponseEntity<String>  borrarTipoDocumento(@PathVariable Integer idTipoDocumento) throws Exception {
        return ResponseEntity.ok(tipoDocumentoServices.borrarTipoDocumento(idTipoDocumento));
    }



}
