<%-- 
    Document   : Principal
    Created on : 05-sep-2018, 6:57:13
    Author     : patei
--%>
<%

    HttpSession sesion = request.getSession(true);
    Integer tipoUsuario = -1;
    if (sesion != null) {
        if (sesion.getAttribute("usuario") == null) {

        } else {
            tipoUsuario = (Integer) sesion.getAttribute("tipo");
        }
    } else {

    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio|MHUW</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Sorts+Mill+Goudy" rel="stylesheet">
        <!--        bootstrap library-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        
          <!-- Script's de sweet alert -->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/logout.js" type="text/javascript"></script>
        <link href="css/prototipo.css" rel="stylesheet" type="text/css"/>
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <link href="css/principal.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <div id="container">
            <div id="header">
                <div id="banner">
                    <h1 class="logo-una"><a href="http://www.una.ac.cr" target="_blank" title="logo UNA"><img src="templates/images/logo-una.png" alt="logoUNA"/></a></h1>
                    <h1 class="logo-ciemhcavi"><a href="http://www.peadep.una.ac.cr" target="_self" title="logo ciemhcavi"><img src="templates/images/logo-ciemhcavi.png" alt="logociemhcavi"/></a></h1>
                    <h1 class="linea-gris"><img src="templates/images/separador-gris.png" alt="sep-gris"/></h1>
                    <div><h1 class="nombre-entidad"> ESCUELA DE CIENCIAS DEL MOVIMIENTO HUMANO Y CALIDAD DE VIDA</h1></div>
                    <div><h1 class="abreviatura-entidad"> CIEMHCAVI</h1></div>
                </div> 
                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Inicio</a>
                        </li>
                        <% if (tipoUsuario == 2) { %> 
                        <li> <a class="nav-link" href="">Administrador</a></li>
                            <% }%> 
                         <% if (tipoUsuario == 0) { %> 
                        <li> <a class="nav-link" href="">Estudiantes</a></li>
                            <% }%> 

                    </ul>
                    <form class="navbar-form navbar-left" action="/action_page.php">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Buscar" name="buscar">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </div>

                    </form>


                    <% if (tipoUsuario == -1) { %> 
                    <ul class="nav navbar-nav ml-auto">
                        <li><a class="nav-link" href="Paginas/Registro.jsp"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
                        <li><a class="nav-link" href="Paginas/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
                    </ul>

                    <% }%> 
                    <% if (tipoUsuario != -1) { %> 
                    <ul class="nav navbar-nav ml-auto">
                         <div class="dropdown">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                          <% out.print(sesion.getAttribute("usuario")); %>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Edit Profile</a>
                            <a class="dropdown-item" href="#">Change Password</a>
                            <a class="dropdown-item" id="logout" >Logout</a>
                        </div>
                    </div>
                    </ul>
                   
                    <% }%> 
                    </ul>

                </nav>
            </div>
            <div id="body">
                <div id="NavegacionSegundaria">
                    <h4>Articulos recientes</h4>

                </div>
                <div id="demo" class="carousel slide" data-ride="carousel">

                    <!-- Indicators -->
                    <ul class="carousel-indicators">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>

                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div id="articuloFormat">
                                <h6>Titulo Prueba</h6><span id="autor">Autor: A </span><span id="fecha">Fecha:16/09/2018</span>
                                <p>Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de pruebaDatos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba...
                                </p>
                                <a href="#">Seguir Leyendo</a>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div id="articuloFormat">
                                <h6>Titulo Prueba</h6><span id="autor">Autor: b </span><span id="fecha">Fecha:16/09/2018</span>
                                <p>Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de pruebaDatos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba...
                                </p>
                                <a href="#">Seguir Leyendo</a>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div id="articuloFormat">
                                <h6>Titulo Prueba</h6><span id="autor">Autor: c </span><span id="fecha">Fecha:16/09/2018</span>
                                <p>Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de pruebaDatos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba
                                    Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba Datos de prueba...
                                </p>
                                <a href="#">Seguir Leyendo</a>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>





            </div>

            <div id="footer">
                <div class="row col-sm-12" >
                    <div class="col-sm-6"> 
                        <div class="copyright"  >
                            <p style="color: #ccc;">Copyright © 2018 Ciencia del Movimiento Humano y Calidad de Vida. Todos los derechos reservados.
                                <br />
                                <a style="color: #eee;" title="UNA" href="http://www.una.ac.cr" target="_blank">Universidad Nacional</a>.</p>
                        </div>
                    </div>
                    <div class="col-sm-6">              
                        <div class="contact"  >
                            <p style="color: #fff;"><strong>Información de Contacto:</strong></p>
                            <p style="color: #ccc;">Correo electrónico: <a title="corre de CIEMHCAVI" href="mailto:ciemhcavi@una.cr">ciemhcavi@una.cr</a> ,Telfs: 2261-0032 / 2237-5849</p></div>       
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
