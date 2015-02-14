<?php

defined('BASEPATH') OR exit('No direct script access allowed');

define("LOGIN", 'login');
define("REGISTER", 'register');
define("BILL", 'bill');
define("ERROR", 'error');

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

    private $error;

    public function __construct() {
        parent::__construct();
        $this->error = "";
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

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));

            if ($this->user->login($email, $password)) {
                //Success
                $xml->addNode(LOGIN, 'Success');
            } else {
                //Failure
                $xml->addNode(LOGIN, 'Failure');
            }
        } catch (Exception $exc) {
            $xml->addNode(ERROR, $exc->getMessage());
        }

        $xml->getXml(true);
    }

    public function register() {
        $this->load->library('Crypt');
        $crypt = new Crypt();

        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));

            if ($this->user->register($email, $password)) {
                //Success
                $xml->addNode(REGISTER, 'Success');
            } else {
                //Failure
                $xml->addNode(REGISTER, 'Failure');
            }
        } catch (Exception $exc) {
            $xml->addNode(ERROR, $exc->getMessage());
        }

        $xml->getXml(true);
    }

    public function incomingBill() {
        $this->load->library('Crypt');
        $crypt = new Crypt();

        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));
            $bill = $crypt->decrypt($this->get_input('bill'));

            if ($this->user->login($email, $password)) {
                //Success
                $this->store_bill($bill);
                $xml->addNode(BILL, 'Success');
            } else {
                //Failure
                $xml->addNode(BILL, 'Failure');
            }
        } catch (Exception $exc) {
            $xml->addNode(ERROR, $exc->getMessage());
        }
        
        $xml->getXml(true);
    }

    public function logout() {
        $this->user->logout();
    }

    private function store_bill($bill) {
        $file = fopen("bill.txt", "w");
        fwrite($file, $bill);
        fclose($file);
    }

    private function get_input($name) {
        if (empty($name)) {
            throw new Exception("Empty input!");
        }

        //try GET first
        $input_get = $this->input->get($name, TRUE);
        if (isset($input_get)) {
            return $input_get;
        }

        //then POST
        $input_post = $this->input->post($name, TRUE);
        if (isset($input_post)) {
            return $input_get;
        }

        throw new Exception("Missing input: $name");
    }

}
