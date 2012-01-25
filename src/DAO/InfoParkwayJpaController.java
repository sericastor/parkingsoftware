/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.InfoParkway;
import controller.MainController;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author miguel
 */
public class InfoParkwayJpaController implements Serializable {

    public InfoParkwayJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InfoParkway infoParkway) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(infoParkway);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InfoParkway infoParkway) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infoParkway = em.merge(infoParkway);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = infoParkway.getId();
                if (findInfoParkway(id) == null) {
                    throw new NonexistentEntityException("The infoParkway with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(InfoParkway infoParkway, long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoParkway newInfoPark = em.find(InfoParkway.class, id);
            newInfoPark.setName(infoParkway.getName());
            newInfoPark.setAddress(infoParkway.getAddress());
            newInfoPark.setNit(infoParkway.getNit());
            newInfoPark.setTelephone(infoParkway.getTelephone());
            newInfoPark.setMaxCapacity(infoParkway.getMaxCapacity());
            newInfoPark.setIVAPercent(infoParkway.getIVAPercent());
            infoParkway = em.merge(newInfoPark);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            MainController.adminView.showMessage("Error", "No fue posible modificar  ".concat(infoParkway.getName()), 0);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoParkway infoParkway;
            try {
                infoParkway = em.getReference(InfoParkway.class, id);
                infoParkway.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infoParkway with id " + id + " no longer exists.", enfe);
            }
            em.remove(infoParkway);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfoParkway> findInfoParkwayEntities() {
        return findInfoParkwayEntities(true, -1, -1);
    }

    public List<InfoParkway> findInfoParkwayEntities(int maxResults, int firstResult) {
        return findInfoParkwayEntities(false, maxResults, firstResult);
    }

    private List<InfoParkway> findInfoParkwayEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfoParkway.class));
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

    public InfoParkway findInfoParkway(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfoParkway.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfoParkwayCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfoParkway> rt = cq.from(InfoParkway.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
