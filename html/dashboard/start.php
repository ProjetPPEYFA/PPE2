<?php
function start() 
{
  session_start(); 

  $db=new PDO('mysql:host=localhost; dbname=mariateam','root','');

  $check=false;

  if(isset($_SESSION['idClient']) && isset($_SESSION['mdp']))
  {
    $req = $db->prepare("SELECT idClient FROM Client WHERE idClient = ? AND mdp = ?");
    $req->execute([$_SESSION['idClient'],$_SESSION['mdp']]);

    $result=$db->query("SELECT Role FROM Client WHERE idClient='".$_SESSION['idClient']."'");
    $row = $result->fetch();
    if($row['Role']!="admin")
    {
      echo'<script>window.location.href="../about.php"</script>';
    }

    if($req->rowCount() > 0)
    {
     // echo 'connecte avec le compte :  ';
      $check=true;
    }
    else{
      echo'<script>window.location.href="../index.html"</script>';
    }
  }
  else{
    echo'<script>window.location.href="../index.html"</script>';
  }

  $id=$_SESSION['idClient'];
}
?>