<?php
function start() 
{
  session_start(); 

  $db=new PDO('mysql:host=localhost; dbname=MariaTeam','root','root');

  $check=false;

  if(isset($_SESSION['idClient']) && isset($_SESSION['mdp']))
  {
    $req = $db->prepare("SELECT idClient FROM Client WHERE idClient = ? AND mdp = ?");
    $req->execute([$_SESSION['idClient'],$_SESSION['mdp']]);

    if($req->rowCount() > 0)
    {
     // echo 'connecte avec le compte :  ';
      $check=true;
    }
    else{
      //pas co
    }
  }
  else{
    header('Location : index.html');
  }

  $id=$_SESSION['idClient'];

  //echo $id;
}
?>