package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad base Producto.
 * Representa un producto general en el sistema.
 */
@Entity
@Table(name = "productos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
    private double precioPorMenor;

    /**
     * Constructor vacío requerido por JPA
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros
     */
    public Producto(String nombre, String descripcion, double precioPorMenor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorMenor = precioPorMenor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioPorMenor() {
        return precioPorMenor;
    }

    // ========================
    // SETTERS
    // ========================

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }


    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioPorMenor=" + precioPorMenor +
                '}';
    }
}
