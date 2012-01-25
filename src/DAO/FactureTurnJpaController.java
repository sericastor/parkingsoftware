/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.FactureTurn;
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
public class FactureTurnJpaController implements Serializable {

    public FactureTurnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FactureTurn factureTurn) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(factureTurn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FactureTurn factureTurn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            factureTurn = em.merge(factureTurn);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = factureTurn.getId();
                if (findFactureTurn(id) == null) {
                    throw new NonexistentEntityException("The factureTurn with id " + id + " no longer exists.");
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
            FactureTurn factureTurn;
            try {
                factureTurn = em.getReference(FactureTurn.class, id);
                factureTurn.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factureTurn with id " + id + " no longer exists.", enfe);
            }
            em.remove(factureTurn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FactureTurn> findFactureTurnEntities() {
        return findFactureTurnEntities(true, -1, -1);
    }

    public List<FactureTurn> findFactureTurnEntities(int maxResults, int firstResult) {
        return findFactureTurnEntities(false, maxResults, firstResult);
    }

    private List<FactureTurn> findFactureTurnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FactureTurn.class));
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

    public FactureTurn findFactureTurn(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FactureTurn.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactureTurnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FactureTurn> rt = cq.from(FactureTurn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
