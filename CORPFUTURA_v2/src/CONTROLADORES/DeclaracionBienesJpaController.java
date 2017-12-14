
package CONTROLADORES;

import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.DeclaracionBienes;
import Entidades.DeclaracionBienesPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DFUENTES
 */
public class DeclaracionBienesJpaController implements Serializable {

   public DeclaracionBienesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DeclaracionBienes declaracionBienes) throws PreexistingEntityException, Exception {
        if (declaracionBienes.getDeclaracionBienesPK() == null) {
            declaracionBienes.setDeclaracionBienesPK(new DeclaracionBienesPK());
        }
        declaracionBienes.getDeclaracionBienesPK().setDui(declaracionBienes.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = declaracionBienes.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                declaracionBienes.setDatosPersonales(datosPersonales);
            }
            em.persist(declaracionBienes);
            if (datosPersonales != null) {
                datosPersonales.getDeclaracionBienesList().add(declaracionBienes);
                datosPersonales = em.merge(datosPersonales);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDeclaracionBienes(declaracionBienes.getDeclaracionBienesPK()) != null) {
                throw new PreexistingEntityException("DeclaracionBienes " + declaracionBienes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DeclaracionBienes declaracionBienes) throws NonexistentEntityException, Exception {
        declaracionBienes.getDeclaracionBienesPK().setDui(declaracionBienes.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DeclaracionBienes persistentDeclaracionBienes = em.find(DeclaracionBienes.class, declaracionBienes.getDeclaracionBienesPK());
            DatosPersonales datosPersonalesOld = persistentDeclaracionBienes.getDatosPersonales();
            DatosPersonales datosPersonalesNew = declaracionBienes.getDatosPersonales();
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                declaracionBienes.setDatosPersonales(datosPersonalesNew);
            }
            declaracionBienes = em.merge(declaracionBienes);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.getDeclaracionBienesList().remove(declaracionBienes);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.getDeclaracionBienesList().add(declaracionBienes);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DeclaracionBienesPK id = declaracionBienes.getDeclaracionBienesPK();
                if (findDeclaracionBienes(id) == null) {
                    throw new NonexistentEntityException("The declaracionBienes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DeclaracionBienesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DeclaracionBienes declaracionBienes;
            try {
                declaracionBienes = em.getReference(DeclaracionBienes.class, id);
                declaracionBienes.getDeclaracionBienesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The declaracionBienes with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = declaracionBienes.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.getDeclaracionBienesList().remove(declaracionBienes);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(declaracionBienes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DeclaracionBienes> findDeclaracionBienesEntities() {
        return findDeclaracionBienesEntities(true, -1, -1);
    }

    public List<DeclaracionBienes> findDeclaracionBienesEntities(int maxResults, int firstResult) {
        return findDeclaracionBienesEntities(false, maxResults, firstResult);
    }

    private List<DeclaracionBienes> findDeclaracionBienesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DeclaracionBienes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DeclaracionBienes findDeclaracionBienes(DeclaracionBienesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DeclaracionBienes.class, id);
        } finally {
            em.close();
        }
    }

    public int getDeclaracionBienesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DeclaracionBienes> rt = cq.from(DeclaracionBienes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
