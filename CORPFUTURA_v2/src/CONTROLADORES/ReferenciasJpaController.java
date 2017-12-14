
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.Referencias;
import Entidades.ReferenciasPK;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author o-a19
 */
public class ReferenciasJpaController implements Serializable {

    public ReferenciasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Referencias referencias) throws PreexistingEntityException, Exception {
        if (referencias.getReferenciasPK() == null) {
            referencias.setReferenciasPK(new ReferenciasPK());
        }
        referencias.getReferenciasPK().setDui(referencias.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = referencias.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                referencias.setDatosPersonales(datosPersonales);
            }
            em.persist(referencias);
            if (datosPersonales != null) {
                datosPersonales.getReferenciasList().add(referencias);
                datosPersonales = em.merge(datosPersonales);
            }
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findReferencias(referencias.getReferenciasPK()) != null) {
                throw new PreexistingEntityException("Referencias " + referencias + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Referencias referencias) throws NonexistentEntityException, Exception {
        referencias.getReferenciasPK().setDui(referencias.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Referencias persistentReferencias = em.find(Referencias.class, referencias.getReferenciasPK());
            DatosPersonales datosPersonalesOld = persistentReferencias.getDatosPersonales();
            DatosPersonales datosPersonalesNew = referencias.getDatosPersonales();
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                referencias.setDatosPersonales(datosPersonalesNew);
            }
            referencias = em.merge(referencias);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.getReferenciasList().remove(referencias);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.getReferenciasList().add(referencias);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
            em.refresh(referencias);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ReferenciasPK id = referencias.getReferenciasPK();
                if (findReferencias(id) == null) {
                    throw new NonexistentEntityException("The referencias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ReferenciasPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Referencias referencias;
            try {
                referencias = em.getReference(Referencias.class, id);
                referencias.getReferenciasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The referencias with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = referencias.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.getReferenciasList().remove(referencias);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(referencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Referencias> findReferenciasEntities() {
        return findReferenciasEntities(true, -1, -1);
    }

    public List<Referencias> findReferenciasEntities(int maxResults, int firstResult) {
        return findReferenciasEntities(false, maxResults, firstResult);
    }

    private List<Referencias> findReferenciasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Referencias.class));
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

    public Referencias findReferencias(ReferenciasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Referencias.class, id);
        } finally {
            em.close();
        }
    }

    public int getReferenciasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Referencias> rt = cq.from(Referencias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public void actualizarReferencias(List<Referencias> newLista, List<Referencias> oldLista ) throws Exception{
        
        int cont =1;
        int indice = oldLista.size();
        int nuevoIndice = newLista.size();
        
        if(indice<nuevoIndice){
            for(Referencias ref: newLista){
                if(cont<=indice){
                    edit(ref);
                }else{
                    create(ref);
                }
                cont++;
            }
        }else{
            for(Referencias ref: oldLista){
                if(cont<=nuevoIndice){
                   edit(ref);
                }else{
                   destroy(ref.getReferenciasPK());
                }
                cont++;
            }
        }
  
    }
    
}
