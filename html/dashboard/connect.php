<?php
$db=new PDO('mysql:host=localhost; dbname=MariaTeam','root','root');
include 'start.php';
start();
$nom = $_SESSION['idClient'];
?>
