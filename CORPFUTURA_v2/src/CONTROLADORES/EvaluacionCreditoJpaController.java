
package CONTROLADORES;

import Entidades.EvaluacionCredito;
import Entidades.EvaluacionCreditoPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.SolicitudCredito;
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
public class EvaluacionCreditoJpaController implements Serializable {

    public EvaluacionCreditoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaluacionCredito evaluacionCredito) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (evaluacionCredito.getEvaluacionCreditoPK() == null) {
            evaluacionCredito.setEvaluacionCreditoPK(new EvaluacionCreditoPK());
        }
        evaluacionCredito.getEvaluacionCreditoPK().setIdSolicitudCredito(evaluacionCredito.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        evaluacionCredito.getEvaluacionCreditoPK().setDui(evaluacionCredito.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        List<String> illegalOrphanMessages = null;
        SolicitudCredito solicitudCreditoOrphanCheck = evaluacionCredito.getSolicitudCredito();
        if (solicitudCreditoOrphanCheck != null) {
            EvaluacionCredito oldEvaluacionCreditoOfSolicitudCredito = solicitudCreditoOrphanCheck.getEvaluacionCredito();
            if (oldEvaluacionCreditoOfSolicitudCredito != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoOrphanCheck + " already has an item of type EvaluacionCredito whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudCredito solicitudCredito = evaluacionCredito.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito = em.getReference(solicitudCredito.getClass(), solicitudCredito.getSolicitudCreditoPK());
                evaluacionCredito.setSolicitudCredito(solicitudCredito);
            }
            em.persist(evaluacionCredito);
            if (solicitudCredito != null) {
                solicitudCredito.setEvaluacionCredito(evaluacionCredito);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEvaluacionCredito(evaluacionCredito.getEvaluacionCreditoPK()) != null) {
                throw new PreexistingEntityException("EvaluacionCredito " + evaluacionCredito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EvaluacionCredito evaluacionCredito) throws IllegalOrphanException, NonexistentEntityException, Exception {
        evaluacionCredito.getEvaluacionCreditoPK().setIdSolicitudCredito(evaluacionCredito.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        evaluacionCredito.getEvaluacionCreditoPK().setDui(evaluacionCredito.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EvaluacionCredito persistentEvaluacionCredito = em.find(EvaluacionCredito.class, evaluacionCredito.getEvaluacionCreditoPK());
            SolicitudCredito solicitudCreditoOld = persistentEvaluacionCredito.getSolicitudCredito();
            SolicitudCredito solicitudCreditoNew = evaluacionCredito.getSolicitudCredito();
            List<String> illegalOrphanMessages = null;
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                EvaluacionCredito oldEvaluacionCreditoOfSolicitudCredito = solicitudCreditoNew.getEvaluacionCredito();
                if (oldEvaluacionCreditoOfSolicitudCredito != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoNew + " already has an item of type EvaluacionCredito whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (solicitudCreditoNew != null) {
                solicitudCreditoNew = em.getReference(solicitudCreditoNew.getClass(), solicitudCreditoNew.getSolicitudCreditoPK());
                evaluacionCredito.setSolicitudCredito(solicitudCreditoNew);
            }
            evaluacionCredito = em.merge(evaluacionCredito);
            if (solicitudCreditoOld != null && !solicitudCreditoOld.equals(solicitudCreditoNew)) {
                solicitudCreditoOld.setEvaluacionCredito(null);
                solicitudCreditoOld = em.merge(solicitudCreditoOld);
            }
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                solicitudCreditoNew.setEvaluacionCredito(evaluacionCredito);
                solicitudCreditoNew = em.merge(solicitudCreditoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EvaluacionCreditoPK id = evaluacionCredito.getEvaluacionCreditoPK();
                if (findEvaluacionCredito(id) == null) {
                    throw new NonexistentEntityException("The evaluacionCredito with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EvaluacionCreditoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EvaluacionCredito evaluacionCredito;
            try {
                evaluacionCredito = em.getReference(EvaluacionCredito.class, id);
                evaluacionCredito.getEvaluacionCreditoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaluacionCredito with id " + id + " no longer exists.", enfe);
            }
            SolicitudCredito solicitudCredito = evaluacionCredito.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito.setEvaluacionCredito(null);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.remove(evaluacionCredito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EvaluacionCredito> findEvaluacionCreditoEntities() {
        return findEvaluacionCreditoEntities(true, -1, -1);
    }

    public List<EvaluacionCredito> findEvaluacionCreditoEntities(int maxResults, int firstResult) {
        return findEvaluacionCreditoEntities(false, maxResults, firstResult);
    }

    private List<EvaluacionCredito> findEvaluacionCreditoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EvaluacionCredito.class));
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

    public EvaluacionCredito findEvaluacionCredito(EvaluacionCreditoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EvaluacionCredito.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvaluacionCreditoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EvaluacionCredito> rt = cq.from(EvaluacionCredito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
