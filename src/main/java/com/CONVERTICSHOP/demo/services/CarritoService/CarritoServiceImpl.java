package com.CONVERTICSHOP.demo.services.CarritoService;

import com.CONVERTICSHOP.demo.modelo.Carrito;
import com.CONVERTICSHOP.demo.repository.CarritoRepository;
import com.CONVERTICSHOP.demo.repository.TallaRepository;
import com.CONVERTICSHOP.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {


    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TallaRepository tallaRepository;

    public List<Carrito> findAll() throws Exception {
        try{
            return carritoRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Carrito obtenerCarrito(Integer idCarrito) {
        return carritoRepository.findById(idCarrito).get();
    }

    @Override
    public Carrito registrarCarrito(Carrito carrito) throws Exception {
        try {
            return carritoRepository.save(carrito);

        }catch (Exception e){

            throw new Exception(e.getMessage());
        }
    }

    /*@Override
    public List<Carrito> obtenerCarritoPorUsuarioId(Integer idUsuario) throws Exception {
        try {
            return carritoRepository.getByUsuario(idUsuario);

        }catch (Exception e){

            throw new Exception(e.getMessage());
        }
    }*/

    @Override
    public void delete(Integer id) throws Exception {
        try {
            carritoRepository.deleteById(id);

        }catch (Exception e){

            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void actualizarInventario(Integer id) throws Exception {

    }



/*    @Override
    public void actualizarInventario(Integer id) throws Exception {
        try {
            List<Carrito> carritoList = carritoRepository.findCarritoCompraByUsuarioId(id);
            for (Carrito carrito : carritoList) {
                Integer idProductoTalla = carrito.get().getId();
                Integer cantidad = carrito.getCantidad();
                ProductoTalla productoTalla = productoTallaRepositorio.findById(idProductoTalla).orElseThrow();

                Integer nuevoInventario = productoTalla.getStock() - cantidad;
                productoTalla.setStock(nuevoInventario);
                productoTallaRepositorio.save(productoTalla);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    }*/
}
