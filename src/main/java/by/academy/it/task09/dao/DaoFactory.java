package by.academy.it.task09.dao;

import by.academy.it.task09.dao.impl.TaskDaoImpl;
import by.academy.it.task09.dao.util.PersistenceUnitName;

/**
 *
 */
public class DaoFactory {

    private static class SingletonHolder {
        private final static DaoFactory INSTANCE = new DaoFactory();
    }

    private DaoFactory() {

    }

    /**
     * @return -
     */
    public static DaoFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return -
     */
    public TaskDao getDaoProduction() {
        return new TaskDaoImpl(PersistenceUnitName.PRODUCTION);
    }

    /**
     * @return -
     */
    public TaskDao getDaoTest() {
        return new TaskDaoImpl(PersistenceUnitName.TEST);
    }
}
