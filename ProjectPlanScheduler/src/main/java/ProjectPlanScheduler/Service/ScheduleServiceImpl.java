package ProjectPlanScheduler.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;
import ProjectPlanScheduler.domain.Task;
import ProjectPlanScheduler.domain.TaskDTO;
import ProjectPlanScheduler.domain.mapper.ProjectPlanMapper;
import ProjectPlanScheduler.repository.ProjectPlanRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ProjectPlanRepository projectPlanRepository;
	@Autowired
	private ProjectPlanMapper projectPlanMapper;
	
	@Override
	public ProjectPlan scheduleProject(String name, Date startDate, List<Task> taskList) {
		System.out.println("scheduleProject start..");
		ProjectPlan projectPlan = null;
		if(null != startDate && !CollectionUtils.isEmpty(taskList)) {
			projectPlan = new ProjectPlan();
			projectPlan.setProjectName("test Name");
			projectPlanRepository.save(projectPlan);
		}
		System.out.println("scheduleProject end.." + projectPlan);
		return projectPlan;
	}

	@Override
	public ProjectPlan saveProjectPlan(ProjectPlanDTO projectPlanDTO) {
		return projectPlanRepository.save(projectPlanMapper.dtoToEntity(projectPlanDTO));
	}

	@Override
	public List<ProjectPlan> getAllProjectPlan() {
		return projectPlanRepository.findAll();
	}

	@Override
	public List<TaskDTO> initTaskDTOList() {
		return initTenTaskDTOList();
	}
	
	private List<TaskDTO> initTenTaskDTOList() {
		List<TaskDTO> taskDTOList = new ArrayList<TaskDTO>();
		for(int ctr = 1; ctr < 11; ctr++) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setSeq(ctr);
			taskDTOList.add(taskDTO);
		}
		return taskDTOList;
	}

}
