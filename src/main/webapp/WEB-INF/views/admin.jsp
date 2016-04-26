<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">

        <h1>Admin</h1>

        <table>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><a href="<c:url value='/${user.id}'/>">${user.id}</a></td>
                    <td>${user.name}</td>
                    <td>${user.authority}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.enabled}">
                                有効
                            </c:when>
                            <c:otherwise>
                                凍結中
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${user.registered}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.enabled}">
                                <button>凍結</button>
                            </c:when>
                            <c:otherwise>
                                <button>凍結解除</button>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:param>
</c:import>
