<?php
  $db=new PDO('mysql:host=localhost; dbname=MariaTeam','root','root');  
  $port = $_GET['port']; 

  echo'<div class="select-wrap one-third">';
  echo'<div class="icon"><span class="ion-ios-arrow-down"></span></div>';
  echo'<select name="arrivee" id="arrivee" class="form-control">';
  echo"<option disabled selected>Destination d'arrivée</option>";
  $getNomArrivee = $db->query("SELECT codePort_Ports FROM Liaison WHERE codePort=".$port." ");
  while($rowA=$getNomArrivee->fetch() )
  {
    $requete="SELECT nomPort FROM Ports WHERE codePort=".$rowA['codePort_Ports']."";
    $getNomPort = $db->query($requete);
    $rowB = $getNomPort->fetch();


    echo'<option value='.$rowA['codePort_Ports'].' style="color:#000;">'.$rowB['nomPort'].'</option>';
  }
  echo'</select>';
  echo'</div>'; 

?>

