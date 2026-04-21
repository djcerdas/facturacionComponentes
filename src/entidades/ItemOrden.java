package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad ItemOrden.
 * Representa una línea dentro de una orden (detalle de factura).
 */
@Entity
@Table(name = "item_orden")
public class ItemOrden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int lineNbr;
    private int cantidad;

    // ========================
    // RELACIONES
    // ========================

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    /**
     * Constructor vacío requerido por JPA
     */
    public ItemOrden() {
    }

    /**
     * Constructor con parámetros
     */
    public ItemOrden(int lineNbr, Producto producto, int cantidad) {
        this.lineNbr = lineNbr;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // ========================
    // GETTERS
    // ========================

    public int getId() {
        return id;
    }

    public int getLineNbr() {
        return lineNbr;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Orden getOrden() {
        return orden;
    }

    // ========================
    // SETTERS
    // ========================

    public void setLineNbr(int lineNbr) {
        this.lineNbr = lineNbr;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    // ========================
    // LÓGICA DE NEGOCIO
    // ========================

    /**
     * Obtiene el precio unitario del producto
     */
    public double getPrecioUnitario() {
        return producto.getPrecioPorMenor();
    }

    /**
     * Calcula el impuesto SOLO si el producto es Taxable (Hardware)
     */
    public double getTax() {
        if (producto instanceof Taxable) {
            return ((Taxable) producto).getTax() * cantidad;
        }
        return 0.0;
    }

    /**
     * Calcula el monto total del item
     * (precio * cantidad + impuesto)
     */
    public double getTotalItem() {
        double subtotal = getPrecioUnitario() * cantidad;
        return subtotal + getTax();
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "ItemOrden{" +
                "lineNbr=" + lineNbr +
                ", producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                '}';
    }
}