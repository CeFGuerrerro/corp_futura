
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.InformacionNegocio;
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
public class InformacionNegocioJpaController implements Serializable {

    public InformacionNegocioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InformacionNegocio informacionNegocio) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        DatosPersonales datosPersonalesOrphanCheck = informacionNegocio.getDatosPersonales();
        if (datosPersonalesOrphanCheck != null) {
            InformacionNegocio oldInformacionNegocioOfDatosPersonales = datosPersonalesOrphanCheck.getInformacionNegocio();
            if (oldInformacionNegocioOfDatosPersonales != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesOrphanCheck + " already has an item of type InformacionNegocio whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = informacionNegocio.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                informacionNegocio.setDatosPersonales(datosPersonales);
            }
            em.persist(informacionNegocio);
            if (datosPersonales != null) {
                datosPersonales.setInformacionNegocio(informacionNegocio);
                datosPersonales = em.merge(datosPersonales);
            }
            
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findInformacionNegocio(informacionNegocio.getDui()) != null) {
                throw new PreexistingEntityException("InformacionNegocio " + informacionNegocio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InformacionNegocio informacionNegocio) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InformacionNegocio persistentInformacionNegocio = em.find(InformacionNegocio.class, informacionNegocio.getDui());
            DatosPersonales datosPersonalesOld = persistentInformacionNegocio.getDatosPersonales();
            DatosPersonales datosPersonalesNew = informacionNegocio.getDatosPersonales();
            List<String> illegalOrphanMessages = null;
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                InformacionNegocio oldInformacionNegocioOfDatosPersonales = datosPersonalesNew.getInformacionNegocio();
                if (oldInformacionNegocioOfDatosPersonales != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The DatosPersonales " + datosPersonalesNew + " already has an item of type InformacionNegocio whose datosPersonales column cannot be null. Please make another selection for the datosPersonales field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                informacionNegocio.setDatosPersonales(datosPersonalesNew);
            }
            informacionNegocio = em.merge(informacionNegocio);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.setInformacionNegocio(null);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.setInformacionNegocio(informacionNegocio);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
            em.refresh(informacionNegocio);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = informacionNegocio.getDui();
                if (findInformacionNegocio(id) == null) {
                    throw new NonexistentEntityException("The informacionNegocio with id " + id + " no longer exists.");
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
            InformacionNegocio informacionNegocio;
            try {
                informacionNegocio = em.getReference(InformacionNegocio.class, id);
                informacionNegocio.getDui();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The informacionNegocio with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = informacionNegocio.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.setInformacionNegocio(null);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(informacionNegocio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InformacionNegocio> findInformacionNegocioEntities() {
        return findInformacionNegocioEntities(true, -1, -1);
    }

    public List<InformacionNegocio> findInformacionNegocioEntities(int maxResults, int firstResult) {
        return findInformacionNegocioEntities(false, maxResults, firstResult);
    }

    private List<InformacionNegocio> findInformacionNegocioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InformacionNegocio.class));
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

    public InformacionNegocio findInformacionNegocio(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InformacionNegocio.class, id);
        } finally {
            em.close();
        }
    }

    public int getInformacionNegocioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InformacionNegocio> rt = cq.from(InformacionNegocio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
