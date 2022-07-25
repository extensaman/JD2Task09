package by.academy.it.task09;

import by.academy.it.task09.dao.DaoFactory;
import by.academy.it.task09.dao.TaskDao;
import by.academy.it.task09.entity.Task;
import by.academy.it.task09.util.HomeTaskEnum;
import by.academy.it.task09.util.TaskEnum;
import by.academy.it.task09.util.WorkTaskEnum;

import java.util.List;

/**
 * Create three classes
 * 1) Task - has the following fields
 * - id
 * - name
 * - description
 * <p>
 * 2) HomeTask extends Task - has additional fields
 * - startDate
 * - endDate
 *
 * @Embedded - performer
 * (type Person [has two fields first and last name, make them Embeddable])
 * @Embedded - accepter
 * (type Person [has two fields first and last name, make them Embeddable])
 * <p>
 * 3) WorkTask extends Task - has additional field
 * - cost
 * <p>
 * In three git branches, implement 3 inheritance strategies:
 * 1 - Table per class hierarchy
 * 2 - Table per subclass
 * 3 - Table Per Concrete class mapping
 * <p>
 * Write there some data from the main method.
 * Check through tests on H2, connect checkstyle, jacoco.
 */
public final class App {
    /**
     *
     */
    private App() {

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("\'Single table\' implementation");
        List<Task> taskList =
                List.of(TaskEnum.FIRST_TASK.getTask(),
                        HomeTaskEnum.FIRST_HOME_TASK.getHomeTask(),
                        WorkTaskEnum.FIRST_WORK_TASK.getWorkTask(),
                        TaskEnum.SECOND_TASK.getTask(),
                        HomeTaskEnum.SECOND_HOME_TASK.getHomeTask(),
                        WorkTaskEnum.SECOND_WORK_TASK.getWorkTask());
        TaskDao dao = DaoFactory.getInstance().getDaoProduction();
        dao.save(taskList);
        List<Task> result = dao.findAll();
        for (Task task : result) {
            System.out.println(task);
        }
    }
}
