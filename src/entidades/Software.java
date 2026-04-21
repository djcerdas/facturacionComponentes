package entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entidad Software.
 * Representa un producto tipo software.
 */
@Entity
@Table(name = "software")
@PrimaryKeyJoinColumn(name = "id")
public class Software extends Producto {

    private String licencia;

    /**
     * Constructor vacío requerido por JPA
     */
    public Software() {
        super();
    }

    /**
     * Constructor con parámetros
     */
    public Software(String nombre, String descripcion, double precioPorMenor, String licencia) {
        super(nombre, descripcion, precioPorMenor);
        this.licencia = licencia;
    }

    // ========================
    // GETTERS
    // ========================

    public String getLicencia() {
        return licencia;
    }

    // ========================
    // SETTERS
    // ========================

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Software{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }
}
