<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Message list</h2>

    <table border = "2">

        <tr>
            <th>ID</th>
            <th>Date_time</th>
            <th>From whom</th>
            <th>Message</th>
            <th>Action</th>
        </tr>
            <c:forEach items = "${messageList}" var = "message">
                <tr>
                    <td><c:out value = "${message.id}"/></td>
                    <td><c:out value = "${message.dateTime}"/></td>
                    <td><c:out value = "${message.fromWhom}"/></td>
                    <td><c:out value = "${message.message}"/></td>
                    <td>delete</td>
                </tr>
            </c:forEach>
    </table>
</body>
</html