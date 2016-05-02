<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <form name="loginForm" action="<c:url value='/login'/>" method="post" class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputId" class="sr-only">ID</label>
            <input type="text" id="inputId" name="username" class="form-control" placeholder="ID" required/>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required/>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="remember-me" checked/> Remember Me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:param>
</c:import>
