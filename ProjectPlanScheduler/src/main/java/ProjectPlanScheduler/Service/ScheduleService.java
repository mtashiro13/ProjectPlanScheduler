package ProjectPlanScheduler.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;
import ProjectPlanScheduler.domain.TaskDTO;

@Component
public interface ScheduleService {

	public ProjectPlan scheduleProject(ProjectPlanDTO projectPlanDTO);
	public ProjectPlan saveProjectPlan(ProjectPlanDTO projectPlanDTO);
	public List<ProjectPlan> getAllProjectPlan();
	public List<TaskDTO> initTaskDTOList();
}
