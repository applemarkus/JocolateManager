<?php

/*
 * Simple Jocolate Manager Web
 * ===========================
 * by Markus Petritz
 */

require_once 'login_manager.php';

$login = new LoginManager();

//Function
if(isset($_GET['action'])){
    $action = $_GET['action'];
    
    switch($action) {
        case "login":
            exit($login->login($_GET['username'], $_GET['password']));
        default:
            break;
    }
}

?>
