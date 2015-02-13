<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<html>
    <head>
        <title>Login to Jocolate Manager</title>
    </head>
    <body>
        <h1>Login to Jocolate Manager</h1>
        <?php echo validation_errors(); ?>
        <?php echo form_open('verifylogin'); ?>
            <label for="username">Username:</label>
            <input type="text" size="20" id="username" name="username"/>
            <br/>
            <label for="password">Password:</label>
            <input type="password" size="20" id="passowrd" name="password"/>
            <br/>
            <input type="submit" value="Login"/>
        <?php echo form_close(); ?>
</body>
</html>
