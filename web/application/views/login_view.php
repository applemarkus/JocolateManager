<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h1>Login</h1>

<div id="body">
    <?php echo validation_errors(); ?>
    <?php echo form_open('auth/verifyLogin'); ?>
        <label for="email">Email:</label>
        <input type="text" size="20" id="email" name="email" placeholder="Email" value="<?php if(isset($email)) echo $email; ?>"/>
        <br/>
        <label for="password">Password:</label>
        <input type="password" size="20" id="password" name="password" placeholder="Password"/>
        <br/>
        <input type="submit" value="Login"/>
        <br>
    <?php echo form_close(); ?>
        
    <?php echo anchor('auth/register', 'Register'); ?>
</div>