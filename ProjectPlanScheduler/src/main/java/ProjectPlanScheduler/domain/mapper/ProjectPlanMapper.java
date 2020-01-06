package ProjectPlanScheduler.domain.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;
import ProjectPlanScheduler.domain.Task;
import ProjectPlanScheduler.domain.TaskDTO;

@Component
public class ProjectPlanMapper {
	
	private final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	
	public ProjectPlan dtoToEntity(ProjectPlanDTO projectPlanDTO) {
		if(null == projectPlanDTO || StringUtils.isEmpty(projectPlanDTO.getProjectName()) || StringUtils.isEmpty(projectPlanDTO.getStartDate())) {
			return null;
		}
		try {
			ProjectPlan projectPlan = new ProjectPlan();
			projectPlan.setProjectName(projectPlanDTO.getProjectName());
			projectPlan.setStartDate((Date)FORMATTER.parse(projectPlanDTO.getStartDate()));
			if(!CollectionUtils.isEmpty(projectPlanDTO.getTaskDTOList())) {
				Date endDate = (Date)FORMATTER.parse(Collections.max(projectPlanDTO.getTaskDTOList(), Comparator.comparing(s -> s.getEndDate())).getEndDate());
				projectPlan.setEndDate(endDate);
			}
					
			return projectPlan;
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Task dtoToEntity(TaskDTO taskDTO, long projectPlanId) {
		try {
			Task task = new Task();
			task.setTaskName(taskDTO.getTaskName());
			task.setDays(taskDTO.getDays());
			task.setHrs(taskDTO.getHrs());
			task.setMins(taskDTO.getMins());
			task.setProjectPlanId(projectPlanId);
			task.setSeq(taskDTO.getSeq());
			task.setDependentTo(taskDTO.getDependentTo());
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
	
	public List<Task> taskDTOListToEntityList(List<TaskDTO> taskDTOList, long projectPlanId) {
		try {
			if(!CollectionUtils.isEmpty(taskDTOList)) {
				List<Task> taskList = new ArrayList<Task>();
				for(TaskDTO taskDTO : taskDTOList) {
					taskList.add(this.dtoToEntity(taskDTO, projectPlanId));
				}
				return taskList;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
}
