package accesoDatos;

import entidades.Cliente;
import java.util.List;

/**
 * DAO específico para Cliente
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    public List<Cliente> listarClientes() {
        return listar("SELECT c FROM Cliente c");
    }
}
