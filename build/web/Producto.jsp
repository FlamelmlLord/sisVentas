<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
                crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
                crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=Productos" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del producto</label>
                            </div>
                            <br>
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" value="${pr.getId()}" name="txtIDproducto" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" value="${pr.getNombre()}" name="txtNombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${pr.getPrecio()}" name="txtPrecio" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" value="${pr.getStock()}" name="txtStock" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" value="${pr.getEstado()}" name="txtEstado" class="form-control">
                            </div>
                        </div>
                        <input type="submit" name="accion" value="Crear" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Stock</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="producto" items="${productos}">
                                    <tr>
                                        <td>${producto.getId()}</td>
                                        <td>${producto.getNombre()}</td>
                                        <td>$ ${producto.getPrecio()}</td>
                                        <td>${producto.getStock()}</td>
                                        <td>${producto.getEstado()}</td>
                                        <td>
                                            <a href="Controlador?menu=Productos&accion=Editar&id=${producto.getId()}" class="btn btn-warning">Editar</a>
                                            <a href="Controlador?menu=Productos&accion=Eliminar&id=${producto.getId()}" class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
