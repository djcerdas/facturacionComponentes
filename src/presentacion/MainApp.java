package presentacion;

import accesoDatos.*;
import entidades.*;

import java.util.Date;

public class MainApp {

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        GenericDAO<Orden> ordenDAO = new GenericDAO<>();

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

        // Items
        ItemOrden item1 = new ItemOrden(1, manual, 1);
        ItemOrden item2 = new ItemOrden(2, software, 3);
        ItemOrden item3 = new ItemOrden(3, hardware, 2);

        orden.agregarItemOrden(item1);
        orden.agregarItemOrden(item2);
        orden.agregarItemOrden(item3);

        orden.calcularTotal();

        ordenDAO.guardar(orden);

        System.out.println("Orden guardada correctamente");
        System.out.println("Total: " + orden.getTotalOrden());
    }
}