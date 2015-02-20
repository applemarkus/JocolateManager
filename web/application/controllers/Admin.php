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
class Admin extends CI_Controller {

    public function __construct() {
        parent::__construct();
        if (!$this->session->userdata('logged_in')) {
            $this->session->set_userdata('last_page', uri_string());
            redirect('auth/login', 'refresh');
        }
    }

    public function index() {
        $this->load->template('admin_view');
    }

    public function profile($id) {
    	$user = $this->user->get_user($id);
        $data['name'] = $user['name'];
        $data['email'] = $user['email'];
        $data['bills'] = $user['bills'];
        $data['packages'] = $user['packages'];
        $data['ip'] = $user['ip'];
        $data['last_login'] = $this->ago_string(strtotime($user['last_login']))." ago";
        $this->agent->parse($user['user_agent']);
        $data['os'] = $this->agent->platform();
        $data['browser'] = $this->agent->browser();
        $this->load->template('profile_view', $data);
    }

    private function ago_string($time) {
        $time = time() - $time;
        $tokens = array (
            31536000 => 'year',
            2592000 => 'month',
            604800 => 'week',
            86400 => 'day',
            3600 => 'hour',
            60 => 'minute',
            1 => 'second'
        );
        foreach ($tokens as $unit => $text) {
            if ($time < $unit) continue;
            $numberOfUnits = floor($time / $unit);
            return $numberOfUnits.' '.$text.(($numberOfUnits>1)?'s':'');
        }
    }

}