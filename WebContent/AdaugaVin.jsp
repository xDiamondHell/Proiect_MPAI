<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Wine</title>
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500"
	rel="stylesheet">
<meta name="robots" content="noindex,follow" />
<style>
<%@include file="css/styleAdaugaVin.css"%>
<%@include file="css/radio-buttons-tipuri-vin.css"%>
</style>
</head>

<body>
	<main class="container">

		<!-- Left Column / Wines Image -->
		<div class="left-column">
			<img data-image="white" src="https://i.imgur.com/cqfrbRA.png" alt="">
			<img data-image="rose" src="https://i.imgur.com/hMvNujW.png" alt="">
			<img data-image="red" class="active"
				src="https://i.imgur.com/9E3RhcZ.png" alt="">
		</div>

		<!-- Right Column -->
		<div class="right-column">
			<form action="creeazaProdus" method="post">
				<!-- Product Description -->
				<div class="product-description">

					<h1>Wine</h1>
					<p>Choose from the most refined types of wine: white, red,
						rose. Specially chosen for all tastes from dry wine to sweet.</p>
				</div>

				<!-- Product Configuration -->
				<div class="product-configuration">
					<!-- Product Color -->
					<div class="product-color">
						<span>Wine Colors</span>

						<div class="color-choose">
							<div>
								<input data-image="red" type="radio" id="red" name="culoare"
									value="Rosu" checked> <label for="red"><span></span></label>
							</div>
							<div>
								<input data-image="rose" type="radio" id="rose" name="culoare"
									value="Rose"> <label for="rose"><span></span></label>
							</div>
							<div>
								<input data-image="white" type="radio" id="white" name="culoare"
									value="Alb"> <label for="white"><span></span></label>
							</div>
						</div>
					</div>

					<!-- Wine Types -->
					<div class="wine-config">
						<span>Wine Types</span>
						<div class="wine-choose">
							<div class="button-wrap">
								<input class="hidden radio-label" type="radio" name="tip"
									id="sec" value="Sec" checked/> <label class="button-label" for="sec" >
									<h1>Dry</h1>
								</label> <input class="hidden radio-label" type="radio" name="tip"
									id="demisec" value="DemiSec" /> <label class="button-label"
									for="demisec">
									<h1>Semi-Dry</h1>
								</label> <input class="hidden radio-label" type="radio" name="tip"
									id="demidulce" value="DemiDulce" /> <label
									class="button-label" for="demidulce">
									<h1>Semi-Sweet</h1>
								</label> <input class="hidden radio-label" type="radio" name="tip"
									id="dulce" value="Dulce" /> <label class="button-label"
									for="dulce">
									<h1>Sweet</h1>
								</label>
							</div>
						</div>
					</div>
				</div>

				<!-- Product Pricing -->
				<div class="product-price">
					<span></span> <input class="cart-btn" type="submit"
						name="Sign Up" value="Buy Now" />
				</div>
			</form>
		</div>
	</main>

	<!-- Scripts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"
		charset="utf-8"></script>
		<script>
<%@include file="js/AdaugaVin.js"%>
</script>
</body>

</html>


