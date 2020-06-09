<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Registration - BAMS</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,700,700i&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/bootstrap/css/bootstrap.min.css}">
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/animate.css/animate.min.css}">
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/icofont/icofont.min.css}">
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/boxicons/css/boxicons.min.css}">
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/venobox/venobox.css}">
<link rel="stylesheet" type="text/css"
	th:href="@{/vendor/owl.carousel/owl.carousel.min.css}">
<link rel="stylesheet" type="text/css" th:href="@{/vendor/aos/aos.css}">

<!-- Template Main CSS File -->
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}">

<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" />
</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top ">
		<div class="container">

			<div class="logo float-left">
				<h1 class="text-light">
					<a href="index.html"><span>BAM SYSTEM</span></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<nav class="nav-menu float-right d-none d-lg-block">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="about.html">About Us</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="portfolio.html">Portfolio</a></li>
					<li><a href="team.html">Team</a></li>
					<li><a href="blog.html">Blog</a></li>
					<li class="drop-down"><a href="">Drop Down</a>
						<ul>
							<li><a href="#">Drop Down 1</a></li>
							<li class="drop-down"><a href="#">Drop Down 2</a>
								<ul>
									<li><a href="#">Deep Drop Down 1</a></li>
									<li><a href="#">Deep Drop Down 2</a></li>
									<li><a href="#">Deep Drop Down 3</a></li>
									<li><a href="#">Deep Drop Down 4</a></li>
									<li><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
							<li><a href="#">Drop Down 3</a></li>
							<li><a href="#">Drop Down 4</a></li>
							<li><a href="#">Drop Down 5</a></li>
						</ul></li>
					<li class="active"><a href="contact.html">Contact Us</a></li>
				</ul>
			</nav>
			<!-- .nav-menu -->

		</div>
	</header>
	<!-- End Header -->

	<main id="main"> <!-- ======= Contact Section ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<div class="d-flex justify-content-between align-items-center">
				<h2>Registration</h2>
				<ol>
					<li><a href="/">Home</a></li>
					<li>Registration</li>
				</ol>
			</div>

		</div>
	</section>
	<!-- End Contact Section --> <!-- ======= Contact Section ======= -->
	<section class="contact" data-aos="fade-up"
		data-aos-easing="ease-in-out" data-aos-duration="500">
		<div class="container">

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<form th:action="@{/}" method="get">
						<button class="btn btn-lg btn-primary btn-block" type="Submit">Go
							To Login Page</button>
					</form>
					<br />
					<form autocomplete="off" action="#" th:action="@{/registration}"
						th:object="${userModel}" method="post" class="form-signin"
						role="form">
						<!-- <h2>Registration Form</h2>
						<div class="form-group">
							<div class="col-sm-9"> -->
						<input type="text" th:field="*{name}" placeholder="Name"
							class="form-control" /> <label
							th:if="${#fields.hasErrors('name')}" th:errors="*{name}"
							class="validation-message"></label> <br />
						<!-- </div>
						</div> -->

						<!-- <div class="form-group">
							<div class="col-sm-9"> -->
						<input type="text" th:field="*{lastName}" placeholder="Last Name"
							class="form-control" /> <label
							th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}"
							class="validation-message"></label> <br />
						<!-- </div>
						</div> -->
						<!-- <div class="form-group">
							<div class="col-sm-9"> -->
						<input type="text" th:field="*{email}" placeholder="Email"
							class="form-control" /> <label
							th:if="${#fields.hasErrors('email')}" th:errors="*{email}"
							class="validation-message"></label> <br />
						<input type="text" th:field="*{phonenumber}" placeholder="Phone Number"
							class="form-control" /> <label
							th:if="${#fields.hasErrors('phonenumber')}" th:errors="*{phonenumber}"
							class="validation-message"></label> <br />
						<!-- 	</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-9"> -->

						<select id="gender" th:field="*{gender}" class="form-control">
							<option value="0">
								--------------------------------------------- Select Gender
								------------------------------------------</option>
							<option value="MALE">Male</option>
							<option value="FEMALE">Female</option>
							<option value="NOT SPECIFY">Not To Specify</option>
						</select> <label th:if="${#fields.hasErrors('gender')}"
							th:errors="*{gender}" class="validation-message"></label> <br />

						<input type="text" th:field="*{pancard}"
							placeholder="Pancard Number" class="form-control" /> <label
							th:if="${#fields.hasErrors('pancard')}" th:errors="*{pancard}"
							class="validation-message"></label> <br /> <input type="text"
							th:field="*{dob}" placeholder="Date Of Birth" id="tbDate"
							class="form-control" /><br /> <input type="text"
							th:field="*{userName}" placeholder="User Name"
							class="form-control" /> <label
							th:if="${#fields.hasErrors('userName')}" th:errors="*{userName}"
							class="validation-message"></label> <br />
						<!-- </div>
						</div>
						<div class="form-group">
							<div class="col-sm-9"> -->
						<input type="password" th:field="*{password}"
							placeholder="Password" class="form-control" /> <label
							th:if="${#fields.hasErrors('password')}" th:errors="*{password}"
							class="validation-message"></label> <br />


						<!-- </div>
						</div>
                                 
						<div class="form-group">
							<div class="col-sm-9"> -->

						<select id="role" th:field="*{role}" class="form-control">
							<option value="0">
								--------------------------------------------- Select Role
								------------------------------------------</option>
							<option value="ADMIN">Admin</option>
							<option value="EMPLOYEE">Employee</option>
							<option value="CUSTOMER">Customer</option>
						</select> <label th:if="${#fields.hasErrors('role')}" th:errors="*{role}"
							class="validation-message"></label> <br />

						<div>

							<h2>Address Details</h2>

							<input type="text" th:field="*{street}" placeholder="Street Name"
								class="form-control" /> <label
								th:if="${#fields.hasErrors('street')}" th:errors="*{street}"
								class="validation-message"></label> <br /> <input type="text"
								th:field="*{city}" placeholder="City" class="form-control" /> <label
								th:if="${#fields.hasErrors('city')}" th:errors="*{city}"
								class="validation-message"></label> <br /> <input type="text"
								th:field="*{pincode}" placeholder="Pincode" class="form-control" />
							<label th:if="${#fields.hasErrors('pincode')}"
								th:errors="*{pincode}" class="validation-message"></label> <br />

							<select id="country" th:field="*{country}" name="country"
								class="form-control"></select> <br /> <select
								th:field="*{state}" id="state" name="state" class="form-control"></select>
							<br /> <select id="role" th:field="*{atype}"
								class="form-control"
								onchange="addressChangeFunction(this.value);">
								<option value="0">
									--------------------------------------------- Select Address
									Type ------------------------------------------</option>
								<option value="PERMANENT">Permanent</option>
								<option value="CURRENT">Current</option>

							</select> <br />
						</div>

						<div style="display: none" class="paddress" id="paddress">

							<h2>Permment Address Details</h2>

							<input type="text" th:field="*{pstreet}"
								placeholder="Street Name" class="form-control" /> <label
								th:if="${#fields.hasErrors('pstreet')}" th:errors="*{pstreet}"
								class="validation-message"></label> <br /> <input type="text"
								th:field="*{pcity}" placeholder="City" class="form-control" />
							<label th:if="${#fields.hasErrors('pcity')}" th:errors="*{pcity}"
								class="validation-message"></label> <br /> <input type="text"
								th:field="*{ppincode}" placeholder="Pincode"
								class="form-control" /> <label
								th:if="${#fields.hasErrors('ppincode')}" th:errors="*{ppincode}"
								class="validation-message"></label> <br /> <select
								id="pcountry" th:field="*{pcountry}" name="pcountry"
								class="form-control"></select> <br /> <select
								th:field="*{pstate}" id="pstate" name="pstate"
								class="form-control"></select> <br /> <select id="patype"
								th:field="*{patype}" class="form-control" disabled>
								<option value="PERMENT" selected="selected">Perment</option>
								<option value="0">
									--------------------------------------------- Select Address
									Type ------------------------------------------</option>

								<option value="CURRENT">Current</option>

							</select> <br />
						</div>
						<button type="submit" class="btn btn-primary btn-block">Register
							User</button>
						<!-- </div>
						</div> -->

						<h2>
							<span class="text-success" th:utext="${successMessage}"></span>
						</h2>

					</form>
				</div>
			</div>
		</div>


	</section>
	<!-- End Contact Section --> <!-- ======= Map Section ======= --> <!-- <section class="map mt-2">
      <div class="container-fluid p-0">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3024.2219901290355!2d-74.00369368400567!3d40.71312937933185!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25a23e28c1191%3A0x49f75d3281df052a!2s150%20Park%20Row%2C%20New%20York%2C%20NY%2010007%2C%20USA!5e0!3m2!1sen!2sbg!4v1579767901424!5m2!1sen!2sbg" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
      </div>
    </section>End Map Section --> </main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer" data-aos="fade-up" data-aos-easing="ease-in-out"
		data-aos-duration="500">

		<!-- <div class="footer-newsletter">
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <h4>Our Newsletter</h4>
            <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>
          </div>
          <div class="col-lg-6">
            <form action="" method="post">
              <input type="email" name="email"><input type="submit" value="Subscribe">
            </form>
          </div>
        </div>
      </div>
    </div> -->

		<div class="footer-top">
			<div class="container">
				<div class="row">

					<div class="col-lg-3 col-md-6 footer-links">
						<h4>Useful Links</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">About
									us</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Terms
									of service</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Privacy
									policy</a></li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-6 footer-links">
						<h4>Our Services</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Web
									Design</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Web
									Development</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Product
									Management</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Graphic
									Design</a></li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-6 footer-contact">
						<h4>Contact Us</h4>
						<p>
							A108 Adam Street <br> New York, NY 535022<br> United
							States <br> <br> <strong>Phone:</strong> +1 5589 55488
							55<br> <strong>Email:</strong> info@example.com<br>
						</p>

					</div>

					<div class="col-lg-3 col-md-6 footer-info">
						<h3>About Moderna</h3>
						<p>Cras fermentum odio eu feugiat lide par naso tierra. Justo
							eget nada terra videa magna derita valies darta donna mare
							fermentum iaculis eu non diam phasellus.</p>
						<div class="social-links mt-3">
							<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
								href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
								href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
							<a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong><span>Moderna</span></strong>. All Rights
				Reserved
			</div>
			<div class="credits">
				<!-- All the links in the footer should remain intact. -->
				<!-- You can delete the links only if you purchased the pro version. -->
				<!-- Licensing information: https://bootstrapmade.com/license/ -->
				<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/ -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>
	<!-- End Footer -->

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

	<!-- Vendor JS Files -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="vendor/php-email-form/validate.js"></script>
	<script src="vendor/venobox/venobox.min.js"></script>
	<script src="vendor/waypoints/jquery.waypoints.min.js"></script>
	<script src="vendor/counterup/counterup.min.js"></script>
	<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script src="js/main.js"></script>
	<script src="js/countries.js"></script>

	<link
		href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
		rel="stylesheet" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>

	<script language="javascript">
		populateCountries("country", "state");
		populateCountries("pcountry", "pstate");
		$(document).ready(function() {
			$('input[id$=tbDate]').datepicker({});
		});

		function addressChangeFunction(value) {
			var x = document.getElementById("paddress");
			if (value == "CURRENT") {
				x.style.display = "block";

			} else {
				x.style.display = "none";
			}

		}
	</script>
</body>

</html>