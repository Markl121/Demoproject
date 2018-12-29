<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="login.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register from here</title>
</head>
<body>
 <div class="container">
     <div class="container">
    	<c:if test="${not empty param.err}">
    	<div class="message"><p>${error}</p></div>
    	</c:if>
        <section id="content">
            <form action="Register" method="post">
                <h1>Register Form</h1>
                <div>
                    <input type="text" placeholder="Username" id="username" name="username"/>
                </div>
                <div>
                    <input type="text" placeholder="email" id="email" name="email"/>
                </div>
                <div>
                    <input type="password" placeholder="Password" id="password" name="password"/>
                </div>
                 <div class="user-options"><select name="type">
								<option value="Reader">Reader</option>
								<option value="Admin">Admin</option>
							</select></div>
                <div>
                    <input type="submit" value="Register" />
                </div>
            </form>
        </section>
    </div>
</body>
</html>