<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<header class="navbar navbar-inverse navbar-fixed-top" id="top" role="banner">
    <div class="all">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">webapp-model</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav"></ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><sec:authentication property="principal.username"/><span class="caret"/></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">Signed in as <strong><sec:authentication property='principal.username'/></strong></li>
                            <li class="divider"></li>
                            <li><a href="/<sec:authentication property='principal.username'/>">Your profile</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/accountsmanager">Accounts Management</a></li>
                            </sec:authorize>
                            <li><a href="#">Help</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Settings</a></li>
                            <li><button type="button" id="logout" class="dropdown-link">Sign out</button></li>
                        </ul>
                    </li>
                    <form id="logout-form" method="post" action="<c:url value='/logout'/>" style="display:none">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                    <script>
                    $(function() {
                        $('#logout').on('click', function(e) {
                            $('#logout-form').submit();
                        })
                    });
                    </script>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value='/login'/>">Login</a></li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</header>
