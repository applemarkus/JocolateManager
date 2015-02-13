<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require_once('phpass-0.3/PasswordHash.php');

define('PHPASS_HASH_STRENGTH', 8);
define('PHPASS_HASH_PORTABLE', false);

class User extends CI_Model {

    var $user_table = 'users';

    function __construct() {
        parent::__construct();
    }

    function register($user_email = '', $user_pass = '', $auto_login = true) {
        if ($user_email == '' OR $user_pass == '') {
            return false;
        }

        $this->db->where('user_email', $user_email);
        $query = $this->db->get_where($this->user_table);

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

        $this->db->set($data);

        if (!$this->db->insert($this->user_table)) {
            return false;
        }

        if ($auto_login) {
            $this->login($user_email, $user_pass);
        }

        return true;
    }

    function update($user_id = null, $user_email = '', $auto_login = true) {
        if ($user_id == null OR $user_email == '') {
            return false;
        }

        $this->db->where('user_id', $user_id);
        $query = $this->db->get_where($this->user_table);

        if ($query->num_rows() == 0) {
            return false;
        }

        $data = array(
            'user_email' => $user_email,
            'user_modified' => date('c'),
        );

        $this->db->where('user_id', $user_id);

        if (!$this->db->update($this->user_table, $data)) {
            return false;
        }

        if ($auto_login) {
            $user_data['user_email'] = $user_email;
            $user_data['user'] = $user_data['user_email'];

            $this->session->set_userdata($user_data);
        }
        return true;
    }

    function login($user_email = '', $user_pass = '') {
        if ($user_email == '' OR $user_pass == '') {
            return false;
        }

        if ($this->session->userdata('user_email') == $user_email) {
            return true;
        }

        $this->db->where('user_email', $user_email);
        $query = $this->db->get_where($this->user_table);


        if ($query->num_rows() > 0) {
            $user_data = $query->row_array();

            $hasher = new PasswordHash(PHPASS_HASH_STRENGTH, PHPASS_HASH_PORTABLE);

            if (!$hasher->CheckPassword($user_pass, $user_data['user_pass'])) {
                return false;
            }

            $this->session->sess_destroy();
            //$this->session->sess_create();
            session_start();
            $this->db->simple_query('UPDATE ' . $this->user_table . ' SET user_last_login = "' . date('c') . '" WHERE user_id = ' . $user_data['user_id']);

            unset($user_data['user_pass']);
            $user_data['user'] = $user_data['user_email'];
            $user_data['logged_in'] = true;
            $this->session->set_userdata($user_data);

            return true;
        } else {
            return false;
        }
    }

    function logout() {
        $this->session->unset_userdata('logged_in');
        $this->session->sess_destroy();
    }

    function delete($user_id) {
        if (!is_numeric($user_id)) {
            return false;
        }

        return $this->db->delete($this->user_table, array('user_id' => $user_id));
    }

    function edit_password($user_email = '', $old_pass = '', $new_pass = '') {
        $this->db->select('user_pass');
        $query = $this->db->get_where($this->user_table, array('user_email' => $user_email));
        $user_data = $query->row_array();

        $hasher = new PasswordHash(PHPASS_HASH_STRENGTH, PHPASS_HASH_PORTABLE);
        if (!$hasher->CheckPassword($old_pass, $user_data['user_pass'])) {
            return FALSE;
        }

        $user_pass_hashed = $hasher->HashPassword($new_pass);
        $data = array(
            'user_pass' => $user_pass_hashed,
            'user_modified' => date('c')
        );

        $this->db->set($data);
        $this->db->where('user_email', $user_email);
        if (!$this->db->update($this->user_table, $data)) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

}