
    <header id="head" class="secondary"></header>

    <!-- container -->
    <div class="container">

        <!--<ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">About</li>
        </ol>-->

        <div class="row">

            <header class="page-header">
                    <h1 class="page-title">Change Passsword</h1>
                </header>

<?php
        if (isset($message) && $message != NULL) {
            echo '<div class="alert alert-info"  id="infoMessage" role="alert">' . $mesage . '</div>';
        }
        ?>

<?php echo form_open("auth/change_password");?>

      <p>
            <label for="old_password">Old Password:</label> <br />
            <?php echo form_input($old_password);?>
      </p>

      <p>
            <label for="new_password">New Password (at least 8 characters long):</label> <br />
            <?php echo form_input($new_password);?>
      </p>

      <p>
            <label for="new_password_confirm">Confirm New Password:</label> <br />
            <?php echo form_input($new_password_confirm);?>
      </p>

      <?php echo form_input($user_id);?>
      <p><?php echo form_submit('submit', lang('change_password_submit_btn'));?></p>

<?php echo form_close();?>

        </div>
    </div>  <!-- /container -->
    