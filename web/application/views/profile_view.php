<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
    <h1>Profile</h1>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-user"></span> Info
				</h3>
			</div>
			<div class="panel-body">
				<h3><strong>Name: </strong><?php echo $name; ?></h3>
				<ul class="list-group">
				  <li class="list-group-item"><strong>Email: </strong><?php echo $email; ?></li>
				  <li class="list-group-item"><strong>Amount Bills: </strong><?php echo $bills; ?></li>
				  <li class="list-group-item"><strong>Amount Packages: </strong><?php echo $packages; ?></li>
				  <li class="list-group-item"><strong>Last Login: </strong><?php echo $last_login; ?></li>
				  <li class="list-group-item"><strong>IP Address: </strong><?php echo $ip; ?></li>
				  <li class="list-group-item"><strong>Browser: </strong><?php echo $browser; ?></li>
				  <li class="list-group-item"><strong>Operating System: </strong><?php echo $os; ?></li>
				</ul>
				<div class="row">
					<div class="col-md-6">
						<a href="mailto:<?php echo $email; ?>" class="btn btn-info btn-lg btn-block"><span class="glyphicon glyphicon-envelope"></span> Send Mail</a>
					</div>
					<div class="col-md-6">
						<a href="<?php echo site_url('auth/logout'); ?>" class="btn btn-danger btn-lg btn-block"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>