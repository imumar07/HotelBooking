<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
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
            width: 300px;
        }
        .para{
            font-size: 40px;
        }
        .bg-container{
            background-color: #fff;
            padding-top: 50px;
            padding-bottom: 50px;
            border-radius: 10px;
        }
        a{
		color:black;
	}
    .buttons-container{
        margin: 20px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        align-items: center;
        background-color: #fff;
        min-height: fit-content;
        padding: 10px;
        width: fit-content;
        border-radius: 6px;
    }
    .second-container{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .button-elements{
        margin: 20px;
    }
    </style>
</head>
<body>
    <div class="container bg-container">
        <div class="row text-center">
        	<div class="col-12">
        	<a href="logOut" id="logoutButton">
        	<button class="text-white btn btn-danger">Log Out</button>
        </a>
        	</div>
            <div class="col-6">
                <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704307344/5421729_2829247_yg2xzx.jpg" id="hotelOwnerOptiondImage"/>
            </div>
            <div class="col-6 d-flex flex-column justify-content-center">
                <div class="d-flex flex-column justify-content-start ">

                   <div class="container">
                        <div class="row">
                               
                                <div class="button-elements col-4"> 
                                        <a >
                                            <button class="btn btn-success" id="addHotelButton">Add Hotel</button>
                                        </a>
                                    </div>
                                    <div class="button-elements col-4">
                                        <a >
                                            <button class="btn btn-success" id="addRoomButton">Add Room</button>
                                        </a>
                                    </div>
                                    <div class="button-elements col-4">
                                        <a >
                                            <button class="btn btn-success" id="removeRoomButton">Remove Room</button>
                                        </a>
                                    </div>
                                    <div class="button-elements col-4">
                                    <a href="seeBookingsOwner">
                                        <button class="btn btn-success" id="seeBookingButton">See Bookings</button>
                                    </a>
                                </div>
                                <div class="col-12 " >
                                    <div style="text-align: left;" > 
                                    <p id="messageHotelOwnerChanges"> ${message}</p></div>
                                </div>
                        </div>
                   </div>

                </div>

            </div>
        </div>
    </div>
    <div class="second-container">
        <div class="d-none buttons-container" id="addHotelEle">
            <form action="addHotelToUser" method="post" enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="hotelId" value="0">
                <div>
                    <label for="hotelNameEle" class="form-label">Hotel Name</label>
                    <input type="text" id="hotelNameEle" class="form-control" name="hotelName"/>
                </div>
                <div>
                    <label for="locationEle" class="form-label">Location</label>
                    <input type="text" id="locationEle" class="form-control" name="location"/>
                </div>
                <div class="text-center">
                    <button class="btn btn-success mt-4" type="submit" id="addHotelButtonDone">Done!</button> </a>
                </div>
            </form>
        </div>
        <div class="d-none buttons-container" id="addRoomEle">
            <form action="/checkRoom">
                <div>
                    <label for="hotelNameEleRoom" class="form-label">Hotel Name</label>
                    <input type="text" id="hotelNameEleRoom" class="form-control" name="hotelName"/>
                </div>
                <div>
                    <label for="roomTypeEle" class="form-label">Room Type</label>
                    <input type="text" id="roomTypeEle" class="form-control" name="roomType"/>
                </div>
                <div>
                    <label for="priceEle" class="form-label">Price</label>
                    <input type="number" id="priceEle" class="form-control" name="price"/>
                </div>
                <div>
                    <label for="roomNumberEle" class="form-label">Room Number</label>
                    <input type="number" id="roomNumberEle" class="form-control" name="roomNumber"/>
                </div>
                <div class="text-center">
                    <button class="btn btn-success mt-4" id="addRoomEleButton">Done!</button>
                </div>
            </form>
        </div>
        <div class="d-none buttons-container" id="removeRoomEle">
            <form action="/removeRoom">
                <div>
                    <label for="hotelNameEleRoomRemove" class="form-label">Hotel Name</label>
                    <input type="text" id="hotelNameEleRoomRemove" class="form-control" name="hotelName"/>
                </div>
                <div>
                    <label for="roomNumberEleRemove" class="form-label">Room Number</label>
                    <input type="number" id="roomNumberEleRemove" class="form-control" name="roomNumber"/>
                </div>
                <div>
                    <label for="roomTypeEleRemove" class="form-label">Room Type</label>
                    <input type="text" id="roomTypeEleRemove" class="form-control" name="roomType"/>
                </div>
                <div class="text-center">
                    <button class="btn btn-success mt-4" id="removeRoomEleButton">Done!</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        let addHotelEle=document.getElementById("addHotelEle");
        let addRoomEle=document.getElementById("addRoomEle");
        let removeRoomEle=document.getElementById("removeRoomEle");
        let addHotelButton=document.getElementById("addHotelButton");
        let addRoomButton=document.getElementById("addRoomButton");
        let removeRoomButton=document.getElementById("removeRoomButton");
        addHotelButton.addEventListener("click",function(){
            addHotelEle.classList.add("d-block");
            addHotelEle.classList.remove("d-none");
    
            addRoomEle.classList.remove("d-block");
            addRoomEle.classList.add("d-none");
    
            removeRoomEle.classList.remove("d-block");
            removeRoomEle.classList.add("d-none");
            
        })
        addRoomButton.addEventListener("click",function(){
            addHotelEle.classList.remove("d-block");
            addHotelEle.classList.add("d-none");
    
            addRoomEle.classList.add("d-block");
            addRoomEle.classList.remove("d-none");
            
            removeRoomEle.classList.remove("d-block");
            removeRoomEle.classList.add("d-none");
            
        })
        removeRoomButton.addEventListener("click",function(){
            addHotelEle.classList.remove("d-block");
            addHotelEle.classList.add("d-none");
            
            addRoomEle.classList.add("d-none");
            addRoomEle.classList.remove("d-block");
    
            removeRoomEle.classList.remove("d-none");
            removeRoomEle.classList.add("d-block");
            
            })
        </script>
</body>
</html>