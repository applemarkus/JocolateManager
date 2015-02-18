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

    public function __construct() {
        parent::__construct();
    }

    public function index() {
        $this->load->helper('form_helper');
        $this->load->view('landing_page');
    }

    public function contact() {
        $name = $this->input->post('contact_name');
        $email = $this->input->post('contact_email');
        $message = $this->input->post('contact_message');

        $this->load->library('email');

        $this->email->from('info@petritzdesigns.at', 'Info Service - PD');
        $this->email->to('jcorn.dev@gmail.com');
        $this->email->bcc('applemarkus@me.com');

        $this->email->subject('New Contact - JocolateManager');
        $this->email->message('New JocolateManager Contact' . "\n" .
                'Name: ' . $name . "\n" .
                'Email: ' . $email . "\n" .
                'Message: ' . $message . "\n\n" .
                'Automated Service');

        $this->email->send();

        redirect('main/index', 'refresh');
    }

}
