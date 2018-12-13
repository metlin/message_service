<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Registration page</title>
  <style>
    table.outside {
      background: #34e59e;
      border-collapse: separate;
      border-spacing: 0px 0px;
      width: 400px;
      margin: 100px auto;
    }

    table.inside {
      border-collapse: separate;
      border-spacing: 0px 0px;
      width: 400px;
    }

    .input {
      width: 405px;
      height: 50px;
      font-size: large;
    }

    .submit {
      width: 410px;
      height: 50px;
      background:#44af84;
      font-size: large;
    }

  </style>
</head>

<body bgcolor="#baffe9">
  <table class="outside">
    <tr>
      <td><h2 align="center">Registration</h2></td>
    </tr>
    <tr><td><br></td></tr>
    
    <tr>
      <td>
        <form:form method="post" commandName = "reg_request" action="/message_service/page/save">
          <table class="inside">
            <tr>
              <td><form:label path="firstName"></form:label></td>
              <td><form:input path="firstName" placeholder="first name" class="input"/></td>
            </tr>
            <tr>
              <td><form:label path="lastName"></form:label></td>
              <td><form:input path="lastName" placeholder = "last name" class="input"/></td>
            </tr>
            <tr>
              <td><form:label path="email"></form:label></td>
              <td><form:input path="email" placeholder = "email" class="input"/></td>
            </tr>
            <tr>
              <td><form:label path="login"></form:label></td>
              <td><form:input path="login" placeholder = "login" class="input"/></td>
            </tr>
            <tr>
               <td><form:label path="password"></form:label></td>
               <td><form:password path="password" placeholder = "password" class="input"/></td>
            </tr>
          </table>
      </td>
    </tr>

    <tr><td><br><br></td></tr>
    <tr>
      <td>
        <input type="submit" value="Sign up" class="submit"/>
      </td>
    </tr>
      </form:form>
  </table>
    
</body>
</html>
