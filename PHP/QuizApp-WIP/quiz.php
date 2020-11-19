<?php
require_once("classes/QuizTemplate.php");
require_once("includes.php");

//Checks if the user is logged in 
if(!isset($_SESSION['isLoggedIn']) || $_SESSION['isLoggedIn'] == false){
    die(header("Location: " . LOGIN_PAGE));
}

$page = new QuizTemplate("Home Page");
$page->addHeadElement('<link rel="stylesheet" href="styles/quiz.css">');
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
    <div class="quiz">
        <form method="" action="">
            <h3 class="mb-3 font-weight-normal">Q1: Test Question?</h3><br>
            <label for="fname">Answer</label>
            <input type="text" id="answer" name="answer">
            <button class="btn btn-primary btn-block" type="submit">Submit</button>
        </form>
    </div>
</main>

<footer class="mastfoot mt-auto">
  
</footer>
</div>' . "\n";
print $page->getBottomSection();