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
<form:form method="POST" action="/SpringTM/addTask" modelAttribute="task" class="ui-form">
    <div class="form-row">
        <form:hidden path="id"/>
    </div>
    <div class="form-row">
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </div>
    <div class="form-row">
        <form:label path="description" >Description</form:label>
        <form:input path="description" />
    </div>
    <div class="form-row">
        <form:label path="start" >Start Date</form:label>
        <form:input path="start"  type = "date" />
    </div>
    <div class="form-row">
        <form:label path="end" >End Date</form:label>
        <form:input path="end"   type = "date"/>
    </div>
    <td><input type="submit" value="Submit"/></td>
</form:form>
</body>
</html>
