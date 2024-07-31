package DataAccess;

import DataAccess.DTO.SexoAltDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SexoAntDAO extends SQLiteDataHelper implements IDAO<SexoAltDTO>{
    
    @Override
    public SexoAltDTO readBy(Integer id) throws Exception {
        SexoAltDTO oS = new SexoAltDTO();
        String query = "SELECT IdSexi"
                     +" .Nombre"
                     +" .EStado"
                     +" .FechaCrea"
                     +" .FechaModifica"
                     +" From Sexo"
                     +" WHERE ESTADO = 'A' AND IdSexo= "+ id.toString();
        try {
            Connection conn = openConnection();     //conectar a BD
            Statement  stmt = conn.createStatement();   //CRUD: Select *
            ResultSet rs = stmt.executeQuery(query);  //ejecutar la
            while (rs.next()) { 
                oS = new SexoAltDTO( rs.getInt(1)     //IdSexxo
                                    ,rs.getString(2)  //Nombre
                                    ,rs.getString(3)  //Estado
                                    ,rs.getString(4)  //FehcaCrea
                                    ,rs.getString(5)); //FechaModifica
            }
            
        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }
    
    @Override
    public List<SexoAltDTO> readAll() throws Exception {
        List <SexoAltDTO> lts = new ArrayList<>();
        String query = "SELECT IdSexo"
                     +" .Nombre"
                     +" .Etado"
                     +" .FechaCrea"
                     +" .FechaModifica"
                     +" From Sexo"
                     +" WHERE ESTADO = 'A'";
        try {
            Connection conn = openConnection();     //conectar a BD
            Statement  stmt = conn.createStatement();   //CRUD: Select *
            ResultSet rs = stmt.executeQuery(query);  //ejecutar la
            while (rs.next()) { 
                SexoAltDTO s = new SexoAltDTO( rs.getInt(1)     //IdSexxo
                                        ,rs.getString(2)  //Nombre
                                        ,rs.getString(3)  //Estado
                                        ,rs.getString(4)  //FehcaCrea
                                        ,rs.getString(5)); //FechaModifica
                lts.add(s);
            }

        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "readAll");
        }
        return lts;
    }
    
    @Override
    public boolean create(SexoAltDTO entity) throws Exception {
        String query = "INSERT INTO Sexo (Nombre) VALUES(?)";
        try {
            Connection conn = openConnection();     //conectar a BD
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "create");
        }
    }
    
    @Override
    public boolean update(SexoAltDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Sexo SET Nombre = ?, FechaModifica = ? WHERE IdSexo = ?";
        try {
            Connection conn = openConnection();     //conectar a BD
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
            // throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE FROM Sexo WHERE IdSexo = ?";
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

    public Integer getMaxRow() throws Exception{
        String query = "SELECT COUNT(*) TotalReg FROM SEXO"
                      +" WHERE Estado = 'A' ";
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
