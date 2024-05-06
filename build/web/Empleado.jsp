<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
                crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
                crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
            <div class="card-body">
                <form action="Controlador?menu=Empleados" method="POST">
                    <div class="form-group">
                        <label> Usuario ${em.getUsuario()}</label>
                        <input type="text" value="${em.getUsuario()}" name="txtUsuario" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> Nombres </label>
                        <input type="text" value="${em.getNombres()}" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> Apellidos </label>
                        <input type="text" value="${em.getApellidos()}" name="txtApellidos" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> Telefono </label>
                        <input type="text" value="${em.getTelefono()}" name="txtTelefono" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> Contraseña </label>
                        <input type="password" name="txtPassword" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> Estado </label>
                        <input type="text" name="txtEstado" value="${em.getEstado()}" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Crear" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>${empleado.getUsuario()}</td>
                            <td>${empleado.getNombres()}</td>
                            <td>${empleado.getApellidos()}</td>
                            <td>${empleado.getTelefono()}</td>
                            <td>${empleado.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Editar&id=${empleado.getUsuario()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&id=${empleado.getUsuario()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        
        
    </body>
</html>
