<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
  <title>Enter message</title>
</head>

<body>
<h2>Enter message</h2>
<form:form method="post" commandName = "message_request" action="/message_service/page/send_message">
  <table>
    <tr>
        <td><form:label path="fromWhom">from(email)</form:label></td>
        <td><form:input path="fromWhom" /></td>
    </tr>
    <tr>
        <td><form:label path="whom">whom(email)</form:label></td>
        <td><form:input path="whom" /></td>
    </tr>
    <tr>
        <td><form:label path="message">message</form:label></td>
        <td><form:input path="message" /></td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="Send message"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>