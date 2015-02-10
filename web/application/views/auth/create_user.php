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
                <h1 class="page-title">Registration</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Register at DomiiDesigns</h3>
                        <p class="text-center text-muted">Create your DomiiDesigns Account and enjoy great benefits. Or <a href="<?php echo base_url(); ?>index.php/auth/login">Login</a> to your Account.</p>
                        <hr>
                        <?php
                        if (isset($message) && $message != NULL) {
                            echo '<div class="alert alert-info"  id="infoMessage" role="alert">' . $mesage . '</div>';
                        }
                        ?>
                        <?php echo form_open("auth/create_user"); ?>
                        <div class="top-margin">
                            <label>First Name</label>
                            <?php echo form_input($first_name);?>
                        </div>
                        <div class="top-margin">
                            <label>Last Name</label>
                            <?php echo form_input($last_name);?>
                        </div>
                        <div class="top-margin">
                            <label>Company</label>
                            <?php echo form_input($company);?>
                        </div>
                        <div class="top-margin">
                            <label>Email Address <span class="text-danger">*</span></label>
                            <?php echo form_input($email);?>
                        </div>
                        <div class="top-margin">
                            <label>Phone</label>
                            <?php echo form_input($phone);?>
                        </div>

                        <div class="row top-margin">
                            <div class="col-sm-6">
                                <label>Password <span class="text-danger">*</span></label>
                                <?php echo form_input($password);?>
                            </div>
                            <div class="col-sm-6">
                                <label>Confirm Password <span class="text-danger">*</span></label>
                                <?php echo form_input($password_confirm);?>
                            </div>
                        </div>

                        <hr>

                        <div class="row">
                            <div class="col-lg-8">
                                <label class="checkbox">
                                    <input type="checkbox"> 
                                    I've read the <a href="page_terms">Terms and Conditions </a>and accept them
                                </label>                        
                            </div>
                            <div class="col-lg-4 text-right">
                                <?php echo form_submit('submit', 'Register');?>
                            </div>
                        </div>
                        <?php echo form_close(); ?>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
</div>	<!-- /container -->
