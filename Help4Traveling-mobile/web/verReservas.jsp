<%-- 
    Document   : verReservas2
    Created on : 02-nov-2016, 20:58:58
    Author     : Antares
--%>

<%@page import="Model.ModelArticulo"%>
<%@page import="servidor.DtInfoReserva"%>
<%@page import="servidor.Estado"%>
<%@page import="servidor.DtReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.ModelReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver Reservas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <style type="text/css">
            .ocultar{
                display: none;
            }
        </style>
        <style type="text/css">
            .mostrar{
                display: inline;
            }
        </style>
    </head>
    <body>

        <jsp:include page="header/header.jsp"/>

        <div class="container">   
            <%
                //Obtencion de datos de modelo
                try {
                    //Prox: Obtener nombre de proveedor mediante sesion
                    String nickProv = request.getSession().getAttribute("usuario_logueado").toString();

                    //Obtengo la funcion para saber si el articulo es promocion o servicio
                    ModelArticulo modArt = (ModelArticulo) request.getAttribute("modeloArticulo");

                    //Obtengo todas las id de reservas a proveedor
                    ModelReserva modRes = (ModelReserva) request.getAttribute("modeloReserva");
                    ArrayList<Integer> allRes = modRes.listarReservasXProv(nickProv);

                    //lista de servicios
                    ArrayList<DtReserva> infoRes = new ArrayList<DtReserva>();
                    for (int x : allRes) {
                        infoRes.add(modRes.devolverReserva(x));
                    }

            %>

            <!-- Listado de reservas -->            
            <% for (int i = 0; i < allRes.size(); i++) {%>
            <div class="panel panel-primary">                
                <div class="panel-heading">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Fecha: <%= infoRes.get(i).getDate().getDia() + "/" + infoRes.get(i).getDate().getMes() + "/" + infoRes.get(i).getDate().getAnio()%></th>
                                <th>Estado: <%= infoRes.get(i).getEstado()%></th>
                                <th>Cliente: <%= infoRes.get(i).getCli()%></th>
                                <th>Precio Total: $<%= Math.round(infoRes.get(i).getPrecio())%></th>
                                <% if (infoRes.get(i).getEstado() == Estado.PAGADA) { %>
                                <button class="btn-primary" style="float:right;" value="<%= infoRes.get(i).getId() %>">Facturar</button>
                                <% } %>
                            </tr>
                        </thead>
                    </table>                                
                </div>
                            
                            
                <!-- Listado de servicios por reserva -->
                <div class="panel-body ocultar">
                    <table class="table table-striped">
                        <tbody>
                            <%
                            for (DtInfoReserva y : infoRes.get(i).getInfoReserva()) {
                                if (y.getNickProveedor().equals(nickProv)) {
                            %>
                            <tr>
                                <td><%= y.getNameArticulo()%></td>
                                <td>$<%= y.getPrecioArticulo()%></td>
                                <td><% if(y.isEstado()){ %> Facturada <% }else{ %> No Facturada <% } %> </td>
                                <td><% if (modArt.esServicio(y.getNameArticulo()) == true) {%>Servicio<%} else {%>Promocion<%}%></td>
                            </tr>                     
                            <%
                                }
                            }
                            %>
                        </tbody>
                    </table>                        
                </div>
                <!-- Fin de Listado de servicios por reserva -->
                
            </div>
            <%}%>            
            <!-- Listado de reservas -->
            
        </div>
                <%
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                %>
                
        <script>
            //Animacion de desplegar info servicios
            function desplegarReserva() {
                if ($(this).next().css('display') == 'none') {
                    $(this).next().show(1000);
                } else {
                    $(this).next().hide(1000);
                }
            };
        </script>
        
        <script>
            //prox: Llamar al servlet que realiza las facturaciones mediante ajax post o get
            function facturarReserva(e) {
                e.stopPropagation();
                $(this).hide(3000);
                var id = $(this).attr("value");
                $.post("facturarArticulo", "idRes="+id + "&nickRes=" + <%= request.getSession().getAttribute("usuario_logueado").toString() %>);
            };
        </script>
        
        <script>
            //Manejador de eventos
            $('.panel-heading').on('click', desplegarReserva);
            //$('button').click({param: $(this).attr("value")} facturarReserva);
            $('button').on('click', facturarReserva);
        </script>
    </body>
</html>
