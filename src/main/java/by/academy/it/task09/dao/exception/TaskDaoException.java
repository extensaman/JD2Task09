package by.academy.it.task09.dao.exception;

/**
 *
 */
public class TaskDaoException extends RuntimeException {
    public TaskDaoException() {
    }

    public TaskDaoException(String message) {
        super(message);
    }

    public TaskDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskDaoException(Throwable cause) {
        super(cause);
    }
}
