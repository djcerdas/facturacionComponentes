package logicaNegocio;

import accesoDatos.*;
import entidades.*;

import java.util.Date;

public class FacturaService {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ProductoDAO productoDAO = new ProductoDAO();
    private GenericDAO<Orden> ordenDAO = new GenericDAO<>();

    public Orden crearOrden(int cManual, int cSoftware, int cHardware) {

        // ========================
        // CLIENTE
        // ========================
        Individuo cliente = new Individuo(
                "David Cerdas",
                "Curridabat",
                "8888-8888",
                "LIC-001"
        );

        clienteDAO.guardar(cliente);

        // ========================
        // PRODUCTOS
        // ========================
        Manual manual = new Manual(
                "Manual Usuario",
                "Guía básica",
                100.0,
                "Autor X"
        );

        Software software = new Software(
                "Software Licencia",
                "Sistema ERP",
                175.0,
                "LIC-ERP"
        );

        Hardware hardware = new Hardware(
                "Mouse",
                "Mouse Gamer",
                200.0,
                12
        );

        productoDAO.guardar(manual);
        productoDAO.guardar(software);
        productoDAO.guardar(hardware);

        // ========================
        // ORDEN
        // ========================
        Orden orden = new Orden(cliente, new Date());

        if (cManual > 0)
            orden.agregarItemOrden(new ItemOrden(1, manual, cManual));

        if (cSoftware > 0)
            orden.agregarItemOrden(new ItemOrden(2, software, cSoftware));

        if (cHardware > 0)
            orden.agregarItemOrden(new ItemOrden(3, hardware, cHardware));

        orden.calcularTotal();

        ordenDAO.guardar(orden);

        return orden;
    }
}
