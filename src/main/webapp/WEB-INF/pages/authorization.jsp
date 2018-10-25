<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Authorization page</title>
</head>

<body>
<h2>Authorization page</h2>
<form:form method="post" action="/message_service/page/search">
  <table>
    <tr>
      <td><form:label path="login">login</form:label></td>
      <td><form:input path="login" /></td>
    </tr>
    <tr>
       <td><form:label path="password">password</form:label></td>
       <td><form:input path="password" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
