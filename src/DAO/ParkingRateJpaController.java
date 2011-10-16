/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.ParkingRate;
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
public class ParkingRateJpaController implements Serializable {

    public ParkingRateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParkingRate parkingRate) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(parkingRate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParkingRate parkingRate) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            parkingRate = em.merge(parkingRate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = parkingRate.getId();
                if (findParkingRate(id) == null) {
                    throw new NonexistentEntityException("The parkingRate with id " + id + " no longer exists.");
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
            ParkingRate parkingRate;
            try {
                parkingRate = em.getReference(ParkingRate.class, id);
                parkingRate.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parkingRate with id " + id + " no longer exists.", enfe);
            }
            em.remove(parkingRate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParkingRate> findParkingRateEntities() {
        return findParkingRateEntities(true, -1, -1);
    }

    public List<ParkingRate> findParkingRateEntities(int maxResults, int firstResult) {
        return findParkingRateEntities(false, maxResults, firstResult);
    }

    private List<ParkingRate> findParkingRateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParkingRate.class));
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

    public ParkingRate findParkingRate(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParkingRate.class, id);
        } finally {
            em.close();
        }
    }

    public int getParkingRateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParkingRate> rt = cq.from(ParkingRate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
