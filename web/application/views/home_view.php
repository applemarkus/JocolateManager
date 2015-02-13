<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h1>Welcome.</h1>

<div id="body">
    <h2>Hello <?php echo $email; ?>! Nice to see you.</h2>
    <?php echo anchor('auth/logout', 'Logout'); ?>
</div>

<p class="footer">Page rendered in <strong>{elapsed_time}</strong> seconds. <?php echo (ENVIRONMENT === 'development') ? 'CodeIgniter Version <strong>' . CI_VERSION . '</strong>' : '' ?></p>
