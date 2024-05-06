package modelo.dto;

import java.util.Date;

public class VentaDTO {
    private String UUID;
    private int ID;
    private int item;
    private String IDCliente;
    private String IDEmpleado;
    private String UUIDProducto;
    private int IDProducto;
    private String numSerie;
    private String nombreProducto;
    private Date fechaActual; 
    private double precioProducto;
    private int cantidad;
    private double subtotal;
    private double monto;
    private int estado;

    public VentaDTO() {
    }

    public VentaDTO(String UUID, int ID, String IDCliente, String IDEmpleado, String UUIDProducto, int IDProducto, String numSerie, String nombreProducto, Date fechaActual, double precioProducto, int cantidad, double subtotal, double monto, int estado) {
        this.UUID = UUID;
        this.ID = ID;
        this.IDCliente = IDCliente;
        this.IDEmpleado = IDEmpleado;
        this.UUIDProducto = UUIDProducto;
        this.IDProducto = IDProducto;
        this.numSerie = numSerie;
        this.nombreProducto = nombreProducto;
        this.fechaActual = fechaActual;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public String getUUIDProducto() {
        return UUIDProducto;
    }

    public void setUUIDProducto(String UUIDProducto) {
        this.UUIDProducto = UUIDProducto;
    }

    

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(String IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
