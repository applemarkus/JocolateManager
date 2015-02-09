<?php

class XMLCreator {

    private $XML_Buffer;
    private $ParentName;

    public function __construct() {
        $this->XML_Buffer = '<?xml version="1.0" encoding="utf-8"?>';
    }

    public function createParent($name) {
        $this->ParentName = $name;
        $this->XML_Buffer .= '<' . $this->ParentName . '>';
    }

    public function appendChild($child_name) {
        $this->XML_Buffer .= '<' . $child_name . '>';
    }

    public function finishChild($child_name) {
        $this->XML_Buffer .= '</' . $child_name . '>';
    }

    public function setAttribut($atr_Name, $atr_Value) {
        $this->XML_Buffer .= '<' . $atr_Name . '>' . trim($atr_Value) . '</' . $atr_Name . '>';
    }

    public function finishParent() {
        $this->XML_Buffer .= '</' . $this->ParentName . '>';
        return $this->XML_Buffer;
    }

}
