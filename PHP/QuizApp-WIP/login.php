<?php

require_once("classes/QuizTemplate.php");
require_once("includes.php");

$page = new QuizTemplate("Login Page");
$page->addHeadElement('<link rel="stylesheet" href="styles/login.css">');
$page->finalizeTopSection();
$page->finalizeBottomSection();

print $page->getTopSection();
print '<form class="form-signin" action="login-action.php" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1><br>';

if(isset($_SESSION['errors'])){
    foreach ($_SESSION['errors'] as $value) {
        print '<p class="font-weight-normal">Error: ' . $value . "</p> <br>";
    }
    $_SESSION['errors'] = '';
    unset($_SESSION['errors']);
}

print    '<label for="username" class="sr-only">Username</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
    <label for="pass" class="sr-only">Password</label>
    <input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">Users:(gabe,pass1) (admin,pass2)</p>
</form>' . "\n";
print $page->getBottomSection();