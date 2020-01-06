<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>Add Project Plan</h1>
    <form:form modelAttribute="projectPlanDTO">
        <form:errors path="" element="div" />
        <div>
        <table>
        	<tr>
	            <td><form:label path="projectName">Project Plan Name</form:label></td>
	            <td><form:input path="projectName" required="true"/></td>
	        </tr>
	        <tr>
	            <td><form:label path="startDate">Project Start Date</form:label></td>
	            <td><form:input path="startDate" type="datetime-local" required="true"/></td>
	        </tr>    
            <c:forEach items="${projectPlanDTO.taskDTOList}" var="task" varStatus="tagStatus">
            	<tr>
            		<td><b>Tasks. (Sequence 1 should always be the first task)</b></td>
            	</tr>
            	<tr>
            	</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].seq"><b>New Task (Task Sequence Number)</b></form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].seq" value="${task.seq}" readonly="true"/></td>
		   		</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].taskName">Task Name</form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].taskName" value="${task.taskName}"/></td>
		   		</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].days">Task Duration (Days)</form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].days" value="${task.days}"/></td>
		   		</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].hrs">Task Duration (Hours)</form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].hrs" value="${task.hrs}"/></td>
		   		</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].mins">Task Duration (Mins)</form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].mins" value="${task.mins}"/></td>
		   		</tr>
		   		<tr>
			   		<td><form:label path="taskDTOList[${tagStatus.index}].dependentTo">Task Dependency (Input Sequence Number)</form:label></td>
			   		<td><form:input path="taskDTOList[${tagStatus.index}].dependentTo" value="${task.dependentTo}"/></td>
		   		</tr>

			</c:forEach>
        </table>
		<input type="submit" />
        </div>
        <form:errors path="projectName" />
    </form:form>
</body>
</html>