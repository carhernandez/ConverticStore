package com.CONVERTICSHOP.demo.services.ProductoService;

import com.CONVERTICSHOP.demo.modelo.*;
import com.CONVERTICSHOP.demo.repository.GeneroRepository;
import com.CONVERTICSHOP.demo.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductServicesImpl implements ProductoService {


    @Autowired
    ProductoRepository productoRepository;


    @Override
    @Transactional
    public List<Producto> obtenerTodos() throws Exception {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto actualizarProducto(Integer idProducto) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public String borrarProducto(Integer idTipoDocumento) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Producto obtenerProductoPorIdGenero(Integer idGenero) throws Exception {
        return null;
    }

   /* @Override
    public Producto obtenerProductoPorIdGenero(Integer idGenero) throws Exception {
        return (Producto) productoRepository.findByIdGenero(idGenero).get(idGenero);
    }*/

    /*@Override
    @Transactional
    public List<Producto> getProductoByGenero(int idGenero) {
        List<Producto> productos = productoRepository.getProductoByGenero(idGenero);
        productos.forEach(producto -> {
            System.out.println(producto.toString());
        });

        return productoRepository.getProductoByGenero(idGenero);
    }*/



    @Override
    @Transactional
    public Producto crearProducto(Producto producto) throws Exception {
        try {
            producto.setMarca(productoRepository.findById(producto.getMarca().getIdMarca()).get().getMarca());
            producto.setColor(productoRepository.findById(producto.getColor().getIdColor()).get().getColor());
            producto.setGenero(productoRepository.findById(producto.getGenero().getIdGenero()).get().getGenero());
            producto.setTalla(productoRepository.findById(producto.getTalla().getIdTalla()).get().getTalla());
            return productoRepository.save(producto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

       /* public void incrementarContadorBusquedas (Integer idProducto) throws Exception {
                Optional < Producto > contadorProducto = productoRepository.findById(idProducto);
        if (contadorProducto.isPresent()) {
            Producto producto1 = contadorProducto.get();
            producto.setMasBuscados(producto.getMasBuscados() + 1);
            productoRepository.save(producto1);
        }*/



   /* @Autowired
    private ProductoRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private MarcaRepository marcaRepository;

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
    public String borrarProducto(Integer idProducto) throws Exception {
        try {
            productRepository.findById(idProducto)
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no existe con esa id :" + idProducto));
            productRepository.deleteById(idProducto);
            return "se borro el producto correctamente ";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(int idProducto) {
        return productRepository.findById(idProducto);
    }
*/

   /* @Autowired
    private ProductoRepository productosRepository;

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
}
