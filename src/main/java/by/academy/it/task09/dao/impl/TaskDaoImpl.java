package by.academy.it.task09.dao.impl;

import by.academy.it.task09.dao.TaskDao;
import by.academy.it.task09.dao.exception.TaskDaoException;
import by.academy.it.task09.dao.util.PersistenceUnitName;
import by.academy.it.task09.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 */
public class TaskDaoImpl implements TaskDao {
    /**
     *
     */
    private final EntityManagerFactory factory;

    public TaskDaoImpl(final PersistenceUnitName name) {
        this.factory =
                Persistence
                        .createEntityManagerFactory(name.getValue());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Task findById(final Long id) {
        EntityManager entityManager = factory.createEntityManager();
        Task result = null;
        try {
            result = entityManager.find(Task.class, id);
        } catch (IllegalArgumentException e) {
            throw new TaskDaoException(e);
        } finally {
            entityManager.close();
        }
        return result;
    }

    /**
     * @return -
     */
    @Override
    public List<Task> findAll() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
        Root<Task> rootEntry = criteriaQuery.from(Task.class);
        CriteriaQuery<Task> all = criteriaQuery.select(rootEntry);
        TypedQuery<Task> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    /**
     * @param task
     */
    @Override
    public void save(final Task task) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new TaskDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param list
     */
    @Override
    public void save(final List<Task> list) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            list.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new TaskDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param task
     */
    @Override
    public void update(final Task task) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(task);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new TaskDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(final Long id) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            Task task = entityManager.find(Task.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(task);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new TaskDaoException(e);
        } finally {
            entityManager.close();
        }
    }
}
