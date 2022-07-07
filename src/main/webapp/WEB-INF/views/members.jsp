<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <ul>
        
        <% 
            System.out.println("in jsp: " + request.getAttribute("mList")); 
        %>

            <li>
                # 회원번호 : , 아이디: , 이름: 
            </li>
      

    </ul>

    <script></script>

</body>
</html>