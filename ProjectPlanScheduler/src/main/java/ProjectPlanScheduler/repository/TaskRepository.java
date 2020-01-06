package ProjectPlanScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjectPlanScheduler.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
