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
        if (!$this->session->userdata('logged_in')) {
            redirect('auth/login', 'refresh');
        }
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
        $user_id = $this->user->get_id($this->session->userdata('user_email'));
        $user = $this->user->get_user($user_id);
        $data['name'] = $user['name'];
        $data['email'] = $user['email'];
        $data['last_login'] = date('d.m.Y H:m:i', strtotime($user['last_login']));
        $this->load->template('profile_view', $data);
    }

    public function bills() {
        $this->load->library('parser');

        $email = $this->session->userdata('user_email');
        $user_id = $this->user->get_id($email);
        $sql = "SELECT `bill_id`, `bill_name`, `bill_date` FROM `bills` WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);

        $bill_items = array();

        if ($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
                array_push($bill_items, array(
                    'id' => $row->bill_id,
                    'name' => $row->bill_name,
                    'date' => date('d.m.Y H:m', strtotime($row->bill_date))
                ));
            }
        }

        $data = array(
            'bills' => $bill_items
        );

        $this->load->view("template/header");
        $this->parser->parse('bills_view', $data);
        $this->load->view("template/footer");
    }

    public function bill($id) {
        if(!$this->authorized_for_bill($id)) {
            show_error("You are not authorized to view this bill!");
        }

        $sql = "SELECT * FROM bills WHERE bill_id = '$id'";
        $query = $this->db->query($sql);

        if ($query->num_rows() == 1) {
            $this->parse_xml($query->row()->bill_data, $query->row()->bill_name);
        } else {
            show_error("Wrong id...");
        }
    }

    private function authorized_for_bill($id) {
        $email = $this->session->userdata('user_email');
        $sql = "SELECT user_id FROM bills WHERE bill_id = '$id'";
        $query = $this->db->query($sql);
        if($query->num_rows() == 0) {
            show_error("Wrong id...");
            return false;
        }
        $user_id_bill = $query->row()->user_id;
        $user_id_real = $this->user->get_id($email);
        if($user_id_real == $user_id_bill) {
            return true;
        } else {
            return false;
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

    public function packages() {
        $this->load->library('parser');

        $email = $this->session->userdata('user_email');
        $user_id = $this->user->get_id($email);
        $sql = "SELECT `package_id`, `package_name`, `package_date` FROM `packages` WHERE user_id = '$user_id'";
        $query = $this->db->query($sql);

        $package_item = array();

        if ($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
                array_push($package_item, array(
                    'id' => $row->package_id,
                    'name' => $row->package_name,
                    'date' => date('d.m.Y H:m', strtotime($row->package_date))
                ));
            }
        } else {
            array_push($package_item, array(
                    'id' => '',
                    'name' => 'No packages available...',
                    'date' => ''
                ));
        }

        $data = array(
            'packages' => $package_item
        );

        $this->load->view("template/header");
        $this->parser->parse('packages_view', $data);
        $this->load->view("template/footer");
    }

    public function package($id) {
        $this->load->library('parser');

        if(!$this->authorized_for_package($id)) {
            show_error("You are not authorized to view this package!");
        }

        $this->update_package_status($id);

        $sql = "SELECT * FROM packages WHERE package_id = '$id'";
        $query = $this->db->query($sql);

        if ($query->num_rows() == 1) {
            
            $row = $query->row();
            $status = "In Order...";
            $status_o = $row->package_status;
            $status_i = intval($status_o);
            switch($status_i) {
                case 0:
                    break;
                case 1:
                    $status = "Checking...";
                    break;
                case 2:
                    $status = "Packaging...";
                    break;
                case 3:
                    $status = "Sending...";
                    break;
                case 4:
                    $status = "Receiving...";
                    break;
                default:
                    break;
            }
            $data = array(
                'name' => $row->package_name,
                'date' => date('d.m.Y H:m:i', strtotime($row->package_date)),
                'status' => $status
            );

            $this->parser->parse('package_view', $data);

        } else {
            show_error("Wrong id...");
        }
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


    private function authorized_for_package($id) {
        $email = $this->session->userdata('user_email');
        $sql = "SELECT user_id FROM packages WHERE package_id = '$id'";
        $query = $this->db->query($sql);
        if($query->num_rows() == 0) {
            show_error("Wrong id...");
            return false;
        }
        $user_id_bill = $query->row()->user_id;
        $user_id_real = $this->user->get_id($email);
        if($user_id_real == $user_id_bill) {
            return true;
        } else {
            return false;
        }
    }
}
