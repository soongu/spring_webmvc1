<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.spring.webmvc.member.repository.*" %>
<%@ page import="com.spring.webmvc.member.model.*" %>
<%@ page import="java.util.*" %>

<%! private MemberRepository repository = MemoryMemberRepo.getInstance();  %>

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
            List<Member> memberList = repository.findAll();
            
            for (Member m : memberList) {
        %>
            <li>
                # 회원번호 : <%= m.getUserNum() %>, 아이디: <%= m.getAccount() %>, 이름: <%= m.getUserName() %>
            </li>
        <% } %>

    </ul>

    <script></script>

</body>
</html>