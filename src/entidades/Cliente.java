package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad base Cliente.
 * Representa un cliente general del sistema de facturación.
 */
@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * Constructor vacío requerido por JPA
     */
    public Cliente() {
    }

    /**
     * Constructor con parámetros básicos
     */
    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // ========================
    // GETTERS
    // ========================

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // ========================
    // SETTERS
    // ========================

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // (No agregamos setters extra para no salirnos del UML)

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
