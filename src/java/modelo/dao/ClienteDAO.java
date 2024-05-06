package modelo.dao;

import interfaces.IDao;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Connector;
import modelo.dto.ClienteDTO;

public class ClienteDAO implements IDao<ClienteDTO>{

    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public ClienteDTO search(ClienteDTO obj) {
        ClienteDTO c = new ClienteDTO();
        String SQL =  "SELECT * FROM cliente WHERE Identificacion=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
             ps.setString(1, obj.getIdentificacion());
            rs = ps.executeQuery();
            while(rs.next()){
                c.setUUID(rs.getString(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setEstado(rs.getInt(6));
            }
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }finally{
            conn.closeConnection();
        }
        return c;
    }

    @Override
    public ArrayList<ClienteDTO> listAll() {
        ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
        String SQL = "SELECT * FROM cliente";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                ClienteDTO c = new ClienteDTO();
                c.setUUID(rs.getString(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setEstado(rs.getInt(6));
                lista.add(c);
            }
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }finally{
            conn.closeConnection();
        }
        return lista;
    }

    @Override
    public boolean delete(ClienteDTO obj) {
        String SQL = "DELETE FROM cliente WHERE Identificacion=?";
        boolean st = false;
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getIdentificacion());
            ps.executeUpdate();
            st = true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            
        }finally{
            conn.closeConnection();
        }
        return st;
    }

    @Override
    public boolean update(ClienteDTO obj) {
        String SQL = "UPDATE cliente SET Nombres=?, Apellidos=?, Direccion=?, Estado=? WHERE Identificacion=?";
        boolean st = false;
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getDireccion());
            ps.setInt(4, obj.getEstado());
            ps.setString(5, obj.getIdentificacion());
            ps.executeUpdate();
            st = true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            
        }finally{
            conn.closeConnection();
        }
        return st;
    }

    @Override
    public boolean create(ClienteDTO obj) {
        String SQL = "INSERT INTO cliente (Identificacion, Nombres, Apellidos, Direccion, Estado) VALUES (?,?,?,?,?)";
        boolean st = false;
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getIdentificacion());
            ps.setString(2, obj.getNombres());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getDireccion());
            ps.setInt(5, obj.getEstado());
            ps.executeUpdate();
            st = true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            
        }finally{
            conn.closeConnection();
        }
        return st;
    }
    
}
