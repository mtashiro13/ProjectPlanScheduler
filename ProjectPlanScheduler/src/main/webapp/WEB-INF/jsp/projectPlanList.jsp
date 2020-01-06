<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Project Plan page</h1>
<body>
<%-- ${projectPlan.id} --%>
<%-- ${projectPlan.projectName} --%>
	<ul>
	<c:forEach items="${projectPlanList}" var="projectPlan">
	   <li>
	   		<td>Project Plan ID: <c:out value="${projectPlan.id}"/></td>
            <td>Project Plan Name: <c:out value="${projectPlan.projectName}"/></td>  
	   </li>
	</c:forEach>
	</ul>

</body>
