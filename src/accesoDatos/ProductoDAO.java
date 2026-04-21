package accesoDatos;

import entidades.Producto;
import java.util.List;

/**
 * DAO para manejar productos
 */
public class ProductoDAO extends GenericDAO<Producto> {

    public List<Producto> listarProductos() {
        return listar("SELECT p FROM Producto p");
    }
}
