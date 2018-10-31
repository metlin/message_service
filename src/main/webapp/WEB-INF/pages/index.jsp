<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
<h2>Message list</h2>

<c:if test = "${!empty messageList}">

    <table border = "2">

        <tr>
            <th width = "50">ID</th>
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
                    <td><a href = "/message_service/page/remove/${message.id}">delete</td>
                </tr>
            </c:forEach>
    </table>
</c:if>

    <br>
    </br>
    <body>
        <a href ="/message_service/page/authorization">
           <input type="submit" value="Exit"/>
        </a>
    </body>

    <br>
        </br>
        <body>

          <input type="submit" value="Change password" onclick = "changePassword()"/>

        </body>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


    </script>
<script type="text/javascript">
        function changePassword() {
            $.ajax({
               uri: '/change_password',


            });
        }


</body>
</html