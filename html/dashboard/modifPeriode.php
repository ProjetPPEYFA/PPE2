<?php include'connect.php';?>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Forms</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <h1>Marie Team</h1>
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <?php require'aside.php';?>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <h1>Marie Team</h1>
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <?php require'aside.php';?>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <?php require 'header.php';

            if(isset($_GET['modif']))
            {
                $idPeriode = $_POST['idPeriode'];
                $saison = $_POST['saison'];
                $dateF = $_POST['dateF'];
                $dateD = $_POST['dateD'];
                $prixA = $_POST['prixA'];
                $prixJ = $_POST['prixJ'];
                $prixE = $_POST['prixE'];
                $prixVeh = $_POST['prixVeh'];
                $prixVeh5 = $_POST['prixVeh5'];
                $prixF = $_POST['prixF'];
                $prixCamping = $_POST['prixCamping'];
                $idLiaison = $_POST['idLiaison'];
                $prixCamion = $_POST['prixCamion']; 
            	

            	if(isset($_POST['btnModif']))
            	{
					$db->query('UPDATE Periode SET saison="'.$saison.'",dateDebut="'.$dateD.'",dateFin="'.$dateF.'",prixAdulte="'.$prixA.'",prixJunior="'.$prixA.'",prixEnfants="'.$prixE.'",prixVinf4m="'.$prixVeh.'",prixVinf5m="'.$prixVeh5.'",prixFourgon="'.$prixF.'",prixCamping="'.$prixCamping.'",prixCamion="'.$prixCamion.'",idLiaison="'.$idLiaison.'" WHERE idPeriode='.$idPeriode.' ');
            	}
            	else{
            		 $db->query('DELETE FROM Periode WHERE idPeriode='.$idPeriode.' ');
            	}
            } 


            ?>

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">

                                
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Modification des liaisons</strong>
                                    </div>
                                        <div class="table-responsive m-b-40">
                                        <table class="table table-borderless table-data3">
                                            <thead>
                                                <center>
                                                <tr>
                                                    <th style="text-align: center;">Id</th>
                                                    <th style="text-align: center; min-width: 150px;">Intitulé Saison</th>
                                                    <th style="text-align: center; min-width: 170px;">Début</th>
                                                    <th style="text-align: center; min-width: 170px;">Fin</th>
                                                    <th style="text-align: center;">Adulte</th>
                                                    <th style="text-align: center;">Junior</th>
                                                    <th style="text-align: center;">Enfants</th>
                                                    <th style="text-align: center;">Vehicule</th>
                                                    <th style="text-align: center;">Vehicule + 5M</th>
                                                    <th style="text-align: center;">Fourgon</th>
                                                    <th style="text-align: center;">Camping car</th>
                                                    <th style="text-align: center;">Camion</th>
                                                    <th style="text-align: center;">Liaison</th>
                                                    <th></th>
                                                    <th></th>
                            
                                                 </tr>
                                                  </center>
                                            </thead>
                                            <tbody>
                                            <?php
                                            $result=$db->query('SELECT * FROM Periode');
                                            $i = 0;
                                            while($row=$result->fetch())
                                            {
                                            $i++;
                                            echo'<form id="ligne'.$i.'" action="modifPeriode.php?modif" method="post" class="form-horizontal">
                                                <tr>
                                                    <input type="hidden" name="idPeriode" value="'.$row['idPeriode'].'"/>
                                                    <td><label>'.$row['idPeriode'].'</label></td>
                                                    <td><input name="saison" value="'.$row['saison'].'" class="form-control"/></td>
                                                    <td><input name="dateD" value="'.$row['dateDebut'].'" class="form-control"/></td>
                                                    <td><input name="dateF" value="'.$row['dateFin'].'" class="form-control"/></td>
                                                    <td><input name="prixA" value="'.$row['prixAdulte'].'" class="form-control"/></td>
                                                    <td><input name="prixJ" value="'.$row['prixJunior'].'" class="form-control"/></td>
                                                    <td><input name="prixE" value="'.$row['prixEnfants'].'" class="form-control"/></td>
                                                    <td><input name="prixVeh" value="'.$row['prixVinf4m'].'" class="form-control"/></td>
                                                    <td><input name="prixVeh5" value="'.$row['prixVinf5m'].'" class="form-control"/></td>
                                                    <td><input name="prixF" value="'.$row['prixFourgon'].'" class="form-control"/></td>
                                                    <td><input name="prixCamping" value="'.$row['prixCamping'].'" class="form-control"/></td>
                                                    <td><input name="prixCamion" value="'.$row['prixCamion'].'" class="form-control"/></td>
                                                    <td><input name="idLiaison" value="'.$row['idLiaison'].'" class="form-control"/></td>

                                                    <td><button type="submit" name="btnModif" class="btn btn-primary btn-sm"><i class="fa fa-dot-circle-o"></i> Enregistrer</button></td>
                                                    <td><button type="button" name="btnDelete" onclick="document.getElementById(\'ligne'.$i.'\').submit();" class="btn btn-danger btn-sm"><i class="fa fa-ban"></i></button></td>
                                                </tr></form>';
                                            }                                     
                                            ?>
                                            </tbody>
                                        </table>
                                        
                                    </div>             
                               </div>
                            </div>
                        </div>
                   
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
