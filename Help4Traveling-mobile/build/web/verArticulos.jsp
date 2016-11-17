
<%@page import="Model.ModelArticulo"%>
<%@page import="servidor.DtPromocion"%>
<%@page import="servidor.DtServicio"%>
<%@page import="java.util.ArrayList"%>
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
        <jsp:include page="header/header.jsp"/>

        <%
            //ArrayList<DtServicio> s = (ArrayList<DtServicio>) request.getAttribute("listaServicios");
            //ArrayList<DtPromocion> p = (ArrayList<DtPromocion>) request.getAttribute("listaPromociones");
            ArrayList<DtServicio> s = ModelArticulo.getInstance().listarServiciosXprov(request.getSession().getAttribute("usuario_logueado").toString());
            ArrayList<DtPromocion> p = ModelArticulo.getInstance().listarPromocionesXprov(request.getSession().getAttribute("usuario_logueado").toString());
        %>

        <div class="col-xs-12" style="margin-top: 50px">
            <div class="row bg-primary" style="height: 32px">
                <div class="col-xs-6">
                    <button style="width: 100%; height: 100%; font-family: Helvetica; border-style: none"
                            class="btn btn-primary" onclick="Servicios()">SERVICIOS</button>
                </div>
                <div class="col-xs-6">
                    <button style="width: 100%; height: 100%; font-family: Helvetica; border-style: none"
                            class="btn btn-primary" onclick="Promociones()">PROMOCIONES</button>
                </div>
            </div>
            <!-- COMIENZO SECCION PARA PANELES CON ARTICULOS DE MIERDA --> 
            <div class="panel-group" id="paneles">

                <%   for (int x = 0; x < s.size(); x++) {%>

                <!-- SECCION A TENER POR CADA SERVICIO -->
                <div class="panel panel-success" id="<%="serv" + (x + 1)%>" style="margin-top: 5px; display: none">
                    <div id="<%="nombreServ" + (x + 1)%>" class="panel-heading btn" data-toggle="collapse" data-target="#<%="bodyServ" + (x + 1)%>" style="color: #333333; font-family: Helvetica; font-size: 115%; width: 100%; text-align: left" onclick="datosServicio('<%= s.get(x).getNickProveedor() %>', '<%= s.get(x).getNombre() %>')"><%= s.get(x).getNombre()%></div>
                    <h4 id="<%="precioServ" + (x + 1)%>" style="position: absolute; right: 30px; margin-top: -30px; font-family: Helvetica; color: #212121"></h4>
                    <div class="panel-body collapse fade" id="<%="bodyServ" + (x + 1)%>">
                        <div class="row">
                            <div class="col-xs-12" style="max-height: 100px; overflow-y: auto">
                                <h5 id="<%="descServ" + (x + 1)%>" style="font-family: Helvetica; color: #212121"></h5>
                            </div>
                        </div>
                        <div class="row">
                            <!-- INICIO CARRUSEL DE IMAGENES DEL SERVICIO -->
                            <center>
                                <div class="col-xs-12">
                                    <div id="<%="imgServ" + (x + 1)%>" class="carousel slide" data-ride="carousel" style="width: 90%; max-width: 400px; height: 250px; margin-top: 5px">
                                        <ol class="carousel-indicators">
                                            <li data-target="#<%="imgServ" + (x + 1)%>" data-slide-to="0" class="active"></li>
                                            <li data-target="#<%="imgServ" + (x + 1)%>" data-slide-to="1"></li>
                                            <li data-target="#<%="imgServ" + (x + 1)%>" data-slide-to="2"></li>
                                        </ol>
                                        <div class="carousel-inner" role="listbox">
                                            <div class="item active">
                                                <img src="devolverImagen?nickP=<%=s.get(x).getNickProveedor()%>&nomA=<%=s.get(x).getNombre()%>&campo=1" style="height: 250px" class="img-responsive img-thumbnail">
                                            </div>
                                            <div class="item">
                                                <img src="devolverImagen?nickP=<%=s.get(x).getNickProveedor()%>&nomA=<%=s.get(x).getNombre()%>&campo=2" style="height: 250px" class="img-responsive img-thumbnail">
                                            </div>
                                            <div class="item">
                                                <img src="devolverImagen?nickP=<%=s.get(x).getNickProveedor()%>&nomA=<%=s.get(x).getNombre()%>&campo=3" style="height: 250px" class="img-responsive img-thumbnail">
                                            </div>
                                        </div>
                                        <a class="left carousel-control" href="#<%="imgServ" + (x + 1)%>" role="button" data-slide="prev">
                                            <span aria-hidden="true" style="font-family: Helvetica; font-style: italic; font-size: 26px">&lt;</span>
                                        </a>
                                        <a class="right carousel-control" href="#<%="imgServ" + (x + 1)%>" role="button" data-slide="next">
                                            <span aria-hidden="true" style="font-family: Helvetica; font-style: italic; font-size: 26px">&gt;</span>
                                        </a>
                                    </div>
                                </div>
                            </center>
                            <!-- FIN CARRUSEL DE IMAGENES -->
                        </div>
                    </div>
                </div>

                <% } %>

                <%   for (int x = 0; x < p.size(); x++) {%>

                <div class="panel panel-success" id="<%="promo" + (x + 1)%>" style="margin-top: 5px; display: none">
                    <div id="<%="nombrePromo" + (x + 1)%>" class="panel-heading btn" style="color: #333333; font-family: Helvetica; font-size: 115%; width: 100%; text-align: left"
                         data-toggle="collapse" data-target="#<%="bodyPromo" + (x + 1)%>" onclick="datosPromocion('<%= p.get(x).getNickProv() %>', '<%= p.get(x).getNombre() %>')"><%= p.get(x).getNombre() %></div>
                         <h4 id="<%="precioPromo" + (x + 1)%>" style="position: absolute; right: 30px; margin-top: -30px; font-family: Helvetica; color: #212121"></h4>
                    <div class="panel-body collapse fade" id="<%="bodyPromo" + (x + 1)%>">
                        <div class="row">
                            <div class="col-xs-12" style="max-height: 100px; overflow-y: auto">
                                <h5 id="<%="descPromo" + (x + 1)%>" style="font-family: Helvetica; color: #212121; margin-top: 0px">
                                    <b></b>
                                </h5>
                            </div>
                        </div>
                        <div class="row">
                            <center>
                                <div class="col-xs-12">
                                    <div class="row bg-info" style="border-left-style: solid; border-color: #01529e; border-width: 4px">
                                        <div class="col-xs-12">
                                            <h5 style="font-family: Helvetica; text-align: left">Servicios asociados</h5>
                                        </div>
                                    </div>
                                    
                                    <!-- FILA A TENER POR CADA SERVICIO ASOCIADO A LA PROMO -->
                                    <div id="<%="articulosPromo" + (x + 1)%>" class="row" style="border-left-style: solid; border-color: #01529e; border-width: 4px">
                                        <!-- FIN FILA A TENER POR CADA SERVICIO ASOCIADO -->
                                    </div>
                                
                                </div>
                            </center>
                        </div>
                    </div>
                </div>

                <% }%>

            </div>
                
                <script type="text/javascript">
                    function datosServicio(nicknameProv, nombreServ){
                        $.get("devolverServicio", "nickname=" + nicknameProv + "&servicio=" + nombreServ, function (servicio) {
                            for(var x = 0; x < <%= s.size() %>; x++){
                                if(document.getElementById('nombreServ' + (x+1)).innerHTML === nombreServ){
                                    document.getElementById('descServ' + (x+1)).innerHTML = servicio.descripcion;
                                    document.getElementById('precioServ' + (x+1)).innerHTML = servicio.precio;
                                }
                            }
                        });
                    }
                </script>
                <script type="text/javascript">
                    function datosPromocion(nicknameProv, nombrePromo){
                        $.get("devolverPromocion", "nickname=" + nicknameProv + "&promocion=" + nombrePromo, function (promocion) {
                             for(var x = 0; x < <%= p.size() %>; x++){
                                if(document.getElementById('nombrePromo' + (x+1)).innerHTML === nombrePromo){
                                    document.getElementById('descPromo' + (x+1)).innerHTML = promocion.descuento + "% descuento";
                                    document.getElementById('precioPromo' + (x+1)).innerHTML = promocion.precio;
                                }
                             }
                         });
                         $.get("devolverServiciosPromocion", "nickname=" + nicknameProv + "&nombrePromo=" + nombrePromo, function (servicios) {
                            for(var x = 0; x < <%= p.size() %>; x++){
                                if(document.getElementById('nombrePromo' + (x+1)).innerHTML === nombrePromo){
                                    $.each(servicios, function (index, serv) {
                                        
                                        var h5 = document.createElement("h5");
                                        h5.id = "NombreServ"+ (index+1) + "Promo" + (x+1);
                                        h5.style.fontFamily = "Helvetica";
                                        h5.style.textAlign = "left";
                                        h5.style.marginLeft = "5px";
                                        h5.innerHTML = serv;
                                        
                                        var col = document.createElement("div");
                                        col.class = "col-xs-12";
                                        col.appendChild(h5);
                                        col.style.borderBottomStyle = "solid";
                                        col.style.borderBottomColor = "#01529e";
                                        col.style.borderBottomWidth = "1px";
                                        
                                        var fila = document.createElement("div");
                                        fila.id = "serv"+ (index+1) + "Promo" + (x+1);
                                        fila.class = "row";
                                        fila.appendChild(col);
                                        
                                        document.getElementById('articulosPromo' + (x+1)).appendChild(fila);
                                        
                                    });
                                }
                            } 
                         });
                    }
                </script>
                
                <script>
                    function Promociones(){
                            for(var x = 0; x < <%= s.size() %>; x++){
                                document.getElementById('serv' + (x+1)).style.display="none";
                            }
                            for(var x = 0; x < <%= p.size() %>; x++){
                                document.getElementById('promo' + (x+1)).style.display="block";
                            }

                    }
                </script>
                <script>
                    function Servicios(){
                        for(var x = 0; x < <%= s.size() %>; x++){
                            document.getElementById('serv' + (x+1)).style.display="block";
                        }
                        for(var x = 0; x < <%= p.size() %>; x++){
                            document.getElementById('promo' + (x+1)).style.display="none";
                        }

                    }
                </script>
                
    </body></html>