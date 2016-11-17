<%@page import="servidor.DtServicio"%>
<%@page import="servidor.DtPromocion"%>
<%@page import="Modelo.ModelArticulo"%>
<%@page import="servidor.DtInfoReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ModelReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/registrarCliente.css" rel="stylesheet" type="text/css">
        <link href="css/algo.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
        <title>Carrito</title>
        
        <script>
            function refresh(){
                location.reload(); 
            }
        </script>
        <script>
            function vuelta(){
                window.location = "index.jsp";
            }
        </script>
        <script>
            function BorrarCarrito(){
            $.get("BorrarCarrito", function(responseText) {
                location.reload();
            });
            }
        </script>
        <script>
            function comprar(){
                window.opener.location.href='/ControllerReserva';
            }
        </script>
    </head>
    <body>

        <jsp:include page="templates/headerC.jsp"/>


        <%   
            ModelReserva modRes = ((ModelReserva)request.getAttribute("ModeloCarrito"));
            ModelArticulo modArt = ((ModelArticulo)request.getAttribute("ModeloServicio"));
            //ArrayList<DtInfoReserva> lserv = modRes.ObtenerDatosReserva(2);
            ArrayList<DtInfoReserva> lserv =null;
            try{
                lserv = (ArrayList<DtInfoReserva>)session.getAttribute("ListaInfoRes");
            }catch(Exception ex){
            }
            float total = 0;
        %>
        
    <div class="section">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12" style="border-bottom-style: solid; border-color: rgb(1, 82, 158); border-width: 9px">
            <h1 class="text-center" style="color: #313131; font-family: Helvetica; ">RESERVA ACTUAL</h1>
          </div>
        </div>
        <div class="row" style="height: 500px">
          <div class="col-md-12">
            <table class="table">
              <thead>
                <tr style="font-family: Helvetica; background-color: #01529e; color: white; font-size: 20px">
                  <th style="width: 70%">ITEM</th>
                  <th style="width: 10%">PRECIO</th>
                  <th style="width: 10%">CANTIDAD</th>
                  <th style="width: 10%">TOTAL</th>
                </tr>
              </thead>
              <tbody style="max-height: 500px; min-height: 500px; height: 500px; overflow-y: auto">
                  <% for (int i = 0; i < lserv.size(); i++) {%>
                <!-- FILA A TENER POR CADA ITEM -->
                <tr style="height: 150px; max-height: 150px; min-height: 150px; border-bottom-style: solid; border-width: 7px; border-color: #01529e">
                  <td>
                    <div class="col-md-12" style="height: 150px">
                      <div class="row" style="width: 100%; margin-left: 0px; height: 25%; min-height: 25%; max-height: 25%; background-color: #e0e0e0; border-left-style: solid; border-width: 5px; border-color: #01529e">
                        <h3 style="margin-top: 7px; margin-left: 10; font-family: Helvetica; color: #01529e"><%= lserv.get(i).getNameArticulo() %></h3>
                      </div>
                      <div class="row" style="width: 100%; margin-left: 0px; height: 75%; min-height: 75%; max-height: 75%; overflow-y: auto">
                        <% if(modArt.EsServicio(lserv.get(i).getNameArticulo())){ %>
                          <h4 style="margin-top: 7px; margin-left: 10; font-family: Helvetica;"><%= (modArt.ObtenerDatosServicio(lserv.get(i).getNameArticulo(), lserv.get(i).getNickProveedor())).getDescripcion() %> </h4>
                        <% } %>
                      </div>
                    </div>
                  </td>
                  <td>
                    <h4 style="font-family: Helvetica; font-size: 20px; margin-top: 50%">$ <%= lserv.get(i).getPrecioArticulo() %></h4>
                  </td>
                  <td>
                    <h4 style="font-family: Helvetica; font-size: 20px; margin-top: 50%"><%= lserv.get(i).getCantidad() %></h4>
                  </td>
                  <td>
                    <h4 style="font-family: Helvetica; font-size: 20px; margin-top: 50%"><%= (lserv.get(i).getPrecioArticulo())*(lserv.get(i).getCantidad()) %></h4>
                  </td>
                </tr>
                <%total += lserv.get(i).getPrecioArticulo(); %>                    
                    <% } %>
                <!-- FIN DE LA FILA A TENER POR CADA ITEM -->
              </tbody>
            </table>
          </div>
        </div>
        <div class="row" style="height: 150px;">
          <div class="col-md-2">
            <button class="btn btn-primary" style="width: 100%; height: 45px; font-family: Helvetica; font-size: 22px; margin-top: 100" onclick="refresh()">Actualizar</button>
          </div>
          <div class="col-md-2">
            <button class="btn btn-danger" style="width: 100%; height: 45px; font-family: Helvetica; font-size: 22px; margin-top: 100" onclick="BorrarCarrito()">Cancelar</button>
          </div>
          <div class="col-md-8">
              <div class="col-md-6"></div>
              <div class="col-md-2">
                <h3 style="font-family: Helvetica; color: #01529e; margin-left: -20px">Total: <%= total %> $</h3>
              </div>
              <div class="col-md-4">
                <form action="../ControllerReserva" method="post">
                <button type="submit" class="btn btn-success" style="width: 100%; height: 45px; font-family: Helvetica; font-size: 22px; margin-top: 100" onclick="comprar()">Comprar</button>
                </form>
              </div>            
          </div>
        </div>
      </div>
    </div>
  
<jsp:include page="templates/footer.jsp"/>

<script type="text/javascript">
    function ERROR(){
        alert("El carro esta vacio");
    }
</script>

</body></html>
