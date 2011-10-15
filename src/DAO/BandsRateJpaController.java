/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.BandsRate;
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
public class BandsRateJpaController implements Serializable {

    public BandsRateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     public List queryByVehicleTypes(VehicleType vehicle) {
        EntityManager em = getEntityManager();

        String id =vehicle.getName();
        Query q = em.createQuery("SELECT u FROM BandsRate u "
                + "where u.vehicletype LIKE :id").setParameter("id", id);
        try {

            List <BandsRate> result =q.getResultList();
            return result;
        } catch (Exception ex) {
            System.out.println("Aja ve y tu que, no tengo datos");
            return null;
        } finally {
            em.close();
        }
    }

    public void create(BandsRate bandsRate) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bandsRate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BandsRate bandsRate) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bandsRate = em.merge(bandsRate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = bandsRate.getId();
                if (findBandsRate(id) == null) {
                    throw new NonexistentEntityException("The bandsRate with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BandsRate bandsRate;
            try {
                bandsRate = em.getReference(BandsRate.class, id);
                bandsRate.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bandsRate with id " + id + " no longer exists.", enfe);
            }
            em.remove(bandsRate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BandsRate> findBandsRateEntities() {
        return findBandsRateEntities(true, -1, -1);
    }

    public List<BandsRate> findBandsRateEntities(int maxResults, int firstResult) {
        return findBandsRateEntities(false, maxResults, firstResult);
    }

    private List<BandsRate> findBandsRateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BandsRate.class));
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

    public BandsRate findBandsRate(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BandsRate.class, id);
        } finally {
            em.close();
        }
    }

    public int getBandsRateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BandsRate> rt = cq.from(BandsRate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
