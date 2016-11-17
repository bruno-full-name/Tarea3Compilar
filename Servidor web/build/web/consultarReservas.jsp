<%@page import="Modelo.ModelArticulo"%>
<%@page import="servidor.DtReserva"%>
<%@page import="servidor.DtInfoReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="jspdf.min.js"></script>
        <script type="text/javascript" src="dom-to-image.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/consultarReservas.css" rel="stylesheet" type="text/css">
        <link href="css/algo.css" rel="stylesheet" type="text/css">
    </head><body>
        <jsp:include page="templates/headerC.jsp"/>
        <%  Integer[] arr = (Integer[]) request.getAttribute("arrayReservas");
            String nameCli = (String) request.getAttribute("namecli");
            /*System.out.println(nameCli);
            System.out.println(arr[0]);*/
        %>

        <div class="divPrincipal">
            <div class="section">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12" style="border-bottom-style: solid; border-color: rgb(1, 82, 158); border-width: 9px">
                            <h1 class="text-center" style="color: #313131; font-family: Helvetica; ">RESERVAS</h1>
                        </div>
                    </div>
                    <div class="row" style="background-color: #01529e; min-height: 70px; max-height: 70px">
                        <div class="row" style="background-color: #01529e; min-height: 70px; max-height: 70px">
                            <div class="col-md-4" style="background-color: #01529e; min-height: 70px; max-height: 70px">
                                <div class="col-md-6">
                                    <h3 style="font-family: Helvetica; color: white; margin-top: 0px">
                                        <b>Estado actual:</b>
                                    </h3>
                                    <h3 style="font-family: Helvetica; color: white; margin-top: 0px">
                                        <b>Total:</b>
                                    </h3>
                                </div>
                                <div class="col-md-6">
                                    <h3 id="estadoAct" style="font-family: Helvetica; color: white; margin-left: -40px; margin-top: 0px"></h3>
                                    <h3 id="precioTot" style="font-family: Helvetica; color: white; margin-left: -40px; margin-top: 0px"></h3>
                                </div>
                            </div>
                            <div class="col-md-4" style="background-color: #01529e; min-height: 70px; max-height: 70px">
                                <div class="col-md-12"></div>
                            </div>
                            <div class="col-md-4" style="background-color: #01529e; min-height: 70px; max-height: 70px">
                                <div class="col-md-6">
                                    <button id="pagar" class="btn btn-primary" style="height: 35px; font-family: Helvetica; font-size: 20px; margin-top: 15px; width: 100%; display: none" onclick="pagar()" >Pagar</button>
                                    <button id="factura" data-toggle="modal" data-target="#modalFactura" class="btn btn-primary" style="height: 35px; font-family: Helvetica; font-size: 20px; margin-top: 15px; width: 100%; display: none">Ver factura</button>
                                </div>
                                <div class="col-md-6">
                                    <button id="cancel" class="btn btn-primary" style="height: 35px; font-family: Helvetica; font-size: 20px; margin-top: 15px; width: 100%" onclick="cancelar()">Cancelar reserva</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3" style="background-color: white; min-height: 550px; max-height: 550px; overflow-y: auto">
                            <div class="col-md-12">
                                <div class="row" style="margin-top: 20px; border-top-style: solid; border-width: 4px; border-color: #01529e">
                                    <center>
                                        <h3 style="height: 35px; font-family: Helvetica; color: #01529e; margin-top: 10px" contenteditable="true">
                                            <b>SELECCIONAR RESERVA</b>
                                        </h3>
                                    </center>
                                </div>
                                <!-- FILA A TENER POR CADA RESERVA -->
                                <%    for (int x = 0; x < arr.length; x++) {%>
                                <div class="row" style="height: 35px">
                                    <button style="height: 32px; width: 100%; font-family: Helvetica; font-size: 18px" class="btn btn-primary" onclick="CONSULTAR('<%= arr[x]%>', '<%= nameCli%>')"><%= arr[x]%></button>
                                </div>
                                <%    }%>
                                <!-- FIN FILA A TENER POR CADA RESERVA -->
                            </div>
                        </div>
                        <!-- SECCION CON SCROLL DE ARTICULOS -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-9" style="height: 550px; max-height: 550px; overflow-y: auto; background-color: white">
                                    <table id="tablaLoca" class="table">
                                        <thead style="background-color: #E6E6E6; color: #01529e;  border-bottom-style: solid; border-width: 4px; border-color: #01529e">
                                            <tr style="height: 40px">
                                                <th style="width: 30%; font-family: Helvetica; font-size: 18px">nombre articulo</th>
                                                <th style="width: 30%; font-family: Helvetica; font-size: 18px">nick prov</th>
                                                <th style="width: 20%; font-family: Helvetica; font-size: 18px">precio</th>
                                                <th style="width: 20%; font-family: Helvetica; font-size: 18px">cantidad</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbodyLoco">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- COMIENZO MODAL CON INFORMACION DE LA FACTURA -->

        <div id="modalFactura" class="modal fade" role="dialog">
            <div class="modal-dialog" style="width: 50%">
                <div class="modal-content">
                    <div class="modal-header" id="modalHeader" style="background-color: #4A4C4E; min-height: 50px; max-height: 50px">
                        <button type="button" class="close" data-dismiss="modal" style="color: white">×</button>
                        <img src="img/logo.png" style="margin-top: -12px; margin-left: -10px">
                        <h3 style="font-family: Helvetica; color: #8e969f; margin-top: -35px; margin-left: 50px">Información de la factura</h3>
                    </div>
                    <div id="modalBody" class="modal-body" style="height: 90%; max-height: 90%; min-height: 550px; overflow-y: auto; background-color: white">
                        <div class="row" id="vapai" style="border-left-style: solid; border-width: 4px; border-color: #01529e">
                            <div class="row" style="width: 100%; margin-left: 0px">
                                <div class="col-md-3">
                                    <h4 style="font-family: Helvetica">
                                        <b>Id reserva:</b>
                                    </h4>
                                    <h4 style="font-family: Helvetica">
                                        <b>Cliente:</b>
                                    </h4>
                                    <h4 style="font-family: Helvetica">
                                        <b>Precio total:</b>
                                    </h4>
                                    <h4 style="font-family: Helvetica">
                                        <b>Fecha:</b>
                                    </h4>
                                </div>
                                <div class="col-md-9">
                                    <h4 id="idReservaModal" style="font-family: Helvetica"></h4>
                                    <h4 id="nickClienteModal" style="font-family: Helvetica"></h4>
                                    <h4 id="precioTotalModal" style="font-family: Helvetica"></h4>
                                    <h4 id="fechaModal" style="font-family: Helvetica"></h4>
                                </div>
                            </div>
                        </div>
                        <!-- FIN INFO & COMIENZO SECCION ARTICULOS ASOCIADOS -->
                        <div class="row" style="width: 100%; margin-left: 0px; border-bottom-style: solid; border-color: #01529e">
                            <h4 style="font-family: Helvetica; color: #01529e">Articulos asociados</h4>
                        </div>
                        <div class="row" style="width: 100%; margin-left: 0px">
                            <div class="col-md-3">
                                <h4 style="font-family: Helvetica">
                                    <b>Nombre</b>
                                </h4>
                            </div>
                            <div class="col-md-3">
                                <h4 style="font-family: Helvetica">
                                    <b>Proveedor</b>
                                </h4>
                            </div>
                            <div class="col-md-3">
                                <h4 style="font-family: Helvetica">
                                    <b>Cantidad</b>
                                </h4>
                            </div>
                            <div class="col-md-3">
                                <h4 style="font-family: Helvetica">
                                    <b>Precio</b>
                                </h4>
                            </div>
                        </div>
                        <!-- COMIENZO FILA A TENER POR CADA ARTICULO EN LA RESERVA -->
                        <div class="row" style="width: 100%; margin-left: 0px; border-bottom-style: solid; border-width: 1px; border-color: #01529e">
                            <div class="col-md-3">
                                <h5 id="nombreModal" style="font-family: Helvetica"></h5>
                            </div>
                            <div class="col-md-3">
                                <h5 id="nickProvModal" style="font-family: Helvetica"></h5>
                            </div>
                            <div class="col-md-3">
                                <h5 id="cantidadModal" style="font-family: Helvetica"></h5>
                            </div>
                            <div class="col-md-3">
                                <h5 id="precioArticuloModal" style="font-family: Helvetica"></h5>
                            </div>
                        </div>
                        <!-- FIN FILA A TENER POR CADA ARTICULO EN LA RESERVA -->
                    </div>
                    <div class="modal-footer" style="background-color: #8e969f; height: 50px">
                        <button type="button" class="btn btn-primary" style="color: white; border: none; font-family: Helvetica; margin-top: -5px; right: 7px; position: absolute" onclick="toPDF()">
                            <b>GENERAR PDF</b>
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- FIN MODAL CON INFORMACION DE LA FACTURA -->

        <jsp:include page="templates/footer.jsp"/>


        <script type="text/javascript">
            function CONSULTAR(id, name) {
                //alert("holaaaaaaaaaa");
                //alert(id + " " + name);
                document.getElementById("cancel").value = id;
                document.getElementById("pagar").value = id;
                $.get("ControllerInfoReserva", "cli=" + name + "&resID=" + id + "&num=1", function (responseJson) {
                    //alert(responseJson);
                    //document.getElementById("tbody");
                    $("#tbody").children().remove();
                    var tblBody = document.getElementById("tbody");

                    $("#tbodyLoco").children().remove();
                    var tblBody = document.getElementById("tbodyLoco");
                    $.each(responseJson, function (index, product) {
                        //alert(index);
                        var row = document.createElement("tr");

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(product.nameArticulo);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(product.nickProveedor);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(product.precioArticulo);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(product.cantidad);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        tblBody.appendChild(row);

                        // cargo mismos datos en modal

                        document.getElementById("nombreModal").innerHTML = product.nameArticulo;
                        document.getElementById("nickProvModal").innerHTML = product.nickProveedor;
                        document.getElementById("cantidadModal").innerHTML = product.cantidad;
                        document.getElementById("precioArticuloModal").innerHTML = product.precioArticulo;

                    });
                });
                $.get("ControllerInfoReserva", "cli=" + name + "&resID=" + id + "&num=2", function (responseJson) {
                    document.getElementById("estadoAct").innerHTML = responseJson.estado;
                    document.getElementById("precioTot").innerHTML = responseJson.precio;

                    if (document.getElementById("estadoAct").innerHTML === "FACTURADA" || document.getElementById("estadoAct").innerHTML === "Facturada") {
                        document.getElementById("factura").style.display = "block";
                    } else
                        document.getElementById("factura").style.display = "none";
                    
                    if (document.getElementById("estadoAct").innerHTML === "REGISTRADA" || document.getElementById("estadoAct").innerHTML === "Registrada") {
                        document.getElementById("pagar").style.display = "block";
                    } else
                        document.getElementById("pagar").style.display = "none";

                    // cargo la misma mierda en el modal

                    document.getElementById("idReservaModal").innerHTML = id;
                    document.getElementById("nickClienteModal").innerHTML = name;
                    document.getElementById("precioTotalModal").innerHTML = responseJson.precio;
                    var f = new Date();
                    document.getElementById("fechaModal").innerHTML = (f.getFullYear() + "/" + f.getMonth() + "/" + f.getDate());

                });
            }

        </script>
        <script>
            function cancelar() {
                if (document.getElementById("estadoAct").innerHTML === "REGISTRADA") {
                    if (document.getElementById("cancel").value != "") {
                        $.get("ControlCancelarReserva", "id=" + document.getElementById("cancel").value, function (resonse) {
                            document.getElementById("estadoAct").innerHTML = "CANCELADA";
                            alert("Reserva Cancelada");
                        });
                    }
                }

            }
        </script>
        
        <script>
            function pagar() {
                //alert("asdsadsa");
                if (document.getElementById("estadoAct").innerHTML === "REGISTRADA") {
                    //alert(document.getElementById("pagar").value);
                    if (document.getElementById("pagar").value != "") {
                        //alert("asdsadsa");
                        $.get("PagarReserva", "id=" + document.getElementById("pagar").value, function (resonse) {
                            document.getElementById("estadoAct").innerHTML = "PAGADA";
                            alert("Reserva Pagada");
                        });
                    }
                }

            }
        </script>

        <script type="text/javascript">
            function toPDF() {
                domtoimage.toJpeg(document.getElementById("modalHeader")).then(function (data) {
                    var doc = new jsPDF('landscape');
                    doc.addImage(data, 'JPEG', 10, 10);
                    domtoimage.toJpeg(document.getElementById("modalBody")).then(function (data) {
                        doc.addImage(data, 'JPEG', 10, 30);
                        doc.save(document.getElementById("nickClienteModal").innerHTML + "_" + document.getElementById("fechaModal").innerHTML + ".pdf");
                    });
                });
                $.get("agregarFactura", "reservaFactura=" + document.getElementById("idReservaModal").innerHTML + "&nickFactura=" + document.getElementById("nickClienteModal").innerHTML + "&precioFactura=" + document.getElementById("precioTotalModal").innerHTML, function (ingresado) {
                    if(ingresado){
                        alert("FACTURA INGRESADA");
                    }
                });
                
            }
        </script>
        
        <script type="text/javascript">
            function enviarMail() {
                /*var fecha = Date.getFullYear() + "/" + Date.getMonth() + "/" + Date.getDate();
                var hora = Date.getHours() + ":" + Date.getMinutes();
                
                var cuerpo = "Estimado ";
                
                var link = "mailto: //request.getSession().getAttribute("email_usuario").toString()"
                         + "&subject=" + escape("[Help4Traveling][" + fecha + " " + hora + "]")
                         + "&body=" + escape(document.getElementById('myText').value);

                window.location.href = link;*/
            }
            
        </script>


    </body></html>

