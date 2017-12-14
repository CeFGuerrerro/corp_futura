
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.Domicilio;
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
public class DomicilioJpaController implements Serializable {

    public DomicilioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Domicilio domicilio) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        DatosPersonales datosPersonalesOrphanCheck = domicilio.getDatosPersonales();
        if (datosPersonalesOrphanCheck != null) {
            Domicilio oldDomicilioOfDatosPersonales = datosPersonalesOrphanCheck.getDomicilio();
            if (oldDomicilioOfDatosPersonales != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesOrphanCheck + " already has an item of type Domicilio whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = domicilio.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                domicilio.setDatosPersonales(datosPersonales);
            }
            em.persist(domicilio);
            if (datosPersonales != null) {
                datosPersonales.setDomicilio(domicilio);
                datosPersonales = em.merge(datosPersonales);
            }
            
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findDomicilio(domicilio.getDui()) != null) {
                throw new PreexistingEntityException("Domicilio " + domicilio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Domicilio domicilio) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Domicilio persistentDomicilio = em.find(Domicilio.class, domicilio.getDui());
            DatosPersonales datosPersonalesOld = persistentDomicilio.getDatosPersonales();
            DatosPersonales datosPersonalesNew = domicilio.getDatosPersonales();
            List<String> illegalOrphanMessages = null;
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                Domicilio oldDomicilioOfDatosPersonales = datosPersonalesNew.getDomicilio();
                if (oldDomicilioOfDatosPersonales != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesNew + " already has an item of type Domicilio whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                domicilio.setDatosPersonales(datosPersonalesNew);
            }
            domicilio = em.merge(domicilio);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.setDomicilio(null);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.setDomicilio(domicilio);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            
            em.getTransaction().commit();
            em.refresh(domicilio);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = domicilio.getDui();
                if (findDomicilio(id) == null) {
                    throw new NonexistentEntityException("The domicilio with id " + id + " no longer exists.");
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
            Domicilio domicilio;
            try {
                domicilio = em.getReference(Domicilio.class, id);
                domicilio.getDui();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The domicilio with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = domicilio.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.setDomicilio(null);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(domicilio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Domicilio> findDomicilioEntities() {
        return findDomicilioEntities(true, -1, -1);
    }

    public List<Domicilio> findDomicilioEntities(int maxResults, int firstResult) {
        return findDomicilioEntities(false, maxResults, firstResult);
    }

    private List<Domicilio> findDomicilioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Domicilio.class));
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

    public Domicilio findDomicilio(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Domicilio.class, id);
        } finally {
            em.close();
        }
    }

    public int getDomicilioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Domicilio> rt = cq.from(Domicilio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
