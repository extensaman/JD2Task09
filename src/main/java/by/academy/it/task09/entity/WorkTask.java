package by.academy.it.task09.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 *
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("work_task")
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
}
