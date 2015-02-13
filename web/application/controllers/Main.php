<?php

defined('BASEPATH') OR exit('No direct script access allowed');
//session_start();

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

    public function __construct() {
        parent::__construct();
    }
    
    public function index() {
        if($this->session->userdata('logged_in')) {
            $session_data = $this->session->userdata('logged_in');
            $data['username'] = $session_data['username'];
            $this->load->view('home_view', $data);
        }
        else {
            redirect('main/login', 'refresh');
        }
    }
    
    public function login() {
        $this->load->helper(array('form'));
        $this->load->view('login_view');
    }
    
    public function logout() {
        $this->session->unset_userdata('logged_in');
        session_destroy();
        redirect('main', 'refresh');
    }
}
