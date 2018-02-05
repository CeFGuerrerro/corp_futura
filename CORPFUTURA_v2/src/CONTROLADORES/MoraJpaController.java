/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;
 
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import Entidades.Creditos;
import Entidades.Mora;
import Entidades.MoraPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.SolicitudCredito;
import UTILIDADES.monto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author dvid1
 */
public class MoraJpaController implements Serializable {

    public MoraJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mora mora) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (mora.getMoraPK() == null) {
            mora.setMoraPK(new MoraPK());
        }
        mora.getMoraPK().setDui(mora.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        mora.getMoraPK().setIdSolicitudCredito(mora.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        List<String> illegalOrphanMessages = null;
        SolicitudCredito solicitudCreditoOrphanCheck = mora.getSolicitudCredito();
        if (solicitudCreditoOrphanCheck != null) {
            Mora oldMoraOfSolicitudCredito = solicitudCreditoOrphanCheck.getMora();
            if (oldMoraOfSolicitudCredito != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoOrphanCheck + " already has an item of type Mora whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
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
                solicitudCredito.setMora(mora);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMora(mora.getMoraPK()) != null) {
                throw new PreexistingEntityException("Mora " + mora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mora mora) throws IllegalOrphanException, NonexistentEntityException, Exception {
        mora.getMoraPK().setDui(mora.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        mora.getMoraPK().setIdSolicitudCredito(mora.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mora persistentMora = em.find(Mora.class, mora.getMoraPK());
            SolicitudCredito solicitudCreditoOld = persistentMora.getSolicitudCredito();
            SolicitudCredito solicitudCreditoNew = mora.getSolicitudCredito();
            List<String> illegalOrphanMessages = null;
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                Mora oldMoraOfSolicitudCredito = solicitudCreditoNew.getMora();
                if (oldMoraOfSolicitudCredito != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoNew + " already has an item of type Mora whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (solicitudCreditoNew != null) {
                solicitudCreditoNew = em.getReference(solicitudCreditoNew.getClass(), solicitudCreditoNew.getSolicitudCreditoPK());
                mora.setSolicitudCredito(solicitudCreditoNew);
            }
            mora = em.merge(mora);
            if (solicitudCreditoOld != null && !solicitudCreditoOld.equals(solicitudCreditoNew)) {
                solicitudCreditoOld.setMora(null);
                solicitudCreditoOld = em.merge(solicitudCreditoOld);
            }
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                solicitudCreditoNew.setMora(mora);
                solicitudCreditoNew = em.merge(solicitudCreditoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MoraPK id = mora.getMoraPK();
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

    public void destroy(MoraPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mora mora;
            try {
                mora = em.getReference(Mora.class, id);
                mora.getMoraPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mora with id " + id + " no longer exists.", enfe);
            }
            SolicitudCredito solicitudCredito = mora.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito.setMora(null);
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

    public Mora findMora(MoraPK id) {
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
    
    public double getMoraPendiente(Creditos credito){
        double mora=0;
        
            if(credito.getSolicitudCredito().getMora()!=null){
                mora = credito.getSolicitudCredito().getMora().getMoraTotal()- credito.getSolicitudCredito().getMora().getMoraCancelada();
                mora = monto.redondear(mora, 2);
            }
    
        return mora;
    }
    
}
