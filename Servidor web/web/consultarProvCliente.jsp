<%@page import="servidor.DtServicio"%>
<%@page import="javax.servlet.jsp.PageContext"%>
<%@page import="Modelo.ModelArticulo"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="servidor.DtProveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/consultarProveedoresVisitante.css" rel="stylesheet" type="text/css">
        <link href="css/algo.css" rel="stylesheet" type="text/css">
    </head><body>
        <jsp:include page="templates/headerC.jsp"/>
        <!---->
        <!--CUERPO-->
        <!---->

        <%! ModelUsuario modUsu = new ModelUsuario();
            List<DtProveedor> p = modUsu.listarProveedoresDatos();
        %>

        <div class="divPrincipal">
            <div class="section">
                <div class="container-fluid" id="scrollspy">
                    <div class="row">
                        <div class="col-md-12" style="border-bottom-style: solid; border-color: rgb(1, 82, 158); border-width: 9px">
                            <h1 class="text-center" style="color: #313131; font-family: Helvetica; ">PROVEEDORES</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3" style="height: 600px; max-height: 600px; overflow-y: auto; background-color: #e0e0e0">
                            <nav id="lista" data-spy="scroll" data-target="#scrollspy" data-offset="50">
                                <ul class="nav nav-pills nav-stacked" style="margin-top: 10px">
                                    <% for (int x = 0; x < p.size(); x++) {%>
                                    <li>
                                        <a href="#<%="p" + (x + 1)%>" style="font-family: Helvetica; font-size: 14px; ; width: 100%; height: 35px; background-color: #01529e; color: white">
                                            <center><%= p.get(x).getNick().trim()%></center>
                                        </a>
                                    </li>
                                    <%}%>
                                </ul>
                            </nav>
                        </div>
                        <!-- FIN LISTA DE PROVEEDORES && COMIENZO INFORMACION DETALLADA -->
                        <div class="col-md-9" style="height: 600px; max-height: 600px; overflow-y: auto; background-color: #e0e0e0">
                            <!-- COMIENZO FILA CON INFORMACION DE CADA PROVEEDOR -->

                            <%   for (int x = 0; x < p.size(); x++) {%>

                            <div id="<%="p" + (x + 1)%>" class="row" style="height: 600px; max-height: 600px; width: 100%;">
                                <div class="row" style="height: 7%; max-height: 7%; background-color: white; margin-left: 1px; border-bottom-style: solid; border-width: 5px; border-color: #01529e">
                                    <center>
                                        <h3 style="margin-top: 8px; font-family: Helvetica; color: #01529e">
                                            <%= p.get(x).getNick().trim()%>
                                        </h3>
                                    </center>
                                </div>
                                <div class="row" style="height: 93%; max-height: 93%; background-color: white; margin-left: 1px">
                                    <div class="col-md-6">
                                        <div class="row" style="min-width: 100%; max-width: 100%; min-height: 60%; max-height: 60%; margin-left: 1px">
                                            <center>
                                                <h3 style="margin-top: 0; background-color: #01529e; color: white; font-family: Helvetica; height: 5%">
                                                    Imagen
                                                </h3>
                                            </center>
                                            <img src="data:image;base64,@System.Convert.ToBase64String(<%= modUsu.getImagen(p.get(x).getNick())%>)" style="min-width: 100%; max-width: 100%; width: 100%; min-height: 55%; max-height: 55%; height: 55%; margin-top: -10px; border: none">

                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="row" style="min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; margin-left: 1px">
                                            <div class="row" style="min-width: 100%; max-width: 100%; min-height: 5%; max-height: 5%; margin-left: 1px">
                                                <center>
                                                    <h3 style="margin-top: 0; background-color: #01529e; color: white; font-family: Helvetica; height: 5%">
                                                        Información
                                                    </h3>
                                                </center>
                                            </div>
                                            <div class="row" style="min-width: 100%; max-width: 100%; min-height: 40%; max-height: 40%; margin-left: 1px">
                                                <!-- TABLA CON DESCRIPCION -->
                                                <div class="col-md-6" style="margin-left: -15px">
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            NICKNAME:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            EMAIL:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            NOMBRE:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            APELLIDO:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            FECHA NAC.:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            NOMBRE EMP.:
                                                        </h4>
                                                    </center>
                                                    <center>
                                                        <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                            LINK EMP.:
                                                        </h4>
                                                    </center>
                                                </div>
                                                <!-- TABLA CON LA INFORMACION -->
                                                <div class="col-md-6" style="margin-left: -20px">
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getNick().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getEmail().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getNombre().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getApellido().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getFechaN().toString().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= p.get(x).getNombreEmpresa().trim()%></h4>
                                                    <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%; max-width: 124%; overflow-x: auto"><%= p.get(x).getUrl().trim()%></h4>
                                                </div>
                                            </div>
                                            <div class="row" style="min-width: 100%; max-width: 100%; min-height: 10%; max-height: 10%; margin-left: 1px; margin-top: 25px">
                                                <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#<%="modalProv" + (x + 1)%>" style="width: 100%; height: 10%; border:none; font-family: Helvetica; font-size: 22px">Ver Servicios</button>
                                            </div>
                                            <!-- MODAL CON INFORMACION DE LOS SERVICIOS DE CADA PROVEEDOR -->
                                            <!-- Modal -->

                                            <div id="<%="modalProv" + (x + 1)%>" class="modal fade" role="dialog">
                                                <div class="modal-dialog" style="width: 80%">
                                                    <div class="modal-content">
                                                        <div class="modal-header" style="background-color: #4A4C4E; min-height: 50px; max-height: 50px">
                                                            <button type="button" class="close" data-dismiss="modal" style="color: white">×</button>
                                                            <center>
                                                                <h3 class="modal-title" style="font-family: Helvetica; color: #8e969f; margin-top: -5px">
                                                                    SERVICIOS DEL PROVEEDOR
                                                                </h3>
                                                            </center>
                                                        </div>
                                                        <div class="modal-body" style="height: 70%; max-height: 70%; min-height: 420px; overflow-y: auto">

                                                            <%   for (int e = 0; e < p.get(x).getServicio().size(); e++) {   %>
                                                            <%  ModelArticulo modArt = new ModelArticulo();
                                List<DtServicio> s = modArt.serviciosXprov(p.get(x).getNick().trim());%>

                                                            <div class="row" style="background-color: #E6E6E6; min-height: 390px; max-height: 390px">
                                                                <div class="row" style="width: 100%; margin-left: 0; min-height: 40px; max-height: 40px; background-color: #D0D0D0">
                                                                    <h3 style="margin-top: 7px; color: #4A4C4E"><%= s.get(e).getNombre().trim()%></h3>
                                                                </div>  
                                                                <div class="row" style="width: 100%; margin-left: 0; min-height: 350px; max-height: 350px;">
                                                                    <!-- CARRUSEL DE IMAGENES -->
                                                                    <div class="col-md-6">
                                                                        <div id="imgs<%= e + "" + x%>" class="carousel slide" data-ride="carousel" style="margin-top: 20px">
                                                                            <ol class="carousel-indicators">
                                                                                <li data-target="#imgs<%= e + "" + x%>" data-slide-to="0" class="active"></li>
                                                                                <li data-target="#imgs<%= e + "" + x%>" data-slide-to="1"></li>
                                                                                <li data-target="#imgs<%= e + "" + x%>" data-slide-to="2"></li>
                                                                            </ol>
                                                                            <div class="carousel-inner" role="listbox">
                                                                                <div class="item active">
                                                                                    <img src="devolverImagenServicio?nickP=<%=s.get(e).getNickProveedor()%>&nomA=<%=s.get(e).getNombre()%>&campo=1" style="min-height: 270px; max-height: 270px; max-width: 470px; min-width: 470px">
                                                                                </div>
                                                                                <div class="item">
                                                                                    <img src="devolverImagenServicio?nickP=<%=s.get(e).getNickProveedor()%>&nomA=<%=s.get(e).getNombre()%>&campo=2" style="min-height: 270px; max-height: 270px; max-width: 470px; min-width: 470px">
                                                                                </div>
                                                                                <div class="item">
                                                                                    <img src="devolverImagenServicio?nickP=<%=s.get(e).getNickProveedor()%>&nomA=<%=s.get(e).getNombre()%>&campo=3" style="min-height: 270px; max-height: 270px; max-width: 470px; min-width: 470px">
                                                                                </div>
                                                                            </div>
                                                                            <a class="left carousel-control" href="#imgs<%= e + "" + x%>" role="button" data-slide="prev">
                                                                                <span aria-hidden="true" style="font-family: Helvetica; font-style: italic; font-size: 26px;">&lt;</span>
                                                                            </a>
                                                                            <a class="right carousel-control" href="#imgs<%= e + "" + x%>" role="button" data-slide="next">
                                                                                <span aria-hidden="true" style="font-family: Helvetica; font-style: italic; font-size: 26px">&gt;</span>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                    <!-- FIN DE CARRUSEL && INICIO INFORMACION SERVICIO -->
                                                                    <div class="col-md-6">
                                                                        <div class="col-md-6" style="margin-top: 20px; margin-left: -20px">
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    PROVEEDOR:
                                                                                </h4>
                                                                            </center>
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    NOMBRE:
                                                                                </h4>
                                                                            </center>
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    PRECIO:
                                                                                </h4>
                                                                            </center>
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    CIUDAD ORIGEN:
                                                                                </h4>
                                                                            </center>
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    CIUDAD DESTINO:
                                                                                </h4>
                                                                            </center>
                                                                            <center>
                                                                                <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid">
                                                                                    DESCRIPCION:
                                                                                </h4>
                                                                            </center>
                                                                        </div>
                                                                        <!-- TABLA CON LA INFORMACION -->
                                                                        <div class="col-md-6" style="margin-top: 20px; margin-left: -20px">
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= s.get(e).getNickProveedor().trim()%></h4>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= s.get(e).getNombre().trim()%></h4>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= s.get(e).getPrecio().toString().trim()%></h4>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; width: 100%"><%= s.get(e).getCiudadOrigen().trim()%></h4>
                                                                            <% if (s.get(e).getCiudadDestino() != null && !s.get(e).getCiudadDestino().isEmpty()) {%>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; max-height: 150px; overflow-y: auto; width: 100%"><%= s.get(e).getCiudadDestino().trim()%></h4>
                                                                            <% } else { %>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; max-height: 150px; overflow-y: auto; width: 100%">(A confirmar...)</h4>
                                                                            <% } %>
                                                                            <% if (s.get(e).getDescripcion() != null && !s.get(e).getDescripcion().isEmpty()) {%>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; max-height: 150px; overflow-y: auto; width: 100%"><%= s.get(e).getDescripcion().trim()%></h4>
                                                                            <% } else { %>
                                                                            <h4 style="font-family: Helvetica; color: #4A4C4E; border-bottom-style: solid; border-color: #80878F; max-height: 150px; overflow-y: auto; width: 100%">(Actualmente, este servicio no posee una descripción)</h4>
                                                                            <% } %>
                                                                        </div>
                                                                    </div>
                                                                </div>     
                                                            </div>

                                                            <%  } // fin for de servicios por proveedor  %>
                                                        </div>
                                                        <div class="modal-footer" style="background-color: #8e969f">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color: #4A4C4E; color: white; border: none; font-family: Helvetica">ACEPTAR</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- FIN DEL MODEL DE SERVICIOS -->
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <%  } // fin for proveedores   %>

                            <!-- FIN FILA CON INFORMACION DE CADA PROVEEDOR -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!---->
        <!-- FUNCIONES JAVASCRIPT-->
        <!---->

        <!---->
        <!--FOOTER-->
        <!---->
        <jsp:include page="templates/footer.jsp"/>

    </body></html>
