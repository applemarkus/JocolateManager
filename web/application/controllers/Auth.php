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
class Auth extends CI_Controller {

    public function __construct() {
        parent::__construct();
    }

    public function index() {
        if ($this->session->userdata('logged_in')) {
            redirect('main/index', 'refresh');
        }
        else {
            redirect('auth/login', 'refresh');
        }
    }

    public function login() {
        $this->load->template('login_view');
    }

    public function logout() {
        $this->user->logout();
        redirect('main/index', 'refresh');
    }
    
    public function register() {
        $this->load->template('register_view');
    }
    
    public function verifyLogin() {
        $this->load->library('form_validation');

        $this->form_validation->set_rules('email', 'Email', 'required|valid_email');
        $this->form_validation->set_rules('password', 'Password', 'required|callback_check');

        if ($this->form_validation->run() == FALSE) {
            $data['email'] = $this->input->post('email');
            $this->load->template('login_view', $data);
        } else {
            redirect('main/index', 'refresh');
        }
    }
    
    public function verifyRegister() {
        $this->load->library('form_validation');

        $this->form_validation->set_rules('email', 'Email', 'required|valid_email');
        $this->form_validation->set_rules('password', 'Password', 'required');

        if ($this->form_validation->run() == FALSE) {
            $this->load->template('login_view');
        } else {
            $this->user->register($this->input->post('email'), $this->input->post('password'), TRUE);
            redirect('main/index', 'refresh');
        }
    }
    
    public function check($password) {
        $email = $this->input->post('email');

        if ($this->user->login($email, $password)) {
            return TRUE;
        } else {
            $this->form_validation->set_message('check', 'Invalid Email or Password');
            return FALSE;
        }
    }
}
