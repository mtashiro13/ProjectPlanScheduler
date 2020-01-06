package ProjectPlanScheduler.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ProjectPlanScheduler.Service.ScheduleService;
import ProjectPlanScheduler.domain.ProjectPlan;
import ProjectPlanScheduler.domain.ProjectPlanDTO;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value = "/addProjectPlan.html", method = RequestMethod.GET)
	public ModelAndView addProjectPlan() {
		ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
		projectPlanDTO.setTaskDTOList(scheduleService.initTaskDTOList());
		return new ModelAndView ("addProjectPlan", "projectPlanDTO", projectPlanDTO);
	}
	
	@RequestMapping(value = "/addProjectPlan.html", method = RequestMethod.POST)
	public String submitProjectPlan(ProjectPlanDTO projectPlanDTO) {
		scheduleService.saveProjectPlan(projectPlanDTO);
		return ("redirect:/projectPlanList.html");
	}
	
	@RequestMapping(value = "/projectPlanList.html", method = RequestMethod.GET)
	public ModelAndView getProjectPlan() {
		List<ProjectPlan> projectPlanList = scheduleService.getAllProjectPlan();
		return new ModelAndView("projectPlanList", "projectPlanList", projectPlanList);
	}

}
