
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <!--<ol class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li class="active">About</li>
    </ol>-->

    <div class="row">

        <header class="page-header">
            <h1 class="page-title">Deactivate User</h1>
        </header>
        <p>Are you sure you want to deactivate the User '<?php echo $user->username; ?>'</p>
        <br>
        <?php echo form_open("auth/deactivate/" . $user->id); ?>

        <table class="" style="width: 150px">
            <tr>
                <td >
                    <label for="confirm">Yes:</label>
                </td>
                <td>
                    <input type="radio" name="confirm" value="yes" checked="checked" />
                </td>
            </tr>   
            <tr>
                <td>
                    <label for="confirm">No:</label>
                </td>
                <td>
                    <input type="radio" name="confirm" value="no" />
                </td>
            </tr>  
        </table>

        <?php echo form_hidden($csrf); ?>
        <?php echo form_hidden(array('id' => $user->id)); ?>


        <p><?php echo form_submit('submit', lang('deactivate_submit_btn')); ?></p>
        <?php echo form_close(); ?>

    </div>
</div>  <!-- /container -->
