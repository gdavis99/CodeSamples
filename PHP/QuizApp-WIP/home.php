<?php
require_once("classes/QuizTemplate.php");
require_once("includes.php");

//Checks if the user is logged in 
if(!isset($_SESSION['isLoggedIn']) || $_SESSION['isLoggedIn'] == false){
    die(header("Location: " . LOGIN_PAGE));
}

$page = new QuizTemplate("Home Page");
$page->addHeadElement('<link rel="stylesheet" href="styles/home.css">');
$page->finalizeTopSection();
$page->finalizeBottomSection();

print $page->getTopSection();
print '<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
<header class="masthead mb-auto">
  <div class="inner">
    <h3 class="masthead-brand">Quiz App</h3>
    <nav class="nav nav-masthead justify-content-center">
      <a class="nav-link active" href="home.php">Home</a>
      <a class="nav-link active" href="quiz.php">Quiz</a>
    </nav>
  </div>
</header>
<main role="main" class="inner cover">
  <h1 class="cover-heading">You are logged in: ' . $_SESSION['username'] .'</h1>
  
  <form class="lead" action="login.php">
    <button class="btn btn-lg btn-secondary" type="submit">Log Out</button>
  </form>
</main>

<footer class="mastfoot mt-auto">
  
</footer>
</div>' . "\n";
print $page->getBottomSection();