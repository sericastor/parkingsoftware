/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.Entries;
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
public class EntriesJpaController implements Serializable {

    public EntriesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entries entries) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entries);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entries entries) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entries = em.merge(entries);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = entries.getId();
                if (findEntries(id) == null) {
                    throw new NonexistentEntityException("The entries with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Entries entries, long id){
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Entries newEntry = em.find(Entries.class, id);
            newEntry.setEmployee(entries.getEmployee());
            newEntry.setEntryDate(entries.getEntryDate());
            newEntry.setPlate(entries.getPlate());
            newEntry.setTicket(entries.getTicket());
            newEntry.setVehicleType(entries.getVehicleType());
            newEntry.setComentary(entries.getComentary());
            entries = em.merge(newEntry);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
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
            Entries entries;
            try {
                entries = em.getReference(Entries.class, id);
                entries.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entries with id " + id + " no longer exists.", enfe);
            }
            em.remove(entries);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entries> findEntriesEntities() {
        return findEntriesEntities(true, -1, -1);
    }

    public List<Entries> findEntriesEntities(int maxResults, int firstResult) {
        return findEntriesEntities(false, maxResults, firstResult);
    }

    private List<Entries> findEntriesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entries.class));
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

    public Entries findEntries(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entries.class, id);
        }catch(Exception ex){
            return null;
        } finally {
            em.close();
        }
    }

    public int getEntriesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entries> rt = cq.from(Entries.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Entries getEntriesByPlate(String plate) {
        EntityManager em = getEntityManager();
        Entries entries = null;
        try {
            Query q = em.createQuery("SELECT u FROM Entries u "
                    + "where u.plate LIKE :plate").setParameter("plate", plate);
            entries = (Entries) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
            return entries;
        }

    }
    public Entries getEntriesByTicketCodification(String ticketCodification) {
        EntityManager em = getEntityManager();
        Entries entries = null;
        try {
            Query q = em.createQuery("SELECT u FROM Entries u "
                    + "where u.ticketCodification LIKE :ticketCodification").setParameter("ticketCodification", ticketCodification);
            entries = (Entries) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
            return entries;
        }
    }
    
}
