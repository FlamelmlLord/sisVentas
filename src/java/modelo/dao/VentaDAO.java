
package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.dto.VentaDTO;
import utils.Connector;

public class VentaDAO {
    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    
    public String GenerarSerie(){
        String numSerie = "";
        String SQL = "SELECT max(NumeroSerie) FROM venta";
        try {
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                numSerie = rs.getString(1);
            }
        } catch (Exception err) {
            System.out.println("Operacion no finalizada: " + err.getMessage());
        } finally{
            conn.closeConnection();
        }
        return numSerie;
    }
    
    public int IDVentas(){
        int idventas = 0;
        String SQL = "SELECT max(ID) FROM venta";
        try {
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                idventas = rs.getInt(1);
            }
        } catch (Exception err) {
            System.out.println("Operacion no finalizada: " + err.getMessage());
        } finally{
            conn.closeConnection();
        }
        return idventas;
    }
    
    public String obtenerUUID(int id){
        String UUID = "";
        String SQL = "SELECT UUID FROM venta WHERE ID=?";
        try {
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                UUID = rs.getString(1);
            }
        } catch (Exception err) {
            System.out.println("Operacion no finalizada: " + err.getMessage());
        } finally{
            conn.closeConnection();
        }
        return UUID;
    }
    
    public boolean create(VentaDTO obj) {
        String SQL = "INSERT INTO venta(Cliente, Empleado, NumeroSerie, Total, Estado) VALUES(?,?,?,?,?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getIDCliente());
            ps.setString(2, obj.getIDEmpleado());
            ps.setString(3, obj.getNumSerie());
            ps.setDouble(4, obj.getMonto());
            ps.setInt(5, obj.getEstado());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }
    
    public boolean guardarDetalleVentas(VentaDTO obj) {
        String SQL = "INSERT INTO detalleventa(Venta, Producto, Cantidad, Precio) VALUES(?,?,?,?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getUUID());
            ps.setString(2, obj.getUUIDProducto());
            ps.setInt(3, obj.getCantidad());
            ps.setDouble(4, obj.getPrecioProducto());
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
