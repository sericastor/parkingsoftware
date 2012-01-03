/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.VehicleType;
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
public class VehicleTypeJpaController implements Serializable {

    public VehicleTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List <VehicleType>  matchPlateType(String codification) {
        EntityManager em = getEntityManager();
        List <VehicleType> vehi = null;
        try {
        Query q = em.createQuery("SELECT u FROM VehicleType u "
                + "where u.codification LIKE :codification").setParameter("codification", codification);
        
            vehi = q.getResultList();
            return vehi;
        } catch (Exception ex) {
            return vehi;
        } finally {
            em.close();
        }
    }

    public void create(VehicleType vehicleType) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vehicleType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VehicleType vehicleType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vehicleType = em.merge(vehicleType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vehicleType.getNumber();
                if (findVehicleType(id) == null) {
                    throw new NonexistentEntityException("The vehicleType with id " + id + " no longer exists.");
                }
            }
            throw ex;
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
            VehicleType vehicleType;
            try {
                vehicleType = em.getReference(VehicleType.class, id);
                vehicleType.getNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehicleType with id " + id + " no longer exists.", enfe);
            }
            em.remove(vehicleType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VehicleType> findVehicleTypeEntities() {
        return findVehicleTypeEntities(true, -1, -1);
    }

    public List<VehicleType> findVehicleTypeEntities(int maxResults, int firstResult) {
        return findVehicleTypeEntities(false, maxResults, firstResult);
    }

    private List<VehicleType> findVehicleTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VehicleType.class));
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

    public VehicleType findVehicleType(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VehicleType.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehicleTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VehicleType> rt = cq.from(VehicleType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
