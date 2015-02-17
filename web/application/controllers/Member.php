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
class Member extends CI_Controller {

    public function __construct() {
        parent::__construct();
    }

    public function index() {
        if ($this->session->userdata('logged_in')) {
            $data['email'] = $this->session->userdata('user_email');
            $user = $this->user->get_user($this->user->get_id($this->session->userdata('user_email')));
            $data['name'] = $user['name'];
            $this->load->template('home_view', $data);
        }
        else {
            redirect('auth/login', 'refresh');
        }
    }

    public function profile() {
        $this->load->template('profile_view');
    }

    public function bills() {
        $this->load->template('bills_view');
    }

    public function packages() {
        $this->load->template('packages_view');
    }
}
