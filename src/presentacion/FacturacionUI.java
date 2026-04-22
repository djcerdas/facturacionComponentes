package presentacion;

import javax.swing.*;
import java.awt.*;

import accesoDatos.*;
import entidades.*;
import logicaNegocio.FacturaService;
import java.util.Date;

public class FacturacionUI extends JFrame {
	private FacturaService service = new FacturaService();

    // Contadores
    private int cManual = 0;
    private int cSoftware = 0;
    private int cHardware = 0;

    // Labels dinámicos
    private JLabel lblManual;
    private JLabel lblSoftware;
    private JLabel lblHardware;

    public FacturacionUI() {

        setTitle("Factura");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     // contenedor central con ancho controlado
     JPanel wrapper = new JPanel(new GridBagLayout());
     add(wrapper, BorderLayout.CENTER);

     // panel real con tamaño fijo
     JPanel panelPrincipal = new JPanel();
     panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
     panelPrincipal.setPreferredSize(new Dimension(300, 200));

     // ========================
     // PANEL PRODUCTOS
     // ========================
     JPanel panelProductos = new JPanel(new GridLayout(3, 1, 5, 5));
     panelProductos.add(crearFila("Manual"));
     panelProductos.add(crearFila("Software"));
     panelProductos.add(crearFila("Hardware"));

     panelPrincipal.add(panelProductos);

     // ========================
     // BOTÓN
     // ========================
     JPanel panelBoton = new JPanel();
     JButton boton = new JButton("Calcular Total");
     boton.setPreferredSize(new Dimension(180, 30));
     panelBoton.add(boton);

     panelPrincipal.add(panelBoton);

     // centrado real
     wrapper.add(panelPrincipal);

     boton.addActionListener(e -> ejecutarFlujo());
     }
    

    // ========================
    // CREAR FILA (+ / -)
    // ========================
    private JPanel crearFila(String nombre) {

        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JLabel titulo = new JLabel(nombre + ":");
        titulo.setPreferredSize(new Dimension(80, 20));

        JButton btnMenos = new JButton("-");
        JButton btnMas = new JButton("+");

        btnMenos.setPreferredSize(new Dimension(45, 25));
        btnMas.setPreferredSize(new Dimension(45, 25));

        JLabel label = new JLabel("0");
        label.setPreferredSize(new Dimension(30, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Asignar referencia
        if (nombre.equals("Manual")) lblManual = label;
        if (nombre.equals("Software")) lblSoftware = label;
        if (nombre.equals("Hardware")) lblHardware = label;

        btnMenos.addActionListener(e -> {
            int valor = getValor(nombre) - 1;
            valor = Math.max(0, valor);
            setValor(nombre, valor);
        });

        btnMas.addActionListener(e -> {
            int valor = getValor(nombre) + 1;
            setValor(nombre, valor);
        });

        fila.add(titulo);
        fila.add(btnMenos);
        fila.add(label);
        fila.add(btnMas);

        return fila;
    }

    private int getValor(String nombre) {
        switch (nombre) {
            case "Manual": return cManual;
            case "Software": return cSoftware;
            case "Hardware": return cHardware;
            default: return 0;
        }
    }

    private void setValor(String nombre, int valor) {
        switch (nombre) {
            case "Manual":
                cManual = valor;
                lblManual.setText(String.valueOf(valor));
                break;
            case "Software":
                cSoftware = valor;
                lblSoftware.setText(String.valueOf(valor));
                break;
            case "Hardware":
                cHardware = valor;
                lblHardware.setText(String.valueOf(valor));
                break;
        }
    }

    // ========================
    // TU LÓGICA ORIGINAL (SIN CAMBIOS)
    // ========================
    private void ejecutarFlujo() {

        try {

            if (cManual == 0 && cSoftware == 0 && cHardware == 0) {
                JOptionPane.showMessageDialog(this, "Seleccione al menos un producto");
                return;
            }

            Orden orden = service.crearOrden(cManual, cSoftware, cHardware);

            mostrarFacturaUI(orden, (Individuo) orden.getCliente());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error ejecutando flujo");
        }
    }
    
    private void mostrarFacturaUI(Orden orden, Individuo cliente) {

        JFrame facturaFrame = new JFrame("Factura");
        facturaFrame.setSize(600, 400);
        facturaFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ========================
        // HEADER
        // ========================
        JPanel header = new JPanel(new GridLayout(2, 2));

        header.add(new JLabel("Factura"));
        header.add(new JLabel("Numero de orden: " + orden.getId()));

        header.add(new JLabel("Cliente: " + cliente.getNombre()));
        header.add(new JLabel("Fecha: " + new java.util.Date()));

        mainPanel.add(header, BorderLayout.NORTH);

        // ========================
        // TABLA
        // ========================
        JPanel tabla = new JPanel(new GridLayout(0, 6));
        tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Encabezados
        tabla.add(new JLabel("Linea"));
        tabla.add(new JLabel("Descripcion"));
        tabla.add(new JLabel("Cantidad"));
        tabla.add(new JLabel("Precio"));
        tabla.add(new JLabel("Impuesto"));
        tabla.add(new JLabel("Monto"));

        int linea = 1;

        for (ItemOrden item : orden.getItems()) {

            tabla.add(new JLabel(String.valueOf(linea++)));
            tabla.add(new JLabel(item.getProducto().getNombre()));
            tabla.add(new JLabel(String.valueOf(item.getCantidad())));

            // TODO VIENE DEL MODELO (JPA)
            tabla.add(new JLabel(String.valueOf(item.getPrecioUnitario())));
            tabla.add(new JLabel(String.valueOf(item.getTax())));
            tabla.add(new JLabel(String.valueOf(item.getTotalItem())));
        }

        mainPanel.add(tabla, BorderLayout.CENTER);

        // ========================
        // TOTAL
        // ========================
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.add(new JLabel("Total: $" + orden.getTotalOrden()));

        mainPanel.add(footer, BorderLayout.SOUTH);

        facturaFrame.add(mainPanel);
        facturaFrame.setVisible(true);
    }
}