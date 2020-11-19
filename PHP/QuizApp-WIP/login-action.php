<?php
require_once("includes.php");

//User Info Verification logic
$users = array('gabe' => '$2y$10$E1UJoyySSUB4WCi8sJZ.NeZPhCBPz3DBMDu6MMPefj6jKPlP/bLFe',
                'admin' => '$2y$10$kwPLMLFN1JsymNaXQ8CdqOF97f8D4t3.lcYSJpB8.S5j3KBp8Wup6');

$_SESSION['errors'] = array();
$required = array("username", "pass");
$isLoggedIn = false;

foreach ($required as $key => $value){
    if(!isset($_POST[$value])){
        $_SESSION['errors'][] = "Form must be filled";
        die(header("Location: ". LOGIN_PAGE));
    }
}

if(array_key_exists($_POST['username'], $users)){
    $userPass = $_POST['pass'];
    $dbPass = $users[$_POST['username']];
    
    if(password_verify($userPass, $dbPass) === true){
        $isLoggedIn = true;

        $_SESSION['username'] = strip_tags($_POST['username']);

    $_SESSION['isLoggedIn'] = true;
    die(header("Location: " . HOME_PAGE));
    }
}

$_SESSION['errors'][] = "Invalid password or user not found";
die(header("Location: " . LOGIN_PAGE));