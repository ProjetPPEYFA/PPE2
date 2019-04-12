<header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                            </form>
                            <div class="header-button">
                                <div class="noti-wrap">
                                </div>
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"><?php echo $nom;?></a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <h5 class="name"><?php echo $nom;?></h5>
                                                <?php 
                                                $resultNom = $db->query('SELECT Mail FROM Client WHERE idClient = "'.$nom.'"'); 
                                                $row = $resultNom->fetch();
                                                echo'<span class="email">'.$row['Mail'].'</span>';
                                                ?>     
                                            </div>
                                            <!--- 
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-account"></i>Compte</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-settings"></i>Paramètre</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-money-box"></i>Factures</a>
                                                </div>
                                            </div>
                                            --->
                                            <div class="account-dropdown__footer">
                                                <a href="deco.php">
                                                    <i class="zmdi zmdi-power"></i>Se deconnecter</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>