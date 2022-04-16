package by.academy.it.task09.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("home_task")
public class HomeTask extends Task {
    /**
     *
     */
    @Column
    private LocalDate startDate;
    /**
     *
     */
    @Column
    private LocalDate finishDate;
    /**
     *
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "surname",
                    column = @Column(name = "p_surname")),
            @AttributeOverride(name = "name",
                    column = @Column(name = "p_name"))
    })
    private Person performer;
    /**
     *
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "surname",
                    column = @Column(name = "a_surname")),
            @AttributeOverride(name = "name",
                    column = @Column(name = "a_name"))
    })
    private Person accepter;

    public HomeTask(String name,
                    String description,
                    LocalDate startDate,
                    LocalDate finishDate,
                    Person performer,
                    Person accepter) {
        super(name, description);
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.performer = performer;
        this.accepter = accepter;
    }
}
