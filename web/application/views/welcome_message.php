<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h1>Welcome.</h1>

<div id="body">
    <p>Jocolate Manger Web API</p>
    <h2>Documentation</h2>
    <p>Everything in [ ] is encrypted. Everything in ( ) not. <a href="<?php echo base_url(); ?>index.php/api/login/?email=990f04d9c5327481a7af01111bdf32f0&pwd=b0e08a6df167ab1f243caa5eb1b7f2ac">Simple Login</a></p>
    <hr>
    <a href="#lo-in-out">Login/Logout/Register</a>
    <a href="#bill">Bill</a>
    <a href="#packages">Packages</a>
    <hr>
    <section id="lo-in-out">
        <h3>Login/Logout/Register</h3>

        <p>To access the API, you have to login:</p>
        <code>/api/login/?email=[email]&pwd=[password]</code>

        <p>Register:</p>
        <code>/api/register/?email=[email]&pwd=[password]</code>

        <p>And you can even logout:</p>
        <code>/api/logout</code>
    </section>
    <section id="bill">
        <h3>Incoming Bill</h3>
        
        <p>Store bill in database</p>
        <code>/api/incomingBill/?email=[email]&pwd=[password]<strong>&bill=[bill]</strong></code>
        
        <p>Get bills</p>
        <code>/api/bills/?email=[email]&pwd=[password]</code>
        
        <p>Get specific bill as html</p>
        <code>/api/bill/?email=[email]&pwd=[password]<strong>&id=(bill_id)</strong></code>
    </section>
    <section id="packages">
        <h3>Packages (Delivery Status)</h3>
        
        <p>Get packages</p>
        <code>/api/packages/?email=[email]&pwd=[password]</code>
        
        <p>Get specific package</p>
        <code>/api/package/?email=[email]&pwd=[password]<strong>&id=(package_id)</strong></code>
    </section>
</div>