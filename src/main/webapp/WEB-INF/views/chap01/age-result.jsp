<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>


    <h1>당신은 ${bYear}년생이시군요~~</h1>
    <c:choose>
        <c:when test="${age > 19}">
            <h2>성인입니다~~</h2>
        </c:when>

        <c:otherwise>
            <h2>미성년자입니다~~</h2>
        </c:otherwise>
    </c:choose>

</body>
</html>