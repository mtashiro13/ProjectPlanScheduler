package ProjectPlanScheduler.domain;

public class TaskDTO {

	private long id;
	private long seq;
	private long projectPlanId;
	private String taskName;
	private String startDate;
	private String endDate;
	private int days;
	private int hrs;
	private int mins;
	private long dependentTo;
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
	 * @return the projectPlanId
	 */
	public long getProjectPlanId() {
		return projectPlanId;
	}
	/**
	 * @param projectPlanId the projectPlanId to set
	 */
	public void setProjectPlanId(long projectPlanId) {
		this.projectPlanId = projectPlanId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	 * @return the days
	 */
	public int getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}
	/**
	 * @return the hrs
	 */
	public int getHrs() {
		return hrs;
	}
	/**
	 * @param hrs the hrs to set
	 */
	public void setHrs(int hrs) {
		this.hrs = hrs;
	}
	/**
	 * @return the mins
	 */
	public int getMins() {
		return mins;
	}
	/**
	 * @param mins the mins to set
	 */
	public void setMins(int mins) {
		this.mins = mins;
	}
	/**
	 * @return the dependentTo
	 */
	public long getDependentTo() {
		return dependentTo;
	}
	/**
	 * @param dependentTo the dependentTo to set
	 */
	public void setDependentTo(long dependentTo) {
		this.dependentTo = dependentTo;
	}
	/**
	 * @return the seq
	 */
	public long getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(long seq) {
		this.seq = seq;
	}
}
