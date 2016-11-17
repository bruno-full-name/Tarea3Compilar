<%-- 
    Document   : index
    Created on : 30/10/2016, 11:40:58 AM
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
    <link href="bootstrap/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
  </head><body>
    <!-- INICIO BARRA DE NAVEGACION -->
    <nav class="navbar navbar-fixed-top" style="background-color: #01529e; height: 50px">
      <div class="container-fluid" style="height: 50px">
        <div class="navbar-header">
          <a class="navbar-brand" href="#" style="color: white" data-toggle="collapse" data-target="#myNavbar">INICIAR SESIÓN</a>
        </div>
      </div>
      <!-- SECCION CON CONTENIDO PARA EL INICIO DE SECCION -->
      <div class="collapse fade col-xs-12" id="myNavbar" style="background-color: #E6E6E6">
        <div class="col-xs-3"></div>
        <div class="col-xs-6">
          <form id="formInicioSesion" action="iniciarSesion" method="post">
            <div class="row" style="min-height: 25%; margin-top: 20px">
              <h4 style="font-family: Helvetica; color: #01529e; margin-top: 30px">NICKNAME</h4>
            </div>
            <div class="row" style="min-height: 25%">
                <input name="nickname" style="width: 100%; height: 25px; font-family: Helvetica" type="text">
            </div>
            <div class="row" style="min-height: 25%; margin-top: -20px">
              <h4 style="font-family: Helvetica; color: #01529e; margin-top: 30px">CONTRASEÑA</h4>
            </div>
            <div class="row" style="min-height: 25%">
                <input name="password" style="width: 100%; height: 25px; font-family: Helvetica" type="password">
            </div>
            <div class="row" style="min-height: 50%; margin-top: 50px">
              <center>
                <button type="submit" class="btn btn-primary" style="background-color: #01529e;color: white; border: none; font-family: Helvetica">
                  <b>INICIAR SESIÓN</b>
                </button>
              </center>
            </div>
          </form>
        </div>
        <div class="col-xs-3"></div>
      </div>
    </nav>
    <!-- FIN DE LA BARRA DE NAVEGACION -->
    <div class="col-xs-12" style="margin-top: 50px">
      <div class="row">
        <div class="col-xs-4"></div>
        <div class="col-xs-4">
          <center>
            <img src="img/logo.png" style="margin-top: 20px; width: 120px">
          </center>
        </div>
        <div class="col-xs-4"></div>
      </div>
      <div class="row">
        <center>
          <h1 style="font-family: Helvetica; color: #313131; font-size: 45px; margin-top: 30px; margin-left: -80px">
            <b>4</b>
          </h1>
          <h2 style="font-family: Helvetica; color: #01529e; margin-left: -180px; margin-top: -50px">HELP</h2>
          <h2 style="font-family: Helvetica; color: #01529e; margin-top: 0px; margin-left: 110px; margin-top: -44px">TRAVELING</h2>
        </center>
      </div>
    </div>
  

</body></html>
