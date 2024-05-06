package modelo.dto;

import java.util.Objects;

public class EmpleadoDTO {
    private String UUID;
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String telefono;
    private int estado;

    public EmpleadoDTO(String UUID, String usuario, String password, String nombres, String apellidos, String telefono, int estado) {
        this.UUID = UUID;
        this.usuario = usuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.estado = estado;
    }

    public EmpleadoDTO() {
        this.UUID = "";
        this.usuario = "";
        this.password = "";
        this.nombres = "";
        this.apellidos = "";
        this.telefono = "";
        this.estado = 0;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "UUID=" + UUID + ", usuario=" + usuario + ", password=" + password + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.UUID);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.nombres);
        hash = 79 * hash + Objects.hashCode(this.apellidos);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + this.estado;
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
        final EmpleadoDTO other = (EmpleadoDTO) obj;
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.UUID, other.UUID)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.telefono, other.telefono);
    }
    
    
    
    
}
