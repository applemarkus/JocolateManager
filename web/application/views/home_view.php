<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h1>Welcome.</h1>

<div id="body">
    <p>Hello <strong><?php echo $email; ?></strong>. Nice to see you.</p>
    <p>Access the API: <?php echo anchor('api/index', 'Click here'); ?></p>
    <?php echo anchor('auth/logout', 'Logout'); ?>
</div>
