package by.academy.it.task09.util;

import by.academy.it.task09.entity.WorkTask;

import java.math.BigDecimal;

/**
 *
 */
public enum WorkTaskEnum {
    /**
     *
     */
    FIRST_WORK_TASK(new WorkTask("Name: WorkTask01",
            "qwertyuiop",
            new BigDecimal("200.98"))),
    /**
     *
     */
    SECOND_WORK_TASK(new WorkTask("Name: WorkTask02",
            "asdfghjkl",
            new BigDecimal("593.74")));
    private WorkTask workTask;

    WorkTaskEnum(WorkTask workTask) {
        this.workTask = workTask;
    }

    public WorkTask getWorkTask() {
        return workTask;
    }

    @Override
    public String toString() {
        return "WorkTaskEnum{" +
                "workTask=" + workTask +
                '}';
    }
}
