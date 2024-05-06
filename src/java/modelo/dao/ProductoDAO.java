package modelo.dao;

import interfaces.IDao;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Connector;
import modelo.dto.ProductoDTO;

public class ProductoDAO implements IDao<ProductoDTO>{
    
    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public ProductoDTO search(ProductoDTO obj) {
        String SQL = "SELECT * FROM producto WHERE ID=?";
        ProductoDTO p = new ProductoDTO();
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setInt(1, obj.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setUUID(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setEstado(rs.getInt(6));
            }
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }finally{
            conn.closeConnection();
        }
        return p;
    }

    @Override
    public ArrayList<ProductoDTO> listAll() {
        ArrayList<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        String SQL = "SELECT * FROM producto";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoDTO p = new ProductoDTO();
                p.setId(rs.getInt(1));
                p.setUUID(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setEstado(rs.getInt(6));
                lista.add(p);
            }
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }finally{
            conn.closeConnection();
        }
        return lista;
    }

    @Override
    public boolean delete(ProductoDTO obj) {
        String SQL = "DELETE FROM producto WHERE ID=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }

    @Override
    public boolean update(ProductoDTO obj) {
        String SQL = "UPDATE producto SET Nombre=?, Precio=?, Stock=?, Estado=? WHERE ID=?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getNombre());
            ps.setDouble(2, obj.getPrecio());
            ps.setInt(3, obj.getStock());
            ps.setInt(4, obj.getEstado());
            ps.setInt(5, obj.getId());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }

    @Override
    public boolean create(ProductoDTO obj) {
        String SQL = "INSERT INTO producto(Nombre, Precio, Stock, Estado) VALUES(?,?,?,?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getNombre());
            ps.setDouble(2, obj.getPrecio());
            ps.setInt(3, obj.getStock());
            ps.setInt(4, obj.getEstado());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }

}
