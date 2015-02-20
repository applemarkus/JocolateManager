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
        } else if(!$this->user->is_admin()) {
        	show_error("You do not have permissions to view this site!");
        }
    }

    public function index() {
        $this->load->library('parser');
        $sql = "SELECT * FROM `users`";
        $query = $this->db->query($sql);

        $members = array();

        if ($query->num_rows() > 0) {
            foreach ($query->result() as $row) {
            	if($row->user_agent_string == "JocolateManager/1.0") {
            		$browser = "JocolateManager";
            		$platform = "Unknown";
            	} else {
            		$this->agent->parse($row->user_agent_string);
            		$browser = $this->agent->browser();
            		$platform = $this->agent->platform();
            	}
            	
                array_push($members, array(
                    'id' => $row->user_id,
                    'name' => $row->user_name,
                    'email' => $row->user_email,
                    'admin' => (($row->admin == "0")?"false":"true"),
                    'last_login' => date('d.m.Y H:m', strtotime($row->user_last_login)),
                    'ip' => $row->user_ip,
                    'browser' => $browser,
                    'platform' => $platform,
                ));
            }
        }

        $data = array(
            'members' => $members
        );

        $this->load->view("template/header");
        $this->parser->parse('admin/admin_view', $data);
        $this->load->view("template/footer");
    }

    public function backup() {
        $this->load->dbutil();
        $this->load->helper('file');
        $this->load->helper('download');

        $prefs = array(
            'format'        => 'zip',
            'filename'      => 'backup_jocolate_manager.sql',
        );

        $backup =& $this->dbutil->backup($prefs);
        write_file('backups/backup_'.date('d.m.Y.h.m.i').'.zip', $backup);
        force_download('backup_jocolate_manager.zip', $backup);
    }

    public function profile($id) {
    	$user = $this->user->get_user($id);
        $data['name'] = $user['name'];
        $data['email'] = $user['email'];
        $data['bills'] = $user['bills'];
        $data['packages'] = $user['packages'];
        $data['ip'] = $user['ip'];
        $data['last_login'] = $this->ago_string(strtotime($user['last_login']))." ago";
        
        if($user['user_agent'] == "JocolateManager/1.0") {
        	$data['os'] = "Unknown";
        	$data['browser'] = "JocolateManager";
        } else {
        	$this->agent->parse($user['user_agent']);
        	$data['os'] = $this->agent->platform();
        	$data['browser'] = $this->agent->browser();
        }

        $this->load->template('admin/profile_view', $data);
    }

    public function profile_delete($id) {
    	$this->user->delete($id);
    	redirect('admin/index', 'refresh');
    }

    public function register() {
    	$this->load->template('admin/register_view');
    }

    public function verifyRegister() {
        $this->load->library('form_validation');

        $this->form_validation->set_rules('user_name', 'Name', 'required');
        $this->form_validation->set_rules('email', 'Email', 'required|valid_email');
        $this->form_validation->set_rules('password', 'Password', 'required');

        if ($this->form_validation->run() == FALSE) {
            $this->load->template('admin/register_view');
        } else {
            $this->user->register($this->input->post('user_name'), $this->input->post('email'), $this->input->post('password'), FALSE);
            $data['info'] = "Successfully registered: ".$this->input->post('user_name');
            $this->load->template('admin/register_view', $data);
        }
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