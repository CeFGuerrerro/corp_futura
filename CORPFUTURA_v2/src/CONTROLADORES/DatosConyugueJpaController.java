
package CONTROLADORES;

import Entidades.DatosConyugue;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author o-a19
 */
public class DatosConyugueJpaController implements Serializable {

    public DatosConyugueJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosConyugue datosConyugue) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        DatosPersonales datosPersonalesOrphanCheck = datosConyugue.getDatosPersonales();
        if (datosPersonalesOrphanCheck != null) {
            DatosConyugue oldDatosConyugueOfDatosPersonales = datosPersonalesOrphanCheck.getDatosConyugue();
            if (oldDatosConyugueOfDatosPersonales != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesOrphanCheck + " already has an item of type DatosConyugue whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = datosConyugue.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                datosConyugue.setDatosPersonales(datosPersonales);
            }
            em.persist(datosConyugue);
            if (datosPersonales != null) {
                datosPersonales.setDatosConyugue(datosConyugue);
                datosPersonales = em.merge(datosPersonales);
            }
            
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findDatosConyugue(datosConyugue.getDui()) != null) {
                throw new PreexistingEntityException("DatosConyugue " + datosConyugue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosConyugue datosConyugue) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosConyugue persistentDatosConyugue = em.find(DatosConyugue.class, datosConyugue.getDui());
            DatosPersonales datosPersonalesOld = persistentDatosConyugue.getDatosPersonales();
            DatosPersonales datosPersonalesNew = datosConyugue.getDatosPersonales();
            List<String> illegalOrphanMessages = null;
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                DatosConyugue oldDatosConyugueOfDatosPersonales = datosPersonalesNew.getDatosConyugue();
                if (oldDatosConyugueOfDatosPersonales != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesNew + " already has an item of type DatosConyugue whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                datosConyugue.setDatosPersonales(datosPersonalesNew);
            }
            datosConyugue = em.merge(datosConyugue);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.setDatosConyugue(null);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.setDatosConyugue(datosConyugue);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
            em.refresh(datosConyugue);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datosConyugue.getDui();
                if (findDatosConyugue(id) == null) {
                    throw new NonexistentEntityException("The datosConyugue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosConyugue datosConyugue;
            try {
                datosConyugue = em.getReference(DatosConyugue.class, id);
                datosConyugue.getDui();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosConyugue with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = datosConyugue.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.setDatosConyugue(null);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(datosConyugue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosConyugue> findDatosConyugueEntities() {
        return findDatosConyugueEntities(true, -1, -1);
    }

    public List<DatosConyugue> findDatosConyugueEntities(int maxResults, int firstResult) {
        return findDatosConyugueEntities(false, maxResults, firstResult);
    }

    private List<DatosConyugue> findDatosConyugueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosConyugue.class));
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

    public DatosConyugue findDatosConyugue(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosConyugue.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosConyugueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosConyugue> rt = cq.from(DatosConyugue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
