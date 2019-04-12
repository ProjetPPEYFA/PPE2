<?php
include'start.php';
start();
session_destroy();
header("Location: ../index.html");
?>