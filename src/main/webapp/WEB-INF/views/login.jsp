<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">

        <h1>Login</h1>

        <form name="loginForm" action="<c:url value='/login'/>" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="username" value=""></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td align="right"><input type="checkbox" name="remember-me" value="1"/></td>
                    <td>Remember Me</td>
                </tr>
                <tr><td colspan="2"></td></tr>
                <tr  align="center">
                    <td colspan="2"><input class="btn btn-primary" type="submit" value="Login"/></td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:param>
</c:import>
