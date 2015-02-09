<?php

require_once 'XML_creator.php';

class LoginManager {

    private $xml;

    public function __construct() {
        $this->xml = new XMLCreator();
    }

    public function login($username, $password) {
        $array = array();
        $array['message'] = 'Success';
        return json_encode($array);
    }

}
