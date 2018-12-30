<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Output</title>
</head>
<body>
	<h1>Last point in the workflow! - JSP</h1>
	<p>
	<h3>Books:</h3>

	<c:choose>
		<c:when test="${ empty requestScope.books}">
			<h5>No books found</h5>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${ books }" var="b">
					<li>${ b }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>



	<%-- <%
		List<String> books = (List<String>) request.getAttribute("books");
		if (books == null || books.size() == 0)
			out.append("No books found!");
		else {
			
			out.append("<ul>");
			for (String b : books) {
				out.append("<li>");
				out.append(b.toString());
				out.append("</li>");
			}
			out.append("</ul>");
		}
	%> --%>
	<h3>Original Search term - EL:</h3>
	${ param.term }
	</p>




</body>
</html>