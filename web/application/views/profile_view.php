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
				<ul class="list-group">
				  <li class="list-group-item"><strong>Name: </strong><?php echo $name; ?></li>
				  <li class="list-group-item"><strong>Email: </strong><?php echo $email; ?></li>
				  <li class="list-group-item"><strong>Last Login: </strong><?php echo $last_login; ?></li>
				</ul>
				<a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-edit"></span> Change Password</a>
				<a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Change Email</a>
			</div>
		</div>
	</div>
</div>