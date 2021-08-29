
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Repertorium {
    
    public void fillRepertorium1(JTable table, String valueToSearch)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        //wypełnianie tabeli informacjami z bazy danych
        try {
            ps = con.prepareStatement("SELECT * FROM `repertorium` WHERE (`num_rep_fin`) IS NULL ");
            
            ResultSet rs = ps.executeQuery(); 
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object [5];
                row[0] = rs.getString(3);
                row[1] = rs.getString(5);
                row[2] = rs.getString(6);
                row[3] = rs.getString(7);
                row[4] = rs.getString(8);
                                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repertorium.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void fillRepertorium2(JTable table, String valueToSearch)
    {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
        try {
            //ps = con.prepareStatement("SELECT * FROM `repertorium` WHERE CONCAT (`num_rep_fin`) LIKE ?");
            ps = con.prepareStatement("SELECT * FROM `repertorium` WHERE CONCAT (`num_rep_fin`) LIKE '%/%'");
            //ps.setString(1, "%"+valueToSearch+"%"); //bez sensu dodatawanie "%" do szukanych znaków 
            
            ResultSet rs = ps.executeQuery(); 
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object [5];
                row[0] = rs.getString(3);
                row[1] = rs.getString(5);
                row[2] = rs.getString(6);
                row[3] = rs.getString(7);
                row[4] = rs.getString(8);
                
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Repertorium.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
   
}
