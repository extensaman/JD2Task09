package by.academy.it.task09.util;

import by.academy.it.task09.entity.HomeTask;

import java.time.LocalDate;

/**
 *
 */
public enum HomeTaskEnum {
    /**
     *
     */
    FIRST_HOME_TASK(
            new HomeTask(
                    "HomeTask01",
                    "zxcvbnm",
                    LocalDate.of(2012, 9, 13),
                    LocalDate.of(2012, 12, 15),
                    PersonEnum.JAMES_BOND.getPerson(),
                    PersonEnum.CURT_COBAIN.getPerson()
            )),
    /**
     *
     */
    SECOND_HOME_TASK(new HomeTask(
            "HomeTask02",
            "mnbvcxz",
            LocalDate.of(1987, 2, 27),
            LocalDate.of(1988, 3, 12),
            PersonEnum.CURT_COBAIN.getPerson(),
            PersonEnum.JAMES_BOND.getPerson()
    ));

    private HomeTask homeTask;

    HomeTaskEnum(HomeTask homeTask) {
        this.homeTask = homeTask;
    }

    public HomeTask getHomeTask() {
        return homeTask;
    }

    @Override
    public String toString() {
        return "HomeTaskEnum{" +
                "homeTask=" + homeTask +
                '}';
    }
}
