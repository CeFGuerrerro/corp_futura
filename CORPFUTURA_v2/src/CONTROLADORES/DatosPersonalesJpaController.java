
package CONTROLADORES;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.DatosConyugue; 
import Entidades.Domicilio;
import Entidades.InformacionNegocio;
import Entidades.Referencias;
import java.util.ArrayList;
import java.util.List;
import Entidades.SolicitudCredito;
import Entidades.Familiares;
import Entidades.Codeudores;
import Entidades.DatosPersonales;
import Entidades.DeclaracionBienes;
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author DFUENTES
 */
public class DatosPersonalesJpaController implements Serializable {

    public DatosPersonalesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("FUTURA_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosPersonales datosPersonales) throws PreexistingEntityException, Exception {
        if (datosPersonales.getReferenciasList() == null) {
            datosPersonales.setReferenciasList(new ArrayList<Referencias>());
        }
        if (datosPersonales.getSolicitudCreditoList() == null) {
            datosPersonales.setSolicitudCreditoList(new ArrayList<SolicitudCredito>());
        }
        if (datosPersonales.getFamiliaresList() == null) {
            datosPersonales.setFamiliaresList(new ArrayList<Familiares>());
        }
        if (datosPersonales.getCodeudoresList() == null) {
            datosPersonales.setCodeudoresList(new ArrayList<Codeudores>());
        }
        if (datosPersonales.getCodeudoresList1() == null) {
            datosPersonales.setCodeudoresList1(new ArrayList<Codeudores>());
        }
        if (datosPersonales.getDeclaracionBienesList() == null) {
            datosPersonales.setDeclaracionBienesList(new ArrayList<DeclaracionBienes>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosConyugue datosConyugue = datosPersonales.getDatosConyugue();
            if (datosConyugue != null) {
                datosConyugue = em.getReference(datosConyugue.getClass(), datosConyugue.getDui());
                datosPersonales.setDatosConyugue(datosConyugue);
            }
            Domicilio domicilio = datosPersonales.getDomicilio();
            if (domicilio != null) {
                domicilio = em.getReference(domicilio.getClass(), domicilio.getDui());
                datosPersonales.setDomicilio(domicilio);
            }
            InformacionNegocio informacionNegocio = datosPersonales.getInformacionNegocio();
            if (informacionNegocio != null) {
                informacionNegocio = em.getReference(informacionNegocio.getClass(), informacionNegocio.getDui());
                datosPersonales.setInformacionNegocio(informacionNegocio);
            }
            List<Referencias> attachedReferenciasList = new ArrayList<Referencias>();
            for (Referencias referenciasListReferenciasToAttach : datosPersonales.getReferenciasList()) {
                referenciasListReferenciasToAttach = em.getReference(referenciasListReferenciasToAttach.getClass(), referenciasListReferenciasToAttach.getReferenciasPK());
                attachedReferenciasList.add(referenciasListReferenciasToAttach);
            }
            datosPersonales.setReferenciasList(attachedReferenciasList);
            List<SolicitudCredito> attachedSolicitudCreditoList = new ArrayList<SolicitudCredito>();
            for (SolicitudCredito solicitudCreditoListSolicitudCreditoToAttach : datosPersonales.getSolicitudCreditoList()) {
                solicitudCreditoListSolicitudCreditoToAttach = em.getReference(solicitudCreditoListSolicitudCreditoToAttach.getClass(), solicitudCreditoListSolicitudCreditoToAttach.getSolicitudCreditoPK());
                attachedSolicitudCreditoList.add(solicitudCreditoListSolicitudCreditoToAttach);
            }
            datosPersonales.setSolicitudCreditoList(attachedSolicitudCreditoList);
            List<Familiares> attachedFamiliaresList = new ArrayList<Familiares>();
            for (Familiares familiaresListFamiliaresToAttach : datosPersonales.getFamiliaresList()) {
                familiaresListFamiliaresToAttach = em.getReference(familiaresListFamiliaresToAttach.getClass(), familiaresListFamiliaresToAttach.getFamiliaresPK());
                attachedFamiliaresList.add(familiaresListFamiliaresToAttach);
            }
            datosPersonales.setFamiliaresList(attachedFamiliaresList);
            List<Codeudores> attachedCodeudoresList = new ArrayList<Codeudores>();
            for (Codeudores codeudoresListCodeudoresToAttach : datosPersonales.getCodeudoresList()) {
                codeudoresListCodeudoresToAttach = em.getReference(codeudoresListCodeudoresToAttach.getClass(), codeudoresListCodeudoresToAttach.getCodeudoresPK());
                attachedCodeudoresList.add(codeudoresListCodeudoresToAttach);
            }
            datosPersonales.setCodeudoresList(attachedCodeudoresList);
            List<Codeudores> attachedCodeudoresList1 = new ArrayList<Codeudores>();
            for (Codeudores codeudoresList1CodeudoresToAttach : datosPersonales.getCodeudoresList1()) {
                codeudoresList1CodeudoresToAttach = em.getReference(codeudoresList1CodeudoresToAttach.getClass(), codeudoresList1CodeudoresToAttach.getCodeudoresPK());
                attachedCodeudoresList1.add(codeudoresList1CodeudoresToAttach);
            }
            datosPersonales.setCodeudoresList1(attachedCodeudoresList1);
            List<DeclaracionBienes> attachedDeclaracionBienesList = new ArrayList<DeclaracionBienes>();
            for (DeclaracionBienes declaracionBienesListDeclaracionBienesToAttach : datosPersonales.getDeclaracionBienesList()) {
                declaracionBienesListDeclaracionBienesToAttach = em.getReference(declaracionBienesListDeclaracionBienesToAttach.getClass(), declaracionBienesListDeclaracionBienesToAttach.getDeclaracionBienesPK());
                attachedDeclaracionBienesList.add(declaracionBienesListDeclaracionBienesToAttach);
            }
            datosPersonales.setDeclaracionBienesList(attachedDeclaracionBienesList);
            em.persist(datosPersonales);
            if (datosConyugue != null) {
                DatosPersonales oldDatosPersonalesOfDatosConyugue = datosConyugue.getDatosPersonales();
                if (oldDatosPersonalesOfDatosConyugue != null) {
                    oldDatosPersonalesOfDatosConyugue.setDatosConyugue(null);
                    oldDatosPersonalesOfDatosConyugue = em.merge(oldDatosPersonalesOfDatosConyugue);
                }
                datosConyugue.setDatosPersonales(datosPersonales);
                datosConyugue = em.merge(datosConyugue);
            }
            if (domicilio != null) {
                DatosPersonales oldDatosPersonalesOfDomicilio = domicilio.getDatosPersonales();
                if (oldDatosPersonalesOfDomicilio != null) {
                    oldDatosPersonalesOfDomicilio.setDomicilio(null);
                    oldDatosPersonalesOfDomicilio = em.merge(oldDatosPersonalesOfDomicilio);
                }
                domicilio.setDatosPersonales(datosPersonales);
                domicilio = em.merge(domicilio);
            }
            if (informacionNegocio != null) {
                DatosPersonales oldDatosPersonalesOfInformacionNegocio = informacionNegocio.getDatosPersonales();
                if (oldDatosPersonalesOfInformacionNegocio != null) {
                    oldDatosPersonalesOfInformacionNegocio.setInformacionNegocio(null);
                    oldDatosPersonalesOfInformacionNegocio = em.merge(oldDatosPersonalesOfInformacionNegocio);
                }
                informacionNegocio.setDatosPersonales(datosPersonales);
                informacionNegocio = em.merge(informacionNegocio);
            }
            for (Referencias referenciasListReferencias : datosPersonales.getReferenciasList()) {
                DatosPersonales oldDatosPersonalesOfReferenciasListReferencias = referenciasListReferencias.getDatosPersonales();
                referenciasListReferencias.setDatosPersonales(datosPersonales);
                referenciasListReferencias = em.merge(referenciasListReferencias);
                if (oldDatosPersonalesOfReferenciasListReferencias != null) {
                    oldDatosPersonalesOfReferenciasListReferencias.getReferenciasList().remove(referenciasListReferencias);
                    oldDatosPersonalesOfReferenciasListReferencias = em.merge(oldDatosPersonalesOfReferenciasListReferencias);
                }
            }
            for (SolicitudCredito solicitudCreditoListSolicitudCredito : datosPersonales.getSolicitudCreditoList()) {
                DatosPersonales oldDatosPersonalesOfSolicitudCreditoListSolicitudCredito = solicitudCreditoListSolicitudCredito.getDatosPersonales();
                solicitudCreditoListSolicitudCredito.setDatosPersonales(datosPersonales);
                solicitudCreditoListSolicitudCredito = em.merge(solicitudCreditoListSolicitudCredito);
                if (oldDatosPersonalesOfSolicitudCreditoListSolicitudCredito != null) {
                    oldDatosPersonalesOfSolicitudCreditoListSolicitudCredito.getSolicitudCreditoList().remove(solicitudCreditoListSolicitudCredito);
                    oldDatosPersonalesOfSolicitudCreditoListSolicitudCredito = em.merge(oldDatosPersonalesOfSolicitudCreditoListSolicitudCredito);
                }
            }
            for (Familiares familiaresListFamiliares : datosPersonales.getFamiliaresList()) {
                DatosPersonales oldDatosPersonalesOfFamiliaresListFamiliares = familiaresListFamiliares.getDatosPersonales();
                familiaresListFamiliares.setDatosPersonales(datosPersonales);
                familiaresListFamiliares = em.merge(familiaresListFamiliares);
                if (oldDatosPersonalesOfFamiliaresListFamiliares != null) {
                    oldDatosPersonalesOfFamiliaresListFamiliares.getFamiliaresList().remove(familiaresListFamiliares);
                    oldDatosPersonalesOfFamiliaresListFamiliares = em.merge(oldDatosPersonalesOfFamiliaresListFamiliares);
                }
            }
            for (Codeudores codeudoresListCodeudores : datosPersonales.getCodeudoresList()) {
                DatosPersonales oldDuiCodeudorOfCodeudoresListCodeudores = codeudoresListCodeudores.getDuiCodeudor();
                codeudoresListCodeudores.setDuiCodeudor(datosPersonales);
                codeudoresListCodeudores = em.merge(codeudoresListCodeudores);
                if (oldDuiCodeudorOfCodeudoresListCodeudores != null) {
                    oldDuiCodeudorOfCodeudoresListCodeudores.getCodeudoresList().remove(codeudoresListCodeudores);
                    oldDuiCodeudorOfCodeudoresListCodeudores = em.merge(oldDuiCodeudorOfCodeudoresListCodeudores);
                }
            }
            for (Codeudores codeudoresList1Codeudores : datosPersonales.getCodeudoresList1()) {
                DatosPersonales oldDatosPersonalesOfCodeudoresList1Codeudores = codeudoresList1Codeudores.getDatosPersonales();
                codeudoresList1Codeudores.setDatosPersonales(datosPersonales);
                codeudoresList1Codeudores = em.merge(codeudoresList1Codeudores);
                if (oldDatosPersonalesOfCodeudoresList1Codeudores != null) {
                    oldDatosPersonalesOfCodeudoresList1Codeudores.getCodeudoresList1().remove(codeudoresList1Codeudores);
                    oldDatosPersonalesOfCodeudoresList1Codeudores = em.merge(oldDatosPersonalesOfCodeudoresList1Codeudores);
                }
            }
            for (DeclaracionBienes declaracionBienesListDeclaracionBienes : datosPersonales.getDeclaracionBienesList()) {
                DatosPersonales oldDatosPersonalesOfDeclaracionBienesListDeclaracionBienes = declaracionBienesListDeclaracionBienes.getDatosPersonales();
                declaracionBienesListDeclaracionBienes.setDatosPersonales(datosPersonales);
                declaracionBienesListDeclaracionBienes = em.merge(declaracionBienesListDeclaracionBienes);
                if (oldDatosPersonalesOfDeclaracionBienesListDeclaracionBienes != null) {
                    oldDatosPersonalesOfDeclaracionBienesListDeclaracionBienes.getDeclaracionBienesList().remove(declaracionBienesListDeclaracionBienes);
                    oldDatosPersonalesOfDeclaracionBienesListDeclaracionBienes = em.merge(oldDatosPersonalesOfDeclaracionBienesListDeclaracionBienes);
                }
            }
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            if (findDatosPersonales(datosPersonales.getDui()) != null) {
                throw new PreexistingEntityException("DatosPersonales " + datosPersonales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosPersonales datosPersonales) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales persistentDatosPersonales = em.find(DatosPersonales.class, datosPersonales.getDui());
            DatosConyugue datosConyugueOld = persistentDatosPersonales.getDatosConyugue();
            DatosConyugue datosConyugueNew = datosPersonales.getDatosConyugue();
            Domicilio domicilioOld = persistentDatosPersonales.getDomicilio();
            Domicilio domicilioNew = datosPersonales.getDomicilio();
            InformacionNegocio informacionNegocioOld = persistentDatosPersonales.getInformacionNegocio();
            InformacionNegocio informacionNegocioNew = datosPersonales.getInformacionNegocio();
            List<Referencias> referenciasListOld = persistentDatosPersonales.getReferenciasList();
            List<Referencias> referenciasListNew = datosPersonales.getReferenciasList();
            List<SolicitudCredito> solicitudCreditoListOld = persistentDatosPersonales.getSolicitudCreditoList();
            List<SolicitudCredito> solicitudCreditoListNew = datosPersonales.getSolicitudCreditoList();
            List<Familiares> familiaresListOld = persistentDatosPersonales.getFamiliaresList();
            List<Familiares> familiaresListNew = datosPersonales.getFamiliaresList();
            List<Codeudores> codeudoresListOld = persistentDatosPersonales.getCodeudoresList();
            List<Codeudores> codeudoresListNew = datosPersonales.getCodeudoresList();
            List<Codeudores> codeudoresList1Old = persistentDatosPersonales.getCodeudoresList1();
            List<Codeudores> codeudoresList1New = datosPersonales.getCodeudoresList1();
            List<DeclaracionBienes> declaracionBienesListOld = persistentDatosPersonales.getDeclaracionBienesList();
            List<DeclaracionBienes> declaracionBienesListNew = datosPersonales.getDeclaracionBienesList();
            List<String> illegalOrphanMessages = null;
            if (datosConyugueOld != null && !datosConyugueOld.equals(datosConyugueNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DatosConyugue " + datosConyugueOld + " since its datosPersonales field is not nullable.");
            }
            if (domicilioOld != null && !domicilioOld.equals(domicilioNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Domicilio " + domicilioOld + " since its datosPersonales field is not nullable.");
            }
            if (informacionNegocioOld != null && !informacionNegocioOld.equals(informacionNegocioNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain InformacionNegocio " + informacionNegocioOld + " since its datosPersonales field is not nullable.");
            }
            for (Referencias referenciasListOldReferencias : referenciasListOld) {
                if (!referenciasListNew.contains(referenciasListOldReferencias)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Referencias " + referenciasListOldReferencias + " since its datosPersonales field is not nullable.");
                }
            }
            for (SolicitudCredito solicitudCreditoListOldSolicitudCredito : solicitudCreditoListOld) {
                if (!solicitudCreditoListNew.contains(solicitudCreditoListOldSolicitudCredito)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SolicitudCredito " + solicitudCreditoListOldSolicitudCredito + " since its datosPersonales field is not nullable.");
                }
            }
            for (Familiares familiaresListOldFamiliares : familiaresListOld) {
                if (!familiaresListNew.contains(familiaresListOldFamiliares)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Familiares " + familiaresListOldFamiliares + " since its datosPersonales field is not nullable.");
                }
            }
            for (Codeudores codeudoresListOldCodeudores : codeudoresListOld) {
                if (!codeudoresListNew.contains(codeudoresListOldCodeudores)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Codeudores " + codeudoresListOldCodeudores + " since its duiCodeudor field is not nullable.");
                }
            }
            for (Codeudores codeudoresList1OldCodeudores : codeudoresList1Old) {
                if (!codeudoresList1New.contains(codeudoresList1OldCodeudores)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Codeudores " + codeudoresList1OldCodeudores + " since its datosPersonales field is not nullable.");
                }
            }
            for (DeclaracionBienes declaracionBienesListOldDeclaracionBienes : declaracionBienesListOld) {
                if (!declaracionBienesListNew.contains(declaracionBienesListOldDeclaracionBienes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DeclaracionBienes " + declaracionBienesListOldDeclaracionBienes + " since its datosPersonales field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosConyugueNew != null) {
                datosConyugueNew = em.getReference(datosConyugueNew.getClass(), datosConyugueNew.getDui());
                datosPersonales.setDatosConyugue(datosConyugueNew);
            }
            if (domicilioNew != null) {
                domicilioNew = em.getReference(domicilioNew.getClass(), domicilioNew.getDui());
                datosPersonales.setDomicilio(domicilioNew);
            }
            if (informacionNegocioNew != null) {
                informacionNegocioNew = em.getReference(informacionNegocioNew.getClass(), informacionNegocioNew.getDui());
                datosPersonales.setInformacionNegocio(informacionNegocioNew);
            }
            List<Referencias> attachedReferenciasListNew = new ArrayList<Referencias>();
            for (Referencias referenciasListNewReferenciasToAttach : referenciasListNew) {
                referenciasListNewReferenciasToAttach = em.getReference(referenciasListNewReferenciasToAttach.getClass(), referenciasListNewReferenciasToAttach.getReferenciasPK());
                attachedReferenciasListNew.add(referenciasListNewReferenciasToAttach);
            }
            referenciasListNew = attachedReferenciasListNew;
            datosPersonales.setReferenciasList(referenciasListNew);
            List<SolicitudCredito> attachedSolicitudCreditoListNew = new ArrayList<SolicitudCredito>();
            for (SolicitudCredito solicitudCreditoListNewSolicitudCreditoToAttach : solicitudCreditoListNew) {
                solicitudCreditoListNewSolicitudCreditoToAttach = em.getReference(solicitudCreditoListNewSolicitudCreditoToAttach.getClass(), solicitudCreditoListNewSolicitudCreditoToAttach.getSolicitudCreditoPK());
                attachedSolicitudCreditoListNew.add(solicitudCreditoListNewSolicitudCreditoToAttach);
            }
            solicitudCreditoListNew = attachedSolicitudCreditoListNew;
            datosPersonales.setSolicitudCreditoList(solicitudCreditoListNew);
            List<Familiares> attachedFamiliaresListNew = new ArrayList<Familiares>();
            for (Familiares familiaresListNewFamiliaresToAttach : familiaresListNew) {
                familiaresListNewFamiliaresToAttach = em.getReference(familiaresListNewFamiliaresToAttach.getClass(), familiaresListNewFamiliaresToAttach.getFamiliaresPK());
                attachedFamiliaresListNew.add(familiaresListNewFamiliaresToAttach);
            }
            familiaresListNew = attachedFamiliaresListNew;
            datosPersonales.setFamiliaresList(familiaresListNew);
            List<Codeudores> attachedCodeudoresListNew = new ArrayList<Codeudores>();
            for (Codeudores codeudoresListNewCodeudoresToAttach : codeudoresListNew) {
                codeudoresListNewCodeudoresToAttach = em.getReference(codeudoresListNewCodeudoresToAttach.getClass(), codeudoresListNewCodeudoresToAttach.getCodeudoresPK());
                attachedCodeudoresListNew.add(codeudoresListNewCodeudoresToAttach);
            }
            codeudoresListNew = attachedCodeudoresListNew;
            datosPersonales.setCodeudoresList(codeudoresListNew);
            List<Codeudores> attachedCodeudoresList1New = new ArrayList<Codeudores>();
            for (Codeudores codeudoresList1NewCodeudoresToAttach : codeudoresList1New) {
                codeudoresList1NewCodeudoresToAttach = em.getReference(codeudoresList1NewCodeudoresToAttach.getClass(), codeudoresList1NewCodeudoresToAttach.getCodeudoresPK());
                attachedCodeudoresList1New.add(codeudoresList1NewCodeudoresToAttach);
            }
            codeudoresList1New = attachedCodeudoresList1New;
            datosPersonales.setCodeudoresList1(codeudoresList1New);
            List<DeclaracionBienes> attachedDeclaracionBienesListNew = new ArrayList<DeclaracionBienes>();
            for (DeclaracionBienes declaracionBienesListNewDeclaracionBienesToAttach : declaracionBienesListNew) {
                declaracionBienesListNewDeclaracionBienesToAttach = em.getReference(declaracionBienesListNewDeclaracionBienesToAttach.getClass(), declaracionBienesListNewDeclaracionBienesToAttach.getDeclaracionBienesPK());
                attachedDeclaracionBienesListNew.add(declaracionBienesListNewDeclaracionBienesToAttach);
            }
            declaracionBienesListNew = attachedDeclaracionBienesListNew;
            datosPersonales.setDeclaracionBienesList(declaracionBienesListNew);
            datosPersonales = em.merge(datosPersonales);
            if (datosConyugueNew != null && !datosConyugueNew.equals(datosConyugueOld)) {
                DatosPersonales oldDatosPersonalesOfDatosConyugue = datosConyugueNew.getDatosPersonales();
                if (oldDatosPersonalesOfDatosConyugue != null) {
                    oldDatosPersonalesOfDatosConyugue.setDatosConyugue(null);
                    oldDatosPersonalesOfDatosConyugue = em.merge(oldDatosPersonalesOfDatosConyugue);
                }
                datosConyugueNew.setDatosPersonales(datosPersonales);
                datosConyugueNew = em.merge(datosConyugueNew);
            }
            if (domicilioNew != null && !domicilioNew.equals(domicilioOld)) {
                DatosPersonales oldDatosPersonalesOfDomicilio = domicilioNew.getDatosPersonales();
                if (oldDatosPersonalesOfDomicilio != null) {
                    oldDatosPersonalesOfDomicilio.setDomicilio(null);
                    oldDatosPersonalesOfDomicilio = em.merge(oldDatosPersonalesOfDomicilio);
                }
                domicilioNew.setDatosPersonales(datosPersonales);
                domicilioNew = em.merge(domicilioNew);
            }
            if (informacionNegocioNew != null && !informacionNegocioNew.equals(informacionNegocioOld)) {
                DatosPersonales oldDatosPersonalesOfInformacionNegocio = informacionNegocioNew.getDatosPersonales();
                if (oldDatosPersonalesOfInformacionNegocio != null) {
                    oldDatosPersonalesOfInformacionNegocio.setInformacionNegocio(null);
                    oldDatosPersonalesOfInformacionNegocio = em.merge(oldDatosPersonalesOfInformacionNegocio);
                }
                informacionNegocioNew.setDatosPersonales(datosPersonales);
                informacionNegocioNew = em.merge(informacionNegocioNew);
            }
            for (Referencias referenciasListNewReferencias : referenciasListNew) {
                if (!referenciasListOld.contains(referenciasListNewReferencias)) {
                    DatosPersonales oldDatosPersonalesOfReferenciasListNewReferencias = referenciasListNewReferencias.getDatosPersonales();
                    referenciasListNewReferencias.setDatosPersonales(datosPersonales);
                    referenciasListNewReferencias = em.merge(referenciasListNewReferencias);
                    if (oldDatosPersonalesOfReferenciasListNewReferencias != null && !oldDatosPersonalesOfReferenciasListNewReferencias.equals(datosPersonales)) {
                        oldDatosPersonalesOfReferenciasListNewReferencias.getReferenciasList().remove(referenciasListNewReferencias);
                        oldDatosPersonalesOfReferenciasListNewReferencias = em.merge(oldDatosPersonalesOfReferenciasListNewReferencias);
                    }
                }
            }
            for (SolicitudCredito solicitudCreditoListNewSolicitudCredito : solicitudCreditoListNew) {
                if (!solicitudCreditoListOld.contains(solicitudCreditoListNewSolicitudCredito)) {
                    DatosPersonales oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito = solicitudCreditoListNewSolicitudCredito.getDatosPersonales();
                    solicitudCreditoListNewSolicitudCredito.setDatosPersonales(datosPersonales);
                    solicitudCreditoListNewSolicitudCredito = em.merge(solicitudCreditoListNewSolicitudCredito);
                    if (oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito != null && !oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito.equals(datosPersonales)) {
                        oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito.getSolicitudCreditoList().remove(solicitudCreditoListNewSolicitudCredito);
                        oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito = em.merge(oldDatosPersonalesOfSolicitudCreditoListNewSolicitudCredito);
                    }
                }
            }
            for (Familiares familiaresListNewFamiliares : familiaresListNew) {
                if (!familiaresListOld.contains(familiaresListNewFamiliares)) {
                    DatosPersonales oldDatosPersonalesOfFamiliaresListNewFamiliares = familiaresListNewFamiliares.getDatosPersonales();
                    familiaresListNewFamiliares.setDatosPersonales(datosPersonales);
                    familiaresListNewFamiliares = em.merge(familiaresListNewFamiliares);
                    if (oldDatosPersonalesOfFamiliaresListNewFamiliares != null && !oldDatosPersonalesOfFamiliaresListNewFamiliares.equals(datosPersonales)) {
                        oldDatosPersonalesOfFamiliaresListNewFamiliares.getFamiliaresList().remove(familiaresListNewFamiliares);
                        oldDatosPersonalesOfFamiliaresListNewFamiliares = em.merge(oldDatosPersonalesOfFamiliaresListNewFamiliares);
                    }
                }
            }
            for (Codeudores codeudoresListNewCodeudores : codeudoresListNew) {
                if (!codeudoresListOld.contains(codeudoresListNewCodeudores)) {
                    DatosPersonales oldDuiCodeudorOfCodeudoresListNewCodeudores = codeudoresListNewCodeudores.getDuiCodeudor();
                    codeudoresListNewCodeudores.setDuiCodeudor(datosPersonales);
                    codeudoresListNewCodeudores = em.merge(codeudoresListNewCodeudores);
                    if (oldDuiCodeudorOfCodeudoresListNewCodeudores != null && !oldDuiCodeudorOfCodeudoresListNewCodeudores.equals(datosPersonales)) {
                        oldDuiCodeudorOfCodeudoresListNewCodeudores.getCodeudoresList().remove(codeudoresListNewCodeudores);
                        oldDuiCodeudorOfCodeudoresListNewCodeudores = em.merge(oldDuiCodeudorOfCodeudoresListNewCodeudores);
                    }
                }
            }
            for (Codeudores codeudoresList1NewCodeudores : codeudoresList1New) {
                if (!codeudoresList1Old.contains(codeudoresList1NewCodeudores)) {
                    DatosPersonales oldDatosPersonalesOfCodeudoresList1NewCodeudores = codeudoresList1NewCodeudores.getDatosPersonales();
                    codeudoresList1NewCodeudores.setDatosPersonales(datosPersonales);
                    codeudoresList1NewCodeudores = em.merge(codeudoresList1NewCodeudores);
                    if (oldDatosPersonalesOfCodeudoresList1NewCodeudores != null && !oldDatosPersonalesOfCodeudoresList1NewCodeudores.equals(datosPersonales)) {
                        oldDatosPersonalesOfCodeudoresList1NewCodeudores.getCodeudoresList1().remove(codeudoresList1NewCodeudores);
                        oldDatosPersonalesOfCodeudoresList1NewCodeudores = em.merge(oldDatosPersonalesOfCodeudoresList1NewCodeudores);
                    }
                }
            }
            for (DeclaracionBienes declaracionBienesListNewDeclaracionBienes : declaracionBienesListNew) {
                if (!declaracionBienesListOld.contains(declaracionBienesListNewDeclaracionBienes)) {
                    DatosPersonales oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes = declaracionBienesListNewDeclaracionBienes.getDatosPersonales();
                    declaracionBienesListNewDeclaracionBienes.setDatosPersonales(datosPersonales);
                    declaracionBienesListNewDeclaracionBienes = em.merge(declaracionBienesListNewDeclaracionBienes);
                    if (oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes != null && !oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes.equals(datosPersonales)) {
                        oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes.getDeclaracionBienesList().remove(declaracionBienesListNewDeclaracionBienes);
                        oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes = em.merge(oldDatosPersonalesOfDeclaracionBienesListNewDeclaracionBienes);
                    }
                }
            }
            em.getTransaction().commit();
            em.refresh(datosPersonales);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datosPersonales.getDui();
                if (findDatosPersonales(id) == null) {
                    throw new NonexistentEntityException("The datosPersonales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosPersonales datosPersonales;
            try {
                datosPersonales = em.getReference(DatosPersonales.class, id);
                datosPersonales.getDui();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosPersonales with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            DatosConyugue datosConyugueOrphanCheck = datosPersonales.getDatosConyugue();
            if (datosConyugueOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the DatosConyugue " + datosConyugueOrphanCheck + " in its datosConyugue field has a non-nullable datosPersonales field.");
            }
            Domicilio domicilioOrphanCheck = datosPersonales.getDomicilio();
            if (domicilioOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the Domicilio " + domicilioOrphanCheck + " in its domicilio field has a non-nullable datosPersonales field.");
            }
            InformacionNegocio informacionNegocioOrphanCheck = datosPersonales.getInformacionNegocio();
            if (informacionNegocioOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the InformacionNegocio " + informacionNegocioOrphanCheck + " in its informacionNegocio field has a non-nullable datosPersonales field.");
            }
            List<Referencias> referenciasListOrphanCheck = datosPersonales.getReferenciasList();
            for (Referencias referenciasListOrphanCheckReferencias : referenciasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the Referencias " + referenciasListOrphanCheckReferencias + " in its referenciasList field has a non-nullable datosPersonales field.");
            }
            List<SolicitudCredito> solicitudCreditoListOrphanCheck = datosPersonales.getSolicitudCreditoList();
            for (SolicitudCredito solicitudCreditoListOrphanCheckSolicitudCredito : solicitudCreditoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the SolicitudCredito " + solicitudCreditoListOrphanCheckSolicitudCredito + " in its solicitudCreditoList field has a non-nullable datosPersonales field.");
            }
            List<Familiares> familiaresListOrphanCheck = datosPersonales.getFamiliaresList();
            for (Familiares familiaresListOrphanCheckFamiliares : familiaresListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the Familiares " + familiaresListOrphanCheckFamiliares + " in its familiaresList field has a non-nullable datosPersonales field.");
            }
            List<Codeudores> codeudoresListOrphanCheck = datosPersonales.getCodeudoresList();
            for (Codeudores codeudoresListOrphanCheckCodeudores : codeudoresListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the Codeudores " + codeudoresListOrphanCheckCodeudores + " in its codeudoresList field has a non-nullable duiCodeudor field.");
            }
            List<Codeudores> codeudoresList1OrphanCheck = datosPersonales.getCodeudoresList1();
            for (Codeudores codeudoresList1OrphanCheckCodeudores : codeudoresList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the Codeudores " + codeudoresList1OrphanCheckCodeudores + " in its codeudoresList1 field has a non-nullable datosPersonales field.");
            }
            List<DeclaracionBienes> declaracionBienesListOrphanCheck = datosPersonales.getDeclaracionBienesList();
            for (DeclaracionBienes declaracionBienesListOrphanCheckDeclaracionBienes : declaracionBienesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DatosPersonales (" + datosPersonales + ") cannot be destroyed since the DeclaracionBienes " + declaracionBienesListOrphanCheckDeclaracionBienes + " in its declaracionBienesList field has a non-nullable datosPersonales field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(datosPersonales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosPersonales> findDatosPersonalesEntities() {
        return findDatosPersonalesEntities(true, -1, -1);
    }

    public List<DatosPersonales> findDatosPersonalesEntities(int maxResults, int firstResult) {
        return findDatosPersonalesEntities(false, maxResults, firstResult);
    }

    private List<DatosPersonales> findDatosPersonalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosPersonales.class));
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

    public DatosPersonales findDatosPersonales(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosPersonales.class, id);
        } finally {
            em.close();
        }
    }
    
     public DatosPersonales findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DatosPersonales> cq = cb.createQuery(DatosPersonales.class);
        Root<DatosPersonales> cli = cq.from(DatosPersonales.class);
        cq.select(cli)
                .where(cb.or(cb.like(cb.upper(cli.<String>get("nombre")), nombre + "%"), 
                             cb.like(cb.lower(cli.<String>get("nombre")), nombre + "%")));
        DatosPersonales dt=null;
        try{
            dt = em.createQuery(cq).getSingleResult();
        }catch(Exception e){}
        finally {
            em.close();
        }
        
        
        return dt;
    }

    public int getDatosPersonalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosPersonales> rt = cq.from(DatosPersonales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<DatosPersonales> findByProcede(boolean procede){
        List<DatosPersonales> dt = new ArrayList<>();
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DatosPersonales> cq = cb.createQuery(DatosPersonales.class);
        Root<DatosPersonales> rt = cq.from(DatosPersonales.class);
        cq.select(rt).where(cb.equal(rt.get("procede"), procede));
        try{
            dt = em.createQuery(cq).getResultList();
         }catch(Exception e){}
        finally {
            em.close();
        }
        return dt;
    }
    
    public List<DatosPersonales> findConCreditosActivos(short estado){
        List<DatosPersonales> dt = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query q = em.createQuery("Select d from DatosPersonales d join d.solicitudCreditoList s join s.creditos c where c.estado =:estado",DatosPersonales.class);
        q.setParameter("estado", estado);
        try{
            dt = q.getResultList();
         }catch(Exception e){}
        finally {
            em.close();
        }
        return dt;
    }
    
}
