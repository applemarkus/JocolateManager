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

<body data-spy="scroll" data-offset="0" data-target="#navigation">

	<!-- Fixed navbar -->
	<div id="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><b>JocolateManager</b></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#home" class="smothscroll">Home</a></li>
					<li><a href="#desc" class="smothscroll">Description</a></li>
					<li><a href="#showcase" class="smothScroll">Showcase</a></li>
					<li><a href="#contact" class="smothScroll">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<?php echo base_url(); ?>index.php/member/index">Member</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div>


	<section id="home" name="home"></section>
	<div id="headerwrap">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-12">
					<h1>Welcome To <b>JocolateManager</b>.</h1>
					<h3>The Best Chocolate Order Client.</h3>
					<br>
				</div>

				<div class="col-lg-2">
					<h5>Amazing Possibilities</h5>
					<p>Create your own chocolate. Put it in the shopping cart together and order it safe und fast.</p>
					<img class="hidden-xs hidden-sm hidden-md" src="<?php echo base_url(); ?>assets/img/arrow1.png">
				</div>
				<div class="col-lg-8">
					<img class="img-responsive" src="<?php echo base_url(); ?>assets/img/app-bg.png" alt="">
				</div>
				<div class="col-lg-2">
					<br>
					<img class="hidden-xs hidden-sm hidden-md" src="<?php echo base_url(); ?>assets/img/arrow2.png">
					<h5>Awesome Design</h5>
					<p>Perfectly crafted and easy to use.</p>
				</div>
			</div>
		</div> <!--/ .container -->
	</div><!--/ #headerwrap -->


	<section id="desc" name="desc"></section>
	<!-- INTRO WRAP -->
	<div id="intro">
		<div class="container">
			<div class="row centered">
				<h1>Designed for Chocolate-Lovers</h1>
				<br>
				<br>
				<div class="col-lg-4">
					<img src="<?php echo base_url(); ?>assets/img/intro01.png" alt="">
					<h3>Chocolate Chooser</h3>
					<p>Create the Chocolate that you love, easy and uncomplicated.</p>
				</div>
				<div class="col-lg-4">
					<img src="<?php echo base_url(); ?>assets/img/intro02.png" alt="">
					<h3>Shopping Cart</h3>
					<p>Put all your Chocolates together and order it with one click.</p>
				</div>
				<div class="col-lg-4">
					<img src="<?php echo base_url(); ?>assets/img/intro03.png" alt="">
					<h3>Delivery Status</h3>
					<p>Check the current status of your packet full of chocolate.</p>
				</div>
			</div>
			<br>
			<hr>
		</div> <!--/ .container -->
	</div><!--/ #introwrap -->

	<!-- FEATURES WRAP -->
	<div id="features">
		<div class="container">
			<div class="row">
				<h1 class="centered">What's New?</h1>
				<br>
				<br>
				<div class="col-lg-6 centered">
					<img class="centered" src="<?php echo base_url(); ?>assets/img/mobile.png" alt="">
				</div>

				<div class="col-lg-6">
					<h3>Some Features</h3>
					<br>
					<!-- ACCORDION -->
					<div class="accordion ac" id="accordion2">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
									Login
								</a>
							</div><!-- /accordion-heading -->
							<div id="collapseOne" class="accordion-body collapse in">
								<div class="accordion-inner">
									<p>Login to your JocolateManager Account to enjoy the automated synchronisation of your bills, packages and chocolates.</p>
								</div><!-- /accordion-inner -->
							</div><!-- /collapse -->
						</div><!-- /accordion-group -->
						<br>

						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
									Bill's
								</a>
							</div>
							<div id="collapseTwo" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>All your bill's are in one window. Easy to view and synchronized on every pc.</p>
								</div><!-- /accordion-inner -->
							</div><!-- /collapse -->
						</div><!-- /accordion-group -->
						<br>

						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
									Awesome Support
								</a>
							</div>
							<div id="collapseThree" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>If you have a problem with our awesome application, contact us at every time. We will help you!</p>
								</div><!-- /accordion-inner -->
							</div><!-- /collapse -->
						</div><!-- /accordion-group -->
						<br>

						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
									Responsive Design
								</a>
							</div>
							<div id="collapseFour" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>One big aspect for us was to create a user-friendly, response and clean design that fits best for our JocolateManager.</p>
								</div><!-- /accordion-inner -->
							</div><!-- /collapse -->
						</div><!-- /accordion-group -->
						<br>			
					</div><!-- Accordion -->
				</div>
			</div>
		</div><!--/ .container -->
	</div><!--/ #features -->


	<section id="showcase" name="showcase"></section>
	<div id="showcase">
		<div class="container">
			<div class="row">
				<h1 class="centered">Some Screenshots</h1>
				<br>
				<div class="col-lg-8 col-lg-offset-2">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
							<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="<?php echo base_url(); ?>assets/img/item-01.png" alt="">
							</div>
							<div class="item">
								<img src="<?php echo base_url(); ?>assets/img/item-02.png" alt="">
							</div>
							<div class="item">
								<img src="<?php echo base_url(); ?>assets/img/item-02.png" alt="">
							</div>
							<div class="item">
								<img src="<?php echo base_url(); ?>assets/img/item-02.png" alt="">
							</div>
							<div class="item">
								<img src="<?php echo base_url(); ?>assets/img/item-02.png" alt="">
							</div>
							<div class="item">
								<img src="<?php echo base_url(); ?>assets/img/item-02.png" alt="">
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<br>
			<br>	
		</div><!-- /container -->
	</div>	


	<section id="contact" name="contact"></section>
	<div id="footerwrap">
		<div class="container">
			<div class="col-lg-5">
				<h3>Address</h3>
				<p>
					Grazer Straße 202<br/>
					8430 Kaindorf an der Sulm,<br/>
					Österreich
				</p>
			</div>

			<div class="col-lg-7">
				<h3>Drop Us A Line</h3>
				<br>
				<?php echo form_open('main/contact'); ?>
				<div class="form-group">
					<label for="name1">Your Name</label>
					<input type="name" name="contact_name" class="form-control" id="name1" placeholder="Your Name">
				</div>
				<div class="form-group">
					<label for="email1">Email address</label>
					<input type="email" name="contact_email" class="form-control" id="email1" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label>Your Text</label>
					<textarea class="form-control" name="contact_message" rows="3" id="message"></textarea>
				</div>
				<br>
				<button type="submit" class="btn btn-large btn-success">SUBMIT</button>
			</form>
		</div>
	</div>
</div>
<div id="c">
	<div class="container">
		<p>Created by <a href="http://petritzdesigns.at">jCorn Development</a></p>

	</div>
</div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<?php echo base_url(); ?>assets/js/bootstrap.js"></script>
        <script>
        	$('.carousel').carousel({
        		interval: 3500
        	})
        </script>
    </body>
    </html>
