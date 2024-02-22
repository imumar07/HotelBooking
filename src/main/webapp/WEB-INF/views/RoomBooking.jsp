<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="roomTypes" value="${sessionScope.roomType}" />

<!DOCTYPE html>
<html>
<head>
<title>Room Types</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
    <style>
    body {
        background-color: aqua;
        height: 100vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .arrange {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        background-color:#fff ;
        border-radius:10px;
    }
    .container {
        padding: 20px;
        margin: 10px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: white;
        border-radius: 5px;
    }
    h2 {
        font-size: 1rem;
    }
    form {
        margin: 20px;
    }
</style>
</head>
<body>
    <h1 id="availableHeading">Available Rooms</h1>
    
    <div class="arrange">
        <c:forEach var="room" items="${roomTypes}">
            <c:choose>
                <c:when test="${room.room_type eq 'Deluxe'}">
                    <!-- Changes made below -->
                    <form id="deluxeForm" action="/bookDeluxe">
                        <div class="container">
                            <h2 name="roomType" id="roomElement" >Deluxe</h2>
                            <p>Price: <span name="price" id="priceEle"  value= "${room.price}" >${room.price}</span> per night</p>
                            <div class="m-3">
                    		<label for="checkInEle" class="form-label">Check In Date</label>
                    		<input type="date" id="checkInEleDeluxe" class="form-control" name="checkInDate"/>
                    	</div>
                    	<div class="m-3">
                		<label for="checkOutEle" class="form-label">Check Out Date</label>
                		 <input type="hidden" name="hotelId" value="${room.hotel_id}" />
                		 <input type="hidden" name="price" value= "${room.price}" />
                		 <input type="hidden" name="roomType" value="Deluxe" />
                		<input type="date" id="checkOutEleDeluxe" class="form-control" name="checkOutDate"/>
                	</div>
                            <button class="btn btn-success" type="submit" id="bookDeluxeButton">Book Deluxe</button>
                        </div>
                        
                	
                    </form>
                </c:when>
                <c:when test="${room.room_type eq 'Normal'}">
                    <!-- Changes made below -->
                    <form id="normalForm" action="/bookNormal">
                        <div class="container">
                            <h2 name="roomType" id="roomElement">Normal</h2>
                            <p>Price: <span name="price" id="priceEle" value= "${room.price}" >${room.price}</span> per night</p>
                            <div class="m-3">
                    		<label for="checkInEle" class="form-label">Check In Date</label>
                    		<input type="date" id="checkInEleNormal" class="form-control" name="checkInDate"/>
                    	</div>
                    	<div class="m-3">
                		<label for="checkOutEle" class="form-label">Check Out Date</label>
                		<input type="date" id="checkOutDateNormal" class="form-control" name="checkOutDate"/>
                		
                		<input type="hidden" name="price" value= "${room.price}" />
                		<input type="hidden" name="hotelId" value="${room.hotel_id}" />
                		<input type="hidden" name="roomType" value="Deluxe" />
                	</div>
                            <button class="btn btn-success" type="submit" id="bookNormalButton">Book Normal</button>
                        </div>
                        
                	
                    </form>
                </c:when>
                <c:otherwise>
                    <p>No room type selected.</p>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
    
    <!-- JavaScript for form submission handling -->
    <script>
        document.querySelectorAll('.arrange form').forEach(form => {
            form.addEventListener('submit', function(event) {
                event.preventDefault();

                var roomContent = this.querySelector('h2').innerText;
                var priceContent = this.querySelector('span').innerText;

                var hiddenRoomInput = document.createElement('input');
                hiddenRoomInput.setAttribute('type', 'hidden');
                hiddenRoomInput.setAttribute('name', 'roomContent');
                hiddenRoomInput.setAttribute('value', roomContent);

                var hiddenPriceInput = document.createElement('input');
                hiddenPriceInput.setAttribute('type', 'hidden');
                hiddenPriceInput.setAttribute('name', 'priceContent');
                hiddenPriceInput.setAttribute('value', priceContent);

                this.appendChild(hiddenRoomInput);
                this.appendChild(hiddenPriceInput);

                this.submit();
            });
        });
    </script>
</body>
</html>
