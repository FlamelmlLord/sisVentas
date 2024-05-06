/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.dao.EmpleadoDAO;
import modelo.dto.EmpleadoDTO;
import modelo.dto.ProductoDTO;
import modelo.dao.ProductoDAO;
import modelo.dto.ClienteDTO;
import modelo.dao.ClienteDAO;
import modelo.dao.VentaDAO;
import modelo.dto.VentaDTO;
import utils.GenerarSerie;

/**
 *
 * @author DAVID
 */
public class Controlador extends HttpServlet {
    
    VentaDTO vDTO = new VentaDTO();
    EmpleadoDTO eDto = new EmpleadoDTO();
    EmpleadoDAO eDao = new EmpleadoDAO();
    List<VentaDTO> lista = new ArrayList<>();
    double totalPagar = 0.0;
    VentaDAO vDAO = new VentaDAO();
    String numeroSerie = "";
    ClienteDAO cDao = new ClienteDAO();
    ClienteDTO cDto = new ClienteDTO();
    ProductoDTO pDto = new ProductoDTO();
    ProductoDAO pDao = new ProductoDAO();
    int item = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String action = request.getParameter("accion");
        if (menu.equals("Principal")){
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if(menu.equals("Empleados")){
            String id;
            switch(action){
                case "Listar":
                    ArrayList<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
                    lista = eDao.listAll();
                    request.setAttribute("empleados", lista);
                    break;
                case "Crear":
                    String usuario = request.getParameter("txtUsuario");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String telefono = request.getParameter("txtTelefono");
                    String pass = request.getParameter("txtPassword");
                    int estado = Integer.parseInt(request.getParameter("txtEstado"));
                    eDto.setUsuario(usuario);
                    eDto.setNombres(nombres);
                    eDto.setApellidos(apellidos);
                    eDto.setTelefono(telefono);
                    eDto.setPassword(pass);
                    eDto.setEstado(estado);
                    eDao.create(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    eDto.setUsuario(id);
                    eDto = eDao.search(eDto);
                    System.out.println(eDto.toString());
                    request.setAttribute("em", eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String usuario1 = request.getParameter("txtUsuario");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    String telefono1 = request.getParameter("txtTelefono");
                    String pass1 = request.getParameter("txtPassword");
                    int estado1 = Integer.parseInt(request.getParameter("txtEstado"));
                    eDto.setUsuario(usuario1);
                    eDto.setNombres(nombres1);
                    eDto.setApellidos(apellidos1);
                    eDto.setTelefono(telefono1);
                    eDto.setPassword(pass1);
                    eDto.setEstado(estado1);
                    eDao.update(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = request.getParameter("id");
                    eDto.setUsuario(id);
                    eDao.delete(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Productos")){
            int idP;
            switch(action){
                case "Listar":
                    ArrayList<ProductoDTO> lista = new ArrayList<ProductoDTO>();
                    lista = pDao.listAll();
                    request.setAttribute("productos", lista);
                    break;
                case "Crear":
                    String nombre = request.getParameter("txtNombre");
                    int cantidad = Integer.parseInt(request.getParameter("txtStock"));
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int estado = Integer.parseInt(request.getParameter("txtEstado"));
                    pDto.setNombre(nombre);
                    pDto.setStock(cantidad);
                    pDto.setPrecio(precio);
                    pDto.setEstado(estado);
                    pDao.create(pDto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idP = Integer.parseInt(request.getParameter("id"));
                    pDto.setId(idP);
                    pDto = pDao.search(pDto);
                    System.out.println(pDto.toString());
                    request.setAttribute("pr", pDto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    pDto.setId(Integer.parseInt(request.getParameter("txtIDproducto")));
                    String nombre1 = request.getParameter("txtNombre");
                    int cantidad1 = Integer.parseInt(request.getParameter("txtStock"));
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int estado1 = Integer.parseInt(request.getParameter("txtEstado"));
                    pDto.setNombre(nombre1);
                    pDto.setStock(cantidad1);
                    pDto.setPrecio(precio1);
                    pDto.setEstado(estado1);
                    System.out.println(pDto.toString());
                    pDao.update(pDto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idP = Integer.parseInt(request.getParameter("id"));
                    pDto.setId(idP);
                    pDao.delete(pDto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("Clientes")){
            String id;
            switch(action){
                case "Listar":
                    ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
                    lista = cDao.listAll();
                    request.setAttribute("clientes", lista);
                    break;
                case "Crear":
                    String identificacion = request.getParameter("txtIdentificacion");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String direccion = request.getParameter("txtDireccion");
                    int estado = Integer.parseInt(request.getParameter("txtEstado"));
                    cDto.setIdentificacion(identificacion);
                    cDto.setNombres(nombres);
                    cDto.setApellidos(apellidos);
                    cDto.setDireccion(direccion);
                    cDto.setEstado(estado);
                    cDao.create(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    cDto.setIdentificacion(id);
                    cDto = cDao.search(cDto);
                    System.out.println(cDto.toString());
                    request.setAttribute("cl", cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String identificacion1 = request.getParameter("txtIdentificacion");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    String direccion1 = request.getParameter("txtDireccion");
                    int estado1 = Integer.parseInt(request.getParameter("txtEstado"));
                    cDto.setIdentificacion(identificacion1);
                    cDto.setNombres(nombres1);
                    cDto.setApellidos(apellidos1);
                    cDto.setDireccion(direccion1);
                    cDto.setEstado(estado1);
                    cDao.update(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = request.getParameter("id");
                    cDto.setIdentificacion(id);
                    cDao.delete(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){   
            switch (action) {
                case "BuscarCliente":
                    String id = request.getParameter("codigocliente");
                    cDto.setIdentificacion(id);
                    cDto = cDao.search(cDto);
                    request.setAttribute("cDto", cDto);
                    break;
                case "BuscarProducto":
                    int idP = Integer.parseInt(request.getParameter("codigoproducto"));
                    pDto.setId(idP);
                    pDto = pDao.search(pDto);
                    request.setAttribute("cDto", cDto);
                    request.setAttribute("pDto", pDto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("cDto", cDto);
                    //Declaracion de variables
                    totalPagar = 0.0;
                    vDTO = new VentaDTO();
                    //Datos que iran en las variables
                    item += 1;
                    vDTO.setItem(item);
                    vDTO.setIDProducto(pDto.getId());
                    vDTO.setUUIDProducto(pDto.getUUID());
                    vDTO.setNombreProducto(request.getParameter("nomproducto"));
                    vDTO.setPrecioProducto(Double.parseDouble(request.getParameter("precio")));
                    vDTO.setCantidad(Integer.parseInt(request.getParameter("cant")));
                    System.out.println(vDTO.getCantidad());
                    vDTO.setSubtotal(vDTO.getPrecioProducto()*vDTO.getCantidad());//Para hallar el subtotal
                    lista.add(vDTO);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualizacion del stock
                    for (int i = 0; i < lista.size(); i++) {
                        //ProductoDTO pdto = new ProductoDTO();
                        int cantidad = lista.get(i).getCantidad();
                        pDto.setId(lista.get(i).getIDProducto());
                        //int idProducto = lista.get(i).getIDProducto();
                        //ProductoDAO pdao = new ProductoDAO();
                        pDto = pDao.search(pDto);
                        pDto.setStock(pDto.getStock() - cantidad); 
                        pDao.update(pDto);
                    }
                    
                    
                    vDTO.setIDCliente(cDto.getUUID());
                    vDTO.setIDEmpleado("74745017-f90f-11ed-9162-d85ed30d9217");
                    vDTO.setNumSerie(numeroSerie);
                    vDTO.setMonto(totalPagar);
                    vDTO.setEstado(1);
                    vDAO.create(vDTO);
                    
                    String UUIDv = vDAO.obtenerUUID(vDAO.IDVentas());
                    //Guardar detalle venta
                    for (int i = 0; i < lista.size(); i++) {
                        vDTO = new VentaDTO();
                        vDTO.setUUID(UUIDv);
                        vDTO.setUUIDProducto(lista.get(i).getUUIDProducto());
                        vDTO.setCantidad(lista.get(i).getCantidad());
                        vDTO.setPrecioProducto(lista.get(i).getSubtotal());
                        vDAO.guardarDetalleVentas(vDTO);
                    }
                    this.lista.clear();
                    break;
                case "Guardar":
                    int item = Integer.parseInt(request.getParameter("id"));
                    totalPagar = 0;
                    VentaDTO temp = null;
                    System.out.println(item);
                    for (int i = 0; i < lista.size();i++){
                        if (lista.get(i).getItem()==item){
                            temp = lista.get(i);
                            break;
                        }
                    }
                    if(temp==null){
                        break;
                    }
                    System.out.println(temp);
                    temp.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    temp.setSubtotal(temp.getPrecioProducto() * temp.getCantidad());//Para hallar el subtotal
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);

                    break;
                case "Eliminar":
                    int itemDel = Integer.parseInt(request.getParameter("id"));
                    totalPagar = 0;
                    for (int i = 0; i < lista.size();i++){
                        if (lista.get(i).getItem()==itemDel){
                            lista.remove(lista.get(i));
                            break;
                        }
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                    
                default:
                    numeroSerie = vDAO.GenerarSerie();
                    if(numeroSerie == null){
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    }else{
                        int incrementar  = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroSerie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
