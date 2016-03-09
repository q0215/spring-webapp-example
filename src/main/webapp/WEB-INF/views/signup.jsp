<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">

        <h1>Signup</h1>

        <form:form modelAttribute="formBean" method="post" action="<c:url value='/signup'/>" cssClass="form-horizontal">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <fieldset>
                <spring:bind path="id">
                    <div class="control-group ${status.error ? 'error' : ''}">
                        <label class="control-label" for="id">ID</label>
                        <div class="controls">
                            <form:input id="id" path="id"/>
                            <form:errors path="id" dir="span" cssClass="help-inline"/>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="control-group ${status.error ? 'error' : ''}">
                        <label class="control-label" for="password">パスワード</label>
                        <div class="controls">
                            <form:input id="password" path="password"/>
                            <form:errors path="password" dir="span" cssClass="help-inline"/>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="password2">
                    <div class="control-group ${status.error ? 'error' : ''}">
                        <label class="control-label" for="password2">パスワード(確認)</label>
                        <div class="controls">
                            <form:input id="password2" path="password2"/>
                            <form:errors path="password2" dir="span" cssClass="help-inline"/>
                        </div>
                    </div>
                </spring:bind>
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary" value="Signup"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </fieldset>
        </form:form>
    </c:param>
</c:import>
