<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        li {
            color: red;
        }
    </style>
</head>
<body>
    
    <ul>        
       
        <h1>MVC버전 목록보기</h1>

        <c:forEach var="m" items="${mList}">
            <li>
                # 회원번호 ${m.userNum}: 
                , 아이디: ${m.account},
                <a href="/mvc/v4/member?userNum=${m.userNum}">
                    이름: ${m.userName} 
                </a> 
                &nbsp;&nbsp;&nbsp;
                <a id="rm-btn" href="/mvc/v4/remove?userNum=${m.userNum}">[delete]</a>

            </li>
        </c:forEach>

    </ul>

    <a href="/mvc/join">새로운 회원가입하기</a>

    <script>

        const $rmBtn = document.querySelector('#rm-btn');
        $rmBtn.addEventListener('click', e => {
            if (!confirm('진짜루 삭제???')) {
                e.preventDefault(); // 링크 이동 중지
                // 삭제 취소
                return;
            }
        });

    </script>

    

</body>
</html>