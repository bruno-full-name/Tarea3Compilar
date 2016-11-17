<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="../bootstrap/jquery.min.js"></script>
        <script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
        <link href="../bootstrap/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    </head><body>
        <nav class="navbar navbar-fixed-top" style="background-color: #01529e; height: 50px; z-index: 999">
            <div class="container-fluid" style="height: 50px">
                <div class="navbar-header">
                    <img src="img/logo2.png" style="margin-top: 3px; margin-left: 5px">
                    <h4 style="color: white; font-family: Helvetica; margin-top: -34px; margin-left: 60px"><%= request.getSession().getAttribute("usuario_logueado")%></h4>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="color: white; font-size: 20px; margin-top: 0px; background-color: #01529e; display: block; visibility: visible; position: absolute; right: 7px; top: 0px">☰</button>
                </div>

            </div>
            <div class="collapse fade" id="myNavbar" style="background-color: #01529e">
                <ul class="nav navbar-nav" style="font-family: Helvetica; width: 100%; margin-left: 0px; background-color: #01529e; z-index: 999">
                    <li class="active">
                        <a onclick="VERRESERVAS()" style="color: white">RESERVAS</a>
                    </li>
                    <li>
                        <a href="verArticulos.jsp" style="color: white">SERVICIOS y PROMOCIONES</a>
                    </li>
                    <li>
                        <a onclick="CerrarSesion()" style="color: white">CERRAR SESIÓN</a>
                    </li>
                </ul>
            </div>
        </nav>

        <form action="CerrarSesion" method="post" id="form"></form>
        <script>
            function CerrarSesion(){
                document.forms["form"].submit();
            }
        </script>
        
        <form action="VerReservas" method="post" id="form2"></form>
        <script>
            function VERRESERVAS(){
                document.forms["form2"].submit();
            }
        </script>

    </body></html>