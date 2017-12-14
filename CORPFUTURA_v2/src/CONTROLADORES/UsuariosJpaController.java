
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.SolicitudCredito;
import Entidades.Usuarios;
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
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) throws PreexistingEntityException, Exception {
        if (usuarios.getSolicitudCreditoList() == null) {
            usuarios.setSolicitudCreditoList(new ArrayList<SolicitudCredito>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SolicitudCredito> attachedSolicitudCreditoList = new ArrayList<SolicitudCredito>();
            for (SolicitudCredito solicitudCreditoListSolicitudCreditoToAttach : usuarios.getSolicitudCreditoList()) {
                solicitudCreditoListSolicitudCreditoToAttach = em.getReference(solicitudCreditoListSolicitudCreditoToAttach.getClass(), solicitudCreditoListSolicitudCreditoToAttach.getSolicitudCreditoPK());
                attachedSolicitudCreditoList.add(solicitudCreditoListSolicitudCreditoToAttach);
            }
            usuarios.setSolicitudCreditoList(attachedSolicitudCreditoList);
            em.persist(usuarios);
            for (SolicitudCredito solicitudCreditoListSolicitudCredito : usuarios.getSolicitudCreditoList()) {
                Usuarios oldIdUsuarioOfSolicitudCreditoListSolicitudCredito = solicitudCreditoListSolicitudCredito.getIdUsuario();
                solicitudCreditoListSolicitudCredito.setIdUsuario(usuarios);
                solicitudCreditoListSolicitudCredito = em.merge(solicitudCreditoListSolicitudCredito);
                if (oldIdUsuarioOfSolicitudCreditoListSolicitudCredito != null) {
                    oldIdUsuarioOfSolicitudCreditoListSolicitudCredito.getSolicitudCreditoList().remove(solicitudCreditoListSolicitudCredito);
                    oldIdUsuarioOfSolicitudCreditoListSolicitudCredito = em.merge(oldIdUsuarioOfSolicitudCreditoListSolicitudCredito);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarios(usuarios.getIdUsuario()) != null) {
                throw new PreexistingEntityException("Usuarios " + usuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getIdUsuario());
            List<SolicitudCredito> solicitudCreditoListOld = persistentUsuarios.getSolicitudCreditoList();
            List<SolicitudCredito> solicitudCreditoListNew = usuarios.getSolicitudCreditoList();
            List<String> illegalOrphanMessages = null;
            for (SolicitudCredito solicitudCreditoListOldSolicitudCredito : solicitudCreditoListOld) {
                if (!solicitudCreditoListNew.contains(solicitudCreditoListOldSolicitudCredito)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SolicitudCredito " + solicitudCreditoListOldSolicitudCredito + " since its idUsuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<SolicitudCredito> attachedSolicitudCreditoListNew = new ArrayList<SolicitudCredito>();
            for (SolicitudCredito solicitudCreditoListNewSolicitudCreditoToAttach : solicitudCreditoListNew) {
                solicitudCreditoListNewSolicitudCreditoToAttach = em.getReference(solicitudCreditoListNewSolicitudCreditoToAttach.getClass(), solicitudCreditoListNewSolicitudCreditoToAttach.getSolicitudCreditoPK());
                attachedSolicitudCreditoListNew.add(solicitudCreditoListNewSolicitudCreditoToAttach);
            }
            solicitudCreditoListNew = attachedSolicitudCreditoListNew;
            usuarios.setSolicitudCreditoList(solicitudCreditoListNew);
            usuarios = em.merge(usuarios);
            for (SolicitudCredito solicitudCreditoListNewSolicitudCredito : solicitudCreditoListNew) {
                if (!solicitudCreditoListOld.contains(solicitudCreditoListNewSolicitudCredito)) {
                    Usuarios oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito = solicitudCreditoListNewSolicitudCredito.getIdUsuario();
                    solicitudCreditoListNewSolicitudCredito.setIdUsuario(usuarios);
                    solicitudCreditoListNewSolicitudCredito = em.merge(solicitudCreditoListNewSolicitudCredito);
                    if (oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito != null && !oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito.equals(usuarios)) {
                        oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito.getSolicitudCreditoList().remove(solicitudCreditoListNewSolicitudCredito);
                        oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito = em.merge(oldIdUsuarioOfSolicitudCreditoListNewSolicitudCredito);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getIdUsuario();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SolicitudCredito> solicitudCreditoListOrphanCheck = usuarios.getSolicitudCreditoList();
            for (SolicitudCredito solicitudCreditoListOrphanCheckSolicitudCredito : solicitudCreditoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the SolicitudCredito " + solicitudCreditoListOrphanCheckSolicitudCredito + " in its solicitudCreditoList field has a non-nullable idUsuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
