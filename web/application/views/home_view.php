<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
	<h1>Welcome.</h1>
</div>

<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-user"></span> Info
				</h3>
			</div>
			<div class="panel-body">
				<p>Hello <strong><?php echo $name; ?></strong>. Nice to see you.</p>
				<p>Here at the JocolateManager you can manage your bills, your packages and get access to the Api Documentation. In future, there are even more possibilites. So stay tuned for the amazing content.</p>
				<a href="<?php echo site_url('auth/logout'); ?>" class="btn btn-danger btn-lg btn-block" role="button"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
			</div>
		</div>
	</div>
<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-bookmark"></span> Quick Shortcuts
			</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-xs-12 col-md-12">
					<a href="<?php echo site_url('member/shopping_cart'); ?>" id="shortcut" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-shopping-cart"></span> <br/>Shopping Cart</a>
					<a href="<?php echo site_url('member/bills'); ?>" id="shortcut" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-list"></span> <br/>Bills</a>
					<a href="<?php echo site_url('member/packages'); ?>" id="shortcut" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-inbox"></span> <br/>Packages</a>
					<a href="<?php echo site_url('api/index'); ?>" id="shortcut" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-cog"></span> <br/>Api</a>
					<a href="<?php echo site_url('member/profile'); ?>" id="shortcut" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Profile</a>

					<?php if($this->user->is_admin()) { ?>
					<a href="<?php echo site_url('admin/index'); ?>" id="shortcut" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-fire"></span> <br/>Admin</a>
					<?php } else { ?>
					<a href="<?php echo "http://petritzdesigns.at"; ?>" id="shortcut" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-globe"></span> <br/>Website</a>
					<?php } ?>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
