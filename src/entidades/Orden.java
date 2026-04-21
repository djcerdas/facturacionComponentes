package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Entidad Orden.
 * Representa una orden de compra (factura).
 */
@Entity
@Table(name = "ordenes")
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fechaOrden;
    private double totalOrden;

    // ========================
    // RELACIONES
    // ========================

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<ItemOrden> items = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA
     */
    public Orden() {
    }

    /**
     * Constructor con parámetros
     */
    public Orden(Cliente cliente, Date fechaOrden) {
        this.cliente = cliente;
        this.fechaOrden = fechaOrden;
    }

    // ========================
    // GETTERS
    // ========================

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemOrden> getItems() {
        return items;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public double getTotalOrden() {
        return totalOrden;
    }

    // ========================
    // SETTERS
    // ========================

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setItems(List<ItemOrden> items) {
        this.items = items;
    }

    // ========================
    // LÓGICA DE NEGOCIO
    // ========================

    /**
     * Agrega un item a la orden
     */
    public void agregarItemOrden(ItemOrden item) {
        item.setOrden(this); // importante para relación bidireccional
        items.add(item);
    }

    /**
     * Calcula el total de la orden
     */
    public double calcularTotal() {
        double total = 0.0;

        for (ItemOrden item : items) {
            total += item.getTotalItem();
        }

        this.totalOrden = total;
        return total;
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", fecha=" + fechaOrden +
                ", total=" + totalOrden +
                '}';
    }
}
