<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<?php echo base_url(); ?>assets/css/bootstrap.css" rel="stylesheet">
</head>
<body class="container">
    <h1>{bill_name}</h1>
    <hr>
    <h2>All</h2>
    <table class="table table-bordered">
        <tbody>
            <tr>
                <td>Date</td>
                <td>{date}</td>
            </tr>
            <tr>
                <td>Price</td>
                <td><strong>{price}</strong></td>
            </tr>
        </tbody>
    </table>
    <h2>Details</h2>
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th>Info</th>
                <th>Value</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Name</td>
                <td>{name}</td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>{firstName}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>{email}</td>
            </tr>
            <tr>
                <td>Phone</td>
                <td>{phone}</td>
            </tr>
            <tr>
                <td>Street</td>
                <td>{street}</td>
            </tr>
            <tr>
                <td>Streetnumber</td>
                <td>{streetNumber}</td>
            </tr>
            <tr>
                <td>Zip-Code</td>
                <td>{zipCode}</td>
            </tr>
            <tr>
                <td>City</td>
                <td>{city}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>{country}</td>
            </tr>
            <tr>
                <td>Card Number</td>
                <td>{cardNumber}</td>
            </tr>
            <tr>
                <td>Expires</td>
                <td>{expires}</td>
            </tr>
            <tr>
                <td>Security Code</td>
                <td>{securityCode}</td>
            </tr>
        </tbody>
    </table>
    <h2>Shopping Cart</h2>
    <table class="table table-hover table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Size</th>
                <th>Logo</th>
                <th>Amount</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            {shopping_items}
            <tr>
                <td>{name}</td>
                <td>{type}</td>
                <td>{size}</td>
                <td>{logo}</td>
                <td>{amount}</td>
                <td>{price}</td>
            </tr>
            {/shopping_items}
        </tbody>
    </table>
</body>
</html>
