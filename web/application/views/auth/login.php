<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Sign in</h1>
            </header>
            <br><br>
            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Sign in</h3>
                        <p class="text-center text-muted">Login or <a href="<?php echo base_url(); ?>index.php/auth/create_user">Register</a> now and enjoy great benefits!</p>
                        <hr>
                        <?php if($message != "") { ?>
                            <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
                        <?php } ?>
                        <?php echo form_open("auth/login");?>
                            <div class="top-margin">
                                <label>Email <span class="text-danger">*</span></label>
                                <?php echo form_input($identity);?>
                            </div>
                            <div class="top-margin">
                                <label>Password <span class="text-danger">*</span></label>
                                <?php echo form_input($password);?>
                            </div>
                        <br>
                            <div>
                                <label for="remember">Remember Me: </label>    
                                <?php echo form_checkbox('remember', '1', FALSE, 'id="remember"');?>
                            </div>
                            <hr>

                            <div class="row">
                                <div class="col-lg-8">
                                    <b><a href="forgot_password">Forgot password?</a></b>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-custom" type="submit" name="submit" value="Login">Sign in</button>
                                </div>
                            </div>
                        <?php echo form_close();?>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
    <br><br><br><br>
</div>	<!-- /container -->
