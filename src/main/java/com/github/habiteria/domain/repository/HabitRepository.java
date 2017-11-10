package com.github.habiteria.domain.repository;

import com.github.habiteria.domain.model.ScheduleType;
import com.github.habiteria.domain.model.Habit;
import com.github.habiteria.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
public interface HabitRepository extends CrudRepository<Habit, String> {
    Set<Habit> findByOwner(User owner);

    @Query("select h from Habit h where h.owner = :owner and h.schedule.type = :type")
    Set<Habit> findByOwnerAndScheduleType(@Param("owner") User owner, @Param("type") ScheduleType type);
}
