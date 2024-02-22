<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Document</title>
    <style>
        body{
            background-color: aqua;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-self: center;
            
        }
        img{
            height: 300px;
            width: fit-content;
        }
        .para{
            font-size: 40px;
        }
        .bg-container{
            background-color: #fff;
            padding-top: 50px;
            padding-bottom: 50px;
            border-radius: 10px;
            width:1000px !important;
            box-sizing:border-box;

        }
        .arrange{
			height:fit-content;
			background-color:#ffffff;
			padding:20px;
			width:300px;
			border-radius:10px;
	    }
    </style>
</head>
<body>
<div class="container bg-container">
    <div class="row">
    	<div class="col-12 text-left">
    		<a href="logOut" id="logoutButton">
    			<button class="text-white btn btn-danger">Log Out</button>
    		</a>
    	</div>
        <div class="col-6 d-flex flex-column justify-content-center">
            <div class="d-flex flex-row justify-content-center">
                <div class="arrange">
                <form action="doBooking" method="post">
                <div>
                    <label for="hotelNameEle" class="form-label">Hotel</label>
                    <select name="hotelName" id="hotelNameEle" class="form-select">
                        <c:forEach items="${sessionScope.hotels}" var="hotel" varStatus="loop">
                            <option value="${hotel}">${hotel} -  ${sessionScope.locations[loop.index]}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="locationEle" class="form-label">Location</label>
                    <select name="location" id="locationEle" class="form-select">
                        <c:forEach items="${sessionScope.locations}" var="location">
                            <option value="${location}">${location}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="text-center m-2 mt-4">
                    <p class="text-danger" id="bookingInfoMessage"> ${message}</p>
                    <br/>
                    <button type="submit" class="btn btn-success" id="newBookingButton">New Booking</button>
                </div>
                
            </form>
                </div>
            </div>
            <div class="text-center">
                <a href="seePreviousBookings">
                    <button class="btn btn-success" id="knowBookingButton">Know your Bookings</button>
                </a>
            </div>
        </div>
        
        <div class="col-6" style="box-sizing:border-box;">
            <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704308215/11235583_10811_bles0r.jpg" id="bookingInfoImage"/>
        </div>
    </div>
</div>
</body>

</html>