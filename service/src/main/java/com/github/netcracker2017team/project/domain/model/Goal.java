package com.github.netcracker2017team.project.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@ToString(of = "name")
@MappedSuperclass
public abstract class Goal extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_unit")
    private TimeUnit timeUnit;

    @Column(name = "time_unit_repeats")
    private int timeUnitRepeats;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Step> children;
}
