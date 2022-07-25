package by.academy.it.task09;


import by.academy.it.task09.dao.DaoFactory;
import by.academy.it.task09.dao.TaskDao;
import by.academy.it.task09.entity.Task;
import by.academy.it.task09.entity.WorkTask;
import by.academy.it.task09.util.HomeTaskEnum;
import by.academy.it.task09.util.TaskEnum;
import by.academy.it.task09.util.WorkTaskEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends Assertions {
    public static final long FIRST_HOME_TASK_ID = 2L;
    public static final long FIRST_WORK_TASK_ID = 3L;
    public static final long SECOND_HOME_TASK_ID = 5L;
    public static final String COST_FOR_CHANGE = "999.99";
    private static TaskDao dao;

    @BeforeAll
    static void beforeAll() {
        dao = DaoFactory.getInstance().getDaoTest();
        List<Task> taskList =
                List.of(TaskEnum.FIRST_TASK.getTask(),
                        HomeTaskEnum.FIRST_HOME_TASK.getHomeTask(),
                        WorkTaskEnum.FIRST_WORK_TASK.getWorkTask(),
                        TaskEnum.SECOND_TASK.getTask(),
                        HomeTaskEnum.SECOND_HOME_TASK.getHomeTask());
        dao.save(taskList);
    }

    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldAddAndFindAddedElement() {
        dao.save(WorkTaskEnum.SECOND_WORK_TASK.getWorkTask());
        List<Task> task = dao.findAll();
        int count = (int) task.stream()
                .filter(t -> t.getName()
                        .equals(WorkTaskEnum.SECOND_WORK_TASK.getWorkTask().getName()))
                .count();
        assertEquals(1, count);
    }

    @Test
    public void shouldFindFirstHomeTask() {
        Task task = dao.findById(FIRST_HOME_TASK_ID);
        assertEquals(HomeTaskEnum.FIRST_HOME_TASK.getHomeTask(), task);
    }

    @Test
    public void shouldUpdateCostInWorkTask() {
        WorkTask workTask = (WorkTask) dao.findById(FIRST_WORK_TASK_ID);
        BigDecimal cost = new BigDecimal(COST_FOR_CHANGE);
        workTask.setCost(cost);
        dao.update(workTask);
        WorkTask updatedWorkTask = (WorkTask) dao.findById(FIRST_WORK_TASK_ID);
        assertEquals(cost, updatedWorkTask.getCost());

    }

    @Test
    public void shouldDeleteSecondHomeTask() {
        List<Task> result = dao.findAll();
        for (Task task : result) {
            System.out.println(task);
        }
        dao.delete(SECOND_HOME_TASK_ID);
        List<Task> task = dao.findAll();
        int count = (int) task.stream()
                .filter(t -> t.equals(HomeTaskEnum.SECOND_HOME_TASK.getHomeTask()))
                .count();
        assertEquals(0, count);
    }

    @Test
    public void shouldNotNullProductionDao(){
        assertNotNull(DaoFactory.getInstance().getDaoProduction());
    }
}
