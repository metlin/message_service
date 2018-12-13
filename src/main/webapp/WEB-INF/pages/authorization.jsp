<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Authorization page</title>
  
   <style>
    table.inside {
      background: #6ccfe7;
      border-collapse: separate;
      border-spacing: 0px 0px;
      width: 400px;
      margin: 100px auto;
    }

    table.outside {
      border-collapse: separate;
      border-spacing: 0px 0px;
      width: 400px;
    }

    table.outside td {
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
      background:#95c4e0;
      font-size: large;
    }

    h2 {
      text-align: center;
    }

    h4 {
      text-align: right;
      font-size: large;
    }
  </style>
</head>

<body bgcolor="#cdf0f9">
  <table class="inside">
    <tr>
      <td bgcolor="#5399aa">
         <h2>Authorization</h2>
      </td>
    </tr> 
    <tr><td bgcolor="#5399aa"><br></td></tr>
    <tr><td><br></td></tr>   
    
    <tr>
      <td>
      <form:form method="post" commandName = "auth_request" action="/message_service/page/search">
        <table class="outside">
        <tr>
          <td><form:label path="login"></form:label></td>
          <td><form:input placeholder = "login" path="login" class = "input"/></td>
        </tr>
        <tr>
          <td><form:label path="password"></form:label></td>
          <td><form:password placeholder = "password" path="password" class = "input"/></td>
        </tr>
         <tr><td><br><br></td></tr>
      </table>
      </td>
    </tr>
     <tr>
        <td>
          <input type="submit" value="Sign in" class= "submit"/>
        </td>
    </tr>
    </form:form>
    <tr><td><br><br><br></td></tr>
    <tr>
      <td>
         <h4><a href ="/message_service/page/registration">Registration</a></h4>
      </td>
    </tr>
  </table>   
</body>
</html>
