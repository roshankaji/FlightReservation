<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>

	<h1>Confirm your reservation</h1>
	<h3>Flight Details</h3>
	Flight Number:${flight.flightNumber }<br>
	Departure City:${flight.departureCity }<br>
	Arrival City:${flight.arrivalCity }<br>
	Departure Date:${flight.dateOfDeparture }<br>
	Departure Time:${flight.estimatedDepartureTime }<br>
	<h3>Passenger Details</h3>
	
	<form action="confirmRegistration" method="post">
	<pre>
	<h2>Enter Passenger Details</h2>
	First Name:<input type="text" name="passengerFirstName">
	Last Name:<input type="text" name="passengerLastName">
	Email Id<input type="text" name="Email">
	Mobile Number:<input type="text" name="passengerMobile">
	<h2>Enter Card Details</h2>
	Card Number:<input type="text" name="cardNumber">
	Card Holder Name:<input type="text" name="cardHolderName">
	Expiration Date:<input type="text" name="expirationDate">
	CVV:<input type="text" name="cvv">
	<input type="hidden" name="flightId" value="${ flight.id}">
	<input type="submit" value="Confirm and Pay">
	</pre>
	</form>

</body>
</html>