
package CONTROLADORES;

import Entidades.Creditos;
import Entidades.CreditosPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.SolicitudCredito;
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import Entidades.Mora;
import Entidades.Pagos;
import UTILIDADES.fechas;
import UTILIDADES.monto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author o-a19
 */
public class CreditosJpaController implements Serializable {
    

    public CreditosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Creditos creditos) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (creditos.getCreditosPK() == null) {
            creditos.setCreditosPK(new CreditosPK());
        }
        creditos.getCreditosPK().setIdSolicitudCredito(creditos.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        creditos.getCreditosPK().setDui(creditos.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        List<String> illegalOrphanMessages = null;
        SolicitudCredito solicitudCreditoOrphanCheck = creditos.getSolicitudCredito();
        if (solicitudCreditoOrphanCheck != null) {
            Creditos oldCreditosOfSolicitudCredito = solicitudCreditoOrphanCheck.getCreditos();
            if (oldCreditosOfSolicitudCredito != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoOrphanCheck + " already has an item of type Creditos whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudCredito solicitudCredito = creditos.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito = em.getReference(solicitudCredito.getClass(), solicitudCredito.getSolicitudCreditoPK());
                creditos.setSolicitudCredito(solicitudCredito);
            }
            em.persist(creditos);
            if (solicitudCredito != null) {
                solicitudCredito.setCreditos(creditos);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCreditos(creditos.getCreditosPK()) != null) {
                throw new PreexistingEntityException("Creditos " + creditos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Creditos creditos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        creditos.getCreditosPK().setIdSolicitudCredito(creditos.getSolicitudCredito().getSolicitudCreditoPK().getIdSolicitudCredito());
        creditos.getCreditosPK().setDui(creditos.getSolicitudCredito().getSolicitudCreditoPK().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Creditos persistentCreditos = em.find(Creditos.class, creditos.getCreditosPK());
            SolicitudCredito solicitudCreditoOld = persistentCreditos.getSolicitudCredito();
            SolicitudCredito solicitudCreditoNew = creditos.getSolicitudCredito();
            List<String> illegalOrphanMessages = null;
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                Creditos oldCreditosOfSolicitudCredito = solicitudCreditoNew.getCreditos();
                if (oldCreditosOfSolicitudCredito != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The SolicitudCredito " + solicitudCreditoNew + " already has an item of type Creditos whose solicitudCredito column cannot be null. Please make another selection for the solicitudCredito field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (solicitudCreditoNew != null) {
                solicitudCreditoNew = em.getReference(solicitudCreditoNew.getClass(), solicitudCreditoNew.getSolicitudCreditoPK());
                creditos.setSolicitudCredito(solicitudCreditoNew);
            }
            creditos = em.merge(creditos);
            if (solicitudCreditoOld != null && !solicitudCreditoOld.equals(solicitudCreditoNew)) {
                solicitudCreditoOld.setCreditos(null);
                solicitudCreditoOld = em.merge(solicitudCreditoOld);
            }
            if (solicitudCreditoNew != null && !solicitudCreditoNew.equals(solicitudCreditoOld)) {
                solicitudCreditoNew.setCreditos(creditos);
                solicitudCreditoNew = em.merge(solicitudCreditoNew);
            }
            em.getTransaction().commit();
            em.refresh(creditos);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CreditosPK id = creditos.getCreditosPK();
                if (findCreditos(id) == null) {
                    throw new NonexistentEntityException("The creditos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CreditosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Creditos creditos;
            try {
                creditos = em.getReference(Creditos.class, id);
                creditos.getCreditosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The creditos with id " + id + " no longer exists.", enfe);
            }
            SolicitudCredito solicitudCredito = creditos.getSolicitudCredito();
            if (solicitudCredito != null) {
                solicitudCredito.setCreditos(null);
                solicitudCredito = em.merge(solicitudCredito);
            }
            em.remove(creditos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Creditos> findCreditosEntities() {
        return findCreditosEntities(true, -1, -1);
    }

    public List<Creditos> findCreditosEntities(int maxResults, int firstResult) {
        return findCreditosEntities(false, maxResults, firstResult);
    }

    private List<Creditos> findCreditosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Creditos.class));
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

    public Creditos findCreditos(CreditosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Creditos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCreditosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Creditos> rt = cq.from(Creditos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Creditos> getCreditosActivos(Short estado1) {
        
        short estado = estado1;
        EntityManager em = getEntityManager();
        Query consulta = em.createNamedQuery("Creditos.findByEstado", Creditos.class);
        consulta.setParameter("estado", estado);
        
        List<Creditos> lista =null;
        
        try{
            lista = consulta.getResultList();
        } catch (NoResultException e){
        } finally {
            em.close();
        }
        
        return lista;
    }
    
      public double obtenerTotalAPagar(Creditos credito){
        double total = monto.redondear(credito.getMonto()+credito.getTotalIntereses()+credito.getTotalIva(), 2);
        return total;
    } 
   
    public double obtenerTotalPagado(Creditos credito){
        double total = monto.redondear(credito.getSaldoPagado()+credito.getInteresPagados()+credito.getIvaPagado(), 2);
        return total;
    } 
     
    public double interesesVencidos(Creditos credito){
        double intvencidos=0.0;
        return intvencidos;
    }
    
    public double ivaVencidos(Creditos credito){
        double ivavencidos=0.0;
        return ivavencidos;
    }
    
    public double moraVencida(Creditos credito){
        double moravencida=0.0;
        return moravencida;
    }
    
    public int getCuotasPagadascf(Creditos credito){
    
       int cuotas=0;
        
            if(credito.getCuotasPagadas()==credito.getCuotasPorPagar()-1){
                cuotas = credito.getCuotasPorPagar();
            }else{
                cuotas = credito.getCuotasPagadas()-1;
            }

       return cuotas; 
    }
     
    public double obtenerSaldoalafecha(Creditos credito, Date fechasistema){
        double saldo = monto.valorXCuota(credito.getMonto(), credito.getPlazo(), credito.getFormaPago());
        int numeropagos=fechas.numerodepagos(credito.getFormaPago(),credito.getFechaPrimerPago(), fechasistema);
        saldo=saldo*numeropagos;
        return saldo;
    }
    
    public Mora obtenerMoraActual(Creditos credito){
        
        Mora mora=null;
        
        if(credito.getSolicitudCredito().getMoraList().size()>0){
            for(Mora mora1: credito.getSolicitudCredito().getMoraList()){
                if(mora1.getEstado()<2){mora=mora1;}
                
            }
            
        }
        return mora;
    }
    
    
      
}
