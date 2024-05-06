package modelo.dto;

import java.util.Objects;

public class ProductoDTO {

    private String UUID;
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private int estado;
    
    public ProductoDTO(){
        this.UUID = "";
        this.id = 0;
        this.nombre = "";
        this.precio = 0;
        this.stock = 0;
        this.estado = 0;
    }

    public ProductoDTO(String UUID, int id, String nombre, double precio, int stock, int estado) {
        this.UUID = UUID;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "UUID=" + UUID + ", id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.UUID);
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 17 * hash + this.stock;
        hash = 17 * hash + this.estado;
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDTO other = (ProductoDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.UUID, other.UUID)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    
    
}
