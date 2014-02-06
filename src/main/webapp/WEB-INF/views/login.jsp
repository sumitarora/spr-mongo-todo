<%@ include file="common/header.jsp"%>

<c:url value="/login" var="loginUrl"/>
<div class="container">
  <div class="row">

    <div class="main col-xs-4 col-xs-offset-4">

      <!-- <h3>Please Log In, or <a href="#">Sign Up</a></h3> -->
<!--       <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
          <a href="#" class="btn btn-lg btn-primary btn-block">Facebook</a>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6">
          <a href="#" class="btn btn-lg btn-info btn-block">Google</a>
        </div>
      </div>
      <div class="login-or">
        <hr class="hr-or">
        <span class="span-or">or</span>
      </div> -->

	    <form action="${loginUrl}" method="post" role="form"> 
	    <h2 class="form-signin-heading">Please sign in</h2>
	    <%
		    if (request.getParameter("error") != null) {
		        out.println("<p>Invalid username and password.</p>");
		    }
	        if (request.getParameter("logout") != null) {
	            out.println("<p>You have been logged out.</p>");
	        }
		%>
      <!-- <form role="form"> -->
        <div class="form-group">
          <label for="inputUsernameEmail">Username or email</label>
          <input type="text" class="form-control" id="username" name="username">
        </div>
        <div class="form-group">
          <a class="pull-right" href="#">Forgot password?</a>
          <label for="inputPassword">Password</label>
          <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="checkbox pull-right">
          <label>
            <input type="checkbox">
            Remember me </label>
        </div>
        <input type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
        <button type="submit" class="btn btn btn-primary">
          Log In
        </button>
      </form>
    
    </div>
    
  </div>
</div>

<%@ include file="common/footer.jsp"%>