/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import Entity.CustomExitTicket;
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
 * @author DiegoAl
 */
public class CustomExitTicketJpaController implements Serializable {

    public CustomExitTicketJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CustomExitTicket customExitTicket) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(customExitTicket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CustomExitTicket customExitTicket) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            customExitTicket = em.merge(customExitTicket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customExitTicket.getId();
                if (findCustomExitTicket(id) == null) {
                    throw new NonexistentEntityException("The customExitTicket with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(CustomExitTicket ticket, Long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CustomExitTicket newTicket = em.find(CustomExitTicket.class, id);
            newTicket.setTittle(ticket.getTittle());
            newTicket.setExitEmployee(ticket.isExitEmployee());
            newTicket.setFootPage(ticket.getFootPage());
            newTicket.setParkwayNit(ticket.isParkwayNit());
            newTicket.setParkwayName(ticket.isParkwayName());
            newTicket.setParkwayAddress(ticket.isParkwayAddress());
            ticket = em.merge(newTicket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
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
            CustomExitTicket customExitTicket;
            try {
                customExitTicket = em.getReference(CustomExitTicket.class, id);
                customExitTicket.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customExitTicket with id " + id + " no longer exists.", enfe);
            }
            em.remove(customExitTicket);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CustomExitTicket> findCustomExitTicketEntities() {
        return findCustomExitTicketEntities(true, -1, -1);
    }

    public List<CustomExitTicket> findCustomExitTicketEntities(int maxResults, int firstResult) {
        return findCustomExitTicketEntities(false, maxResults, firstResult);
    }

    private List<CustomExitTicket> findCustomExitTicketEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CustomExitTicket.class));
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

    public CustomExitTicket findCustomExitTicket(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CustomExitTicket.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomExitTicketCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CustomExitTicket> rt = cq.from(CustomExitTicket.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
