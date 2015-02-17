<?php

defined('BASEPATH') OR exit('No direct script access allowed');
$page = uri_string();
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="JocolateManager - Best Chocolate Order Client">
	<meta name="author" content="jCorn Development">

	<title>JocolateManager - Best Chocolate Order Client</title>

	<!-- Bootstrap core CSS -->
	<link href="<?php echo base_url(); ?>assets/css/bootstrap.css" rel="stylesheet">

	<!-- Custom styles -->
	<link href="<?php echo base_url(); ?>assets/css/main.css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>

	<script src="<?php echo base_url(); ?>assets/js/jquery.min.js"></script>
	<script src="<?php echo base_url(); ?>assets/js/smoothscroll.js"></script>


</head>

<body>

	<!-- Fixed navbar -->
	<div id="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<?php echo base_url(); ?>"><b>JocolateManager</b></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<?php echo site_url('main/index'); ?>">Home</a></li>
					<li class="<?php
					if($page == "member/index" || $page == "member") {
						echo "active";
					}
					?>"><a href="<?php echo site_url('member/index'); ?>">Member</a></li>
					<li><a href="#" >Bills</a></li>
					<li><a href="#">Packages</a></li>
				</ul>
				<?php if ($this->session->userdata('logged_in')) { ?>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<?php echo site_url('auth/logout'); ?>">Logout</a></li>
				</ul>
				<?php } else { ?>
				<ul class="nav navbar-nav navbar-right">
					<li class="<?php
					if($page == "auth/login" || $page == "auth/register") {
						echo "active";
					}
					?>"><a href="<?php echo site_url('auth/login'); ?>">Login/Register</a></li>
				</ul>
				<?php } ?>
			</div><!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">