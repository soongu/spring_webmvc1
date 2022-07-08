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

    <h1>나이 검사하기~</h1>
    
    <form action="/model/age-check">

        <label>
            # 나이를 입력하세요. 
            <input type="number" name="age">
        </label>
        <button type="submit">전송</button>
    </form>

</body>
</html>