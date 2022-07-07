<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="com.spring.webmvc.chap01.member.repository.*" %>
<%@ page import="com.spring.webmvc.chap01.member.model.*" %>


<%-- 여기는 jsp 주석입니다~~ --%>

<%-- 필드 선언 --%>

<%!  private MemberRepository repository = MemoryMemberRepo.getInstance();  %>


<% 
    // 이 내부는 서블릿의 service메서드 내부입니다.
    //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    String userName = request.getParameter("userName");

    //2. 회원 정보를 적절한 저장소에 저장
    Member member = new Member(account, password, userName);
    repository.save(member);

    //3. 홈 화면으로 이동 (리다이렉션)
    response.sendRedirect("/");
%>
