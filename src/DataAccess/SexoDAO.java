package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.SexoAltDTO;
import DataAccess.DTO.SexoDTO;

public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO>{

    @Override
    public SexoDTO readBy(Integer id) throws Exception {
        SexoDTO s = new SexoDTO();
        String query = "SELECT IdCatalogo"
                        +" .IdCatalogoTipo"
                        +" .Nombre"
                        +" .Descripcion"
                        +" .Estado"
                        +" .FechaCreacion"
                        +" .FechaModifica"
                        +" From Catalogo"
                        +" WHERE ESTADO = 'A'"
                        +" AND IdCatalogoTipo = 2"
                        +" AND IdCatalogo " + id.toString();
        try {
            Connection conn = openConnection();     //conectar a BD
            Statement  stmt = conn.createStatement();   //CRUD: Select *
            ResultSet rs = stmt.executeQuery(query);  //ejecutar la
            while (rs.next()) { 
                s = new SexoDTO( rs.getInt(1)
                                ,rs.getInt(2)    //IdCatalogoTipo
                                ,rs.getString(3)  //Nombre
                                ,rs.getString(4)  //Descripcion
                                ,rs.getString(5)  //Estado
                                ,rs.getString(6)  //FehcaCrea
                                ,rs.getString(7)); //FechaModifica//FechaModifica
            }
            
        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return s;
    }

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (IdCatalogoTip0,Nombre,Descripcion) VALUES(?.?,?)";
        try {
            Connection conn = openConnection();     //conectar a BD
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,2);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2,entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "create");
        }
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {
        List <SexoDTO> lts = new ArrayList<>();
        String query = "SELECT IdCatalogo"
                        +" .IdCatalogoTipo"
                        +" .Nombre"
                        +" .Descripcion"
                        +" .Estado"
                        +" .FechaCreacion"
                        +" .FechaModifica"
                        +" From Catalogo"
                        +" WHERE ESTADO = 'A'"
                        +" AND IdCatalogoTipo = 2";
        try {
            Connection conn = openConnection();     //conectar a BD
            Statement  stmt = conn.createStatement();   //CRUD: Select *
            ResultSet rs = stmt.executeQuery(query);  //ejecutar la
            while (rs.next()) { 
                SexoDTO s = new SexoDTO( rs.getInt(1)
                                        ,rs.getInt(2)    //IdCatalogoTipo
                                        ,rs.getString(3)  //Nombre
                                        ,rs.getString(4)  //Descripcion
                                        ,rs.getString(5)  //Estado
                                        ,rs.getString(6)  //FehcaCrea
                                        ,rs.getString(7)); //FechaModifica
                lts.add(s);
            }

        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "readAll");
        }
        return lts;
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?,Descripcion=?, FechaModifica = ? WHERE IdSexo = ?";
        try {
            Connection conn = openConnection();     //conectar a BD
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Catalogo SET Estado=? WHERE IdCatalogo=?";
        try {
            Connection conn = openConnection();     //conectar a BD
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getRowCount() throws Exception{
        String query = "SELECT COUNT(*) TotalReg FROM Catalogo"
                      +" WHERE Estado = 'A' "
                      +" AND IdCatalogoTipo = 2";
        try {
            Connection conn = openConnection();     //conectar a BD
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
                
            }
        }catch (SQLException e){
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
