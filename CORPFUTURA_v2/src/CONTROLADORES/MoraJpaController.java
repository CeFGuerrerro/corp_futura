
package CONTROLADORES;

import Entidades.Mora;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.SolicitudCredito;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author o-a19
 */
public class MoraJpaController implements Serializable {

    public MoraJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mora mora) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudCredito solicitudCredito = mora.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito = em.getReference(solicitudCredito.getClass(), solicitudCredito.getSolicitudCreditoPK());
                mora.setSolicitudCredito(solicitudCredito);
            }
            em.persist(mora);
            if (solicitudCredito != null) {
                solicitudCredito.getMoraList().add(mora);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.getTransaction().commit();
            em.refresh(solicitudCredito);
        } catch (Exception ex) {
            if (findMora(mora.getIdMora()) != null) {
                throw new PreexistingEntityException("Mora " + mora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mora mora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mora persistentMora = em.find(Mora.class, mora.getIdMora());
            SolicitudCredito solicitudCreditoOld = persistentMora.getSolicitudCredito();
            SolicitudCredito solicitudCreditoNew = mora.getSolicitudCredito();
            if (solicitudCreditoNew != null) {
                solicitudCreditoNew = em.getReference(solicitudCreditoNew.getClass(), solicitudCreditoNew.getSolicitudCreditoPK());
                mora.setSolicitudCredito(solicitudCreditoNew);
            }
            mora = em.merge(mora);
            if (solicitudCreditoOld != null && !solicitudCreditoOld.equals(solicitudCreditoNew)) {
                solicitudCreditoOld.getMoraList().remove(mora);
                solicitudCreditoOld = em.merge(solicitudCreditoOld);
            }
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                solicitudCreditoNew.getMoraList().add(mora);
                solicitudCreditoNew = em.merge(solicitudCreditoNew);
            }
            em.getTransaction().commit();
            em.refresh(mora);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mora.getIdMora();
                if (findMora(id) == null) {
                    throw new NonexistentEntityException("The mora with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mora mora;
            try {
                mora = em.getReference(Mora.class, id);
                mora.getIdMora();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mora with id " + id + " no longer exists.", enfe);
            }
            SolicitudCredito solicitudCredito = mora.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito.getMoraList().remove(mora);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.remove(mora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mora> findMoraEntities() {
        return findMoraEntities(true, -1, -1);
    }

    public List<Mora> findMoraEntities(int maxResults, int firstResult) {
        return findMoraEntities(false, maxResults, firstResult);
    }

    private List<Mora> findMoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mora.class));
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

    public Mora findMora(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mora.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mora> rt = cq.from(Mora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Mora> getMorasActivas(Short estado1) {
        
   
        EntityManager em = getEntityManager();
        Query consulta = em.createNamedQuery("Mora.findByEstado", Mora.class);
        consulta.setParameter("estado", estado1);
        
        List<Mora> lista =null;
        
        try{
            lista = consulta.getResultList();
        } catch (NoResultException e){
        } finally {
            em.close();
        }
        
        return lista;
    }
    
    
}
