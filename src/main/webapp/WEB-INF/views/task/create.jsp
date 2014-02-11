<%@ include file="../common/header.jsp"%>

<div class="row">
 <form class="form-horizontal" role="form" method="post"
     action="${pageContext.request.contextPath}/task/save">
    
    <input type="hidden" value="${requestScope.task.id}" name="taskId"/>
    <div class="form-group">
        <label for="taskName" class="col-sm-2 control-label">Task
            Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="taskName"
                placeholder="Task Name" value="${requestScope.task.name}" >
        </div>
    </div>

    <div class="form-group">
        <label for="taskDesc" class="col-sm-2 control-label">Task Description</label>
        <div class="col-sm-3">
            <textarea class="form-control" name="taskDesc"
                placeholder="Task Description">${requestScope.task.description}</textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="taskPriority" class="col-sm-2 control-label">Task
            Priority</label>
        <div class="col-sm-3">
            <select class="form-control" name="taskPriority">
            <option value='h'
                <c:if test="${requestScope.task.priority == 'h'}">selected='selected'</c:if>
            >High</option>

            <option value='m'
                <c:if test="${requestScope.task.priority == 'm'}">selected='selected'</c:if>
            >Medium</option>
            
            <option value='l'
                <c:if test="${requestScope.task.priority == 'l'}">selected='selected'</c:if>
            >Low</option>                                               
            </select>
        </div>
    </div>

    <div class="form-group">
        <label for="taskStatus" class="col-sm-2 control-label">Task
            Status</label>
        <div class="col-sm-3">
            <select class="form-control" name="taskStatus">
            <option value='s'
                <c:if test="${requestScope.task.status == 's'}">selected='selected'</c:if>
            >Started</option>

            <option value='p'
                <c:if test="${requestScope.task.status == 'p'}">selected='selected'</c:if>
            >Pending</option>
            
            <option value='f'
                <c:if test="${requestScope.task.status == 'f'}">selected='selected'</c:if>
            >Finished</option>
            </select>
        </div>
    </div>


    <div class="form-group">
        <label for="inputDate" class="col-sm-2 control-label">Due
            Date</label>
        <div class="col-sm-3">
        <input type='date' class='form-control' name='inputDate' placeholder='Date' value='${dt}'>
        
             
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success" name="saveTask">Save</button>
            <button type="button" class="btn btn-danger"
                onclick="window.location.href='${pageContext.request.contextPath}/task/list'">Cancel</button>
            </div>
        </div>

    </form>
</div>

<%@ include file="../common/footer.jsp"%>