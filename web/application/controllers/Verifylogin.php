<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class VerifyLogin extends CI_Controller {

    public function __construct() {
        parent::__construct();
        //$this->load->model('user', '', TRUE);
    }

    public function index() {
        $this->load->library('form_validation');

        $this->form_validation->set_rules('username', 'Username', 'required|valid_email');
        $this->form_validation->set_rules('password', 'Password', 'required|callback_check');

        if ($this->form_validation->run() == FALSE) {
            $this->load->template('login_view');
        } else {
            redirect('main/index', 'refresh');
        }
    }

    public function check($password) {
        $username = $this->input->post('username');

        $result = $this->user->login($username, $password);

        if ($result) {
            $sess_array = array();
            foreach ($result as $row) {
                $sess_array = array(
                    'id' => $row->id,
                    'username' => $row->username
                );
                $this->session->set_userdata('logged_in', $sess_array);
            }
            return TRUE;
        } else {
            $this->form_validation->set_message('check', 'Invalid Username or Password');
            return false;
        }
    }

}
