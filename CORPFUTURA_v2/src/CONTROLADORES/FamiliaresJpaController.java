
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosPersonales;
import Entidades.Familiares;
import Entidades.FamiliaresPK;
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
public class FamiliaresJpaController implements Serializable {

    public FamiliaresJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familiares familiares) throws PreexistingEntityException, Exception {
        if (familiares.getFamiliaresPK() == null) {
            familiares.setFamiliaresPK(new FamiliaresPK());
        }
        familiares.getFamiliaresPK().setDui(familiares.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales = familiares.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales = em.getReference(datosPersonales.getClass(), datosPersonales.getDui());
                familiares.setDatosPersonales(datosPersonales);
            }
            em.persist(familiares);
            if (datosPersonales != null) {
                datosPersonales.getFamiliaresList().add(familiares);
                datosPersonales = em.merge(datosPersonales);
            }
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findFamiliares(familiares.getFamiliaresPK()) != null) {
                throw new PreexistingEntityException("Familiares " + familiares + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familiares familiares) throws NonexistentEntityException, Exception {
        familiares.getFamiliaresPK().setDui(familiares.getDatosPersonales().getDui());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familiares persistentFamiliares = em.find(Familiares.class, familiares.getFamiliaresPK());
            DatosPersonales datosPersonalesOld = persistentFamiliares.getDatosPersonales();
            DatosPersonales datosPersonalesNew = familiares.getDatosPersonales();
            if (datosPersonalesNew != null) {
                datosPersonalesNew = em.getReference(datosPersonalesNew.getClass(), datosPersonalesNew.getDui());
                familiares.setDatosPersonales(datosPersonalesNew);
            }
            familiares = em.merge(familiares);
            if (datosPersonalesOld != null && !datosPersonalesOld.equals(datosPersonalesNew)) {
                datosPersonalesOld.getFamiliaresList().remove(familiares);
                datosPersonalesOld = em.merge(datosPersonalesOld);
            }
            if (datosPersonalesNew != null && !datosPersonalesNew.equals(datosPersonalesOld)) {
                datosPersonalesNew.getFamiliaresList().add(familiares);
                datosPersonalesNew = em.merge(datosPersonalesNew);
            }
            em.getTransaction().commit();
            em.refresh(familiares);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FamiliaresPK id = familiares.getFamiliaresPK();
                if (findFamiliares(id) == null) {
                    throw new NonexistentEntityException("The familiares with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FamiliaresPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familiares familiares;
            try {
                familiares = em.getReference(Familiares.class, id);
                familiares.getFamiliaresPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familiares with id " + id + " no longer exists.", enfe);
            }
            DatosPersonales datosPersonales = familiares.getDatosPersonales();
            if (datosPersonales != null) {
                datosPersonales.getFamiliaresList().remove(familiares);
                datosPersonales = em.merge(datosPersonales);
            }
            em.remove(familiares);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familiares> findFamiliaresEntities() {
        return findFamiliaresEntities(true, -1, -1);
    }

    public List<Familiares> findFamiliaresEntities(int maxResults, int firstResult) {
        return findFamiliaresEntities(false, maxResults, firstResult);
    }

    private List<Familiares> findFamiliaresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familiares.class));
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

    public Familiares findFamiliares(FamiliaresPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familiares.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamiliaresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familiares> rt = cq.from(Familiares.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void actualizarFamiliares(List<Familiares> newLista, List<Familiares> oldLista ) throws Exception{
        
        int cont =1;
        int indice = oldLista.size();
        int nuevoIndice = newLista.size();
        
        if(indice<nuevoIndice){
            for(Familiares fam: newLista){
                if(cont<=indice){
                    edit(fam);
                }else{
                    create(fam);   
                }
                cont++;
            }
        }else{
            for(Familiares fam: oldLista){
                if(cont<=nuevoIndice){
                  edit(fam);
                }else{
                  destroy(fam.getFamiliaresPK()); 
                }
                cont++;
            }
        }
  
    }
    
    
}
