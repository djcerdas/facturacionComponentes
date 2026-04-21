package accesoDatos;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * DAO genérico para operaciones básicas
 */
public class GenericDAO<T> {

    protected EntityManager em;

    public GenericDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public void guardar(T entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    public T buscar(Class<T> clase, int id) {
        return em.find(clase, id);
    }

    public List<T> listar(String jpql) {
        return em.createQuery(jpql).getResultList();
    }

    public void cerrar() {
        if (em != null) {
            em.close();
        }
    }
}
