package by.academy.it.task09.dao.util;

/**
 *
 */
public enum PersistenceUnitName {
    /**
     *
     */
    PRODUCTION("production"),
    /**
     *
     */
    TEST("test");
    private String value;

    PersistenceUnitName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
