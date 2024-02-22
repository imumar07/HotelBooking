<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Bookings</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
        	background-color:aqua;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .booking-container {
            padding: 10px;
            margin-bottom: 10px;
            width: 80%;
            max-width: 500px;
        }
        .booking-details {

            padding: 8px;
            margin-top: 10px;
            background-color:#fff;
            border-radius:5px;
            display:flex;
            flex-direction:row;
            justify-content:center;
            align-items:center;
            flex-wrap:wrap;
        }
        .booking-details p {
            margin: 5px 0;
            font-weight:500;
        }
        .booking-details span {
            
            font-size:0.9rem;
        }
    </style>
</head>
<body>
    <h1>Hotel Bookings</h1>
    <c:set var="index" value="0" />
    <div class="booking-container">
        <c:forEach items="${bookings}" var="data"  varStatus="loop">
        <c:set var="index" value="${loop.index}" />
            <div class="booking-details">
                <div class="container">
                	<div class="row d-flex flex-row justify-content-center">
                		<div class="col-12 text-center" >
                				<p>${message}</p>
                		</div>
                		<div class="col-6 d-flex flex-column justify-content-center">
                			<p>Booked By: <span>${data.getUserName()}</span></p>
                			<p>Hotel Name: <span>${data.getHotelName()}</span></p>
                			<p>Location: <span>${data.getLocation()}</span></p>
                		</div>
                		<div class="col-6 d-flex flex-column justify-content-center">
                			<p>Check-in Date: <span>${data.getCheckInDate()}</span></p>
                			<p>Check-out Date: <span>${data.getCheckOutDate()}</span></p>
                			<p id="price">Price: <span>${data.getPrice()}</span></p>
                		</div>
                		<div class="col-6 d-flex flex-column justify-content-center">
                		<p>Room Number: ${data.getRoomNumber()}</p>
                		<p id="bookingStatus">Status: 
                                <c:choose>
                                    <c:when test="${data.status eq 'booked'}">
                                       <span class="text-success">Booking Done</span> 
                                    </c:when>
                                    <c:otherwise>
                                    <span class="text-danger">Booking Cancelled</span>
                                    </c:otherwise>
                                </c:choose>	
                        </p>
                		</div>
                		<div class="col-12 text-center m-3" >
                			<form action="cancelBooking">
                				<div>
                					<input type="hidden" name="username" value=${data.getUserName()}>
                					<input type="hidden" name="hotelName" value=${data.getHotelName()}>
                					<input type="hidden" name="location" value=${data.getLocation()}>
                					<input type="hidden" name="checkinDate" value=${data.getCheckInDate()}>
                					<input type="hidden" name="checkoutDate" value=${data.getCheckOutDate()}>
                					 <input type="hidden" name="index" value="${index}">
                					<button class="btn btn-danger" id="cancelBookingButton"> Cancel Booking </button>
                				</div>
                			</form>
                		</div>
                	</div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
