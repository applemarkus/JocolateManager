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

class Main extends CI_Controller {

    public function index() {
        $this->template('welcome_message');
    }

    private function template($view) {
        $this->load->view("template/header.php");
        $this->load->view($view);
        $this->load->view("template/footer.php");
    }
}
