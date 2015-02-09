<?php

/*
 * Simple Jocolate Manager Web
 * ===========================
 * by Markus Petritz
 */

require_once 'login_manager.php';
require_once 'XML_creator.php';

$xml = new XMLCreator();

//Function
if(isset($_GET['action'])){
    $action = $_GET['action'];
    
    switch($action) {
        case "login":
            exit(LoginManager::login($_GET['username'], $_GET['password']));
        default:
            break;
    }
}