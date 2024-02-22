<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        	text-decoration:none;
        }
    </style>
</head>
<body>
    <div class="container bg-container">
        <div class="row text-center">
            <div class="col-6">
                <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704348631/12083608_Wavy_Bus-26_Single-11_g2zsgn.jpg" id="cancelSuccessful"/>
            </div>
            <div class="col-6 d-flex flex-column justify-content-center">
                <div class="d-flex flex-column justify-content-start">
                    <p class="para text-success" id="cancelPara">Cancellation Successful</p>
                    <div>
                    <a href="seePreviousBookings">
            		<button class="text-white btn btn-success" id="seeBooking">See Bookings</button>
            		</a>
                    <a href="logOut">
                		<button class="text-white btn btn-danger" id="logOutButton">Log Out</button>
                	</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>