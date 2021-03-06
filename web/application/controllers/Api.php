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
        $error = "";

        try {
            $email = $crypt->decrypt($this->get_input('email'));
            $password = $crypt->decrypt($this->get_input('pwd'));
            $id = $this->get_input('id');

            if ($this->user->login($email, $password)) {
                $this->get_bill_data($id);
            } else {
                $error = "Login failed.";
            }
        } catch (Exception $exc) {
            $error = $exc->getMessage();
        } finally {
            //display error, even if none
            if (!$error == "") {
                show_error($error);
            }
        }
    }

    public function packages() {
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

                $xml->startBranch('packages');
                $this->createPackages($xml, $email);
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

    public function package() {
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
                $xml->addNode(LOGIN, SUCCESS);
                $this->get_package_status($xml, $id);
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
        $count = $query->num_rows() + 1;

        $sql = "INSERT INTO `$this->bill_table`(`bill_id`, `user_id`, `bill_name`, `bill_date`, `bill_data`) VALUES (?,?,?,?,?)";
        if (!$this->db->query($sql, array('', $user_id, 'Bill #' . $count, date('c'), $bill))) {
            return false;
        }

        $this->create_package($email);

        return true;
    }

    private function get_bill_data($id) {
        $sql = "SELECT * FROM $this->bill_table WHERE bill_id = '$id'";
        $query = $this->db->query($sql);

        if ($query->num_rows() == 1) {
            $this->parse_xml($query->row()->bill_data, $query->row()->bill_name);
        } else {
            throw new Exception("There are bills with the same id!");
        }
    }

    private function parse_xml($xml_data, $bill_name) {
        $this->load->library('parser');
        $xml = new SimpleXMLElement($xml_data);

        $name = $xml->Details[0]->name;
        $firstName = $xml->Details[0]->firstName;
        $email = $xml->Details[0]->email;
        $phone = $xml->Details[0]->phone;
        $street = $xml->Details[0]->street;
        $streetNumber = $xml->Details[0]->streetNumber;
        $zipCode = $xml->Details[0]->zipCode;
        $city = $xml->Details[0]->city;
        $country = $xml->Details[0]->country;
        $cardNumber = $xml->Details[0]->cardNumber;
        $expires = $xml->Details[0]->expires;
        $securityCode = $xml->Details[0]->securityCode;

        $date_o = $xml->Details[0]->date;
        $date = date('d.m.Y H:i', intval($date_o));
        $price = 0.00;

        $shopping_items = array();
        foreach ($xml->ShoppingCart[0]->ShoppingCartItem as $item) {
            $price += doubleval(str_replace(',', '.', $item->price));
            array_push($shopping_items, array(
                'name' => $item->name,
                'type' => $item->type,
                'size' => $item->size,
                'logo' => $item->logo,
                'amount' => $item->amount,
                'price' => '€ ' . $item->price
            ));
        }

        $data = array(
            'bill_name' => $bill_name,
            'name' => $name,
            'firstName' => $firstName,
            'email' => $email,
            'phone' => $phone,
            'street' => $street,
            'streetNumber' => $streetNumber,
            'zipCode' => $zipCode,
            'city' => $city,
            'country' => $country,
            'cardNumber' => $cardNumber,
            'expires' => $expires,
            'securityCode' => $securityCode,
            'date' => $date,
            'price' => '€ ' . number_format($price, 2, ',', '.'),
            'shopping_items' => $shopping_items
        );
        $this->parser->parse('bill_view', $data);
    }

    private function createBills(Xml_writer $xml, $email) {
        $user_id = $this->email_to_userid($email);
        $sql = "SELECT `bill_id`, `bill_name`, `bill_date` FROM `$this->bill_table` WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);

        if ($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
                $xml->startBranch(BILL);
                $xml->addNode('id', $row->bill_id);
                $xml->addNode('name', $row->bill_name);
                $xml->addNode('date', $row->bill_date);
                $xml->endBranch();
            }
        }
    }

    private function createPackages(Xml_writer $xml, $email) {
        $user_id = $this->email_to_userid($email);
        $sql = "SELECT * FROM `packages` WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);

        if ($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
                $xml->startBranch(BILL);
                $xml->addNode('id', $row->package_id);
                $xml->addNode('name', $row->package_name);
                $xml->addNode('date', $row->package_date);
                $xml->endBranch();
            }
        }
    }

    private function get_package_status(Xml_writer $xml, $id) {
        $this->update_package_status($id);
        $sql = "SELECT package_status FROM `packages` WHERE package_id = '$id'";
        $query = $this->db->query($sql);
        $status = $query->row()->package_status;
        $xml->addNode('status', $status);
    }

    private function update_package_status($id) {
        $sql = "SELECT package_date FROM packages WHERE package_id = '$id'";
        $query = $this->db->query($sql);
        $date_raw = $query->row()->package_date;
        $timestamp = strtotime($date_raw);
        
        // 0: Nothing | 1: Check | 2: Packaging | 3: Send | 4: Receive
        // 0... immediately
        // 1... after 10 seconds
        // 2... after 5 minutes
        // 3... after 20 minutes
        // 4... after 1 hour
        
        $status = 0;
        
        $status_1 = strtotime("+10 seconds", $timestamp);
        $status_2 = strtotime("+5 minutes", $timestamp);
        $status_3 = strtotime("+20 minutes", $timestamp);
        $status_4 = strtotime("+1 hour", $timestamp);
        
        $now = time();
        if($now <= $timestamp) {
            $status = 0;
        } else if($now >= $timestamp && $now < $status_1) {
            $status = 0;
        } else if($now >= $timestamp && $now < $status_2) {
            $status = 1;
        } else if($now >= $timestamp && $now < $status_3) {
            $status = 2;
        } else if($now >= $timestamp && $now < $status_4) {
            $status = 3;
        } else if($now >= $timestamp && $now >= $status_4) {
            $status = 4;
        }
        
        //update
        $sql = "UPDATE `packages` SET `package_status`= '$status' WHERE `package_id` = '$id'";
        $this->db->query($sql);
    }

    private function create_package($email) {
        $user_id = $this->email_to_userid($email);
        $sql = "SELECT * FROM packages WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);
        $count = $query->num_rows() + 1;

        $sql = "INSERT INTO `packages`(`package_id`, `user_id`, `package_name`, `package_date`, `package_status`) VALUES (?,?,?,?,?)";
        if (!$this->db->query($sql, array('', $user_id, 'Package #' . $count, date('c'), '0'))) {
            return false;
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
        if ($query->num_rows() == 1) {
            return $query->row()->user_id;
        } else {
            throw new Exception("There are users with the same email!");
        }
    }

}
