<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            align-items: center;
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
        .arrange{
		height:fit-content;
		background-color:#ffffff;
		padding:10px;
		border-radius:10px;
	}
    </style>
</head>
<body>
    <div class="container bg-container" id="mainContainer">
        <div class="row">
            <div class="col-6 text-center">
                <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704306699/5423351_Mobile-login_evy03d.jpg" id="loginImage"/>
            </div>
            <div class="col-6 d-flex flex-column justify-content-start">
                <div class="d-flex flex-row justify-content-center">
                    <div class="arrange">
                        <form action="loginUser" method="post">
                        <div class="text-left">
                            <label for="usernameEle" class="form-label" id="usernameLabelEle">Username</label>
                        <input type="text" id="usernameEle" class="form-control" name="username"/>
                        </div>
                        <label for="passwordEle" class="form-label" id="passwordLabelEle">Password</label>
                        <input type="password" id="passwordEle" class="form-control" name="password"/>
                        <div class="text-center m-2 mt-4">
                        <p >${message}</p>
                        <br/>
                        <button type="submit" class="btn btn-success" id="loginButton">Login</button>
                        <br/>
                        <a href="loginForm">Not Registered Yet?</a>
                        
                        <br/>
                        </div>
                        </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
