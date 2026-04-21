package entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entidad Hardware.
 * Representa un producto físico que aplica impuestos.
 */
@Entity
@Table(name = "hardware")
@PrimaryKeyJoinColumn(name = "id")
public class Hardware extends Producto implements Taxable {

    private int periodoGarantia;

    private static final double TAX_RATE = 0.13;

    /**
     * Constructor vacío requerido por JPA
     */
    public Hardware() {
        super();
    }

    /**
     * Constructor con parámetros
     */
    public Hardware(String nombre, String descripcion, double precioPorMenor, int periodoGarantia) {
        super(nombre, descripcion, precioPorMenor);
        this.periodoGarantia = periodoGarantia;
    }

    // ========================
    // GETTERS
    // ========================

    public int getPeriodoGarantia() {
        return periodoGarantia;
    }

    // ========================
    // SETTERS
    // ========================

    public void setPeriodoGarantia(int periodoGarantia) {
        this.periodoGarantia = periodoGarantia;
    }

    // ========================
    // LÓGICA DE IMPUESTO
    // ========================

    @Override
    public double getTax() {
        return getPrecioPorMenor() * TAX_RATE;
    }

    // ========================
    // toString
    // ========================

    @Override
    public String toString() {
        return "Hardware{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", garantia=" + periodoGarantia +
                '}';
    }
}
