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
    <h1>{name}</h1>
    <hr>
    <table class="table table-bordered">
        <tbody>
            <tr>
                <td>Date</td>
                <td>{date}</td>
            </tr>
            <tr>
                <td>Status</td>
                <td><strong>{status}</strong></td>
            </tr>
        </tbody>
    </table>
</body>
</html>