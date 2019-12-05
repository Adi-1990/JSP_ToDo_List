<%@ page import="java.util.Collection" %>
<%@ page import="ro.sda.model.Task" %>
<%@ page import="ro.sda.model.TaskRepository" %><%--
  Created by IntelliJ IDEA.
  User: Adi
  Date: 7/27/2019
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Collection<Task> items = TaskRepository.getInstance().getAllTasks();
    request.setAttribute("items", items);
%>

<html>
<head>
    <title>JSP To Do List</title>
    <link rel="stylesheet" href="indexCSS.css">
    <script type="text/javascript" src="PersistanceTask.js"></script>
</head>
<body>

<div class="container">
    <h2>My ToDo List</h2>
    <form action="${pageContext.request.contextPath}/add-new" method="POST" id="sendCompleteForm">
        <%--        <input type="hidden" name="actionType" value="complete"/>    --  nu stiu ce face aici comanda asta --%>
        <table>
            <c:forEach items="#{items}" var="item">
                <tr>
                    <td>
                        <c:out value="${item.taskName}"/>
                    </td>
                    <td>
                        <c:if test="${item.checked}">
                            <input type="checkbox" name="checked" checked onclick="sendComplete('${item.taskName}')">
                        </c:if>
                        <c:if test="${!item.checked}">
                            <input type="checkbox" name="checked" onclick="sendComplete('${item.taskName}')">
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>

<br><br>

<div>
    <h2>Add new "ToDo" item</h2>
    <form action="${pageContext.request.contextPath}/add-new" method="POST">
        <%--        <input type="hidden" name="actionType" value="add">  --%>
        <label for="actionName"> Action: </label>
        <input type="text" name="actionName" id="actionName">
        <input type="submit" value="Push-me to add">
    </form>
</div>

</body>
</html>