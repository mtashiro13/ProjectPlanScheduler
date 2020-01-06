<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Project Plan page</h1>
<body>
	<table>
		<c:forEach items="${projectPlanList}" var="projectPlan" varStatus="tagStatus">
			<tr>
				<td>Project Plan ID: </td>
				<td><c:out value="${projectPlan.id}"/></td>
			</tr>
			<tr>
	            <td>Project Plan Name: </td>
	            <td><c:out value="${projectPlan.projectName}"/></td>  
			</tr>
			<tr>
	            <td>Project Plan Start Date:  </td>
	            <td><c:out value="${projectPlan.startDate}"/></td>
			</tr>
			<tr>
	            <td>Project Plan End Date:  </td>
	            <td><c:out value="${projectPlan.endDate}"/></td>
			</tr>
			<tr class="blank_row">
            	<td bgcolor="#FFFFFF" colspan="3">&nbsp;</td>
        	</tr>
		   <c:forEach items="${projectPlanList[tagStatus.index].taskList}" var="task">
		   <tr>
		   		<td>Task ID: </td>
		   		<td><c:out value="${task.id}"/></td>
		   </tr>
		   <tr>
	            <td>Task Name: </td>
	            <td><c:out value="${task.taskName}"/></td>  
		   </tr>
		   <tr>
	            <td>Task Sequence Number: </td>
	            <td><c:out value="${task.seq}"/></td>  
		   </tr>
		   <tr>
	            <td>Task Start Date:  </td>
	            <td><c:out value="${task.startDate}"/></td>
		   </tr>
		   <tr>
	            <td>Task End Date:  </td>
	            <td><c:out value="${task.endDate}"/></td>
		   </tr>
		   <tr>
	            <td>Task Dependent to (Sequence Number):  </td>
	            <td><c:out value="${task.dependentTo}"/></td>
		   </tr>
		   <tr>
		   		<td>Task Duration</td>
		   </tr>
		   <tr>
	            <td>Days:  </td>
	            <td><c:out value="${task.days}"/></td>
		   </tr>
		   <tr>
	            <td>Hours:  </td>
	            <td><c:out value="${task.hrs}"/></td>
		   </tr>
		   <tr>
	            <td>Mins:  </td>
	            <td><c:out value="${task.mins}"/></td>
		   </tr>
		   <tr class="blank_row">
            	<td bgcolor="#FFFFFF" colspan="3">&nbsp;</td>
        	</tr>
		   </c:forEach>
		</c:forEach>
	</table>
</body>
