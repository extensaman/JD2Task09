package by.academy.it.task09.util;

import by.academy.it.task09.entity.Person;

/**
 *
 */
public enum PersonEnum {
    /**
     *
     */
    JAMES_BOND(new Person("Bond", "James")),
    /**
     *
     */
    CURT_COBAIN(new Person("Cobain", "Curt"));
    private Person person;

    PersonEnum(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
