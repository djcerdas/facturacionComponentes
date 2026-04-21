package entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entidad Individuo.
 * Representa un cliente de tipo persona física.
 */
@Entity
@Table(name = "individuos")
@PrimaryKeyJoinColumn(name = "id")
public class Individuo extends Cliente {

    private String numeroLic;

    /**
     * Constructor vacío requerido por JPA
     */
    public Individuo() {
        super();
    }

    /**
     * Constructor con parámetros
     */
    public Individuo(String nombre, String direccion, String telefono, String numeroLic) {
        super(nombre, direccion, telefono);
        this.numeroLic = numeroLic;
    }

    // ========================
    // GETTERS
    // ========================

    public String getNumeroLic() {
        return numeroLic;
    }

    // ========================
    // SETTERS
    // ========================

    public void setNumeroLic(String numeroLic) {
        this.numeroLic = numeroLic;
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Individuo{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", numeroLic='" + numeroLic + '\'' +
                '}';
    }
}
