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
            <?php require 'header.php';?>
            <!-- HEADER DESKTOP-->
            <?php 
            if(isset($_GET['ajouter']))
            {
				
				$saison = $_POST['saison'];
				$datedebut = $_POST['datedebut'];
				$datefin = $_POST['datefin'];
				$prixA = (float) $_POST['prixA'];
				$prixJ = (float) $_POST['prixJ'];
				$prixE = (float) $_POST['prixE'];
				$prixV4m = (float) $_POST['prixV4m'];
				$prixV5m = (float) $_POST['prixV5m'];
				$prixfourgon = (float) $_POST['prixfourgon'];
				$prixcamping = (float) $_POST['prixcamping'];
				$prixcamion = (float) $_POST['prixcamion'];
				$idliaison = $_POST['idliaison'];
				

				$sql=$db->prepare("INSERT INTO Periode (saison, dateDebut, dateFin, prixAdulte, prixJunior, prixEnfants, prixVinf4m, prixVinf5m, prixFourgon, prixCamping, prixCamion, idLiaison) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
				$sql->execute([$saison, $datedebut, $datefin, $prixA, $prixJ, $prixE, $prixV4m, $prixV5m, $prixfourgon, $prixcamping, $prixcamion, $idliaison]);

				echo "<script type='text/javascript'>";
				echo "alert('La période a bien été ajoutée.');";
				echo "</script>";
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
                                        <strong>Ajouter une période</strong>
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="ajoutPeriode.php?ajouter" method="post" class="form-horizontal" required>
										
                                            
											
											<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Id Liaison</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <select name="idliaison" class="form-control">
                                                        <option value="0"></option>
                                                    <?php
                                                    $result=$db->query('SELECT * FROM Liaison');
                                                    while($row=$result->fetch())
                                                    {
                                                        echo'<option value="'.$row['codeLiaison'].'">'.$row['codeLiaison'].'</option>';
                                                    }
                                                    ?>
                                                        
                                                        
                                                    </select>
                                                </div>
												</div>
											
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Saison</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="saison" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire la saison effective de la période</small>
                                                </div>
                                            </div>
											
											<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Date de début</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="datedebut" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire la date de début (AAAA-MM-JJ)</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Date de fin</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="datefin" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire la date de fin (AAAA-MM-JJ)</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Adulte</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixA" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les adultes</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Junior</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixJ" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les juniors</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Enfant</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixE" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les enfants</small>
                                                </div>
												</div>
												
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Véhicules (inférieurs à 4m)</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixV4m" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les véhicules de -4m</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Véhicules (inférieurs à 5m)</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixV5m" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les véhicules de -5m</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Fourgon</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixfourgon" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les fourgons</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix Camion</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixcamion" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les camions</small>
                                                </div>
												</div>
												
												<div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="email-input" class=" form-control-label">Prix camping</label>
                                                </div>
												
												
                                                <div class="col-12 col-md-9">
                                                    <input type="text" name="prixcamping" placeholder="" class="form-control" required>
                                                    <small class="help-block form-text">Inscrire le prix pour les campings</small>
                                                </div>
												</div>

											

                                            </div>
											
                                            <div class="card-footer">
                                                <button type="submit" class="btn btn-primary btn-sm">
                                                    <i class="fa fa-dot-circle-o"></i> Valider
                                                </button>
                                                <button type="reset" class="btn btn-danger btn-sm">
                                                    <i class="fa fa-ban"></i> Reset
                                                </button>
                                            </div>
                                        </form>
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