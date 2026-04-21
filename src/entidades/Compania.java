package entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad Compania.
 * Representa un cliente de tipo empresa.
 */
@Entity
@Table(name = "companias")
public class Compania extends Cliente {

    private String contacto;
    private int descuento;

    /**
     * Constructor vacío requerido por JPA
     */
    public Compania() {
        super();
    }

    /**
     * Constructor con parámetros
     */
    public Compania(String nombre, String direccion, String telefono,
                    String contacto, int descuento) {
        super(nombre, direccion, telefono);
        this.contacto = contacto;
        this.descuento = descuento;
    }

    // ========================
    // GETTERS
    // ========================

    public String getContacto() {
        return contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    // ========================
    // SETTERS
    // ========================

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Compania{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", contacto='" + contacto + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
