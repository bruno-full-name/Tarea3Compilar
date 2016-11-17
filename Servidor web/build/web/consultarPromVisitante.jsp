<%@page import="java.util.List"%>
<%@page import="servidor.DtPromocion"%>
<%@page import="Modelo.ModelArticulo"%>
<%@page import="Modelo.ModelUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
    <title>Consultar Promocion</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/consultarPromociones.css" rel="stylesheet" type="text/css">
    <link href="css/algo.css" rel="stylesheet" type="text/css">   
  </head><body>
    <jsp:include page="templates/header.jsp"/>
    <!---->
    <!--CUERPO-->
    <div class="divPrincipal">
    <!---->
         <div class="section">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12" style="border-bottom-style: solid; border-color: rgb(1, 82, 158); border-width: 9px">
              <h1 class="text-center" style="color: #313131; font-family: Helvetica; ">PROMOCIONES</h1>
          </div>
        </div>
        <div class="row">
          <!-- INICIO TREEVIEW CON CATEGORIAS -->
          <div class="col-md-3" style="background-color: white; min-height: 550px; max-height: 550px; overflow-y: auto">
            <div class="col-md-12">
              <div class="row" style="margin-top: 20px; border-top-style: solid; border-width: 4px; border-color: #01529e">
                  <center>
                <h3 style="height: 35px; font-family: Helvetica; color: #01529e; margin-top: 10px">
                    <b>SELECCIONAR</b>
                </h3>
                  </center>
              </div>
              <!-- FILA A TENER POR CADA PROMOCION -->
              <div class="row" style="height: 35px">
                <table id="tabla" class="table">
                  <thead style="background-color: #01529e; color: white; font-family: Helvetica; font-size: 14px">
                    <tr>
                      <th style="width: 30px">NICKNAME PROV.</th>
                      <th style="width: 30px">NOMBRE</th>
                    </tr>
                  </thead>
                  <tbody style="color: black; font-family: Helvetica; font-size: 13">
                    <%! ModelArticulo modArt = new ModelArticulo();
                        List<DtPromocion> prom = modArt.listarPromociones(); %>
                    <% for(int i=0; i<prom.size(); i++){ %>
                    <tr>
                      <td style="border-bottom-style: solid; border-width: 1px; border-color: #01529e"><%= prom.get(i).getNickProv() %></td>
                      <td style="border-bottom-style: solid; border-width: 1px; border-color: #01529e"><%= prom.get(i).getNombre() %></td>
                      <% } %>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- FIN FILA A TENER POR CADA PROMOCION -->
            </div>
          </div>
          <!-- FIN TREEVIEW && INICIO LA OTRA SHIT -->
          <!-- SECCION CON SCROLL DE SERVICIOS -->
          <div class="col-md-9" style="height: 550px; max-height: 550px; overflow-y: auto; background-color: #E6E6E6">
            <!-- COMIENZO FILA A TENER POR CADA SERVICIO -->
            <center>
              <div class="row" style="height: 510px; margin-top: 20px; background-color: #f9f9f9; max-height: 550px; width: 100%; border-color: #01529e; border-width: 9px; border-bottom-style: solid">
                <div class="row" style="height: 50px; background-color: white; width: 100%; border-top-style: solid; border-color: #01529e">
                  <div class="col-md-10">
                    <h2 id="nomProm" style="margin-top: 9px; font-family: Helvetica; color: #01529e; font-size: 27px; width: 100%; text-align: left"></h2>
                  </div>
                  <div class="col-md-2">
                    <div class="col-md-1">
                      <h2 style="margin-top: 6px; font-family: Helvetica; color: #359151; margin-left: 0px; font-size: 30px">
                        <b>$</b>
                      </h2>
                    </div>
                    <div class="col-md-3">
                      <h2 id="preProm" style="margin-top: 9px; font-family: Helvetica; color: #359151; text-align: left; font-size: 25px "></h2>
                    </div>
                  </div>
                  <div class="row" style="height: 60px; width: 100%; margin-top: 60px">
                    <div class="col-md-12" style="height: 60px; min-height: 60px; margin-left: 0px">
                      <div class="col-md-2">
                        <h3 style="font-family: Helvetica; text-align: left">
                          <b>Proveedor:</b>
                        </h3>
                      </div>
                      <div class="col-md-5">
                        <h3 id="nickProm" style="font-family: Helvetica; text-align: left; margin-left: -10px"></h3>
                      </div>
                      <div class="col-md-2">
                        <h3 style="font-family: Helvetica; text-align: left">
                          <b>Descuento:</b>
                        </h3>
                      </div>
                      <div class="col-md-3">
                        <h3 id="descProm" style="font-family: Helvetica; text-align: left; margin-left: -10px"></h3>
                      </div>
                    </div>
                  </div>
                  <!-- COMIENZO FILA CON TABLA DE SERVICIOS DE LA PROMOCION -->
                  <div class="row" style="width: 97%; margin-top: 5px; height: 360px; background-color: white; border-left-style: solid; border-width: 6px; border-color: #359151">
                    <div class="row" style="width: 100%; height: 40px; min-height: 40px">
                      <h2 style="margin-top: 7px; font-family: Helvetica; color: #359151; margin-left: 10px; font-size: 25px; text-align: left">Servicios asociados</h2>
                    </div>
                    <div class="row" style="width: 97%">
                      <table id="tablaServ" class="table" style="background-color: #979797; margin-top: 5px; ">
                        <thead style="background-color: #D9E9E9; color: #333333; font-family: Helvetica; font-size: 14px; border-bottom-style: solid; border-width: 4px; border-color: #359151">
                          <tr>
                            <th style="width: 300">NOMBRE PROVEEDOR</th>
                            <th style="width: 300">NOMBRE SERVICIO</th>
                          </tr>
                        </thead>
                        <tbody id="tbody" style="background-color: white; color: #333333"></tbody>
                      </table>
                    </div>
                  </div>
                  <!-- FIN FILA CON TABLA DE SERVICIOS DE LA PROMOCION -->
                </div>
              </div>
            </center>
          </div>
        </div>
      </div>
    </div>                                
    <!---->
    </div>
    <!--FOOTER-->
    <!---->
    
    
    
    <jsp:include page="templates/footer.jsp"/>
    
    <form method="post" id="registro">
    </form>

    <script type="text/javascript">
        function agregarRegistro(){
            alert("entre madafaka");
            var nav="Desconocido";
            if (navigator.userAgent.indexOf("Firefox") !== -1) nav="Firefox";
            if (navigator.userAgent.indexOf("Chrome") !== -1) nav="Chrome";
            if (navigator.userAgent.indexOf("Vivaldi") !== -1) nav="Vivaldi";
            if (navigator.userAgent.indexOf("Opera") !== -1) nav="Opera";
            alert(nav);
            var so="Desconocido";
            if (navigator.appVersion.indexOf("Win") !== -1) so="Windows";
            if (navigator.appVersion.indexOf("Mac") !== -1) so="MacOS";
            if (navigator.appVersion.indexOf("X11") !== -1) so="UNIX";
            if (navigator.appVersion.indexOf("Linux") !== -1) so="Linux";
            alert(nav);
            String servlet = "agregarRegistro?so=" + so + "&nav=" + nav;
            alert(servlet);
            document.forms['registro'].action = servlet;    
            document.form['registro'].submit();
           
           
        }
    </script>

<script type="text/javascript">
    $("#tabla tr").click(function(){
        $(this).addClass('selected').siblings().removeClass('selected');    
        var value = $(this).find('td:first').html();
        var value2 = $(this).find("td").eq(1).html();
        if (value !== undefined){
            document.getElementById("nickProm").innerHTML = value;
            document.getElementById("nomProm").innerHTML = value2;
            //alert("chau");
            $.get("DevolverPromocion", "nomProm="+ value2 +"&nickProm=" + value, function(responseText) {
                document.getElementById("descProm").innerHTML = responseText;
            });
            $.get("DevolverPromocion", "nomProm="+ value2 +"&nickProm=" + value +"&descProm=" + document.getElementById('descProm').innerHTML, function(responseText) {
                document.getElementById('preProm').innerHTML = responseText;
            });
            $.get("DevolverPromocion", "nomProm="+ value2 +"&nickProm=" + value +"&descProm=" + document.getElementById('descProm').innerHTML +"&preProm=" + document.getElementById('preProm').innerHTML, function(responseJson) {
                $("#tbody").children().remove();
                var tblBody  = document.getElementById("tbody");                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                $.each(responseJson, function(index, item) { // Iterate over the JSON array.
                   var row = document.createElement("tr");

                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(document.getElementById('nickProm').innerHTML);
                    cell.appendChild(cellText);
                    row.appendChild(cell);

                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(item);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    tblBody.appendChild(row);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
                });
            });
               
        }
         
    });
</script>

<script type="text/javascript">
    $("#tablaServ tr").click(function(){
        $(this).addClass('selected').siblings().removeClass('selected');    
        var value = $(this).find('td:first').html();
        var value2 = $(this).find("td").eq(1).html();
        if (value !== undefined){
            $.get("DevolverPromocion", "nomServ="+ value2 +"&nickServ=" + value, function(responseJson) {
                document.getElementById("nickServ").innerHTML = responseJson.nickProveedor;
                document.getElementById("nomServ").innerHTML = responseJson.nombre;
                document.getElementById("precioServ").innerHTML = responseJson.precio;
                document.getElementById("oriServ").innerHTML = responseJson.ciudadOrigen;
                document.getElementById("destServ").innerHTML = responseJson.ciudadDestino;
                document.getElementById("descServ").innerHTML = responseJson.descripcion;
                
            });
        }
         
    });
</script>

</body></html>
