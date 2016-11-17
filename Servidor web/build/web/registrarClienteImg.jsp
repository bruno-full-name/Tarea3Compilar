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
        
        <script type="text/javascript"> window.onload = Display;</script>        
    </head><body>
     <jsp:include page="templates/header.jsp"/>
<!---->
<!--CUERPO-->
<!---->
    <div class="divPrincipal">
<!---->

    <h1>El Cliente fue Registrado con Exito</h1>

        <p>Seleccione una imagen si asi lo desea</p>

        <form action="ControllerUserImage" id="form2" method="post" enctype="multipart/form-data">
            <input class="img-responsive" type="file" name="imagentest"/>
            <input type="hidden" name="namecli" value="<%= request.getParameter("nick") %>"/>
            <input class="btn-toolbar" type="submit" name="imagesubmit" value="Aceptar"/>
        </form>

        <a href="index.jsp">Volver al inicio</a>    
    
<!---->
  </div>
<!---->
<!--FOOTER-->
<!---->
<jsp:include page="templates/footer.jsp"/>

  </body></html>

