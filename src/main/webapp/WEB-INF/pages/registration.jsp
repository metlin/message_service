<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Registration page</title>
</head>

<body>
<h2>Registration page</h2>
<form:form method="post" action="/message_service/page/save">
  <table>
    <tr>
      <td><form:label path="firstName">first_name</form:label></td>
      <td><form:input path="firstName" /></td>
    </tr>
    <tr>
      <td><form:label path="lastName">last_name</form:label></td>
      <td><form:input path="lastName" /></td>
    </tr>
    <tr>
      <td><form:label path="email">email</form:label></td>
      <td><form:input path="email" /></td>
    </tr>
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
