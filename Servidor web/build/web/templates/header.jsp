<%@page contentType="text/html" pageEncoding="UTF-8"%>


        
 
        
<div class="navbar navbar navbar-static-top dkd">
    
            <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle dkd" data-toggle="collapse" data-target="#navbar-ex-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand dkd" href="index.jsp" style="font-size: 40">HELP<b>4</b>TRAVELING</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
              <ul class="nav navbar-nav navbar-right dkd">
                <li>
                  <a href="consultarServVisitante.jsp" class="dkd">SERVICIOS</a>
                </li>
                <li>
                  <a href="consultarPromVisitante.jsp" class="dkd">PROMOCIONES</a>
                </li>
                <li>
                  <a href="consultarProvVisitante.jsp" class="dkd">PROVEEDORES</a>
                </li>
                <li>
                  <a data-toggle="modal" data-target="#registrarse" class="dkd" >REGISTRARSE</a>
                </li>
                <li>
                    <a data-toggle="modal" data-target="#modalsesion" class="dkd" onclick="BLANK()">INICIAR SESION</a>
                </li>
              </ul>
            </div>
        </div>
    </div>

 <div id="registrarse" class="modal fade" role="dialog">
     
     
     
      <div class="modal-dialog" style="width: 70%">
          
          
        <div class="modal-content">
          <div class="modal-header" style="background-color: #4A4C4E; min-height: 50px; max-height: 50px">
            <button type="button" class="close" data-dismiss="modal" style="color: white">×</button>
            <center>
            <h3 class="modal-title" style="font-family: Helvetica; color: #8e969f; margin-top: -5px">
              REGISTRARSE
            </h3>
            </center>
          </div>
          <div class="modal-body" style="height: 70%; max-height: 650px; min-height: 650px; overflow-y: auto; background-color: white">
            <div class="row" style="height: 35%">
              <div class="row" style="height: 70%; width: 100%; margin-left: 0px">
                <center>
                  <img src="img/logo2.png">
                </center>
              </div>
              <div class="row" style="height: 20%; width: 100%; margin-left: 0px">
                <center>
                  <h1 style="font-family: Helvetica; color:#01529e; margin-top: 0px">HELP4TRAVELING</h1>
                </center>
              </div>
            </div>
            <div class="row" style="height: 60%">
              <div class="col-md-11" style="width: 98%; margin-left: 5px">
                  <form id="regi" action="ControllerUsuario" method="post" class="form-horizontal" role="form" onsubmit="Tamal()">
                  <center> 
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label for="nick" class="control-label">Nick</label>
                      </div>
                      <div class="col-sm-9">
                          <input name="nick" type="text" class="form-control" id="nick" placeholder="Nick">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label for="Email" class="control-label">Email</label>
                      </div>
                      <div class="col-sm-9">
                        <input id="email" type="email" name="email" class="form-control" placeholder="Email">
                      </div>
                      <div class="form-group"></div>
                      <div class="col-sm-2">
                        <label for="inputPassword" class="control-label">Password</label>
                      </div>
                      <div class="col-sm-9">
                        <input id="pass" name="pass" type="password" class="form-control" placeholder="Password">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label for="inputConfPassword" class="control-label">Confirmar Password</label>
                      </div>
                      <div class="col-sm-9">
                        <input id="pass2" name="pass2" type="password" class="form-control" placeholder="Confirmar Password">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label for="inputNombre" class="control-label">Nombre</label>
                      </div>
                      <div class="col-sm-9">
                        <input id="nombre" name="nombre" type="text" class="form-control" placeholder="Nombre">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label for="inputApellido" class="control-label">Apellido</label>
                      </div>
                      <div class="col-sm-9">
                        <input id="ape" name="apellido" type="text" class="form-control" placeholder="Apellido">
                      </div>
                    </div>
                    <h4>Facha de Nacimiento</h4>
                    <br>
                    <center>
                      <div style="width: 100%; margin-left: 0px" class="row">
                        <div class="col-md-3" style="margin-left:90px">
                          <div class="col-sm-2">
                            <label for="dia" class="control-label">Dia</label>
                          </div>
                          <div class="col-sm-9">
                            <input id="dia" name="fnac1" type="number" min="1" class="form-control" placeholder="Dia">
                          </div>
                        </div>
                        <div class="col-md-3" style="margin-left:10">
                          <div class="col-sm-2">
                            <label for="mes" class="control-label">Mes</label>
                          </div>
                          <div class="col-sm-9">
                              <input id="mes" name="fnac2" type="number" min="1" class="form-control" placeholder="Mes">
                          </div>
                        </div>
                        <div class="col-md-3" style="margin-left:25">
                          <div class="col-sm-2">
                            <label for="anio" class="control-label">Año</label>
                          </div>
                          <div class="col-sm-9">
                            <input id="anio" name="fnac3" type="number" min="1900" class="form-control" placeholder="Año">
                          </div>
                        </div>
                      </div>
                    </center>
                  </center>
                      
                </form>
              </div>
            </div>
          </div>
        <div class="modal-footer" style="background-color: #8e969f">
            <input class="btn-toolbar" type="submit" name="enviar" value="Aceptar" onclick="REGISTRARSE()"/>
          <!--<input type="submit" class="btn btn-default" data-dismiss="modal" style="background-color: #4A4C4E; color: white; border: none; font-family: Helvetica">-->
        </div> 
        </div>
      </div>
    </div>

   <div id="modalsesion" class="modal fade" role="dialog">
      <div class="modal-dialog" style="width: 60%">
        <div class="modal-content">
            
          <div class="modal-header" style="background-color: #4A4C4E; min-height: 50px; max-height: 50px">
            <button type="button" class="close" data-dismiss="modal" style="color: white">×</button>
            <center>
            <h3 class="modal-title" style="font-family: Helvetica; color: #8e969f; margin-top: -5px">
              INICIAR SESIÓN
            </h3>
            </center>
          </div>
          <div class="modal-body" style="height: 50%; max-height: 550px; min-height: 550px; overflow-y: auto; background-color: white">
            <div class="col-md-12" style="height: 100%">
              <div class="row" style="height: 50%">
                <div class="row" style="height: 55%">
                  <div class="col-md-4"></div>
                  <div class="col-md-4">
                    <center>
                      <img src="img/logo2.png">
                    </center>
                  </div>
                  <div class="col-md-4"></div>
                </div>
                <div class="row" style="height: 40%">
                  <div class="col-md-3"></div>
                  <div class="col-md-6">
                    <h1 style="font-family: Helvetica; color: #01529e; font-size: 50px; width: 135px; margin-left: -30px">HELP</h1>
                    <h1 style="font-family: Helvetica; color: #313131; font-size: 65px; width: 40px; margin-top: -80px; margin-left: 100px">
                      <b>4</b>
                    </h1>
                    <h1 style="font-family: Helvetica; color: #01529e; font-size: 50px; width: 200px; margin-top: -65px; margin-left: 135px">TRAVELING</h1>
                  </div>
                  <div class="col-md-3"></div>
                </div>
              </div>
              <div class="row" style="height: 280px; background-color: #01529e">
                <div class="col-md-3" style="margin-top: -40px;"></div>
                </br></br>
                <form id="pBolDo" action="IniciarSesion" method="post" class="form-horizontal" role="form">
                <div class="col-md-8" style="margin-top: -40px;">
                  <div class="row" style="min-height: 25%; margin-top: 20px; margin-left: 250px">
                    <h4 style="font-family: Helvetica; color: white; margin-top: 30px">NICKNAME</h4>
                  </div>
                  <div class="row" style="min-height: 25%; margin-left: 250px">
                      <input name="idNick" id="idNick" style="width: 100%; height: 25px; font-family: Helvetica" type="text">
                  </div>
                  <div class="row" style="min-height: 25%; margin-top: -20px">
                    <h4 style="font-family: Helvetica; color: white; margin-top: 30px; margin-left: 250px">CONTRASEÑA</h4>
                  </div>
                  <div class="row" style="min-height: 25%; margin-left: 250px">
                    <input name="idPass" id="idPass" style="width: 100%; height: 25px; font-family: Helvetica" type="password">
                  </div>
                </div>
                </form>
                <div class="col-md-3" style="margin-top: -40px;"></div>
              </div>
            </div>
          </div>
          <div class="modal-footer" style="background-color: #8e969f">
            <center>
                <button type="button" class="btn btn-primary" data-dismiss="modal" style="background-color: #01529e;color: white; border: none; font-family: Helvetica" onclick="USER_PASS()">
                <b>INICIAR SESIÓN</b>
              </button>
            </center>
          </div>
        </div>
      </div>
    </div>

<script type="text/javascript">
        function REGISTRARSE() {
            //alert(document.getElementById("nick").value);
            if (document.getElementById("nick").value == "" || document.getElementById("email").value == "" || document.getElementById("pass").value == "" || document.getElementById("pass2").value == "" || document.getElementById("nombre").value == "" || document.getElementById("ape").value == "" || document.getElementById("dia").value == "" || document.getElementById("mes").value == "" || document.getElementById("anio").value == ""){
                alert("Debe llenar todos los campos!!");
            }else{
                document.getElementById('regi').submit();
            }
            
        }
                
</script>

<script type="text/javascript">
    function USER_PASS() {
        //alert(document.getElementById("nick").value);
        if(document.getElementById("idNick").value == "" || document.getElementById("idPass").value == ""){
            alert("Debe llenar todos los campos!!");
        }else{
            document.getElementById('pBolDo').submit();
        }
    }         
</script>

<script type="text/javascript">
    function BLANK() {
        document.getElementById("idNick").value='';
        document.getElementById("idPass").value='';
    }         
</script>
