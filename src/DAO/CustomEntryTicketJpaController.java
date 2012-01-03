/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import Entity.CustomEntryTicket;
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
public class CustomEntryTicketJpaController implements Serializable {

    public CustomEntryTicketJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CustomEntryTicket customTicket) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(customTicket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCustomTicket(customTicket.getId()) != null) {
                throw new PreexistingEntityException("CustomTicket " + customTicket + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CustomEntryTicket customTicket) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            customTicket = em.merge(customTicket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customTicket.getId();
                if (findCustomTicket(id) == null) {
                    throw new NonexistentEntityException("The customTicket with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(CustomEntryTicket ticket, Long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CustomEntryTicket newTicket = em.find(CustomEntryTicket.class, id);
            newTicket.setTittle(ticket.getTittle());
            newTicket.setEntryEmployee(ticket.isEntryEmployee());
            newTicket.setBarcode(ticket.isBarcode());
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
            CustomEntryTicket customTicket;
            try {
                customTicket = em.getReference(CustomEntryTicket.class, id);
                customTicket.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customTicket with id " + id + " no longer exists.", enfe);
            }
            em.remove(customTicket);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CustomEntryTicket> findCustomTicketEntities() {
        return findCustomTicketEntities(true, -1, -1);
    }

    public List<CustomEntryTicket> findCustomTicketEntities(int maxResults, int firstResult) {
        return findCustomTicketEntities(false, maxResults, firstResult);
    }

    private List<CustomEntryTicket> findCustomTicketEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CustomEntryTicket.class));
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

    public CustomEntryTicket findCustomTicket(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CustomEntryTicket.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomTicketCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CustomEntryTicket> rt = cq.from(CustomEntryTicket.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
