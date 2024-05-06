<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
                crossorigin="anonymous"></script>
        </head>

        <body>
            <div class="container mt-4 col-lg-4">
                <div class="card col-sm-10">
                    <div class="card-body">
                        <form action="Validar" method="POST">
                            <div class="form-group text-center">
                                <h3>Login</h3>
                                <label> Bienvenido</label>
                            </div>
                            <div class="form-group">
                                <label>Usuario</label>
                                <input type="text" name="user" class="form-control" placeholder="Ingrese su usuario">
                            </div>
                            <div class="form-group">
                                <label>Contraseña</label>
                                <input type="password" name="pass" class="form-control" placeholder="Ingrese su contraseña">
                            </div>

                            <button name="login" value="Ingresar" type="submit" class="btn btn-primary" style="margin-top: 2rem">Ingresar</button>
                            <c:if test="${requestScope.notFounded}">
                                <label style='color: red;'><c:out value=" Error, usuario o contraseña incorrectos"/></label>
                            </c:if>
                        </form>
                          <!--Hola-->
				  <!--Hola 2-->
                    </div>
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
                integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
                integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
                crossorigin="anonymous"></script>
        </body>

        </html>