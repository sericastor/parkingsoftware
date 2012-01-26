/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.Employee;
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
public class EmployeeJpaController implements Serializable {

    public EmployeeJpaController() {
    }

    public EmployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Employee findEmployeeByUser(String user) {
        EntityManager em = getEntityManager();
        Employee employee = null;
        Query q = em.createQuery("SELECT u FROM Employee u "
               + "where u.user LIKE :user")
               .setParameter("user", user);
        try{
            
            employee = (Employee) q.getSingleResult();
        }catch(Exception ex){
            
            //TODO: fuck yeah!! xD, mirar Hechepchion :) 
        }finally{
            em.close();
            return employee;
        }

    }
    
    public void create(Employee employee) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        }catch(Exception ex){
            MainController.adminView.showMessage("Error", "Imposible crear al usaurio " + employee.getUser(), 0);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Employee employee, long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee newEmployee = em.find(Employee.class, id);
            newEmployee.setLastName(employee.getLastName());
            newEmployee.setName(employee.getName());
            newEmployee.setDocument(employee.getDocument());
            newEmployee.setUser(employee.getUser());
            newEmployee.setPassword(employee.getPassword());
            newEmployee.setAdministrator(employee.isAdministrator());
            newEmployee.setIsActive(employee.isIsActive());
            newEmployee.setTheme(employee.getTheme());
            employee = em.merge(newEmployee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            MainController.adminView.showMessage("Error", "Imposible mofidicar al usaurio " + employee.getUser(), 0);
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
            Employee employee;
            try {
                employee = em.getReference(Employee.class, id);
                employee.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employee with id " + id + " no longer exists.", enfe);
            }
            em.remove(employee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Employee> findEmployeeEntities() {
        return findEmployeeEntities(true, -1, -1);
    }

    public List<Employee> findEmployeeEntities(int maxResults, int firstResult) {
        return findEmployeeEntities(false, maxResults, firstResult);
    }

    public List<Employee> findEmployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employee.class));
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

    public Employee findEmployee(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employee> rt = cq.from(Employee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
