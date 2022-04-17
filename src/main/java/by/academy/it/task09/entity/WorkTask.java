package by.academy.it.task09.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 *
 */
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("work_task")
@Access(AccessType.FIELD)
public class WorkTask extends Task {
    /**
     *
     */
    @Column
    private BigDecimal cost;

    public WorkTask(String surname, String name, BigDecimal cost) {
        super(surname, name);
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
