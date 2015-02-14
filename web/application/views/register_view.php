<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h1>Register</h1>

<div id="body">
    <?php echo validation_errors(); ?>
    <?php echo form_open('auth/verifyRegister'); ?>
        <label for="email">Email:</label>
        <input type="text" size="20" id="email" name="email" placeholder="Email"/>
        <br/>
        <label for="password">Password:</label>
        <input type="password" size="20" id="password" name="password" placeholder="Password"/>
        <br/>
        <input type="submit" value="Register"/>
        <br>
    <?php echo form_close(); ?>
        
    <?php echo anchor('auth/login', 'Login'); ?>
</div>