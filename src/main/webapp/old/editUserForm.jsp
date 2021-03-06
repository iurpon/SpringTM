<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
        <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
    </head>
    <body>
    <ul class="menu">
        <li><a class="menu" href="projects">See all Projects</a></li>
        <li><a class="menu" href="tasks">See all Tasks</a></li>
        <li><a class="menu" href="users">See all Users</a></li>
    </ul>
        <form:form method="POST" action="/SpringTM/addUser" modelAttribute="user" class="ui-form">
                <div class="form-row">
                    <form:hidden path="id"/>
                </div>
                <div class="form-row">
                    <form:label path="name">Name</form:label>
                    <form:input path="name"/>
                </div>
                 <div class="form-row">
                    <form:label path="password" >Password</form:label>
                    <form:input path="password" type = "password"/>
                </div>
                  <div class="form-row">
                    <form:label path="role"> Role</form:label>
                    <form:select path="role">
                        <form:option value="ADMIN"/>
                        <form:option value="USER"/>
                    </form:select>
                  </div>
                  <td><input type="submit" value="Submit"/></td>
        </form:form>
    </body>
</html>