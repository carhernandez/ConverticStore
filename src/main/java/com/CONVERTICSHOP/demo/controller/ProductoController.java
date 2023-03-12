package com.CONVERTICSHOP.demo.controller;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.services.ProductoService.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String registro() {
        return "/administrador/FormularioRegistro";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getProductos() throws Exception {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    /*@PostMapping ("/register")
    private ResponseEntity<Producto> saveDocuments(@RequestBody Producto producto){
        try{
            Producto producto1= productService.crearProducto(producto);
            return ResponseEntity.created(new URI("/producto/"+producto1.getIdProducto())).body(producto1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }*/

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Producto> createProducto(@RequestBody Producto producto) throws Exception {
        try {
            return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/generoparam/{idGenero}")
    public ResponseEntity<List<Producto>> getProductosByGenero(@PathVariable Integer idGenero)
            throws Exception {
        try {
            return ResponseEntity.ok(productoService.getProductoByGenero(idGenero));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> getProductoByDescripcionOrColorOrMarca(@RequestParam(required = false) String descripcion,
                                                                                 @RequestParam(required = false) String color,
                                                                                 @RequestParam(required = false) String marca) {

        return ResponseEntity.ok(productoService.getProductoByDescripcionOrColorOrMarca(descripcion, color, marca));
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Producto>> getProductosByGenero(@PathVariable String genero)
            throws Exception {
        try {
            return ResponseEntity.ok((List<Producto>) productoService.obtenerProductosPorGenero(genero));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> getProductoPorId(@PathVariable Integer idProducto)
            throws Exception {
        try {
            return ResponseEntity.ok(productoService.getProductoPorId(idProducto));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/masbuscados")
    public ResponseEntity<?> obtenerProductosMasBuscados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findProductosMasBuscados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran productos\"}");

        }

    }

}

