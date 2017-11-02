package com.github.netcracker2017team.project.domain.model.template;

import com.github.netcracker2017team.project.domain.model.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alex Ivchenko
 */
@Setter
@Getter
@ToString(callSuper = true, exclude = "owner")
@Entity
@DiscriminatorValue("doer")
public class UserGoalTemplate extends GoalTemplate {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "goal", orphanRemoval = true)
    private Set<UserStepTemplate> steps;
}
