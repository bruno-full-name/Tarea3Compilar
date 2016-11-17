<%@page import="java.util.List"%>
<%@page import="servidor.DtInfoReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servidor.DtReserva"%>
<%@page import="Modelo.ModelReserva"%>
<%@page import="servidor.DtCliente"%>
<%@page import="Modelo.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/verPerfil.css" rel="stylesheet" type="text/css">
        <link href="css/algo.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="templates/headerC.jsp"/>
        <!---->
        <!--CUERPO-->
        <!---->
        <div class="divPrincipal">
            <div class="section">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12" style="border-bottom-style: solid; border-color: rgb(1, 82, 158); border-width: 9px">
                            <h1 class="text-center" style="color: #313131; font-family: Helvetica; ">MI PERFIL</h1>
                        </div>
                    </div>
                    <div class="row">
                        <!-- INICIO TREEVIEW CON CATEGORIAS -->
                        <div class="col-md-3" style="background-color: white; min-height: 550px; max-height: 550px; overflow-y: auto">
                            <div class="col-md-12">
                                <div class="row" style="margin-top: 10px; border-bottom-style: solid; border-width: 4px; border-color: #01529e">
                                    <center>
                                        <h3 style="height: 35px; font-family: Helvetica; color: #01529e; margin-top: 10px">
                                            <b>MIS RESERVAS</b>

                                        </h3>
                                    </center>
                                </div>
                                <div class="row" style="height: 35px; margin-top: 20px">

                                    <%
                                        ModelUsuario modUsu = new ModelUsuario();
                                        ModelReserva modRes = new ModelReserva();
                                        String nick = request.getSession().getAttribute("usuario_logueado").toString();
                                        DtCliente c = modUsu.devolverCliente(nick);
                                    %>

                                    <!-- FILA A TENER POR CADA RESERVA -->
                                    <%   for (int x = 0; x < c.getReservas().size(); x++) {%>
                                    <% DtReserva dtres = modRes.devolverReserva(c.getReservas().get(x));
                                 
                                    %>
   
                                    <button style="height: 32px; width: 100%; font-family: Helvetica; font-size: 18px" class="btn btn-primary" data-toggle="modal" data-target="#<%="modal"+(dtres.getId())%>"><%= dtres.getId()%></button>
                                    
                                    <!-- Modal -->
                                    <!-- COMIENZO MODAL RESERVA -->
                                    <div id="<%="modal"+dtres.getId()%>" class="modal fade" role="dialog">
                                        <div class="modal-dialog" style="width: 70%">
                                            <div class="modal-content">
                                                <div class="modal-header" style="background-color: #4A4C4E; min-height: 50px; max-height: 50px">
                                                    <button type="button" class="close" data-dismiss="modal" style="color: white">×</button>
                                                    <center>
                                                        <h3 class="modal-title" style="font-family: Helvetica; color: #8e969f; margin-top: -5px">
                                                            INFORMACIÓN DE RESERVA
                                                        </h3>
                                                    </center>
                                                </div>
                                                <div class="modal-body" style="height: 70%; max-height: 650px; min-height: 650px; overflow-y: auto; background-color: white">
                                                    <div class="row" style="height: 40%">
                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 15%; max-height: 15%; min-height: 15%; background-color: #E6E6E6; border-left-style: solid; border-color: #01529e; border-size: 9px">
                                                            <h3 style="margin-top: 7px; color: #01529e; margin-left: 10px">Servicios y Promociones asociadas</h3>
                                                        </div>
                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 85%; max-height: 85%; min-height: 85%">
                                                            <div class="col-md-2" style="margin-left: 20px">
                                                                <div class="row" style="height: 20%; min-height: 30%; margin-top: 20px">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e">Id:</h3>
                                                                </div>
                                                                <div class="row" style="height: 20%; min-height: 30%">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e">Precio total:</h3>
                                                                </div>
                                                                <div class="row" style="height: 20%; min-height: 30%">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e">Estado actual:</h3>
                                                                </div>
                                                            </div>
                                                            
                                                            <%  DtReserva res = modRes.devolverReserva(dtres.getId());   %>
                                                            <script>
                                                       
                                                            </script>
                                                            <div class="col-md-4">
                                                                <div class="row" style="height: 20%; min-height: 30%; margin-top: 20px">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e"><%= res.getId() %></h3>
                                                                </div>
                                                                <div class="row" style="height: 20%; min-height: 30%">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e"><%= res.getPrecio() %></h3>
                                                                </div>
                                                                <div class="row" style="height: 20%; min-height: 30%">
                                                                    <h3 style="margin-top: 7px; margin-left: 10px; border-bottom-style: solid; border-color: #01529e"><%= res.getEstado().toString() %></h3>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row" style="height: 60%">
                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%; min-height: 10%; background-color: #E6E6E6; border-left-style: solid; border-color: #01529e; border-size: 9px">
                                                            <h3 style="margin-top: 7px; color: #01529e; margin-left: 10px">Servicios y Promociones asociadas</h3>
                                                        </div>
                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 85%; max-height: 85%; min-height: 85%; overflow-y: auto">
                                                            <div class="col-md-12">
                                                                
                                                                <%
                                                                    List<DtInfoReserva> infores = dtres.getInfoReserva();
                                                                    for(int e = 0; e < infores.size(); e++){
                                                                %>
                                                                
                                                                    <!-- comienzo fila a tener por cada articulo en la reserva -->
                                                                    <div class="row" style="height: 30%; max-height: 43%; min-height: 30%; background-color: #E6E6E6">
                                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 40%; max-height: 40%; min-height: 40%; background-color: white; border-bottom-style: solid; border-color: #01529e; border-size: 9px">
                                                                            <h4 style="margin-top: 9px; margin-left: 20px; color: #01529e; "><%= infores.get(e).getNameArticulo() %></h4>
                                                                        </div>
                                                                        <div class="row" style="width: 100%; margin-left: 0px; height: 60%; max-height: 60%; min-height: 60%;">
                                                                            <div class="col-md-4">
                                                                                <div class="col-md-5">
                                                                                    <h4 style="font-family: helvetica">
                                                                                        <b>Proveedor:</b>
                                                                                    </h4>
                                                                                </div>
                                                                                <div class="col-md-7">
                                                                                    <h4 style="font-family: helvetica"><%= infores.get(e).getNickProveedor() %></h4>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="col-md-5">
                                                                                    <h4 style="font-family: helvetica">
                                                                                        <b>Cantidad:</b>
                                                                                    </h4>
                                                                                </div>
                                                                                <div class="col-md-7">
                                                                                    <h4 style="font-family: helvetica"><%= infores.get(e).getCantidad() %></h4>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="col-md-5">
                                                                                    <h4 style="font-family: helvetica">
                                                                                        <b>Precio:</b>
                                                                                    </h4>
                                                                                </div>
                                                                                <div class="col-md-7">
                                                                                    <h4 style="font-family: helvetica"><%= infores.get(e).getPrecioArticulo() %></h4>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!-- FIN DE LA FILA POR CADA SERVICIO -->
                                                                    
                                                                <%}%>
                                                                    
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer" style="background-color: #8e969f">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color: #4A4C4E; color: white; border: none; font-family: Helvetica">ACEPTAR</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- FIN MODAL. -->
                                    
                                    <%   }%>
                                    <!-- FIN FILA A TENER POR CADA RESERVA --> 
                                </div>
                            </div>
                        </div>
                        <!-- FIN TREEVIEW && INICIO LA OTRA SHIT -->
                        <!-- SECCION CON SCROLL DE SERVICIOS -->
                        <div class="col-md-9" style="height: 600px; max-height: 600px; overflow-y: auto; background-color: #01529e">
                            <div class="row" style="height: 12%; border-bottom-style: solid; border-width: 5px; border-color: white">
                                <center>
                                    <h3 style="font-family: Helvetica; color: white">
                                        <b>MI INFORMACIÓN</b>
                                    </h3>
                                </center>
                            </div>
                            <div class="col-md-6" style="height: 85%">
                                <div class="row" style="height: 15%; max-height: 15%"></div>
                                <div class="row" style="height: 50%; max-height: 50%">
                                    <img src="devolverImagenUsuario?nickU=<%= c.getNick().trim()%>" class="img-rounded img-responsive">
                                </div>
                                <div class="row" style="height: 25%; max-height: 25%"></div>
                            </div>
                            <div class="col-md-6" style="height: 85%">
                                <div class="row" style="height: 20%; max-height: 20%; border-bottom-style: solid; border-color: white; border-width: 6px">
                                    <center>
                                        <h1 style="color: white; font-family: Helvetica; margin-top: 30px"><%= c.getNick().trim()%></h1>
                                    </center>
                                </div>
                                <div class="row" style="height: 80%; max-height: 80%">
                                    <div class="col-md-5">
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%;">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white">NOMBRE:</h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white">APELLIDO:</h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white">EMAIL:</h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white">FECHA NAC.:</h3>
                                        </div>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%;">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white"><%= c.getNombre().trim()%></h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white"><%= c.getApellido().trim()%></h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white"><%= c.getEmail().trim()%></h3>
                                        </div>
                                        <div class="row" style="width: 100%; margin-left: 0px; height: 10%; max-height: 10%">
                                            <h3 style="color: white; font-family: Helvetica; border-bottom-style: solid; border-color: white"><%= c.getFechaN().toString().trim()%></h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!---->
        <!--FOOTER-->
        <!---->
        <jsp:include page="templates/footer.jsp"/>


    </body></html>

