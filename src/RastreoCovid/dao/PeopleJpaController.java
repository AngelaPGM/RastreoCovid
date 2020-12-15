/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RastreoCovid.dao;

import RastreoCovid.dao.exceptions.NonexistentEntityException;
import RastreoCovid.dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import RastreoCovid.entity.People;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author angep
 */
public class PeopleJpaController implements Serializable {

    public PeopleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("RastreoCovidPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(People people) throws PreexistingEntityException, Exception {
        if (people.getPeopleList() == null) {
            people.setPeopleList(new ArrayList<People>());
        }
        if (people.getPeopleList1() == null) {
            people.setPeopleList1(new ArrayList<People>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<People> attachedPeopleList = new ArrayList<People>();
            for (People peopleListPeopleToAttach : people.getPeopleList()) {
                peopleListPeopleToAttach = em.getReference(peopleListPeopleToAttach.getClass(), peopleListPeopleToAttach.getId());
                attachedPeopleList.add(peopleListPeopleToAttach);
            }
            people.setPeopleList(attachedPeopleList);
            List<People> attachedPeopleList1 = new ArrayList<People>();
            for (People peopleList1PeopleToAttach : people.getPeopleList1()) {
                peopleList1PeopleToAttach = em.getReference(peopleList1PeopleToAttach.getClass(), peopleList1PeopleToAttach.getId());
                attachedPeopleList1.add(peopleList1PeopleToAttach);
            }
            people.setPeopleList1(attachedPeopleList1);
            em.persist(people);
            for (People peopleListPeople : people.getPeopleList()) {
                peopleListPeople.getPeopleList().add(people);
                peopleListPeople = em.merge(peopleListPeople);
            }
            for (People peopleList1People : people.getPeopleList1()) {
                peopleList1People.getPeopleList().add(people);
                peopleList1People = em.merge(peopleList1People);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeople(people.getId()) != null) {
                throw new PreexistingEntityException("People " + people + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(People people) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            People persistentPeople = em.find(People.class, people.getId());
            List<People> peopleListOld = persistentPeople.getPeopleList();
            List<People> peopleListNew = people.getPeopleList();
            List<People> peopleList1Old = persistentPeople.getPeopleList1();
            List<People> peopleList1New = people.getPeopleList1();
            List<People> attachedPeopleListNew = new ArrayList<People>();
            for (People peopleListNewPeopleToAttach : peopleListNew) {
                peopleListNewPeopleToAttach = em.getReference(peopleListNewPeopleToAttach.getClass(), peopleListNewPeopleToAttach.getId());
                attachedPeopleListNew.add(peopleListNewPeopleToAttach);
            }
            peopleListNew = attachedPeopleListNew;
            people.setPeopleList(peopleListNew);
            List<People> attachedPeopleList1New = new ArrayList<People>();
            for (People peopleList1NewPeopleToAttach : peopleList1New) {
                peopleList1NewPeopleToAttach = em.getReference(peopleList1NewPeopleToAttach.getClass(), peopleList1NewPeopleToAttach.getId());
                attachedPeopleList1New.add(peopleList1NewPeopleToAttach);
            }
            peopleList1New = attachedPeopleList1New;
            people.setPeopleList1(peopleList1New);
            people = em.merge(people);
            for (People peopleListOldPeople : peopleListOld) {
                if (!peopleListNew.contains(peopleListOldPeople)) {
                    peopleListOldPeople.getPeopleList().remove(people);
                    peopleListOldPeople = em.merge(peopleListOldPeople);
                }
            }
            for (People peopleListNewPeople : peopleListNew) {
                if (!peopleListOld.contains(peopleListNewPeople)) {
                    peopleListNewPeople.getPeopleList().add(people);
                    peopleListNewPeople = em.merge(peopleListNewPeople);
                }
            }
            for (People peopleList1OldPeople : peopleList1Old) {
                if (!peopleList1New.contains(peopleList1OldPeople)) {
                    peopleList1OldPeople.getPeopleList().remove(people);
                    peopleList1OldPeople = em.merge(peopleList1OldPeople);
                }
            }
            for (People peopleList1NewPeople : peopleList1New) {
                if (!peopleList1Old.contains(peopleList1NewPeople)) {
                    peopleList1NewPeople.getPeopleList().add(people);
                    peopleList1NewPeople = em.merge(peopleList1NewPeople);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = people.getId();
                if (findPeople(id) == null) {
                    throw new NonexistentEntityException("The people with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            People people;
            try {
                people = em.getReference(People.class, id);
                people.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The people with id " + id + " no longer exists.", enfe);
            }
            List<People> peopleList = people.getPeopleList();
            for (People peopleListPeople : peopleList) {
                peopleListPeople.getPeopleList().remove(people);
                peopleListPeople = em.merge(peopleListPeople);
            }
            List<People> peopleList1 = people.getPeopleList1();
            for (People peopleList1People : peopleList1) {
                peopleList1People.getPeopleList().remove(people);
                peopleList1People = em.merge(peopleList1People);
            }
            em.remove(people);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<People> findPeopleEntities() {
        return findPeopleEntities(true, -1, -1);
    }

    public List<People> findPeopleEntities(int maxResults, int firstResult) {
        return findPeopleEntities(false, maxResults, firstResult);
    }

    private List<People> findPeopleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(People.class));
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

    public People findPeople(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(People.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeopleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<People> rt = cq.from(People.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
