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
                <h1 class="page-title">Create User Group</h1>
            </header>
            <?php if($message != "") { ?>
                <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
            <?php } ?>

            <div id="infoMessage"></div>

            <?php echo form_open("auth/create_group");?>

              <p>
                <label for="group_name">Group Name:</label> <br />
                <?php echo form_input($group_name);?>
            </p>

            <p>
                <label for="description">Description:</label> <br />
                <?php echo form_input($description);?>
            </p>

            <p><?php echo form_submit('submit', lang('create_group_submit_btn'));?></p>

            <?php echo form_close();?>

        </div>
    </div>  <!-- /container -->
