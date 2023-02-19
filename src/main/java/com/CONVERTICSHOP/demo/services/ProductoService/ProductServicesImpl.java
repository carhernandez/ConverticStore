package com.CONVERTICSHOP.demo.services.ProductoService;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //obtener todos los Productos
    @Override
    @Transactional (readOnly = true)
    public List<Producto> obtenerTodos() throws Exception {
        try {
            return productRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Crear un Producto
    @Override
    @Transactional
    public Producto crearProducto(Producto producto) throws Exception {
        try {

            return productRepository.save(producto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    //Actualizar un Producto
    @Override
    @Transactional
    public Producto actualizarProducto(Integer idProducto) throws Exception {
        return null;
    }

    //Borrar un Producto
    @Override
    @Transactional
    public String borrarProducto(Integer IdUsuario) throws Exception {
        try {
            productRepository.findById(IdUsuario)
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no existe con esa id :" + IdUsuario));
            productRepository.deleteById(IdUsuario);
            return "se borro el producto correctamente ";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(int idProducto) {
        return productRepository.findById(idProducto);
    }


   /* @Autowired
    private ProductRepository productosRepository;

    //obtener todos los usuario
    public ResponseEntity<List<Producto>> getAllProductos() {
        return new ResponseEntity<>(productosRepository.findAll(), HttpStatus.OK);
    }

    // crear producto rest api
    public ResponseEntity <Producto> createProducto(Producto producto) {
        return new ResponseEntity<>(productosRepository.save(producto),HttpStatus.OK) ;
    }


    // obtener producto por id rest api
    public ResponseEntity<Producto> getProductosById(Integer idProducto) {
        Producto producto = (Producto) productosRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no existe con esa id :" +
                        idProducto));
        return ResponseEntity.ok(producto);
    }

    // actualizar producto rest api
    public ResponseEntity<Producto> updateProductos(int idProducto, Producto producto) {
        Producto producto1 = (Producto) productosRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no existe con esa id :" + idProducto));


        producto.setIdProducto(producto1.getIdProducto());
        producto.setDescripcion(producto1.getDescripcion());
        producto.setIdGenero(producto1.getIdGenero());
        producto.setMarca(producto1.getMarca());
        producto.setIdColor(producto1.getIdColor());
        producto.setIdTalla(producto1.getIdTalla());
        producto.setCantidad(producto1.getCantidad());
        producto.setValor(producto1.getValor());

        Producto updateProducto = productosRepository.save(producto);
        return ResponseEntity.ok(updateProducto);
    }

    // borrar producto rest api
    public ResponseEntity<Map<String, Boolean>> deleteProducto(int idProductos) {
        Producto producto = (Producto) productosRepository.findByIdProducto(idProductos)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no existe con esa id :" + idProductos));

        productosRepository.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/



    /*public ResponseEntity <List<Producto>> getIdProductoAndDescripcion(int idProductos , String descripcion) {
        List<Producto> productos = (List<Producto>) productosRepository.findByIdProductosAndDescripcion(idProductos, descripcion)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idProductos));
        return ResponseEntity.ok(productos);
    }

    public ResponseEntity <List<Producto>> getIdProdcutoAndDescripcion(int idProductos , String descripcion) {
        List<Producto> productos = (List<Producto>) productosRepository.findByIdProductosAndDescripcion(idProductos, descripcion)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idProductos));
        return ResponseEntity.ok(productos);
    }

    /*public ResponseEntity <List<Usuario>> getUsuarioOrNombres(int idUsuarios , String nombres) {
        List<Usuario> usuario = productosRepository.findByIdUsuarioOrNombres(idUsuarios, nombres)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuario);
    }*/


}
