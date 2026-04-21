package accesoDatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilidad para manejar JPA
 */
public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("FacturacionPU");

    /**
     * Obtiene un EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Cerrar fábrica (opcional)
     */
    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
