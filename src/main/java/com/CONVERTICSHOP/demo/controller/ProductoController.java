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
    public ResponseEntity <List<Producto>> getProductos() throws Exception {
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
        try{
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping ("/generoparam/{idGenero}")
   public ResponseEntity<List<Producto>> getProductosByGenero(@PathVariable Integer idGenero)
            throws Exception {
        try {
            return ResponseEntity.ok(productoService.getProductoByGenero(idGenero));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping ("/buscar")
    public ResponseEntity <List<Producto>> getProductoByDescripcionOrColorOrMarca(@RequestParam(required = false) String descripcion,
                                                                 @RequestParam(required = false) String color,
                                                                 @RequestParam(required = false) String marca) {

            return ResponseEntity.ok(productoService.getProductoByDescripcionOrColorOrMarca(descripcion,color,
                    marca));




    }


/*
    @GetMapping ("/generoparam/{idGenero}")
    public ResponseEntity<List<Producto>> getProductosByGenero(@PathVariable String genero)
            throws Exception {
        try {

            return ResponseEntity.ok((List<Producto>) productoService.getProductoByGenero(genero));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }*/



    /*@GetMapping("/products/masbuscados")
    public List<Producto> getLosMasBuscados() {

        return productRepository.findTop10ByOrderBySearchCountDesc();
    }
}*/



   /* @PostMapping ("/update")
    public ResponseEntity <Producto> updateProducto(@RequestBody Producto producto) {
    return null;
    }*/


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
