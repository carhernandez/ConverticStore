package com.CONVERTICSHOP.demo.controller;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.services.ProductoService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductController {

   @Autowired
   private ProductService productService;

   @GetMapping("")
    public String registro() {
        return "/administrador/FormularioRegistro";
    }

    @GetMapping("/all")
    public ResponseEntity <List<Producto>> getProductos() throws Exception {
        return ResponseEntity.ok(productService.obtenerTodos());
    }

    @PostMapping("/register")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) throws Exception {
        return new ResponseEntity<>(productService.crearProducto(producto), HttpStatus.CREATED);
    }

    @PostMapping ("/update")
    public ResponseEntity <Producto> updateProducto(@RequestBody Producto producto) {
    return null;
    }






    /*@DeleteMapping("/delete/{idProducto}")*/

/*
    @DeleteMapping("/delete/{idProducto}")
    public ResponseEntity<Map<String, Boolean>> deleteProductos(@PathVariable Integer idProducto) {
        return productosServices.deleteProducto(idProducto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAllProductos() {
        return productosServices.getAllProductos();
    }

    @PostMapping("/register")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        return productosServices.createProducto(producto);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> getProductosById(@PathVariable Integer idProducto) {
        return productosServices.getProductosById(idProducto);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> updateProductos(@PathVariable Integer idProducto, @RequestBody Producto producto) {
        return productosServices.updateProductos(idProducto, producto);
    }*/
/*
    @GetMapping("/" +
            "")
    public ResponseEntity<List<Usuario>> getUsuarioAndPassword(@RequestParam int idProducto,
                                                                @RequestParam String contrasena) {
        return usuariosServices.getIdUsuarioAndPassword(idProducto, contrasena);

    }

    @DeleteMapping("/searchidNom")
    public ResponseEntity<List<Usuario>> getUsuarioOrNombres(@RequestParam String idUsuarios,
                                                              @RequestParam String nombres) {
        return usuariosServices.getUsuarioOrNombres(Integer.parseInt(idUsuarios), nombres);

    }*/



}
