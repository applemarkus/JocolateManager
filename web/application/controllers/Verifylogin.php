<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class VerifyLogin extends CI_Controller {

    public function __construct() {
        parent::__construct();
        $this->load->model('user', '', TRUE);
    }

    public function index() {
        $this->load->library('form_validation');

        $this->form_validation->set_rules('username', 'Username', 'trim|required|xss_clean|is_unique[users.email]');
        $this->form_validation->set_rules('password', 'Password', 'trim|required|xss_clean|callback_database_check');

        if ($this->form_validation->run() == FALSE) {
            $this->load->view('login_view');
        } else {
            redirect('main/index', 'refresh');
        }
    }
    
    public function check_database($password) {
        $this->form_validation->set_message('check_database', 'Yolo');
        return FALSE;
    }
}
