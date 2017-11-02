package com.github.netcracker2017team.project.domain.model;

import com.github.netcracker2017team.project.domain.model.template.DistributorStepTemplate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Alex Ivchenko
 */
@Setter
@Getter
@ToString(exclude = "goal")
@Entity
@DiscriminatorValue("foreign")
public class ForeignStep extends Step {

    @ManyToOne
    @JoinColumn(name = "distributor_step_template_id", nullable = false)
    private DistributorStepTemplate template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foreign_goal_id")
    private ForeignGoal goal;

    @Column(name = "action")
    private String action;
}
