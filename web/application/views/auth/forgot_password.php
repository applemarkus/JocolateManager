
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <!--<ol class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li class="active">About</li>
    </ol>-->

    <div class="row">

        <header class="page-header">
            <h1 class="page-title">Forgot Password</h1>
        </header>
        <div class="alert alert-info" role="alert" id="infoMessage2">Please enter your Email Adress to change your Password. You will receive a message, where to edit your Password</div>
        <?php if ($message != "") { ?>
            <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
        <?php } ?>

        <?php echo form_open("auth/forgot_password"); ?>

        <p>
            <label for="email">Email:</label> <br />
            <?php echo form_input($email); ?>
        </p>

        <p><?php echo form_submit('submit', lang('forgot_password_submit_btn')); ?></p>

        <?php echo form_close(); ?>

    </div>
</div>  <!-- /container -->
