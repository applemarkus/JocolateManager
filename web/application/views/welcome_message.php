<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
    <h1>Welcome.</h1>
</div>

<div id="body">
    <p>Jocolate Manger Web API</p>
    <h2>Documentation</h2>
    <p>Everything in [ ] is encrypted. Everything in ( ) not.</p>
    <hr>
    <a href="#lo-in-out" class="btn btn-default">#Login/Logout/Register</a> <br>
    <a href="#bill" class="btn btn-default">#Bill</a> <br>
    <a href="#packages" class="btn btn-default">#Packages</a>
    <hr>
    <section id="lo-in-out">
        <h3>Login/Logout/Register</h3>

        <p>To access the API, you have to login: <code>/api/login/?email=[email]&pwd=[password]</code> <br>
        Register: <code>/api/register/?email=[email]&pwd=[password]</code> <br>
        And you can even logout: <code>/api/logout</code></p>
        
    </section>
    <section id="bill">
        <h3>Incoming Bill</h3>
        
        <p>Store bill in database: <code>/api/incomingBill/?email=[email]&pwd=[password]<strong>&bill=[bill]</strong></code><br>
        Get bills: <code>/api/bills/?email=[email]&pwd=[password]</code><br>
        Get specific bill as html: <code>/api/bill/?email=[email]&pwd=[password]<strong>&id=(bill_id)</strong></code><br></p>
    </section>
    <section id="packages">
        <h3>Packages (Delivery Status)</h3>
        
        <p>Get packages: <code>/api/packages/?email=[email]&pwd=[password]</code><br>
        Get specific package: <code>/api/package/?email=[email]&pwd=[password]<strong>&id=(package_id)</strong></code></p>
    </section>
</div>