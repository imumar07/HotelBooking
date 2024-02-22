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
    </style>
</head>
<body>
    <div class="container bg-container">
        <div class="row ">
            <div class="col-6 text-center">
                <img src="https://res.cloudinary.com/dqe4ld4cx/image/upload/v1704357168/19466810_6134225_pbplgr.jpg"/>
            </div>
            <div class="col-6 d-flex flex-column justify-content-center">
                <div class="d-flex flex-row justify-content-center">
                    <form action="doPayment" method="post">
                        <div class="m-2">
                            <label for="cardNumberEle" class="form-label">Card Number</label>
                            <input type="number" id="cardNumberEle" class="form-control" placeholder="xxxx xxxx xxxx" name="cardNumber"/>
                        </div>
                        <div class="m-2">
                            <label for="cardNameEle" class="form-label">Name on Card</label>
                            <input type="text" id="cardNameEle" class="form-control" placeholder="Enter Name" name="cardName"/>
                        </div>
                        <div class="m-2">
                            <label for="cvvEle" class="form-label">Enter CVV</label>
                            <input type="password" id="cvvEle" class="form-control" placeholder="Enter CVV" name="cvv" maxlength="3"/>
                        </div>
                        <div class="m-1">
                        	<h5>Booking Amount ${price}</h5>
                        </div>
                        <div class="m-2">
                            <button class="btn btn-success" id="makePaymentButton">Make Payment</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>