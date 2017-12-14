
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.Usuarios;
import Entidades.EvaluacionCredito;
import Entidades.Creditos;
import Entidades.Mora;
import java.util.ArrayList;
import java.util.List;
import Entidades.Pagos;
import Entidades.SolicitudCredito;
import Entidades.SolicitudCreditoPK;
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author o-a19
 */
public class SolicitudCreditoJpaController implements Serializable {

    public SolicitudCreditoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitudCredito solicitudCredito) throws PreexistingEntityException, Exception {
        if (solicitudCredito.getSolicitudCreditoPK() == null) {
            solicitudCredito.setSolicitudCreditoPK(new SolicitudCreditoPK());
        }
        if (solicitudCredito.getMoraList() == null) {
            solicitudCredito.setMoraList(new ArrayList<Mora>());
        }
        if (solicitudCredito.getPagosList() == null) {
            solicitudCredito.setPagosList(new ArrayList<Pagos>());
        }
        solicitudCredito.getSolicitudCreditoPK().setDui(solicitudCredito.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = solicitudCredito.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                solicitudCredito.setDatosPersonales(datosPersonales);
            }
            Usuarios idUsuario = solicitudCredito.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                solicitudCredito.setIdUsuario(idUsuario);
            }
            EvaluacionCredito evaluacionCredito = solicitudCredito.getEvaluacionCredito();
            if (evaluacionCredito != null) {
                evaluacionCredito = em.getReference(evaluacionCredito.getClass(), evaluacionCredito.getEvaluacionCreditoPK());
                solicitudCredito.setEvaluacionCredito(evaluacionCredito);
            }
            Creditos creditos = solicitudCredito.getCreditos();
            if (creditos != null) {
                creditos = em.getReference(creditos.getClass(), creditos.getCreditosPK());
                solicitudCredito.setCreditos(creditos);
            }
            List<Mora> attachedMoraList = new ArrayList<Mora>();
            for (Mora moraListMoraToAttach : solicitudCredito.getMoraList()) {
                moraListMoraToAttach = em.getReference(moraListMoraToAttach.getClass(), moraListMoraToAttach.getIdMora());
                attachedMoraList.add(moraListMoraToAttach);
            }
            solicitudCredito.setMoraList(attachedMoraList);
            List<Pagos> attachedPagosList = new ArrayList<Pagos>();
            for (Pagos pagosListPagosToAttach : solicitudCredito.getPagosList()) {
                pagosListPagosToAttach = em.getReference(pagosListPagosToAttach.getClass(), pagosListPagosToAttach.getIdPago());
                attachedPagosList.add(pagosListPagosToAttach);
            }
            solicitudCredito.setPagosList(attachedPagosList);
            em.persist(solicitudCredito);
            if (datosPersonales != null) {
                datosPersonales.getSolicitudCreditoList().add(solicitudCredito);
                datosPersonales = em.merge(datosPersonales);
            }
            if (idUsuario != null) {
                idUsuario.getSolicitudCreditoList().add(solicitudCredito);
                idUsuario = em.merge(idUsuario);
            }
            if (evaluacionCredito != null) {
                SolicitudCredito oldSolicitudCreditoOfEvaluacionCredito = evaluacionCredito.getSolicitudCredito();
                if (oldSolicitudCreditoOfEvaluacionCredito != null) {
                    oldSolicitudCreditoOfEvaluacionCredito.setEvaluacionCredito(null);
                    oldSolicitudCreditoOfEvaluacionCredito = em.merge(oldSolicitudCreditoOfEvaluacionCredito);
                }
                evaluacionCredito.setSolicitudCredito(solicitudCredito);
                evaluacionCredito = em.merge(evaluacionCredito);
            }
            if (creditos != null) {
                SolicitudCredito oldSolicitudCreditoOfCreditos = creditos.getSolicitudCredito();
                if (oldSolicitudCreditoOfCreditos != null) {
                    oldSolicitudCreditoOfCreditos.setCreditos(null);
                    oldSolicitudCreditoOfCreditos = em.merge(oldSolicitudCreditoOfCreditos);
                }
                creditos.setSolicitudCredito(solicitudCredito);
                creditos = em.merge(creditos);
            }
            for (Mora moraListMora : solicitudCredito.getMoraList()) {
                SolicitudCredito oldSolicitudCreditoOfMoraListMora = moraListMora.getSolicitudCredito();
                moraListMora.setSolicitudCredito(solicitudCredito);
                moraListMora = em.merge(moraListMora);
                if (oldSolicitudCreditoOfMoraListMora != null) {
                    oldSolicitudCreditoOfMoraListMora.getMoraList().remove(moraListMora);
                    oldSolicitudCreditoOfMoraListMora = em.merge(oldSolicitudCreditoOfMoraListMora);
                }
            }
            for (Pagos pagosListPagos : solicitudCredito.getPagosList()) {
                SolicitudCredito oldSolicitudCreditoOfPagosListPagos = pagosListPagos.getSolicitudCredito();
                pagosListPagos.setSolicitudCredito(solicitudCredito);
                pagosListPagos = em.merge(pagosListPagos);
                if (oldSolicitudCreditoOfPagosListPagos != null) {
                    oldSolicitudCreditoOfPagosListPagos.getPagosList().remove(pagosListPagos);
                    oldSolicitudCreditoOfPagosListPagos = em.merge(oldSolicitudCreditoOfPagosListPagos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSolicitudCredito(solicitudCredito.getSolicitudCreditoPK()) != null) {
                throw new PreexistingEntityException("SolicitudCredito " + solicitudCredito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitudCredito solicitudCredito) throws IllegalOrphanException, NonexistentEntityException, Exception {
        solicitudCredito.getSolicitudCreditoPK().setDui(solicitudCredito.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudCredito persistentSolicitudCredito = em.find(SolicitudCredito.class, solicitudCredito.getSolicitudCreditoPK());
            DatosPersonales datosPersonalesOld = persistentSolicitudCredito.getDatosPersonales();
            DatosPersonales datosPersonalesNew = solicitudCredito.getDatosPersonales();
            Usuarios idUsuarioOld = persistentSolicitudCredito.getIdUsuario();
            Usuarios idUsuarioNew = solicitudCredito.getIdUsuario();
            EvaluacionCredito evaluacionCreditoOld = persistentSolicitudCredito.getEvaluacionCredito();
            EvaluacionCredito evaluacionCreditoNew = solicitudCredito.getEvaluacionCredito();
            Creditos creditosOld = persistentSolicitudCredito.getCreditos();
            Creditos creditosNew = solicitudCredito.getCreditos();
            List<Mora> moraListOld = persistentSolicitudCredito.getMoraList();
            List<Mora> moraListNew = solicitudCredito.getMoraList();
            List<Pagos> pagosListOld = persistentSolicitudCredito.getPagosList();
            List<Pagos> pagosListNew = solicitudCredito.getPagosList();
            List<String> illegalOrphanMessages = null;
            if (evaluacionCreditoOld != null && !evaluacionCreditoOld.equals(evaluacionCreditoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain EvaluacionCredito " + evaluacionCreditoOld + " since its solicitudCredito field is not nullable.");
            }
            if (creditosOld != null && !creditosOld.equals(creditosNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Creditos " + creditosOld + " since its solicitudCredito field is not nullable.");
            }
            for (Mora moraListOldMora : moraListOld) {
                if (!moraListNew.contains(moraListOldMora)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mora " + moraListOldMora + " since its solicitudCredito field is not nullable.");
                }
            }
            for (Pagos pagosListOldPagos : pagosListOld) {
                if (!pagosListNew.contains(pagosListOldPagos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pagos " + pagosListOldPagos + " since its solicitudCredito field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                solicitudCredito.setDatosPersonales(datosPersonalesNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                solicitudCredito.setIdUsuario(idUsuarioNew);
            }
            if (evaluacionCreditoNew != null) {
                evaluacionCreditoNew = em.getReference(evaluacionCreditoNew.getClass(), evaluacionCreditoNew.getEvaluacionCreditoPK());
                solicitudCredito.setEvaluacionCredito(evaluacionCreditoNew);
            }
            if (creditosNew != null) {
                creditosNew = em.getReference(creditosNew.getClass(), creditosNew.getCreditosPK());
                solicitudCredito.setCreditos(creditosNew);
            }
            List<Mora> attachedMoraListNew = new ArrayList<Mora>();
            for (Mora moraListNewMoraToAttach : moraListNew) {
                moraListNewMoraToAttach = em.getReference(moraListNewMoraToAttach.getClass(), moraListNewMoraToAttach.getIdMora());
                attachedMoraListNew.add(moraListNewMoraToAttach);
            }
            moraListNew = attachedMoraListNew;
            solicitudCredito.setMoraList(moraListNew);
            List<Pagos> attachedPagosListNew = new ArrayList<Pagos>();
            for (Pagos pagosListNewPagosToAttach : pagosListNew) {
                pagosListNewPagosToAttach = em.getReference(pagosListNewPagosToAttach.getClass(), pagosListNewPagosToAttach.getIdPago());
                attachedPagosListNew.add(pagosListNewPagosToAttach);
            }
            pagosListNew = attachedPagosListNew;
            solicitudCredito.setPagosList(pagosListNew);
            solicitudCredito = em.merge(solicitudCredito);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.getSolicitudCreditoList().remove(solicitudCredito);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.getSolicitudCreditoList().add(solicitudCredito);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getSolicitudCreditoList().remove(solicitudCredito);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getSolicitudCreditoList().add(solicitudCredito);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (evaluacionCreditoNew != null && !evaluacionCreditoNew.equals(evaluacionCreditoOld)) {
                SolicitudCredito oldSolicitudCreditoOfEvaluacionCredito = evaluacionCreditoNew.getSolicitudCredito();
                if (oldSolicitudCreditoOfEvaluacionCredito != null) {
                    oldSolicitudCreditoOfEvaluacionCredito.setEvaluacionCredito(null);
                    oldSolicitudCreditoOfEvaluacionCredito = em.merge(oldSolicitudCreditoOfEvaluacionCredito);
                }
                evaluacionCreditoNew.setSolicitudCredito(solicitudCredito);
                evaluacionCreditoNew = em.merge(evaluacionCreditoNew);
            }
            if (creditosNew != null && !creditosNew.equals(creditosOld)) {
                SolicitudCredito oldSolicitudCreditoOfCreditos = creditosNew.getSolicitudCredito();
                if (oldSolicitudCreditoOfCreditos != null) {
                    oldSolicitudCreditoOfCreditos.setCreditos(null);
                    oldSolicitudCreditoOfCreditos = em.merge(oldSolicitudCreditoOfCreditos);
                }
                creditosNew.setSolicitudCredito(solicitudCredito);
                creditosNew = em.merge(creditosNew);
            }
            for (Mora moraListNewMora : moraListNew) {
                if (!moraListOld.contains(moraListNewMora)) {
                    SolicitudCredito oldSolicitudCreditoOfMoraListNewMora = moraListNewMora.getSolicitudCredito();
                    moraListNewMora.setSolicitudCredito(solicitudCredito);
                    moraListNewMora = em.merge(moraListNewMora);
                    if (oldSolicitudCreditoOfMoraListNewMora != null && !oldSolicitudCreditoOfMoraListNewMora.equals(solicitudCredito)) {
                        oldSolicitudCreditoOfMoraListNewMora.getMoraList().remove(moraListNewMora);
                        oldSolicitudCreditoOfMoraListNewMora = em.merge(oldSolicitudCreditoOfMoraListNewMora);
                    }
                }
            }
            for (Pagos pagosListNewPagos : pagosListNew) {
                if (!pagosListOld.contains(pagosListNewPagos)) {
                    SolicitudCredito oldSolicitudCreditoOfPagosListNewPagos = pagosListNewPagos.getSolicitudCredito();
                    pagosListNewPagos.setSolicitudCredito(solicitudCredito);
                    pagosListNewPagos = em.merge(pagosListNewPagos);
                    if (oldSolicitudCreditoOfPagosListNewPagos != null && !oldSolicitudCreditoOfPagosListNewPagos.equals(solicitudCredito)) {
                        oldSolicitudCreditoOfPagosListNewPagos.getPagosList().remove(pagosListNewPagos);
                        oldSolicitudCreditoOfPagosListNewPagos = em.merge(oldSolicitudCreditoOfPagosListNewPagos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                SolicitudCreditoPK id = solicitudCredito.getSolicitudCreditoPK();
                if (findSolicitudCredito(id) == null) {
                    throw new NonexistentEntityException("The solicitudCredito with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(SolicitudCreditoPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudCredito solicitudCredito;
            try {
                solicitudCredito = em.getReference(SolicitudCredito.class, id);
                solicitudCredito.getSolicitudCreditoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitudCredito with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            EvaluacionCredito evaluacionCreditoOrphanCheck = solicitudCredito.getEvaluacionCredito();
            if (evaluacionCreditoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SolicitudCredito (" + solicitudCredito + ") cannot be destroyed since the EvaluacionCredito " + evaluacionCreditoOrphanCheck + " in its evaluacionCredito field has a non-nullable solicitudCredito field.");
            }
            Creditos creditosOrphanCheck = solicitudCredito.getCreditos();
            if (creditosOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SolicitudCredito (" + solicitudCredito + ") cannot be destroyed since the Creditos " + creditosOrphanCheck + " in its creditos field has a non-nullable solicitudCredito field.");
            }
            List<Mora> moraListOrphanCheck = solicitudCredito.getMoraList();
            for (Mora moraListOrphanCheckMora : moraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SolicitudCredito (" + solicitudCredito + ") cannot be destroyed since the Mora " + moraListOrphanCheckMora + " in its moraList field has a non-nullable solicitudCredito field.");
            }
            List<Pagos> pagosListOrphanCheck = solicitudCredito.getPagosList();
            for (Pagos pagosListOrphanCheckPagos : pagosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SolicitudCredito (" + solicitudCredito + ") cannot be destroyed since the Pagos " + pagosListOrphanCheckPagos + " in its pagosList field has a non-nullable solicitudCredito field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DatosPersonales datosPersonales = solicitudCredito.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.getSolicitudCreditoList().remove(solicitudCredito);
                datosPersonales = em.merge(datosPersonales);
            }
            Usuarios idUsuario = solicitudCredito.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getSolicitudCreditoList().remove(solicitudCredito);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(solicitudCredito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudCredito> findSolicitudCreditoEntities() {
        return findSolicitudCreditoEntities(true, -1, -1);
    }

    public List<SolicitudCredito> findSolicitudCreditoEntities(int maxResults, int firstResult) {
        return findSolicitudCreditoEntities(false, maxResults, firstResult);
    }

    private List<SolicitudCredito> findSolicitudCreditoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitudCredito.class));
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

    public SolicitudCredito findSolicitudCredito(SolicitudCreditoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudCredito.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitudCreditoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitudCredito> rt = cq.from(SolicitudCredito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public boolean comprobarSolicitud(DatosPersonales dp){
        boolean valido = true;
            for(SolicitudCredito solicitud: dp.getSolicitudCreditoList()){
                if (solicitud.getEstado()<=2){valido = false;}
            }
        return valido;
    }
    
    public int obtenerID(){
        int id = this.getSolicitudCreditoCount()+1;
        return id; 
    }
    
    public List<SolicitudCredito> getSolicitudEnProceso(Short estado1) {
        
        short estado = estado1;
        EntityManager em = getEntityManager();
        Query consulta = em.createNamedQuery("SolicitudCredito.findByEstado", SolicitudCredito.class);
        consulta.setParameter("estado", estado);
        consulta.setParameter("desembolso",false);
        
        List<SolicitudCredito> lista =null;
        
        try{
            lista = consulta.getResultList();
        } catch (NoResultException e){
        } finally {
            em.close();
        }
        
        return lista;
    }
    
    
    
    
}
