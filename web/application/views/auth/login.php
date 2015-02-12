<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$page = "Login";
?>

<div class="row">
    <ol class="breadcrumb">
        <li><a href="<?php echo base_url(); ?>"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active"><?php echo $page; ?></li>
    </ol>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><?php echo $page; ?></h1>
    </div>
</div><!--/.row-->

<div class="login-panel panel panel-default">
    <div class="panel-heading">Please Log in</div>
    <div class="panel-body">
        <?php if ($message != "") { ?>
            <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
        <?php } ?>
        <?php echo form_open("auth/login"); ?>
        <fieldset>
            <div class="form-group">
                <?php echo form_input($identity, '', 'placeholder="Email"'); ?>
            </div>
            <div class="form-group">
                <?php echo form_input($password, '', 'placeholder="Password"'); ?>
            </div>
            <div class="checkbox">
                <label>
                    <?php echo form_checkbox('remember', '1', FALSE, 'id="remember"'); ?> Remember Me
                </label>
            </div>
            <a href="index.html" class="btn btn-primary">Login</a>
        </fieldset>
        </form>
    </div>
</div>