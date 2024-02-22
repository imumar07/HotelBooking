<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            padding: 20px;
            background-color: aqua;
            min-height: 100vh;
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
        }
        .arrange{
		height:fit-content;
		background-color:#ffffff;
		padding:10px;
		border-radius:10px;
	}
    </style>
</head>
<body>
    <div class="container bg-container">
        <div class="row ">
            <div class="col-6 d-flex flex-column justify-content-center">
                <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704310315/11668479_20943593_bpxywv.jpg"/>
            </div>
            <div class="col-6 d-flex flex-column justify-content-center">
                <div class="d-flex flex-row justify-content-center">
                    <div class="arrange">
                        <form action="loginNew" method="post">
                        <!-- Name -->
                        <label for="nameEle" class="form-label">Name</label>
                        <input type="text" id="nameEle" class="form-control" name="name"/>
                        <!-- Email -->
                        <label for="emailEle" class="form-label">Email</label>
                        <input type="email" id="emailEle" class="form-control" name="email"/>
                        <!-- Phone Number -->
                        <label for="phoneNumberEle" class="form-label">Number</label>
                        <input type="text" id="phoneNumberEle" class="form-control" name="phoneNumber"/>
                        <!-- Username -->
                        <label for="usernameEle" class="form-label">Username</label>
                        <input type="text" id="usernameEle" class="form-control" name="username"/>
                        <!-- password -->
                        <label for="passwordEle" class="form-label">Password</label>
                        <input type="password" id="passwordEle" class="form-control" name="password"/>
                        <!-- Confrim Password -->
                        <label for="confrimPasswordEle" class="form-label">Confrim Password</label>
                        <input type="password" id="confrimPasswordEle" class="form-control" name="confrim-password"/>
                        <label for="userTypeBooking" class="radio-buttons">Booking User</label>
                        <input type="radio" id="userTypeBooking" name="userType" value="User" checked/>
                        <label for="userTypeHotel" class="radio-buttons">Hotel Owner</label>
                        <input type="radio" id="userTypeHotel" name="userType" value="Hotel_Owner" />
                        
                        <div class="text-center m-2 mt-4">
                        <button type="submit" class="btn btn-success" id="loginNewFormButton">Login In</button>
                        <br/>
                        <p style="color:red;" id="loginNewFormMessage">
                        ${message}
                        </p>
                        </div>
                        </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>