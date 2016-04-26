<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>webapp-model</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="<c:url value='/favicon.ico'/>"/>

    <link href="<c:url value='/css/mystyle.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">

    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="all">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <c:import url="/WEB-INF/views/layout/layout-header.jsp"/>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">${param.content}</div>
            </div>
        </div>
        <div class="container-fluid">
            <footer>
                <hr>
                <div class="row-fluid">
                    <div class="span12">
                        <p>Copyright &copy; 2016 q9029 All Rights Reserved.</p>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</body>
</html>
