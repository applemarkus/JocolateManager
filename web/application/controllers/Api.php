<?php

defined('BASEPATH') OR exit('No direct script access allowed');

define("LOGIN", 'login');
define("REGISTER", 'register');
define("BILL", 'bill');
define("ERROR", 'error');

define("SUCCESS", 'success');
define("FAILURE", 'failure');

define("NONE", 'none');

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
    private $bill_table = "bills";

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

        $error = "none";

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));

            if ($this->user->login($email, $password)) {
                //Success
                $xml->addNode(LOGIN, SUCCESS);
            } else {
                //Failure
                $xml->addNode(LOGIN, FAILURE);
            }
        } catch (Exception $exc) {
            $error = $exc->getMessage();
        } finally {
            //display error, even if none
            $xml->addNode(ERROR, $error);
        }

        $xml->getXml(true);
    }

    public function register() {
        $this->load->library('Crypt');
        $crypt = new Crypt();

        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        $error = "none";

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));

            if ($this->user->register($email, $password)) {
                //Success
                $xml->addNode(REGISTER, SUCCESS);
            } else {
                //Failure
                $xml->addNode(REGISTER, FAILURE);
            }
        } catch (Exception $exc) {
            $error = $exc->getMessage();
        } finally {
            //display error, even if none
            $xml->addNode(ERROR, $error);
        }

        $xml->getXml(true);
    }

    public function incomingBill() {
        $this->load->library('Crypt');
        $crypt = new Crypt();

        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        $error = "none";

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));
            $bill = $crypt->decrypt($this->get_input('bill'));

            if ($this->user->login($email, $password)) {
                //Success
                $xml->addNode(LOGIN, SUCCESS);

                if ($this->store_bill($bill)) {
                    $xml->addNode(BILL, SUCCESS);
                } else {
                    $xml->addNode(BILL, FAILURE);
                }
            } else {
                //Failure
                $xml->addNode(LOGIN, FAILURE);
                $xml->addNode(BILL, FAILURE);
            }
        } catch (Exception $exc) {
            $error = $exc->getMessage();
        } finally {
            //display error, even if none
            $xml->addNode(ERROR, $error);
        }

        $xml->getXml(true);
    }
    
    public function bills() {
        //return bills
    }
    
    public function bill() {
        //return bill at index
    }

    public function logout() {
        $this->user->logout();
    }

    private function store_bill($bill) {
        $count = $this->db->count_all($this->bill_table) + 1;
        
        $sql = "INSERT INTO `$this->bill_table`(`bill_id`, `bill_name`, `bill_date`, `bill_data`) VALUES (?,?,?,?)";
        if(!$this->db->query($sql, array('', 'Bill #'.$count, date('c'), $bill))) {
            return false;
        }
        
        return true;
    }

    private function get_input($name) {
        if (empty($name)) {
            throw new Exception("Empty input!");
        }

        $input = $this->input->post_get($name, TRUE);
        if (isset($input)) {
            return $input;
        }

        throw new Exception("Missing input: $name");
    }

}
