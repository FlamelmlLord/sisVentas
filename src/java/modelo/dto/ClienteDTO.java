package modelo.dto;

import java.util.Objects;

public class ClienteDTO {
    private String UUID;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int estado;

    public ClienteDTO(String UUID, String identificacion, String nombres, String apellidos, String direccion, int estado) {
        this.UUID = UUID;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estado = estado;
    }

    public ClienteDTO() {
        this.UUID = "";
        this.identificacion = "";
        this.nombres = "";
        this.apellidos = "";
        this.direccion = "";
        this.estado = 0;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.UUID);
        hash = 71 * hash + Objects.hashCode(this.identificacion);
        hash = 71 * hash + Objects.hashCode(this.nombres);
        hash = 71 * hash + Objects.hashCode(this.apellidos);
        hash = 71 * hash + Objects.hashCode(this.direccion);
        hash = 71 * hash + this.estado;
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
        final ClienteDTO other = (ClienteDTO) obj;
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.UUID, other.UUID)) {
            return false;
        }
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
    }
    
    
    
    
    
}
