<%-- 
    Document   : registrarCliente
    Created on : 16/09/2016, 01:43:10 PM
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/registrarCliente.css" rel="stylesheet" type="text/css">
        <link href="css/algo.css" rel="stylesheet" type="text/css">
        <title>Registrar cliente</title>
        
        <script type="text/javascript">
            var Msg = "<%=request.getAttribute("error_registro")%>";
            var Msg2 = '<%=request.getAttribute("mensaje")%>';
            function Display() {
                document.getElementById('errordiv1').style.visibility = 'hidden';
                document.getElementById('exitodiv1').style.visibility = 'hidden';

                if (Msg !== "null") {
                    document.getElementById("errordiv1").style.visibility = "visible";
                    if (Msg === "nick") {
                        document.getElementById("error1").innerHTML = "El Nick ya fue tomado por otro usuario";
                    } else if (Msg === "mail") {
                        document.getElementById("error1").innerHTML = "El E-mail ya fue tomado por otro usuario";
                    } else if (Msg === "pass") {
                        document.getElementById("error1").innerHTML = "Las claves no coinciden";
                    }
                } else if (Msg2 !== "null") {
                    document.getElementById("exitodiv1").style.visibility = "visible";
                }
            }
        </script>
        <script type="text/javascript"> window.onload = Display;</script>
    </head><body>
    <jsp:include page="templates/header.jsp"/>
<!---->
<!--CUERPO-->
<!---->
  <div class="divPrincipal">
<!---->

    <div id="errordiv1">
        <center>
            <div class="col-sm-10">
                <label class="control-label" id="error1"> El Nick ya fue tomado por otro usuario </label>
            </div>                
        </center>
    </div>
    <div id="exitodiv1">
        <center>
            <div class="col-sm-10">
                <label class="control-label" id="exitodiv1"> El registro se realizo exitosamente! </label>
            </div>
        </center>            
    </div>    

    <div class="col-md-12">
        <h1>Registrar cliente</h1>
        
        <form id="form1" class="form-horizontal" role="form" action="ControllerUsuario" method="post">

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="nick" placeholder="Nick" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="email" placeholder="Email" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="password" name="pass" placeholder="Password" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="password" name="pass2" placeholder="Confirme password" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="nombre" placeholder="Nombre" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="apellido" placeholder="Apellido" required/>
                </div>
            </div>

            <h4>Fecha de nacimiento</h4>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="fnac1" placeholder="dia" required/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="fnac2" placeholder="mes" required/> 
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input class="form-control" type="text" name="fnac3" placeholder="anio" required/>
                </div>
            </div>
            <input class="btn-toolbar" type="submit" name="enviar" value="Aceptar"/>
        </form>
        
        <a href="index.jsp">Volver</a>
    </div>

    

<!---->
  </div>
<!---->
<!--FOOTER-->
<!---->
<jsp:include page="templates/footer.jsp"/>

  </body></html>

