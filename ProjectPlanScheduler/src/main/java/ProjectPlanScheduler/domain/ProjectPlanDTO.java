package ProjectPlanScheduler.domain;

import java.util.List;

public class ProjectPlanDTO {
	private long id;
	private String projectName;
	private String startDate;
	private String endDate;
	private List<TaskDTO> taskDTOList;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the taskDTOList
	 */
	public List<TaskDTO> getTaskDTOList() {
		return taskDTOList;
	}
	/**
	 * @param taskDTOList the taskDTOList to set
	 */
	public void setTaskDTOList(List<TaskDTO> taskDTOList) {
		this.taskDTOList = taskDTOList;
	}
}
