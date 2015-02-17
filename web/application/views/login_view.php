<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
    <h1>Login</h1>
</div>

<div id="body">
    <?php if(validation_errors() != "") { ?>
    <div class="alert alert-danger alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <strong>Error!</strong><br><?php echo validation_errors(); ?>
  </div>
  <?php } ?>
  <?php echo form_open('auth/verifyLogin'); ?>
  <div class="form-group">
    <label for="email">Email:</label>
    <input class="form-control" type="text" size="20" id="email" name="email" placeholder="Email" value="<?php if(isset($email)) echo $email; ?>"/>
</div>
<div class="form-group">
    <label for="password">Password:</label>
    <input class="form-control" type="password" size="20" id="password" name="password" placeholder="Password"/>
</div>
<div class="form-group">
    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"/>
</div>
<?php echo form_close(); ?>

<?php echo anchor('auth/register', 'No Account? Register here.'); ?>
</div>