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

    <h1>${m.userNum}번 회원 상세 정보</h1>
    <ul>
        <li># 계정명: ${m.account}</li>
        <li># 비번: ${m.password}</li>
        <li># 이름: ${m.userName}</li>
    </ul>
</body>
</html>