package ProjectPlanScheduler.domain.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;
import ProjectPlanScheduler.domain.Task;
import ProjectPlanScheduler.domain.TaskDTO;
import ProjectPlanScheduler.repository.ProjectPlanRepository;

@Component
public class ProjectPlanMapper {
	@Autowired
	private ProjectPlanRepository projectPlanRepository;
	
	private final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	public ProjectPlan dtoToEntity(ProjectPlanDTO projectPlanDTO) {
		try {
			ProjectPlan projectPlan = new ProjectPlan();
			projectPlan.setProjectName(projectPlanDTO.getProjectName());
			projectPlan.setStartDate((Date)FORMATTER.parse(projectPlanDTO.getStartDate()));
			
			return projectPlan;
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Task dtoToEntity(TaskDTO taskDTO) {
		try {
			Task task = new Task();
			task.setTaskName(taskDTO.getTaskName());
			task.setDays(taskDTO.getDays());
			task.setHrs(taskDTO.getHrs());
			task.setMins(taskDTO.getMins());
			task.setProjectPlan(projectPlanRepository.getOne(taskDTO.getProjectPlanId()));
			if(!StringUtils.isEmpty(taskDTO.getStartDate())) {
				task.setStartDate((Date)FORMATTER.parse(taskDTO.getStartDate()));				
			}
			if(!StringUtils.isEmpty(taskDTO.getEndDate())) {
				task.setEndDate((Date)FORMATTER.parse(taskDTO.getEndDate()));				
			}
			return task;
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		return null;
	}
}
