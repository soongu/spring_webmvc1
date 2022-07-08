<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <h1></h1>

    <%--
    <c:choose>
        <c:when test="${result == 'success'}">
            <h1>로그인 성공!</h1>
        </c:when>
        <c:when test="${result == 'f-id'}">
            <h1>아이디가 없습니다.</h1>
        </c:when>
        <c:when test="${result == 'f-pw'}">
            <h1>비번이 틀렸습니다.</h1>
        </c:when>        
    </c:choose>
    --%>

    <a href="/hw/s-login-form">다시 로그인하기</a>
    
    <script>
        let result = '${result}';
        console.log(result);

        const $h1 = document.querySelector('h1');
        switch (result) {
            case 'f-id': 
                $h1.textContent = '아이디가 존재하지 않습니다.';
                break;
            case 'f-pw':
                $h1.textContent = '비밀번호가 틀렸습니다.';
                break;
            case 'success':
                $h1.textContent = '로그인 성공.';
                break;        
        }

    </script>
</body>
</html>