<?php
include'start.php';
session_start();
session_destroy();
header("Location: http://10.3.14.167");
?>