<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Sistema de ventas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Empleados&accion=Listar" target="principalFrame">Empleados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Productos&accion=Listar" target="principalFrame">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Clientes&accion=Listar" target="principalFrame">Clientes</a>
                        </li> <!--as-->
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=NuevaVenta&accion=Listar" target="principalFrame">Nueva venta</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-info dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <c:out value="${requestScope.user.getNombres()} ${requestScope.user.getApellidos()}"/>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-light">
                            <li><a class="dropdown-item active" href="#">Usuario: <c:out value="${requestScope.user.getUsuario()}"/> </a></li>
                            <li><a class="dropdown-item" href="#">Telefono: <c:out value="${requestScope.user.getTelefono()}"/></a></li>
                            <li><a class="dropdown-item" href="#">Estado: 
                                    <c:if test="${requestScope.user.getEstado() == 1}">
                                        Usuario activo
                                    </c:if>
                                    <c:if test="${requestScope.user.getEstado() != 1}">
                                        Usuario inactivo
                                    </c:if>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider"></li>
                            <li>
                                <form action="Validar" method="POST">
                                    <button style="width:'100%'" name="login" value="Salir" type="submit" class="btn btn-light">Cerrrar sesión</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div style="height: 550px;">
            <iframe name="principalFrame" style="height: 100%; width: 100%; border: none;"></iframe>
        </div>
    </body>
</html>
