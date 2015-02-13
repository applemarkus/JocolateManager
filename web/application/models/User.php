<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require_once('phpass-0.3/PasswordHash.php');

define('PHPASS_HASH_STRENGTH', 8);
define('PHPASS_HASH_PORTABLE', false);

class User extends CI_Model {

    var $CI;
    var $user_table = 'users';

    function __construct() {
        parent::__construct();
    }

    function register($user_email = '', $user_pass = '', $auto_login = true) {
        $this->CI = & get_instance();

        if ($user_email == '' OR $user_pass == '') {
            return false;
        }

        $this->CI->db->where('user_email', $user_email);
        $query = $this->CI->db->get_where($this->user_table);

        if ($query->num_rows() > 0) {
            return false;
        }

        $hasher = new PasswordHash(PHPASS_HASH_STRENGTH, PHPASS_HASH_PORTABLE);
        $user_pass_hashed = $hasher->HashPassword($user_pass);

        $data = array(
            'user_email' => $user_email,
            'user_pass' => $user_pass_hashed,
            'user_date' => date('c'),
            'user_modified' => date('c'),
        );

        $this->CI->db->set($data);

        if (!$this->CI->db->insert($this->user_table)) {
            return false;
        }

        if ($auto_login) {
            $this->login($user_email, $user_pass);
        }

        return true;
    }

    function update($user_id = null, $user_email = '', $auto_login = true) {
        $this->CI = & get_instance();

        if ($user_id == null OR $user_email == '') {
            return false;
        }

        $this->CI->db->where('user_id', $user_id);
        $query = $this->CI->db->get_where($this->user_table);

        if ($query->num_rows() == 0) {
            return false;
        }

        $data = array(
            'user_email' => $user_email,
            'user_modified' => date('c'),
        );

        $this->CI->db->where('user_id', $user_id);

        if (!$this->CI->db->update($this->user_table, $data)) {
            return false;
        }

        if ($auto_login) {
            $user_data['user_email'] = $user_email;
            $user_data['user'] = $user_data['user_email'];

            $this->CI->session->set_userdata($user_data);
        }
        return true;
    }

    function login($user_email = '', $user_pass = '') {
        $this->CI = & get_instance();

        if ($user_email == '' OR $user_pass == '') {
            return false;
        }

        if ($this->CI->session->userdata('user_email') == $user_email) {
            return true;
        }

        $this->CI->db->where('user_email', $user_email);
        $query = $this->CI->db->get_where($this->user_table);


        if ($query->num_rows() > 0) {
            $user_data = $query->row_array();

            $hasher = new PasswordHash(PHPASS_HASH_STRENGTH, PHPASS_HASH_PORTABLE);

            if (!$hasher->CheckPassword($user_pass, $user_data['user_pass'])) {
                return false;
            }

            $this->CI->session->sess_destroy();

            $this->CI->session->sess_create();

            $this->CI->db->simple_query('UPDATE ' . $this->user_table . ' SET user_last_login = "' . date('c') . '" WHERE user_id = ' . $user_data['user_id']);

            //Set session data
            unset($user_data['user_pass']);
            $user_data['user'] = $user_data['user_email'];
            $user_data['logged_in'] = true;
            $this->CI->session->set_userdata($user_data);

            return true;
        }
        else {
            return false;
        }
    }

    function logout() {
        $this->CI = & get_instance();

        $this->CI->session->sess_destroy();
    }

    function delete($user_id) {
        $this->CI = & get_instance();

        if (!is_numeric($user_id)) {
            return false;
        }

        return $this->CI->db->delete($this->user_table, array('user_id' => $user_id));
    }

    function edit_password($user_email = '', $old_pass = '', $new_pass = '') {
        $this->CI = & get_instance();

        $this->CI->db->select('user_pass');
        $query = $this->CI->db->get_where($this->user_table, array('user_email' => $user_email));
        $user_data = $query->row_array();

        $hasher = new PasswordHash(PHPASS_HASH_STRENGTH, PHPASS_HASH_PORTABLE);
        if (!$hasher->CheckPassword($old_pass, $user_data['user_pass'])) { //old_pass is the same
            return FALSE;
        }

        $user_pass_hashed = $hasher->HashPassword($new_pass);
        $data = array(
            'user_pass' => $user_pass_hashed,
            'user_modified' => date('c')
        );

        $this->CI->db->set($data);
        $this->CI->db->where('user_email', $user_email);
        if (!$this->CI->db->update($this->user_table, $data)) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

}
