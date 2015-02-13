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
        $this->load->template('welcome_message');
    }
    
    public function login() {
        $this->load->library('Crypt');
        $crypt = new Crypt();
        
        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        $email = $crypt->decrypt($this->input->get('email', TRUE));
        $password = $crypt->decrypt($this->input->get('pwd', TRUE));
        if($this->user->login($email, $password)) {
            //Success
            $xml->addNode('login', 'Success');
        } else {
            //Failure
            $xml->addNode('login', 'Failure');
        }
        $xml->getXml(true);
    }
    
    public function register() {
        $this->load->library('Crypt');
        $crypt = new Crypt();
        
        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();
        
        $email = $crypt->decrypt($this->input->get('email', TRUE));
        $password = $crypt->decrypt($this->input->get('pwd', TRUE));
        if($this->user->register($email, $password)) {
            //Success
            $xml->addNode('register', 'Success');
        } else {
            //Failure
            $xml->addNode('register', 'Failure');
        }
        $xml->getXml(true);
    }
    
    public function logout() {
        $this->user->logout();
    }
}
