<%--
  Created by IntelliJ IDEA.
  User: hongeunlee
  Date: 2022/12/29
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>

    <ul>
        <c:forEach items="${dtoList}" var="dto">
            <li>
                <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                <span>${dto.title}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished?"DONE": "NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>


  <%--  <h3> 기본 처리 방법 </h3>
    <h1>List page</h1>
    <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach>

    <h3> begin&end 사용 방법 </h3>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <li>${num}</li>
        </c:forEach>
    </ul>

    <h3>c:if문 사용 방법 </h3>
    <c:if test="${list.size()%2 == 0}">
        짝수
    </c:if>
    <c:if test="${list.size()%2 != 0}">
        홀수
    </c:if>

    <h3>c:choose 사용 방법 </h3>
    <c:choose>
        <c:when test="${list.size()%2 ==0}">
            짝수2
        </c:when>
        <c:otherwise>
            홀수2
        </c:otherwise>
    </c:choose>

    <h3>c:set 사용방법 </h3>
    <c:set var="target" value="5"></c:set>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <c:if test="${num == target}">
                num is target
            </c:if>
        </c:forEach>
    </ul>
--%>
<%--page : 69p > 81p 진행함 + jstl 추가함 + jstl사용법 추가 87p --%>
</body>

</html>
