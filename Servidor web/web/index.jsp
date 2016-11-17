<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="servidor.DtCliente"%>
<%@page import="servidor.DtFecha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link href="css/algo.css" rel="stylesheet" type="text/css">
  </head><body>
      <style>
      body {
            		background-image: url("img/7.jpg");
              		background-repeat: no-repeat;
                	background-size: 100% 100%;
        		}
    </style>
    <script type="text/javascript">
     function Tamal(){
            var Msg = "<%=request.getAttribute("error_registro")%>";
            var Msg2 = '<%=request.getAttribute("mensaje")%>';

                if (Msg !== "null") {
                    if (Msg === "nick") {
                        alert("El Nick ya fue tomado por otro usuario");
                    } else if (Msg === "mail") {
                        alert("El E-mail ya fue tomado por otro usuario");
                    } else if (Msg === "pass") {
                        alert("Las claves no coinciden");
                    }
                } else if (Msg2 !== "null") {
                    alert("Exito papu");
                }
            }
        
        </script>
        
        <script type="text/javascript"> window.onload = Tamal;</script>
    <jsp:include page="templates/header.jsp"/>
<!---->
<!--CUERPO-->
<!---->
  <div class="divPrincipal">
<!---->
<div class="section">
    <div class="container-fluid">
      <div class="col-md-12">
        <center>
          <img class="img-responsive" src="img/logo2.png">
          <div class="container-fluid">
            <h1 style="font-family: Helvetica; font-size: 70;">HELP
              <b>
                <a style="font-size: 90; color: #121212">4</a>
              </b>TRAVELING</h1>
          </div>
        </center>
      </div>
    </div>
  </div>
<!---->
  </div>
<!---->
<!--FOOTER-->
<!---->
    <jsp:include page="templates/footer.jsp"/>


</body></html>
