
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <!--<ol class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li class="active">About</li>
    </ol>-->

    <div class="row">

        <!-- Article main content -->
        <header class="page-header">
            <h1 class="page-title">Edit Users</h1>
        </header>

        <div class="alert alert-info" id="infoMessage2" role="alert">Please enter the user's information below.</div>

        <?php if ($message != "") { ?>
            <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
        <?php } ?>

        <?php echo form_open(uri_string()); ?>

        <p>
            <label for="first_name">First Name:</label> <br />
            <?php echo form_input($first_name); ?>
        </p>

        <p>
            <label for="last_name">Last Name:</label> <br />
            <?php echo form_input($last_name); ?>
        </p>

        <p>
            <label for="company">Company Name:</label> <br />
            <?php echo form_input($company); ?>
        </p>

        <p>
            <label for="phone">Phone:</label> <br />
            <?php echo form_input($phone); ?>
        </p>

        <p>
            <label for="password">New Password: (For changing current Password)</label> <br />
            <?php echo form_input($password); ?>
        </p>

        <p>
            <label for="password_confirm">Confirm New Password: (For changing current Password)</label><br />
            <?php echo form_input($password_confirm); ?>
        </p>

        <?php if ($this->ion_auth->is_admin()): ?>

            <header class="page-header">
                <h3 class="page-title">Groups</h3>
            </header>
            <?php foreach ($groups as $group): ?>
                <label class="checkbox">
                    <?php
                    $gID = $group['id'];
                    $checked = null;
                    $item = null;
                    foreach ($currentGroups as $grp) {
                        if ($gID == $grp->id) {
                            $checked = ' checked="checked"';
                            break;
                        }
                    }
                    ?>
                    <input type="checkbox" name="groups[]" value="<?php echo $group['id']; ?>"<?php echo $checked; ?>>
                    <?php echo htmlspecialchars($group['name'], ENT_QUOTES, 'UTF-8'); ?>
                </label>
            <?php endforeach ?>

        <?php endif ?>

        <?php echo form_hidden('id', $user->id); ?>
        <?php echo form_hidden($csrf); ?>

        <p><?php echo form_submit('submit', lang('edit_user_submit_btn')); ?></p>

        <?php echo form_close(); ?>
        <!-- /Article -->

    </div>
</div>  <!-- /container -->
