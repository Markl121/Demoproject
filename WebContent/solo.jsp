<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="./solo.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">

</head>


<body>
	<header class="main-header">
		<div class="row--no-pad-tb">
			<img class="logo" src="img/logo3.png" alt="library logo" />
			<nav class="inline-nav">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<li><a href="login.jsp"><button>Login</button></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#">Welcome ${user.username}</a></li>
							<li><a href="#">My account</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">
									<button>Logout</button>
							</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</header>

	<div id="slider">
		<figure>
			<img src="img/film2.jpg">
			<img src="img/book.jpg">
			<img src="img/dvd.jpg">
			<img src="img/2018movie.jpg">
		</figure>
	</div>


	<div class="Titles">
		<ul class="large-block-grid-6 small-block-grid-2 medium-block-grid-3">
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\9780735221109.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\book2.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\book3.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\book4.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\book5.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
			<li>
				<div class="Description">
					<div class="Item">
						<img src="img\book6.jpg">
					</div>

					<h3 title="Simplicity Parenting" class="title-name"
						data-media-id="716633" tabindex="-1">Simplicity Parenting</h3>
					<p class="title-author">by Kim John Payne, M.Ed.</p>
				</div>
			</li>
		</ul>
	</div>
	<section class="bg--light-grey">
		<div class="row">
			<div class="col col12">
				<h3 class="section-header">About Us</h3>
			</div>

			<div class="col col4 ">
				<div class="info-card bg--green">
					<span class="info-card--ribbon">New!!</span> <i
						class="info-card--icon fas fa-book-reader fa-4x"></i>
					<h4 class="info-card--title">Online Book</h4>
					<p class="info-card--text">Our online resources also
						familiarise children with digital technology, using a variety of
						platforms to unlock a world of knowledge, fun and information.
						e-Library offers secure solutions to ensure that children access
						age-appropriate resources in a controlled environment.</p>
					<a class="button" href="#">More</a>
				</div>
			</div>

			<div class="col col4">
				<div class="info-card bg--orange">
					<i class="info-card--icon fas fa-film fa-4x"></i>
					<h4 class="info-card--title">Online movie</h4>
					<p class="info-card--text">Audio books offer a wonderful
						learning experience, at home or on the move. Listening to stories
						develops fundamental language and also teaches essential listening
						skills. Audio books further expose children to pronunciation,
						vocabulary and grammar.</p>
					<a class="button" href="#">More</a>
				</div>
			</div>

			<div class="col col4 last-col">
				<div class="info-card bg--blue">
					<i class="info-card--icon fas fa-users fa-4x"></i>
					<h4 class="info-card--title">About Us</h4>
					<p class="info-card--text">An online book is a resource in
						book-like form that is only available to read on the Internet. It
						differs from the common idea of an e-book, which is usually
						available for users to download and read locally on a computer,
						smartphone or on an e-reader.</p>
					<a class="button" href="#">More</a>
				</div>
			</div>
		</div>
	</section>

	<div>
		<h5>Contact us today</h5>
		<!-- <form id="contact_form"> -->

		<div>
			<form action="/action_page.php">
				<p>Send us your message. We will get back to you within 24
					hours!</p>

				<!-- <label for="fname">First Name</label> -->
				<input type="text" name="name" placeholder="Your name...">

				<!-- <label for="lname">Last Name</label> -->
				<input type="text" name="email" placeholder="Your email...">

				<!-- <label for="country">Country</label> -->
				<select name="genre">
					<option value="" disabled selected>Favorite Genre...</option>
					<option value="anime">Anime</option>
					<option value="romance">Romance</option>
					<option value="scary">Scary</option>
				</select> 
				<c:if test="${not empty param.err}">
					<div class="message">
						<p>${error}</p>
					</div>
				</c:if>
				<br /> <input type="submit" value="Submit">
			</form>
		</div>
	</div>
	<footer class="page-footer">
		<h4 class="copyright">Created by Me!</h4>
	</footer>
</body>

</html>