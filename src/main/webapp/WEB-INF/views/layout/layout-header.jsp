<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="<c:url value='/'/>">webapp-model</a>
            <ul class="nav"></ul>
            <div class="pull-right">
                <ul class="nav">
                    <sec:authorize access="isAuthenticated()" var="isAuthenticated">
                        <li>
                            <a href="/<sec:authentication property='principal.username'/>"><sec:authentication property="principal.username"/></a>
                        </li>
                        <li>
                            <a href="#logout">Logout</a>
                        </li>
                        <form id="logout-form" method="post" action="<c:url value='/logout'/>" style="display:none">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </form>
                        <script>
                            $(function() {
                                $('a[href=#logout]').on('click', function(e) {
                                    $('#logout-form').submit();
                                })
                            });
                        </script>
                    </sec:authorize>
                    <c:if test="${!isAuthenticated}">
                        <li><a href="<c:url value='/login'/>">Login</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
