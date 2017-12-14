
package CONTROLADORES;

import Entidades.Codeudores;
import Entidades.CodeudoresPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DFUENTES
 */
public class CodeudoresJpaController implements Serializable {

    public CodeudoresJpaController() {
       this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Codeudores codeudores) throws PreexistingEntityException, Exception {
        if (codeudores.getCodeudoresPK() == null) {
            codeudores.setCodeudoresPK(new CodeudoresPK());
        }
        codeudores.getCodeudoresPK().setDui(codeudores.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales duiCodeudor = codeudores.getDuiCodeudor();
            if (duiCodeudor != null) {
                duiCodeudor = em.getReference(duiCodeudor.getClass(), duiCodeudor.getDui());
                codeudores.setDuiCodeudor(duiCodeudor);
            }
            DatosPersonales datosPersonales = codeudores.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                codeudores.setDatosPersonales(datosPersonales);
            }
            em.persist(codeudores);
            if (duiCodeudor != null) {
                duiCodeudor.getCodeudoresList().add(codeudores);
                duiCodeudor = em.merge(duiCodeudor);
            }
            if (datosPersonales != null) {
                datosPersonales.getCodeudoresList().add(codeudores);
                datosPersonales = em.merge(datosPersonales);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCodeudores(codeudores.getCodeudoresPK()) != null) {
                throw new PreexistingEntityException("Codeudores " + codeudores + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Codeudores codeudores) throws NonexistentEntityException, Exception {
        codeudores.getCodeudoresPK().setDui(codeudores.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Codeudores persistentCodeudores = em.find(Codeudores.class, codeudores.getCodeudoresPK());
            DatosPersonales duiCodeudorOld = persistentCodeudores.getDuiCodeudor();
            DatosPersonales duiCodeudorNew = codeudores.getDuiCodeudor();
            DatosPersonales datosPersonalesOld = persistentCodeudores.getDatosPersonales();
            DatosPersonales datosPersonalesNew = codeudores.getDatosPersonales();
            if (duiCodeudorNew != null) {
                duiCodeudorNew = em.getReference(duiCodeudorNew.getClass(), duiCodeudorNew.getDui());
                codeudores.setDuiCodeudor(duiCodeudorNew);
            }
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                codeudores.setDatosPersonales(datosPersonalesNew);
            }
            codeudores = em.merge(codeudores);
            if (duiCodeudorOld != null && !duiCodeudorOld.equals(duiCodeudorNew)) {
                duiCodeudorOld.getCodeudoresList().remove(codeudores);
                duiCodeudorOld = em.merge(duiCodeudorOld);
            }
            if (duiCodeudorNew != null && !duiCodeudorNew.equals(duiCodeudorOld)) {
                duiCodeudorNew.getCodeudoresList().add(codeudores);
                duiCodeudorNew = em.merge(duiCodeudorNew);
            }
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.getCodeudoresList().remove(codeudores);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.getCodeudoresList().add(codeudores);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CodeudoresPK id = codeudores.getCodeudoresPK();
                if (findCodeudores(id) == null) {
                    throw new NonexistentEntityException("The codeudores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CodeudoresPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Codeudores codeudores;
            try {
                codeudores = em.getReference(Codeudores.class, id);
                codeudores.getCodeudoresPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The codeudores with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales duiCodeudor = codeudores.getDuiCodeudor();
            if (duiCodeudor != null) {
                duiCodeudor.getCodeudoresList().remove(codeudores);
                duiCodeudor = em.merge(duiCodeudor);
            }
            DatosPersonales datosPersonales = codeudores.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.getCodeudoresList().remove(codeudores);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(codeudores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Codeudores> findCodeudoresEntities() {
        return findCodeudoresEntities(true, -1, -1);
    }

    public List<Codeudores> findCodeudoresEntities(int maxResults, int firstResult) {
        return findCodeudoresEntities(false, maxResults, firstResult);
    }

    private List<Codeudores> findCodeudoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Codeudores.class));
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

    public Codeudores findCodeudores(CodeudoresPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Codeudores.class, id);
        } finally {
            em.close();
        }
    }

    public int getCodeudoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Codeudores> rt = cq.from(Codeudores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void actualizarCodeudores(List<Codeudores> newLista, List<Codeudores> oldLista ) throws Exception{
        
        int cont =1;
        int indice = oldLista.size();
        int nuevoIndice = newLista.size();
        
        if(indice<nuevoIndice){
            for(Codeudores codeudor: newLista){
                if(cont<=indice){
                    edit(codeudor);
                }else{
                    create(codeudor);   
                }
                cont++;
            }
        }else{
            for(Codeudores codeudor: oldLista){
                if(cont<=nuevoIndice){
                  edit(codeudor);
                }else{
                  destroy(codeudor.getCodeudoresPK()); 
                }
                cont++;
            }
        }
  
    }
    
}
