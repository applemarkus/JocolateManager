<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <!--<ol class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li class="active">About</li>
    </ol>-->

    <div class="row">

        <!-- Article main content -->
        <article class="col-sm-8 maincontent">
            <header class="page-header">
                <h1 class="page-title">Userlist</h1>
            </header>
            <div class="row container">

                <?php if ($message != "") { ?>
                    <div class="alert alert-info" role="alert" id="infoMessage"><?php echo $message; ?></div>
                <?php } ?>

                <table class="table table-bordered table-hover">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Groups</th>
                        <th style="width: 50px;">Status</th>
                        <th style="width: 50px;">Action</th>
                    </tr>
                    <?php foreach ($users as $user): ?>
                        <tr>
                            <td><?php echo htmlspecialchars($user->first_name, ENT_QUOTES, 'UTF-8'); ?></td>
                            <td><?php echo htmlspecialchars($user->last_name, ENT_QUOTES, 'UTF-8'); ?></td>
                            <td><?php echo htmlspecialchars($user->email, ENT_QUOTES, 'UTF-8'); ?></td>
                            <td>
                                <?php foreach ($user->groups as $group): ?>
                                    <a href="<?php echo base_url(); ?>index.php/auth/edit_group/<?php echo $group->id; ?>" class="text-muted"><i class="fa fa-users"></i> <?php echo $group->name; ?></a><br>
                                <?php endforeach ?>
                            </td>
                            <td>
                                <?php if ($user->active) { ?>
                                    <a href="<?php echo base_url(); ?>index.php/auth/deactivate/<?php echo $user->id; ?>"class="btn btn-success"><i class="fa fa-check"></i> Active</a>
                                <?php } else { ?>
                                    <a href="<?php echo base_url(); ?>index.php/auth/activate/<?php echo $user->id; ?>"class="btn btn-success"><i class="fa fa-check"></i> Inactive</a>
                                <?php } ?>
                            </td>
                            <td><a href="<?php echo base_url(); ?>index.php/auth/edit_user/<?php echo $user->id; ?>"class="btn btn-danger"><i class="fa fa-edit"></i> Edit</a></td>
                        </tr>
                    <?php endforeach; ?>
                </table>

                <p>
                    <a href="<?php echo base_url(); ?>index.php/auth/create_user" class="btn btn-info">Create a new user</a>
                    <a href="<?php echo base_url(); ?>index.php/auth/create_group" class="btn btn-info">Create a new group</a>
                </p>
            </div>  
        </article>
        <!-- /Article -->

    </div>
</div>