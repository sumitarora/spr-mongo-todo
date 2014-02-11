<%@ include file="../common/header.jsp"%>
<%@ page import="com.sumit.mongomodel.Task" %>
<%@ page import="java.util.List" %>

<div class="container">
    <p>
        Total Tasks: <strong>${requestScope.totalTasksCount} tasks</strong>,
        Finished: <strong>${requestScope.finishedTasksCount} tasks</strong>,
        Pending: <strong>${requestScope.pendingTasksCount} tasks</strong>
    </p>
    <a type="button" class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/task/create">
        Add Task
    </a>
    <br/><br/>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Task Name</th>
                    <th>Description</th>
                    <th>Priority</th>
                    <th>Due Date</th>
                    <th>Task Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.allTasks}" var="task">
                    <tr>
                        <td>${task.name}</td>
                        <td>${task.description}</td>
                        <td>${task.dueDate}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm">Edit</button> 
                            <%-- <a href="${pageContext.request.contextPath}/tasks?id=${task.id}">Edit</a> --%>
                            <button type="button" class="btn btn-danger btn-sm">Delete</button>
                            <%-- <a href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=d">Delete</a> --%>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br />
    <h3>Pending Tasks</h3>

<%@ include file="../common/footer.jsp"%>