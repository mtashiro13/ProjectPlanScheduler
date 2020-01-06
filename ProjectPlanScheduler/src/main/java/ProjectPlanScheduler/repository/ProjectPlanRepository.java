package ProjectPlanScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjectPlanScheduler.domain.ProjectPlan;

@Repository
public interface ProjectPlanRepository extends JpaRepository<ProjectPlan, Long> {

}
