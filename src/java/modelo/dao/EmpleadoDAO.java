package modelo.dao;

import interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.dto.EmpleadoDTO;
import utils.Connector;
import utils.Security;

public class EmpleadoDAO implements IDao<EmpleadoDTO> {

    
    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public EmpleadoDTO search(EmpleadoDTO obj) {
        EmpleadoDTO e = new EmpleadoDTO();
        String SQL =  "SELECT * FROM empleado WHERE Usuario=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
             ps.setString(1, obj.getUsuario());
            rs = ps.executeQuery();
            while(rs.next()){
                e.setUUID(rs.getString(1));
                e.setUsuario(rs.getString(2));
                e.setNombres(rs.getString(3));
                e.setApellidos(rs.getString(4));
                e.setTelefono(rs.getString(5));
                e.setEstado(rs.getInt(6));
            }
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }finally{
            conn.closeConnection();
        }
        return e;
    }

    @Override
    public ArrayList<EmpleadoDTO> listAll() {
        ArrayList<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
        String SQL = "SELECT * FROM empleado";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                EmpleadoDTO e = new EmpleadoDTO();
                e.setUUID(rs.getString(1));
                e.setUsuario(rs.getString(2));
                e.setNombres(rs.getString(3));
                e.setApellidos(rs.getString(4));
                e.setTelefono(rs.getString(5));
                e.setEstado(rs.getInt(6));
                lista.add(e);
            }
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
        }finally{
            conn.closeConnection();
        }
        
        return lista;
    }

    @Override
    public boolean delete(EmpleadoDTO obj) {
        String SQL = "DELETE FROM empleado WHERE Usuario=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
        
        return true;
        
    }

    @Override
    public boolean update(EmpleadoDTO obj) {
        String SQL = "UPDATE empleado SET Nombres=?, Apellidos=?, Telefono=?, Estado=?, password=? WHERE Usuario=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getTelefono());
            ps.setInt(4, obj.getEstado());
            ps.setString(5, Security.encryptPassword(obj.getPassword(), "aSrQe165Z!a-w_qs".getBytes()));
            ps.setString(6, obj.getUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
        
        return true;
    }

    @Override
    public boolean create(EmpleadoDTO obj) {
        String SQL = "INSERT INTO empleado(Usuario, Nombres, Apellidos, Telefono, Estado, password) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getNombres());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getTelefono());
            ps.setInt(5, obj.getEstado());
            ps.setString(6, Security.encryptPassword(obj.getPassword(), "aSrQe165Z!a-w_qs".getBytes()));
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
        
        return true;
    }
    
    public EmpleadoDTO logIn(String user, String pass){
        EmpleadoDTO empleado = new EmpleadoDTO();
        String SQL = "SELECT * FROM empleado WHERE Usuario = ? AND password = ?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, user);
            ps.setString(2, Security.encryptPassword(pass, "aSrQe165Z!a-w_qs".getBytes()));
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setUUID(rs.getString("UUID"));
                empleado.setUsuario(rs.getString("Usuario"));
                empleado.setNombres(rs.getString("Nombres"));
                empleado.setApellidos(rs.getString("Apellidos"));
                empleado.setTelefono(rs.getString("Telefono"));
                empleado.setEstado(rs.getInt("Estado"));
                empleado.setPassword(rs.getString("password"));
            }
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
        }finally{
            conn.closeConnection();
        }
        return empleado;
    }
    
}
