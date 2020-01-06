package ProjectPlanScheduler.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;
import ProjectPlanScheduler.domain.Task;
import ProjectPlanScheduler.domain.TaskDTO;
import ProjectPlanScheduler.domain.mapper.ProjectPlanMapper;
import ProjectPlanScheduler.repository.ProjectPlanRepository;
import ProjectPlanScheduler.repository.TaskRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ProjectPlanRepository projectPlanRepository;
	@Autowired
	private ProjectPlanMapper projectPlanMapper;
	@Autowired
	private TaskRepository taskRepository;
	
	private final long ZERO = 0;
	private final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	
	@Override
	public ProjectPlan scheduleProject(ProjectPlanDTO projectPlanDTO) {
		if(!CollectionUtils.isEmpty(projectPlanDTO.getTaskDTOList())) {
			projectPlanDTO.setTaskDTOList(removeExcessTask(projectPlanDTO.getTaskDTOList()));
			projectPlanDTO.setTaskDTOList(calculateScheduleForTasks(projectPlanDTO));
			
		}
		return this.saveProjectPlan(projectPlanDTO);
	}

	@Override
	public ProjectPlan saveProjectPlan(ProjectPlanDTO projectPlanDTO) {
		ProjectPlan projectPlan = projectPlanMapper.dtoToEntity(projectPlanDTO);
		projectPlan.setTaskList(null);
		ProjectPlan projectPlanForTask = projectPlanRepository.save(projectPlan);
		List<Task> taskList = projectPlanMapper.taskDTOListToEntityList(projectPlanDTO.getTaskDTOList(), projectPlan.getId());
		List<Task> taskListFinal = taskRepository.saveAll(taskList);
		projectPlanForTask.setTaskList(taskListFinal);
		return projectPlanForTask;
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
	
	private List<TaskDTO> removeExcessTask(List<TaskDTO> taskDTOList){
		List<TaskDTO> taskListRetained = new ArrayList<TaskDTO>(taskDTOList);
		if(!CollectionUtils.isEmpty(taskDTOList)) {
			for(TaskDTO taskDTO : taskDTOList) {
				if(StringUtils.isEmpty(taskDTO.getTaskName())) {
					taskListRetained.remove(taskDTO);
				}
			}
		}
		return taskListRetained;
	}
	
	private List<TaskDTO> calculateScheduleForTasks(ProjectPlanDTO projectPlanDTO){
		try {
			for(TaskDTO taskDTO : projectPlanDTO.getTaskDTOList()) {
				//compute all with no dependencies starts on the start date
				if(ZERO == taskDTO.getDependentTo()) {
					taskDTO.setStartDate(projectPlanDTO.getStartDate());
					//add duration starting from mins,hrs,days
					Date endDate = (Date)FORMATTER.parse(projectPlanDTO.getStartDate());
					Calendar endDateCal = Calendar.getInstance();
					endDateCal.setTime(endDate);
					endDateCal.add(Calendar.MINUTE, taskDTO.getMins());
					endDateCal.add(Calendar.HOUR, taskDTO.getHrs());
					endDateCal.add(Calendar.DAY_OF_MONTH, taskDTO.getDays());
					taskDTO.setEndDate(FORMATTER.format(endDateCal.getTime()));
				}
			}
			//all with dependencies starting with the lowest to the highest
			if(!CollectionUtils.isEmpty(projectPlanDTO.getTaskDTOList())) {
				List<TaskDTO> taskDTOListHolder = new ArrayList<TaskDTO> (projectPlanDTO.getTaskDTOList());
				long highestReq =  Collections.max(projectPlanDTO.getTaskDTOList(), Comparator.comparing(s -> s.getDependentTo())).getDependentTo();
				for(long ctr = 1; ctr <= highestReq; ctr++) {
					for(TaskDTO taskDTO : projectPlanDTO.getTaskDTOList()) {
						if(ZERO != taskDTO.getDependentTo()) {
							if(ctr == taskDTO.getDependentTo()) {
								TaskDTO taskDTOTemp = taskDTOListHolder.stream()
										.filter(task -> taskDTO.getDependentTo() == task.getSeq())
										.findAny()
										.orElse(null);
								//set start date and end date
								taskDTO.setStartDate(taskDTOTemp.getEndDate()); //start
								Date endDate = (Date)FORMATTER.parse(taskDTOTemp.getEndDate());
								Calendar endDateCal = Calendar.getInstance();
								endDateCal.setTime(endDate);
								endDateCal.add(Calendar.MINUTE, taskDTO.getMins());
								endDateCal.add(Calendar.HOUR, taskDTO.getHrs());
								endDateCal.add(Calendar.DAY_OF_MONTH, taskDTO.getDays());
								taskDTO.setEndDate(FORMATTER.format(endDateCal.getTime()));//end
							}
						}
					}
				}
				return projectPlanDTO.getTaskDTOList();
			}
			
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
