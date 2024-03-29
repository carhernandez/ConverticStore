package com.CONVERTICSHOP.demo.services.ProductoService;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductoService {


    @Autowired
    ProductoRepository productoRepository;


    @Override
    @Transactional
    public List<Producto> obtenerTodos() throws Exception {
        return productoRepository.findAll();   }

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
    }
        @Override
        public Producto actualizarProducto (Integer idProducto) throws Exception {
            return null;
        }

        @Override
        public String borrarProducto (Integer idTipoDocumento) throws Exception {
            return null;
        }

    @Override
    public List<Producto> getProductoByGenero(Integer idGenero) {
        return productoRepository.getByGenero_idGenero(idGenero);
    }

    @Override
    public List<Producto> getProductoByDescripcionOrColorOrMarca(@PathVariable String descripcion,
                                                                 @PathVariable String color,
                                                                 @PathVariable String marca) {
        try {

            List<Producto> productoList = productoRepository.getProductoByDescripcionOrColor_colorOrMarca_idMarca(descripcion,color,marca);
            for (Producto producto : productoList) {
                incrementarContadorBusquedas(producto);
            }
            return productoList;

        }catch (Exception e){
            System.out.println(e.getMessage());
         return null;
        }


    }



    @Override
    public List<Producto> findProductosMasBuscados() {
            return productoRepository.findTop4ByOrderByMasBuscadosDesc();

    }



    @Override
    public List<Producto> obtenerProductosPorGenero(String genero) {
        return productoRepository.getByGenero(genero);
    }

    @Override
    public Producto getProductoPorId(Integer idProducto) {
        return productoRepository.findById(idProducto).get();
    }

    /*@Override
    public List<Producto> findTop04ByOrderBySearchCountDesc() {
        return List<Producto> productoRepository.findTop04ByOrderBySearchCountDesc();
    }
*/
  /*  @Override
    public List<Producto> findTop10ByOrderBySearchCountDesc() {
        return null;
    }*/


    public void incrementarContadorBusquedas (Producto producto) throws Exception {
               producto.setMasBuscados(producto.getMasBuscados() + 1);
               productoRepository.save(producto);
       }

    @Transactional
    public boolean validarInventorio(Integer productId, int cantidad) {
        Optional<Producto> optionalInventory = productoRepository.findById(productId);
        if (optionalInventory.isPresent()) {
            Producto producto = optionalInventory.get();
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                productoRepository.save(producto);
                return true;
            }
        }
        return false;
    }







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





