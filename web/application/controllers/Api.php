<?php

defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * JocolateManager
 * Web
 * 
 * @author Markus Petritz
 * @author Julian Maierl
 * @author Paul Kasper
 * @author Tobias Färber
 * 
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */

class Api extends CI_Controller {

    public function __construct() {
        parent::__construct();
    }
    
    public function index() {
        $this->load->view('welcome_message');
    }
}
