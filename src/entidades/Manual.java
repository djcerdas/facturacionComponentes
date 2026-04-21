package entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entidad Manual.
 * Representa un producto tipo manual.
 */
@Entity
@Table(name = "manuales")
@PrimaryKeyJoinColumn(name = "id")
public class Manual extends Producto {

    private String autor;

    /**
     * Constructor vacío requerido por JPA
     */
    public Manual() {
        super();
    }

    /**
     * Constructor con parámetros
     */
    public Manual(String nombre, String descripcion, double precioPorMenor, String autor) {
        super(nombre, descripcion, precioPorMenor);
        this.autor = autor;
    }

    // ========================
    // GETTERS
    // ========================

    public String getAutor() {
        return autor;
    }

    // ========================
    // SETTERS
    // ========================

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Manual{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
