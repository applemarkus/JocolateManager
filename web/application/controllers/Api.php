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

                if ($this->store_bill($email, $bill)) {
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
                
                $xml->startBranch('bills');
                $this->createBills($xml, $email);
                $xml->endBranch();
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
    
    public function bill() {
        $this->load->library('Crypt');
        $crypt = new Crypt();

        $this->load->library('Xml_writer');
        $xml = new Xml_writer;
        $xml->initiate();

        $error = "none";

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));
            $id = $this->get_input('id');

            if ($this->user->login($email, $password)) {
                //Success
                $xml->addNode(LOGIN, SUCCESS);
                
                $xml->startBranch('bill');
                $xml->addNode('data', $this->get_bill_data($id), '', TRUE);
                $xml->endBranch();
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

    public function logout() {
        $this->user->logout();
    }

    private function store_bill($email, $bill) {
        $user_id = $this->email_to_userid($email);
        $sql = "SELECT * FROM $this->bill_table WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);
        $count = $query->num_rows();
        
        $sql = "INSERT INTO `$this->bill_table`(`bill_id`, `user_id`, `bill_name`, `bill_date`, `bill_data`) VALUES (?,?,?,?,?)";
        if(!$this->db->query($sql, array('', $user_id, 'Bill #'.$count, date('c'), $bill))) {
            return false;
        }
        
        return true;
    }
    
    private function get_bill_data($id) {
        $sql = "SELECT * FROM $this->bill_table WHERE bill_id = '$id'";
        $query = $this->db->query($sql);
        
        if($query->num_rows() == 1) {
            return $this->parse_xml($query->row()->bill_data);
        }
        else {
            throw new Exception("There are bills with the same id!");
        }
    }
    
    private function parse_xml($xml_data) {
        return $xml_data;
    }
    
    private function createBills(Xml_writer $xml, $email) {
        $user_id = $this->email_to_userid($email);
        $sql = "SELECT `bill_id`, `bill_name`, `bill_date` FROM `$this->bill_table` WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);
        
        if($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
                $xml->startBranch(BILL);
                $xml->addNode('id', $row->bill_id);
                $xml->addNode('name', $row->bill_name);
                $xml->addNode('date', $row->bill_date);
                $xml->endBranch();
            }
        }
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
    
    private function email_to_userid($email) {
        $sql = "SELECT user_id FROM users WHERE user_email = '$email'";
        $query = $this->db->query($sql);
        if($query->num_rows() == 1) {
            return $query->row()->user_id;
        }
        else {
            throw new Exception("There are users with the same email!");
        }
    }
}
