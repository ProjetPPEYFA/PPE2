<?php
$db=new PDO('mysql:host=localhost; dbname=mariateam','root','');
include 'start.php';
start();
$nom = $_SESSION['idClient'];
?>
