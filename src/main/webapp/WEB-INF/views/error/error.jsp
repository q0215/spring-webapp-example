<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">

        <h1>ERROR</h1>

        <p><a href="<c:url value='/'/>">permitAll</a></p>
        <p><a href="<c:url value='/user'/>">Only ROLE_USER</a></p>
        <p><a href="<c:url value='/admin'/>">Only ROLE_ADMIN</a></p>
    </c:param>
</c:import>
