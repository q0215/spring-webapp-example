<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <h1>Accounts Manager</h1>
        <table class="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>権限</th>
                <th>状態</th>
                <th>登録日時</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><a href="<c:url value='/${user.id}'/>">${user.id}</a></td>
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
                                    <button class="btn btn-danger">凍結</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-warning">凍結解除</button>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:param>
</c:import>
