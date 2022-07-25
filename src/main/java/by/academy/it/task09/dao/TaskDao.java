package by.academy.it.task09.dao;

import by.academy.it.task09.entity.Task;

import java.util.List;

/**
 *
 */
public interface TaskDao {
    /**
     * @param id
     * @return -
     */
    Task findById(Long id);

    /**
     * @return -
     */
    List<Task> findAll();

    /**
     * @param task
     */
    void save(Task task);

    /**
     * @param list
     */
    void save(List<Task> list);

    /**
     * @param task
     */
    void update(Task task);

    /**
     * @param id
     */
    void delete(Long id);
}
