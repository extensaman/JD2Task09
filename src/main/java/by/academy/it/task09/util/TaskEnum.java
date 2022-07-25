package by.academy.it.task09.util;

import by.academy.it.task09.entity.Task;

/**
 *
 */
public enum TaskEnum {
    /**
     *
     */
    FIRST_TASK(new Task("Task01", "Description for Task01")),
    /**
     *
     */
    SECOND_TASK(new Task("Task02", "Description for Task02"));

    private final Task task;

    TaskEnum(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
